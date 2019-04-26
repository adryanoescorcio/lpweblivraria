package livraria.ifma.edu.livrariaweb.service;

import livraria.ifma.edu.livrariaweb.dto.LivroDTO;
import livraria.ifma.edu.livrariaweb.model.LivroModel;
import livraria.ifma.edu.livrariaweb.repository.LivroRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.lang.reflect.Type;
import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Transactional(readOnly = true)
    public List<LivroDTO> ObterTodos() {
        List<LivroModel> retorno  = livroRepository.findAll();

        Type listType = new TypeToken<List<LivroDTO>>() {}.getType();
        return new ModelMapper().map(retorno, listType);
    }

    @Transactional
    public LivroModel Salvar(LivroModel livro){
        return livroRepository.save(
                new ModelMapper().map(
                        livro,
                        LivroModel.class));
    }

    @Transactional
    public List<LivroModel> Salvar(List<LivroModel> livros){
        return livroRepository.saveAll(livros);
    }

    @Transactional
    public void RemoverPor(Integer idLivro) {
        livroRepository.deleteById(idLivro);
    }

    @Transactional
    public LivroDTO AtualizarPor(LivroModel novo) {
        return new ModelMapper().map(
                livroRepository.save(novo),
                LivroDTO.class);
    }

    @Transactional(readOnly = true)
    public LivroDTO ObterPor(Integer idLivro) {
        return new ModelMapper().map(
                livroRepository.findById(idLivro).get(),
                LivroDTO.class);
    }

}
