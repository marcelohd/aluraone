package dev.marcelohd.alura.literarua;


import dev.marcelohd.alura.literarua.repositorio.LivroRepository;
import dev.marcelohd.alura.literarua.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.marcelohd.alura.literarua.principal.Principal;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Autowired
	LivroRepository repository;
	@Override
	public void run(String... args) throws Exception {
		LivrosService livrosService = new LivrosService(repository);
		Principal principal = new Principal(livrosService);
		principal.exibeMenu();
	}

}
