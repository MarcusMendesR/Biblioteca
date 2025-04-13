package com.marcus.biblioteca.infrastructure.entity;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Biblioteca extends Livro {
    Scanner scanner = new Scanner(System.in);

    public void menuBiblioteca() {
        int opcao = 0;

        do {
            System.out.println("---Biblioteca---");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Buscar livro pelo autor");
            System.out.println("3 - Lista de livros");
            System.out.println("4- Escolher livro");
            System.out.println("5 - Devolver Livro");
            System.out.println("6 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    verLivroAutor();
                    break;
                case 3:
                    listarLivros();
                    break;
                case 4:
                    emprestarLivro();
                    break;
                case 5:
                    devolverLivro();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
            }

        } while (opcao != 6);
    }
}
