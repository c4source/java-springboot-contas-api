package com.gabriel.contasapi.service;

import com.gabriel.contasapi.model.Conta;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


//ContaService é uma depedencia de ContaController
// ContaController depende da ContaService para trabalhar


@Service // Anotacao que diz que está classe é uma service
public class ContaService {

    //Service get contas  --> retorna uma lista de contas
    private List<Conta> contas = new ArrayList<>();

    public List<Conta> listarContas(){
         return contas;
     }

     //Service get por id --> Pega o id que o cliente envia, verifica se existe e retorna conta.
     public Conta buscarPorId(long id ){

         for (Conta conta : contas) {

             if (conta.getId() == id) {
                 return conta;
             }
         }
         return null; //Futaramente vamos tratar com execeptions
    }

    public Conta cadastrar(Conta conta) {

        //Adiciona o objeto a lista
        contas.add(conta);

        //E retorna o valor da lista, na controller podemos utilizar o valor desse metodo e armazena-lo
        //Pra dps mostrar em json o retorno ao cliente na controller.
        return conta;

    }

}
