package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;
import br.escola.bibliohaydee.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Autor> autores = new ArrayList<>();
        List<Livro> livros = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();

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

        System.out.println("=== CADASTRO DE USUÁRIO ===");

        String nome;

        do {
            System.out.print("Nome: ");
            nome = scanner.nextLine();

            if (nome.trim().isEmpty()) {
                System.out.println("O nome não pode ser vazio.");
            }

        } while (nome.trim().isEmpty());

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        String tipo;

        do {
            System.out.print("Tipo (ALUNO ou PROFESSOR): ");
            tipo = scanner.nextLine().toUpperCase();

            if (!tipo.equals("ALUNO") && !tipo.equals("PROFESSOR")) {
                System.out.println("O tipo deve ser ALUNO ou PROFESSOR.");
            }

        } while (!tipo.equals("ALUNO") && !tipo.equals("PROFESSOR"));

        System.out.print("Limite de empréstimos: ");
        Integer limiteEmprestimos = Integer.parseInt(scanner.nextLine());

        Usuario usuario = new Usuario(
                nome,
                matricula,
                tipo,
                limiteEmprestimos
        );

        usuarios.add(usuario);

        System.out.println("\n=== USUÁRIO CADASTRADO ===");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Matrícula: " + usuario.getMatricula());
        System.out.println("Tipo: " + usuario.getTipo());
        System.out.println("Limite de empréstimos: " + usuario.getLimiteEmprestimos());
        System.out.println("Empréstimos ativos: " + usuario.getEmprestimosAtivos());

        System.out.println("\n=== ACERVO ===");

        if (livros.isEmpty()) {
            System.out.println("O acervo está vazio.");
        } else {
            for (Livro l : livros) {
                System.out.println(l);
            }
        }

        scanner.close();
    }
}