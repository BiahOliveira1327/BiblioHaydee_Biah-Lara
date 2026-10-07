package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Autor> autores = new ArrayList<>();
        List<Livro> livros = new ArrayList<>();

        Autor autor = new Autor(
                "Colleen Hoover",
                "Americana",
                1979
        );

        Livro livro = new Livro(
                "O Lado Feio do Amor",
                "9788501105483",
                autor,
                2015,
                "Romance"
        );

        livros.add(livro);
        autores.add(autor);

        if (livros.isEmpty()) {
            System.out.println("O acervo está vazio.");
        } else {
            for (Livro l : livros) {
                System.out.println(l);
            }
        }
    }
}