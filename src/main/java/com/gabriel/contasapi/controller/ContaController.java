package com.gabriel.contasapi.controller;


import java.util.ArrayList;
import java.util.List;
import com.gabriel.contasapi.model.Conta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //Marca a classe como uma CONTROLLER | @RestController: annotation
@RequestMapping("contas") // anotacao define o endereço do controller base na classe, evitando que cada endpoint repita o ("/contas")
public class ContaController {

    private List<Conta> contas = new ArrayList<>(); // É um atributo do Controller que possibilita o get e post trabalhar na lista


    public ContaController() {
        contas.add(new Conta(1l, "Conta-Corrente", "Gabriel", 9959.53));
        contas.add(new Conta(2l, "Conta-Poupança", "Maria", 2500));
    }


    @GetMapping// Quando chegar a requisicao em /contas (aqui), execute e retorne buscarContas()
    public List<Conta> buscarContas() {

        return contas; //Retorna os objetos da lista do controller ( objetos )

    }

    ;

      /*

        Vamos retornar um OBJETO do tipo CONTA

        Conta conta = new Conta (1L, "Conta Corrente", "Gabriel", 9959.53);
        Conta conta2 = new Conta (2L, "Conta poupanca", "Pamela", 10.000 );


        return List.of(conta, conta2);

       */


    @PostMapping //Post: criar/enviar uma conta.
    public Conta cadastrar(@RequestBody Conta conta) { // @Requestbody transforma o corpo da requisicao em objeto do tipo Conta

        //Adiciona o objeto à lista e o armazena
        contas.add(conta);

        return conta;
    }


    //Nova Assinatura: ResponseEntity<> --> Esse metodo retorna uma resposta HTTP que pode carregar uma Conta
    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarId(@PathVariable long id) {

        for (Conta conta : contas) {

            if (conta.getId() == id) {
                return ResponseEntity.ok(conta); //Se ok, devolva essa conta no corpo com status 200 ok
            }

        }
        return ResponseEntity.notFound().build(); //senao achar o id devolva uma notFound 404 sem objeto no corpo
    }


    //Atualizar (Update) dados que vem em json, é convertido para objeto e é alterado os valores do objeto.
    @PutMapping("/{id}")
    public ResponseEntity<Conta> atualizarDados(@PathVariable long id, @RequestBody Conta conta){ //ParthVariable Recebe dados da URL ex (id)

        for (Conta i : contas) {

            if(i.getId() == id) {
                i.setNomeConta(conta.getNomeConta());  //Aleterando os valores do objeto atraves do set e getter
                i.setTitular(conta.getTitular());
                i.setSaldo(conta.getSaldo());
                return ResponseEntity.ok(conta); //Se for encontrado retorne 200 Atraves da anotacao ResponseEntity
            }
        }
        return ResponseEntity.notFound().build(); // Senao responda 404 notfound.
    }

}
