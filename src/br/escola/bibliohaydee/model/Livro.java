package br.escola.bibliohaydee.model;

public class Livro {

    private String titulo;
    private String isbn;
    private Autor autor;
    private int anoPublicacao;
    private String genero;
    private boolean disponibilidade;

    public Livro(String titulo, String isbn, Autor autor, int anoPublicacao, String genero) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        this.disponibilidade = true;
    }

    public Livro(String titulo, String isbn, Autor autor, int anoPublicacao) {
        this(titulo, isbn, autor, anoPublicacao, "Não informado");
    }
    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor=" + autor +
                ", anoPublicacao=" + anoPublicacao +
                ", genero='" + genero + '\'' +
                ", disponibilidade=" + disponibilidade +
                '}';
    }
}