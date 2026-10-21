package br.escola.bibliohaydee.model;

public class Usuario {

    private String nome;
    private String matricula;
    private String tipo;
    private Integer limiteEmprestimos;
    private Integer emprestimosAtivos;

    public Usuario(String nomeUsuario, String matriculaUsuario, String tipoUsuario, Integer limiteUsuario) {
        if (nomeUsuario == null || nomeUsuario.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        if (tipoUsuario == null || (!tipoUsuario.equals("ALUNO") && !tipoUsuario.equals("PROFESSOR"))) {
            throw new IllegalArgumentException("O tipo deve ser ALUNO ou PROFESSOR.");
        }

        nome = nomeUsuario;
        matricula = matriculaUsuario;
        tipo = tipoUsuario;
        limiteEmprestimos = limiteUsuario;
        emprestimosAtivos = 0;
    }
    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getLimiteEmprestimos() {
        return limiteEmprestimos;
    }

    public Integer getEmprestimosAtivos() {
        return emprestimosAtivos;
    }
}