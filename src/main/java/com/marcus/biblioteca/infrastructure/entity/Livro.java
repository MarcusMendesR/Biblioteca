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

}
