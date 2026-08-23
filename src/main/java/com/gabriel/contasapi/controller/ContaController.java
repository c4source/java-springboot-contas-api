package com.gabriel.contasapi.controller;


import com.gabriel.contasapi.model.Conta;
import com.gabriel.contasapi.service.ContaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController //Marca a classe como uma CONTROLLER | @RestController: annotation
@RequestMapping("/contas") // anotacao define o endereço do controller base na classe, evitando que cada endpoint repita o ("/contas")
public class ContaController {

    //private List<Conta> contas = new ArrayList<>(); // É um atributo do Controller que possibilita o get e post trabalhar na lista

    //Criando a dependencia
    //ContaController precisa de ContaService
    //Espring vai fornercer o objeto
    private final ContaService contaService;


    //Injetando a depedencia
    public ContaController(ContaService contaService) {
        this.contaService = contaService;

    }

    //GET - READ --> Leitura simples sem buscar por ID.
    @GetMapping// Quando chegar a requisicao em /contas (aqui), execute e retorne buscarContas()
    public List<Conta> buscarContas() {
        return contaService.listarContas();
        //return contas; //Retorna os objetos da lista do controller ( objetos )
    }

      /*
        Vamos retornar um OBJETO do tipo CONTA

        Conta conta = new Conta (1L, "Conta Corrente", "Gabriel", 9959.53);
        Conta conta2 = new Conta (2L, "Conta poupanca", "Pamela", 10.000 );


        return List.of(conta, conta2);
       */

    @PostMapping //Post: criar/enviar uma conta.
    public ResponseEntity<Conta> cadastrar(@RequestBody Conta conta) { // @Requestbody transforma o corpo da requisicao em objeto do tipo Conta

        Conta contaAdd = contaService.cadastrar(conta); // Variavel local recebendo o valor do metodo cadastrar() para ser retornado o resultado que service devolveu
                                                        // É uma variavel para receber o valor de contaService
        if(contaAdd != null) {
            return ResponseEntity.ok(contaAdd);
        }
        return ResponseEntity.notFound().build();

        /*Adiciona o objeto à lista e o armazena
        contas.add(conta);

        return conta;
         */
    }

    //Agora nossa Controller, vai apenas pegar o id e chamar a função que está dentro da service.
    //A controller agora só responsável por receber e enviar as requisicoes.
    //As anotacoes de requisicao HTTP fica na controller.

    @GetMapping("/{id}")
    //Nova Assinatura: ResponseEntity<> --> Esse metodo retorna uma resposta HTTP que pode carregar uma Conta
    public ResponseEntity<Conta> buscarId(@PathVariable Long id) {

        Optional<Conta> conta = contaService.buscarPorId(id);

        if (conta.isPresent()) {
            return ResponseEntity.ok(conta.get()); //Se achar responde 200, e pegue a Conta q esta ai dentro
        }
        return ResponseEntity.notFound().build(); //senao achar o id devolva uma notFound 404 sem objeto no corpo
    }

    //Atualizar (Update) dados que vem em json, é convertido para objeto e é alterado os valores do objeto.
    @PutMapping("/{id}")
    public ResponseEntity<Conta> atualizarDados(@PathVariable Long id, @RequestBody Conta conta) { //ParthVariable Recebe dados da URL ex (id)

        Conta contaAtualizada = contaService.atualizar(id, conta);

        if (contaAtualizada != null) {
            return ResponseEntity.ok(contaAtualizada); //Se for encontrado retorne 200 Atraves da anotacao ResponseEntity
        }
        return ResponseEntity.notFound().build(); // Senao responda 404 notfound.

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Conta> deletarConta(@PathVariable Long id) {

        Optional<Conta> contaDeletada = contaService.deletarConta(id);

        if(contaDeletada != null) {
            return ResponseEntity.ok(contaDeletada.get());
        }
        return ResponseEntity.notFound().build();

    }


}
