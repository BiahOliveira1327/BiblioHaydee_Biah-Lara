
package br.escola.bibliohaydee.model;

public class Usuario {

    public static final int LIMITE_PADRAO = 3;

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

        if (limiteUsuario == null || limiteUsuario < 1) {
            throw new IllegalArgumentException("O limite deve ser maior que zero.");
        }

        this.nome = nomeUsuario.trim();
        this.matricula = matriculaUsuario;
        this.tipo = tipoUsuario;
        this.limiteEmprestimos = limiteUsuario;
        this.emprestimosAtivos = 0;
    }

    public Usuario(String nome, String matricula, String tipo) {
        this(nome, matricula, tipo, LIMITE_PADRAO);
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

    public boolean setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }

        this.nome = nome.trim();
        return true;
    }

    public boolean setLimiteEmprestimos(int limiteEmprestimos) {
        if (limiteEmprestimos < 1) {
            return false;
        }

        this.limiteEmprestimos = limiteEmprestimos;
        return true;
    }
}
