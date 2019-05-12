package livraria.ifma.edu.livrariaweb.repository;

import livraria.ifma.edu.livrariaweb.model.ClientePessoaFisicaModel;
import livraria.ifma.edu.livrariaweb.model.ClientePessoaJuridicaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientePessoaJuridicaRepository extends JpaRepository<ClientePessoaJuridicaModel, Integer> {

}
