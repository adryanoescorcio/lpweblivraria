package livraria.ifma.edu.livrariaweb;

import livraria.ifma.edu.livrariaweb.model.LivroModel;
import livraria.ifma.edu.livrariaweb.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariawebApplication {

	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(LivrariawebApplication.class, args);
	}

}
