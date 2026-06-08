package model;

public class Paciente {

    private Long id;
    private String nome;

    public Paciente(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
