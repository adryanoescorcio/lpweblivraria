package livraria.ifma.edu.livrariaweb.model;

import javax.persistence.*;

@Entity
@Table (name = "livro")
public class LivroModel  {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    public LivroModel() {
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
}
