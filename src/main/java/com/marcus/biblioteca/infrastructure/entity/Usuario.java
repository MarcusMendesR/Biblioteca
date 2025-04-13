package com.marcus.biblioteca.infrastructure.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {

    private String nome;
    private String senha;
    private static List<Usuario> login = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    Usuario usuario = null;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nome, usuario.nome) && Objects.equals(senha, usuario.senha);
    }

    // Implementação de hashCode
    @Override
    public int hashCode() {
        return Objects.hash(nome, senha);
    }

    public void cadastrarUsuario() {
        System.out.println("---Cadastro de Usuario---");
        System.out.println("Digite o seu nome: ");
        nome = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Digite a sua senha: ");
        senha = scanner.nextLine();
        usuario = new Usuario(nome, senha);
        if (login.contains(usuario)) {
            System.out.println("Usuario ja cadastrado!");
        } else {
            login.add(usuario);
            System.out.println("Usuario cadastrado com sucesso!");
        }

    }

    public void logarUsuario() {
        System.out.println("---Login---");
        System.out.println("Digite o seu nome: ");
        String nome = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Digite a sua senha: ");
        String senha = scanner.nextLine();
        usuario = new Usuario(nome, senha);
        if (login.contains(usuario)) {
            System.out.println("Login realizado com sucesso!");

        } else {
            System.out.println("Nome ou senha incorretos!");
        }

    }

    public void editarUsuario() {
        System.out.println("---Editar Usuario---");
        System.out.println("Digite seu nome de usuario");
        String nome = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Digite sua senha");
        String senha = scanner.nextLine();
        usuario = new Usuario(nome, senha);
        if (login.contains(usuario)) {
            System.out.println("Digite o novo nome de usuario");
            String novoNome = scanner.nextLine();
            System.out.println("Digite a nova senha");
            String novaSenha = scanner.nextLine();
            usuario = new Usuario(novoNome, novaSenha);
            login.set(login.indexOf(usuario), usuario);
            System.out.println("Usuario editado com sucesso!");
        } else {
            System.out.println("Usuario não encontrado!");
        }
    }

    public void excluirUsuario() {
        System.out.println("---Ecluir Usuario---");
        System.out.println("Digite o nome de usuario");
        String nome = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Digite a senha");
        String senha = scanner.nextLine();
        usuario = new Usuario(nome, senha);
        if (login.contains(usuario)) {
            login.remove(usuario);
            System.out.println("Usuario excluido com sucesso!");
        } else
            System.out.println("Usuario não encontrado!");
    }

    public Usuario(String nome2, String senha2) {

    }

    public void menuUsuario() {
        int opcao = 0;

        do {
            System.out.println("---Biblioteca---");
            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Login Usuario");
            System.out.println("3 - Editar Usuario");
            System.out.println("4 - Excluir Usuario");
            System.out.println("5 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:

                    cadastrarUsuario();
                    break;
                case 2:
                    logarUsuario();
                    opcao = 5;
                    break;
                case 3:
                    editarUsuario();
                    break;
                case 4:
                    excluirUsuario();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:

            }
        } while (opcao != 5);

    }
}
