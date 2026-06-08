package service;

import exception.RegraNegocioException;
import model.Consulta;
import model.Medico;
import model.Paciente;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConsultaService {

    private final List<Consulta> consultas = new ArrayList<>();

    public void agendarConsulta(
            Medico medico,
            Paciente paciente,
            LocalDateTime dataHora) {

        validarHorarioComercial(dataHora);
        validarAntecedencia(dataHora);
        validarConflitoMedico(medico, dataHora);

        Consulta consulta = new Consulta(
                medico,
                paciente,
                dataHora
        );

        consultas.add(consulta);

        System.out.println("Consulta agendada com sucesso!");
    }

    private void validarHorarioComercial(
            LocalDateTime dataHora) {

        DayOfWeek dia = dataHora.getDayOfWeek();

        int hora = dataHora.getHour();

        if (dia == DayOfWeek.SATURDAY ||
                dia == DayOfWeek.SUNDAY) {

            throw new RegraNegocioException(
                    "Consultas não podem ser marcadas aos finais de semana."
            );
        }

        if (hora < 8 || hora >= 18) {
            throw new RegraNegocioException(
                    "Fora do horário comercial."
            );
        }
    }

    private void validarAntecedencia(
            LocalDateTime dataHora) {

        LocalDateTime agora = LocalDateTime.now();

        if (dataHora.isBefore(agora.plusMinutes(30))) {

            throw new RegraNegocioException(
                    "A consulta deve possuir pelo menos 30 minutos de antecedência."
            );
        }
    }

    private void validarConflitoMedico(
            Medico medico,
            LocalDateTime dataHora) {

        boolean conflito = consultas.stream()
                .anyMatch(c ->
                        c.getMedico().getId().equals(medico.getId())
                                &&
                                c.getDataHora().equals(dataHora));

        if (conflito) {

            throw new RegraNegocioException(
                    "O médico já possui consulta neste horário."
            );
        }
    }

    public void listarConsultas() {

        consultas.forEach(System.out::println);
    }
}
