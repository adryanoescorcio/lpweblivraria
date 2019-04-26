package livraria.ifma.edu.livrariaweb.repository;


import livraria.ifma.edu.livrariaweb.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository <LivroModel, Integer> {

}
