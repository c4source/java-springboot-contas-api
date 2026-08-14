package com.gabriel.contasapi.controller;


import java.util.ArrayList;
import java.util.List;
import com.gabriel.contasapi.model.Conta;
import org.springframework.web.bind.annotation.*;

@RestController //Marca a classe como uma CONTROLLER | @RestController: annotation
public class ContaController {

    private List<Conta> contas = new ArrayList<>(); // É um atributo do Controller que possibilita o get e post trabalhar na lista


    public ContaController() {
        contas.add(new Conta(1l, "Conta-Corrente", "Gabriel", 9959.53));

        contas.add(new Conta(2l, "Conta-Poupança", "Maria", 2500));
    }




    @GetMapping("/contas") // Quando chegar a requisicao em /contas (aqui), execute e retorne buscarContas()
    public List<Conta> buscarContas(){

        return contas; //Retorna os objetos da lista do controller ( objetos )

    };

      /*

        Vamos retornar um OBJETO do tipo CONTA

        Conta conta = new Conta (1L, "Conta Corrente", "Gabriel", 9959.53);
        Conta conta2 = new Conta (2L, "Conta poupanca", "Pamela", 10.000 );


        return List.of(conta, conta2);

       */




    @PostMapping("/contas") //Post: criar/enviar uma conta.
    public Conta cadastrar(@RequestBody Conta conta){ // @Requestbody transforma o corpo da requisicao em objeto do tipo Conta

        //Adiciona o objeto à lista e o armazena
        contas.add(conta);

        return conta;
    }

    @GetMapping("/contas/{id}")
    public Conta buscarId(@PathVariable long id){

        for(Conta conta : contas) {

            if(conta.getId() == id) {
                return conta;
            }

        }
        return null;
    }


}
