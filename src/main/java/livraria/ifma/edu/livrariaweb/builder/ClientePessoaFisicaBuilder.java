package livraria.ifma.edu.livrariaweb.builder;

import livraria.ifma.edu.livrariaweb.model.ClientePessoaFisicaModel;

import java.util.ArrayList;
import java.util.List;

public class ClientePessoaFisicaBuilder {

    public static ClientePessoaFisicaModel createClientePessoaFisica() {

        final ClientePessoaFisicaModel clientePessoaFisica = new ClientePessoaFisicaModel();

        return clientePessoaFisica;
    }

    public static ClientePessoaFisicaModel createClientePessoaFisicaSample() {

        final ClientePessoaFisicaModel cliente = getClientePessoaFisicaDefault();
        return cliente;
    }


    private static ClientePessoaFisicaModel getClientePessoaFisicaDefault() {
        final ClientePessoaFisicaModel cliente = new ClientePessoaFisicaModel();

        cliente.setNome("Adryano");
        cliente.setCpf("04953597346");
        cliente.setEndereco("Rua 25");
        cliente.addTelefone("98987041068","98981200104");

        return cliente;
    }

    public static List<ClientePessoaFisicaModel> createPoolClienteSample() {
        List<ClientePessoaFisicaModel> listaClientes = new ArrayList<>();

        listaClientes.add(createClientePessoaFisicaSample("João da Silva"));
        listaClientes.add(createClientePessoaFisicaSample("Carlinhos de Jesus"));
        listaClientes.add(createClientePessoaFisicaSample("Xuxa Meneghel"));
        listaClientes.add(createClientePessoaFisicaSample("Carlos Drummond de Andrade"));

        return listaClientes;
    }

    public static ClientePessoaFisicaModel createClientePessoaFisicaSample(String nome) {

        ClientePessoaFisicaModel cliente = getClientePessoaFisicaDefault();
        cliente.setNome(nome);
        return cliente;
    }


}