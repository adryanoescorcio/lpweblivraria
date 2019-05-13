package livraria.ifma.edu.livrariaweb.controller.io;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {

    private T dados;
    private List<Erro> erros = new ArrayList<>();

    public Response() {
    }

    public T getDados() {
        return dados;
    }

    public void setDados(T dados) {
        this.dados = dados;
    }

    public List<Erro> getErros() {
        return erros;
    }

    public void setErros(List<Erro> erros) {
        this.erros = erros;
    }

    public void add(Erro erro) {
        erros.add(erro );
    }

}
