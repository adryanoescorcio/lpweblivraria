package livraria.ifma.edu.livrariaweb.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "cliente_pessoa_juridica")
public class ClientePessoaJuridicaModel extends ClienteAbstractModel {

    @NotBlank(message = "Campo Obrigatório")
    private String razaoSocial;

    @NotBlank(message = "Campo Obrigatório")
    private String cnpj;

    @Temporal(TemporalType.DATE)
    @NotBlank(message = "Campo Obrigatório")
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
