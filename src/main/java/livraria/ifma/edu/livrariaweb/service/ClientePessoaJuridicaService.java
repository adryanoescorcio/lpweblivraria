package livraria.ifma.edu.livrariaweb.service;

import livraria.ifma.edu.livrariaweb.model.ClientePessoaFisicaModel;
import livraria.ifma.edu.livrariaweb.model.ClientePessoaJuridicaModel;
import livraria.ifma.edu.livrariaweb.repository.ClientePessoaFisicaRepository;
import livraria.ifma.edu.livrariaweb.repository.ClientePessoaJuridicaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ClientePessoaJuridicaService {

    private final ClientePessoaJuridicaRepository clienteRepository;

    @Autowired
    public ClientePessoaJuridicaService(ClientePessoaJuridicaRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional(readOnly = true)
    public List<ClientePessoaJuridicaModel> ObterTodos() {
        List<ClientePessoaJuridicaModel> retorno  = clienteRepository.findAll();

        Type listType = new TypeToken<List<ClientePessoaJuridicaModel>>() {}.getType();
        return new ModelMapper().map(retorno, listType);
    }

    @Transactional
    public ClientePessoaJuridicaModel Salvar(ClientePessoaJuridicaModel cliente){
        return clienteRepository.save(
                new ModelMapper().map(
                        cliente,
                        ClientePessoaJuridicaModel.class));
    }

    @Transactional
    public List<ClientePessoaJuridicaModel> Salvar(List<ClientePessoaJuridicaModel> clientes){
        return clienteRepository.saveAll(clientes);
    }

    @Transactional
    public void RemoverPor(Integer idCliente) {
        clienteRepository.deleteById(idCliente);
    }

    @Transactional
    public ClientePessoaJuridicaModel AtualizarPor(ClientePessoaJuridicaModel novo) {
        return new ModelMapper().map(
                clienteRepository.save(novo),
                ClientePessoaJuridicaModel.class);
    }

    @Transactional(readOnly = true)
    public ClientePessoaJuridicaModel ObterPor(Integer idCliente) {
        return new ModelMapper().map(
                clienteRepository.findById(idCliente).get(),
                ClientePessoaJuridicaModel.class);
    }

}
