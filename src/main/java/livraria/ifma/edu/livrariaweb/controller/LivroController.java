package livraria.ifma.edu.livrariaweb.controller;

import livraria.ifma.edu.livrariaweb.dto.LivroDTO;
import livraria.ifma.edu.livrariaweb.model.LivroModel;
import livraria.ifma.edu.livrariaweb.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.CREATED)
    public LivroModel Salvar (@RequestBody LivroModel livro) {
        return livroService.Salvar(livro);
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
