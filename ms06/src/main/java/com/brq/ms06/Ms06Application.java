package com.brq.ms06;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brq.ms06.services.UsuarioService;

@SpringBootApplication
public class Ms06Application implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(Ms06Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//usuarioService.deleteAll();
		//final var list = usuarioService.getAll();

		//if (list.size() < 100) {
		usuarioService.insertMany(500);
		//}
	}

}