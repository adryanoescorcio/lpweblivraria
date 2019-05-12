package livraria.ifma.edu.livrariaweb.service;

import livraria.ifma.edu.livrariaweb.model.ClientePessoaFisicaModel;
import livraria.ifma.edu.livrariaweb.repository.ClientePessoaFisicaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ClientePessoaFisicaService {

    private final ClientePessoaFisicaRepository clienteRepository;

    @Autowired
    public ClientePessoaFisicaService(ClientePessoaFisicaRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional(readOnly = true)
    public List<ClientePessoaFisicaModel> ObterTodos() {
        List<ClientePessoaFisicaModel> retorno  = clienteRepository.findAll();

        Type listType = new TypeToken<List<ClientePessoaFisicaModel>>() {}.getType();
        return new ModelMapper().map(retorno, listType);
    }

    @Transactional
    public ClientePessoaFisicaModel Salvar(ClientePessoaFisicaModel cliente){
        return clienteRepository.save(
                new ModelMapper().map(
                        cliente,
                        ClientePessoaFisicaModel.class));
    }

    @Transactional
    public List<ClientePessoaFisicaModel> Salvar(List<ClientePessoaFisicaModel> clientes){
        return clienteRepository.saveAll(clientes);
    }

    @Transactional
    public void RemoverPor(Integer idCliente) {
        clienteRepository.deleteById(idCliente);
    }

    @Transactional
    public ClientePessoaFisicaModel AtualizarPor(ClientePessoaFisicaModel novo) {
        return new ModelMapper().map(
                clienteRepository.save(novo),
                ClientePessoaFisicaModel.class);
    }

    @Transactional(readOnly = true)
    public ClientePessoaFisicaModel ObterPor(Integer idCliente) {
        return new ModelMapper().map(
                clienteRepository.findById(idCliente).get(),
                ClientePessoaFisicaModel.class);
    }

}
