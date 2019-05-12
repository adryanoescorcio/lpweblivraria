package livraria.ifma.edu.livrariaweb.model;

import livraria.ifma.edu.livrariaweb.builder.ClientePessoaFisicaBuilder;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "cliente")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ClienteAbstractModel implements IModel{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private boolean status = true;

    @ElementCollection
    @CollectionTable(
            name = "telefone",
            joinColumns = @JoinColumn(name = "idCliente", nullable = false)
    )

    @Size(min=1)
    @Column(name = "numero")
    private Set<String> telefones;

    private String endereco;

    public ClienteAbstractModel() {
        telefones = new LinkedHashSet<>();
    }

    public static ClientePessoaFisicaModel createClientePessoaFisicaFactory() {
        final ClientePessoaFisicaModel cliente = new ClientePessoaFisicaBuilder().createClientePessoaFisica();
        return cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    public void addTelefone(String... telefone) {
        for (String item: telefone) {
            this.telefones.add(item);
        }
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteAbstractModel that = (ClienteAbstractModel) o;
        return isStatus() == that.isStatus() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getTelefones(), that.getTelefones());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isStatus(), getTelefones());
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}