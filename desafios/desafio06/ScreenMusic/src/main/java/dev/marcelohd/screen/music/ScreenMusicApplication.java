package dev.marcelohd.screen.music;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.marcelohd.screen.music.principal.Principal;
import dev.marcelohd.screen.music.repository.ArtistaRepository;

@SpringBootApplication
public class ScreenMusicApplication implements CommandLineRunner {
	@Autowired
	private ArtistaRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(ScreenMusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.controle();

	}

}
