package com.gabriel.contasapi.service;

import com.gabriel.contasapi.model.Conta;
import com.gabriel.contasapi.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


//ContaService é uma depedencia de ContaController
// ContaController depende da ContaService para trabalhar


@Service // Anotacao que diz que está classe é uma service
public class ContaService {


    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }


    //GET- read --> retorna uma lista de contas --> versao antiga
    //Agora contaRepository retorna contaRepository.
    public List<Conta> listarContas(){
         return contaRepository.listarContas(); // Leia: Repository busque um dado para mim e me devolva

     }
     //GET - READ
     //Service get por id --> Pega o id que o cliente envia, verifica se existe e retorna conta.
     public Conta buscarPorId(long id ){
        return contaRepository.buscarId(id);
    }


    public Conta cadastrar(Conta conta) {
        return contaRepository.cadastrar(conta);
    }


   /*() //CREATE - POST
    public Conta cadastrar(Conta conta) {

        //Adiciona o objeto a lista
        contas.add(conta);

        //E retorna o valor da lista, na controller podemos utilizar o valor desse metodo e armazena-lo
        //Pra dps mostrar em json o retorno ao cliente na controller.
        return conta;

    }
    */


    //UPDATE - PUT
    public Conta atualizar(long id,  Conta conta) {
        return contaRepository.atualizar(id, conta);


        /*for (Conta i : contas) {

            //Verifica se o id existe
            // Se existe altere os atributos do objeto com getters e setters.
            if(i.getId() == id) {
                i.setNomeConta(i.getNomeConta());
                i.setTitular(i.getTitular());
                i.setSaldo(i.getSaldo());
                i.setId(i.getId());

                return conta;
            }
        }
        return null;

         */
    }

    //Delete - Delete --> Deletar uma conta da lista contas
    public Conta deletarConta(long id) {

        return contaRepository.deletar(id);


        /*//Percorrendo a lista de compras pelos indices
        //
        for(int indice = 0 ; indice < contas.size() ; indice++){

            //Pega a posicao atual atual da lista
            Conta contaDeletar = contas.get(indice);

            //Verifica se o id da conta atual é o mesmo id vindo da requisicao
            if(contaDeletar.getId() == id) {
                contas.remove(indice);

                return contaDeletar;
            }

        }
        return null;

         */
    }
}
