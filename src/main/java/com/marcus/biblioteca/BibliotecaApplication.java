package com.marcus.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcus.biblioteca.infrastructure.entity.Usuario;

@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		usuario.cadastrarUsuario();
		usuario.logarUsuario();
		usuario.editarUsuario();
		usuario.excluirUsuario();
	}

}
