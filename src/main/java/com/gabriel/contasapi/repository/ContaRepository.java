package com.gabriel.contasapi.repository;

import com.gabriel.contasapi.model.Conta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository // Annotations que define essa classe como um Repository
//Classe responsável por acessar os dados.
public class ContaRepository {

    //Lista de contas
    //Atributo da ContaRepository -> memoria que guarda as contas
    private List<Conta> contas = new ArrayList<>();

    //Funcao que lista as contas, agora dentro do repository
    //A service agora só faz a lógica.
    public List<Conta> listarContas(){
        return contas;
    }
    //Funcao que recebe um id e verifica se ele existe dentro da lista de contas, se existir retornamos ele.
    public Conta buscarId(long id) {
        for (Conta conta : contas) {
            if(conta.getId() == id ) {
                return conta;
            }
        }
        return null;
    }

    //Post.
    //Recebe um objeto do tipo conta e o adiciona a lista.
    public Conta cadastrar(Conta conta) {
        contas.add(conta);
        return conta;
    }

    //UPDATE - PUT
    public Conta atualizar(long id, Conta conta) {

        for (Conta i : contas) {

            if (i.getId() == id ) {

                i.setId(conta.getId());
                i.setSaldo(conta.getSaldo());
                i.setTitular(conta.getTitular());
                i.setNomeConta(conta.getNomeConta());

                return i;
            }
        }
        return null;
    }

    //Delete - Delete --> Deletar uma conta da lista contas

    public Conta deletar(long id) {

        for (int indice = 0; indice < contas.size() ; indice++) {

            Conta contaDeletado = contas.get(indice);

            if(contaDeletado.getId() == id) {
                contas.remove(indice);
                return contaDeletado;
            }

        }
        return null;
    }

}
