import model.Medico;
import model.Paciente;
import service.ConsultaService;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        ConsultaService service =
                new ConsultaService();

        Medico medico =
                new Medico(
                        1L,
                        "Dr. João",
                        "Cardiologista");

        Paciente paciente =
                new Paciente(
                        1L,
                        "Vinicius");

        LocalDateTime horario =
                LocalDateTime.now()
                        .plusDays(1)
                        .withHour(10)
                        .withMinute(0);

        service.agendarConsulta(
                medico,
                paciente,
                horario
        );

        service.listarConsultas();
    }
}
