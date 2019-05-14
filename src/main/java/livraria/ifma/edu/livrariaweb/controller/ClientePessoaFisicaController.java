package livraria.ifma.edu.livrariaweb.controller;

import livraria.ifma.edu.livrariaweb.model.ClientePessoaFisicaModel;
import livraria.ifma.edu.livrariaweb.model.ClientePessoaJuridicaModel;
import livraria.ifma.edu.livrariaweb.service.ClientePessoaFisicaService;
import livraria.ifma.edu.livrariaweb.service.ClientePessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes/pessoafisica")
public class ClientePessoaFisicaController {

    private final ClientePessoaFisicaService clientePessoaFisicaService;

    @Autowired
    public ClientePessoaFisicaController(ClientePessoaFisicaService clientePessoaFisicaService) {
        this.clientePessoaFisicaService = clientePessoaFisicaService;
    }

    @GetMapping
    public List<ClientePessoaFisicaModel> ObterTodos() {
        return clientePessoaFisicaService.ObterTodos();
    }

    @PostMapping ("/SalvarCliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientePessoaFisicaModel Salvar (@RequestBody ClientePessoaFisicaModel cliente) {
        return clientePessoaFisicaService.Salvar(cliente);
    }

    @GetMapping("/{idCliente}")
    public ClientePessoaFisicaModel ObterPor(@PathVariable Integer idCliente) {
        return clientePessoaFisicaService.ObterPor(idCliente);
    }

    @DeleteMapping("/{idCliente}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void RemoverPor(@PathVariable Integer idCliente) {
        clientePessoaFisicaService.RemoverPor(idCliente);
    }

    @PutMapping("/{idCliente}")
    public ClientePessoaFisicaModel AlterarPor(@RequestBody ClientePessoaFisicaModel novo) {
        return  clientePessoaFisicaService.AtualizarPor(novo);
    }

}
