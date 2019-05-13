package livraria.ifma.edu.livrariaweb.controller;

import livraria.ifma.edu.livrariaweb.controller.io.Response;
import livraria.ifma.edu.livrariaweb.dto.LivroDTO;
import livraria.ifma.edu.livrariaweb.model.LivroModel;
import livraria.ifma.edu.livrariaweb.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<LivroDTO> ObterTodos() {
        return livroService.ObterTodos();
    }

    @PostMapping ("/SalvarLivro")
    public ResponseEntity<Response<LivroModel>> Salvar (@Valid @RequestBody LivroModel livro)
    {
        final LivroModel livroSalvo = livroService.Salvar(livro);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(livroSalvo.getId())
                .toUri();

        Response<LivroModel> resposta = new  Response<>();
        resposta.setDados(livroSalvo);

        return ResponseEntity.created(uri).body(resposta);
    }

    @PostMapping ("/SalvarLivros")
    @ResponseStatus(HttpStatus.CREATED)
    public List<LivroModel> Salvar (@RequestBody List<LivroModel> livros) {
        return livroService.Salvar(livros);
    }

    @GetMapping("/{idLivro}")
    public LivroDTO ObterPor(@PathVariable Integer idLivro) {
        return livroService.ObterPor(idLivro);
    }

    @DeleteMapping("/{idLivro}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void RemoverPor(@PathVariable Integer idLivro) {
        livroService.RemoverPor(idLivro);
    }

    @PutMapping("/{idLivro}")
    public LivroDTO AlterarPor(@RequestBody LivroModel novo) {
        return  livroService.AtualizarPor(novo);
    }

}
