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

        Livro livroSemGenero = new Livro(
                "Livro de Teste",
                "123456789",
                autor,
                2024
        );

        livros.add(livroSemGenero);

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

        System.out.print("Definir o limite? (S/N): ");
        String definirLimite = scanner.nextLine().toUpperCase();

        Usuario usuario;

        if (definirLimite.equals("S")) {

            System.out.print("Limite de empréstimos: ");

            int limiteEmprestimos;

            while (true) {
                try {
                    limiteEmprestimos = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Digite um número válido: ");
                }
            }

            usuario = new Usuario(
                    nome,
                    matricula,
                    tipo,
                    limiteEmprestimos
            );

        } else {

            usuario = new Usuario(
                    nome,
                    matricula,
                    tipo
            );
        }

        usuarios.add(usuario);

        System.out.println("\n=== USUÁRIO CADASTRADO ===");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Matrícula: " + usuario.getMatricula());
        System.out.println("Tipo: " + usuario.getTipo());
        System.out.println("Limite de empréstimos: " + usuario.getLimiteEmprestimos());
        System.out.println("Empréstimos ativos: " + usuario.getEmprestimosAtivos());

        System.out.print("\nDigite a matrícula do usuário que deseja alterar: ");
        String matriculaAlteracao = scanner.nextLine();

        Usuario usuarioEncontrado = buscarUsuario(usuarios, matriculaAlteracao);

        if (usuarioEncontrado == null) {

            System.out.println("Usuário não localizado. Nenhuma alteração feita.");

        } else {

            System.out.println("Usuário encontrado: " + usuarioEncontrado.getNome());

            System.out.println("1 - Alterar nome");
            System.out.println("2 - Alterar limite");

            System.out.print("Escolha uma opção: ");

            int opcao;

            while (true) {
                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Digite uma opção válida: ");
                }
            }

            if (opcao == 1) {

                System.out.print("Novo nome: ");
                String novoNome = scanner.nextLine();

                if (usuarioEncontrado.setNome(novoNome)) {
                    System.out.println("Nome alterado com sucesso.");
                } else {
                    System.out.println("Nome inválido. Nenhuma alteração feita.");
                }

            } else if (opcao == 2) {

                System.out.print("Novo limite: ");

                int novoLimite;

                while (true) {
                    try {
                        novoLimite = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print("Digite um número válido: ");
                    }
                }

                if (usuarioEncontrado.setLimiteEmprestimos(novoLimite)) {
                    System.out.println("Limite alterado com sucesso.");
                } else {
                    System.out.println("Limite inválido. Nenhuma alteração feita.");
                }

            } else {

                System.out.println("Opção inválida. Nenhuma alteração feita.");
            }
        }

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

    public static Usuario buscarUsuario(List<Usuario> usuarios, String matricula) {

        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equals(matricula)) {
                return usuario;
            }
        }

        return null;
    }
}