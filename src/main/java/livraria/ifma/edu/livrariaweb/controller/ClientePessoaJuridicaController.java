package livraria.ifma.edu.livrariaweb.controller;

import livraria.ifma.edu.livrariaweb.model.ClientePessoaFisicaModel;
import livraria.ifma.edu.livrariaweb.model.ClientePessoaJuridicaModel;
import livraria.ifma.edu.livrariaweb.model.IModel;
import livraria.ifma.edu.livrariaweb.service.ClientePessoaFisicaService;
import livraria.ifma.edu.livrariaweb.service.ClientePessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes/pessoajuridica")
public class ClientePessoaJuridicaController {

    private final ClientePessoaJuridicaService clientePessoaJuridicaService;

    @Autowired
    public ClientePessoaJuridicaController(ClientePessoaJuridicaService clientePessoaJuridicaService) {
        this.clientePessoaJuridicaService = clientePessoaJuridicaService;
    }

    @GetMapping
    public List<ClientePessoaJuridicaModel> ObterTodos() {
        return clientePessoaJuridicaService.ObterTodos();
    }

    @PostMapping ("/SalvarCliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientePessoaJuridicaModel Salvar (@RequestBody ClientePessoaJuridicaModel cliente) {
        return clientePessoaJuridicaService.Salvar(cliente);
    }

    @PostMapping ("/SalvarClientes")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ClientePessoaJuridicaModel> Salvar (@RequestBody List<ClientePessoaJuridicaModel> clientes) {
        return clientePessoaJuridicaService.Salvar(clientes);
    }

    @GetMapping("/{idCliente}")
    public ClientePessoaJuridicaModel ObterPor(@PathVariable Integer idCliente) {
        return clientePessoaJuridicaService.ObterPor(idCliente);
    }

    @DeleteMapping("/{idCliente}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void RemoverPor(@PathVariable Integer idCliente) {
        clientePessoaJuridicaService.RemoverPor(idCliente);
    }

    @PutMapping("/{idCliente}")
    public ClientePessoaJuridicaModel AlterarPor(@RequestBody ClientePessoaJuridicaModel novo) {
        return  clientePessoaJuridicaService.AtualizarPor(novo);
    }

}
