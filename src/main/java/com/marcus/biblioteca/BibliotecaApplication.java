package com.marcus.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcus.biblioteca.infrastructure.entity.Livro;
import com.marcus.biblioteca.infrastructure.entity.Usuario;
import com.marcus.biblioteca.infrastructure.entity.Biblioteca;

@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {

		Usuario usuario = new Usuario();
		// usuario.menuUsuario();
	    Biblioteca biblioteca = new Biblioteca();
		biblioteca.menuBiblioteca();
	}

}
