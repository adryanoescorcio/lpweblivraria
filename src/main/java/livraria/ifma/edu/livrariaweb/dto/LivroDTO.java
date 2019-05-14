package livraria.ifma.edu.livrariaweb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import livraria.ifma.edu.livrariaweb.model.LivroModel;
import org.springframework.beans.BeanUtils;
import util.PropriedadesUtil;

import javax.validation.constraints.NotEmpty;

public class LivroDTO implements IDto {

    private Integer id;

    @NotEmpty
    private String nome;

    public LivroDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonIgnore
    public LivroModel getDto2Model() {
        final LivroModel livroModel = new LivroModel();
        BeanUtils.copyProperties(this, livroModel);
        return livroModel;
    }

    @JsonIgnore
    public LivroDTO getModel2Dto(LivroModel model) {
        BeanUtils.copyProperties(model, this);
        return this;
    }

    public LivroModel atualizaIgnorandoNuloEm(LivroModel model) {
        BeanUtils.copyProperties(this,
                model,
                PropriedadesUtil.obterPropriedadesComNullDe(this) );

        return model;
    }
}
