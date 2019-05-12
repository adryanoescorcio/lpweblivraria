package livraria.ifma.edu.livrariaweb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "cliente_pessoa_fisica")
public class ClientePessoaFisicaModel extends ClienteAbstractModel {

    @NotBlank(message = "Campo Obrigatório")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "Campo Obrigatório")
    private String cpf;

    @Temporal(TemporalType.DATE)
    @NotBlank(message = "Campo Obrigatório")
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
