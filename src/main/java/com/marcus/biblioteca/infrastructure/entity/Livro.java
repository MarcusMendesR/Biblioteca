package com.marcus.biblioteca.infrastructure.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
    private String titulo;
    private String autor;
    private static List<Livro> livros = new ArrayList();
    private static List<Livro> livrosEmprestados = new ArrayList();
    private static Scanner scanner = new Scanner(System.in);

    public void adicionarLivro() {

        System.out.println("Digite o titulo do livro");
        titulo = scanner.nextLine();
        System.out.println("Digite o autor do livro");
        autor = scanner.nextLine();

        boolean livroExiste = false;
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo) && l.getAutor().equalsIgnoreCase(autor)) {
                livroExiste = true;
                break;
            }
        }

        if (livroExiste) {
            System.out.println("Livro ja cadastrado");
        } else {
            Livro livro = new Livro(titulo, autor);
            livros.add(livro);
            System.out.println("Livro adicionado com sucesso");
        }
    }

    public void verLivroAutor() {
        System.out.println("Digite o autor para buscar seus livros");
        String autor = scanner.nextLine();

        boolean encontrado = false;
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                System.out.println(livro.getTitulo());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum livro encontrado para esse autor");
        }
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados na biblioteca.");
        } else {
            System.out.println("\n=== LIVROS CADASTRADOS ===");
            for (int i = 0; i < livros.size(); i++) {

                Livro livro = livros.get(i);
                System.out.println((i + 1) + ". Título: " + livro.getTitulo() + " | Autor: " + livro.getAutor());

                for (Livro livroEmprestado : livrosEmprestados) {
                    if (livroEmprestado.getTitulo().equalsIgnoreCase(livro.getTitulo())) {
                        System.out.println(" (EMPRESTADO)");
                        break;
                    }
                }
                System.out.println("=========================\n");
            }
        }
    }

    public void emprestarLivro() {
        System.out.println("Digite o titulo do livro");
        titulo = scanner.nextLine();

        boolean livroExiste = false;
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                livroExiste = true;
                break;
            }
        }

        if (!livroExiste) {
            System.out.println("Livro nao tem na bibloteca");
        } else {
            boolean emprestado = false;
            for (Livro l : livrosEmprestados) {
                if (l.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println("Livro ja emprestado");
                    emprestado = true;
                    break;
                }
            }
            if (!emprestado) {
                livros.remove(new Livro(titulo, null));
                livrosEmprestados.add(new Livro(titulo, null));
                System.out.println("Livro " + getTitulo() + " emprestado com sucesso");

            }

        }

    }

    public void devolverLivro() {
        System.out.println("Digite o titulo do livro que deseja devolver");
        titulo = scanner.nextLine();
        boolean devolvido = false;
        for (Livro l : livrosEmprestados) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                livros.add(l);
                livrosEmprestados.remove(l);
                devolvido = true;
                System.out.println("Livro " + l.getTitulo() + " devolvido");
                break;
            }

        }
        if (!devolvido) {
            System.out.println("Livro ja foi devolvido");
        }
    }

}
