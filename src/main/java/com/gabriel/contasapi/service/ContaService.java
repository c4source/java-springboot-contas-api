package com.gabriel.contasapi.service;

import com.gabriel.contasapi.model.Conta;
import com.gabriel.contasapi.repository.ContaRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

import java.util.List;


//ContaService é uma depedencia de ContaController
//ContaController depende da ContaService para trabalhar


@Service // Anotacao que diz que está classe é uma service
public class ContaService {

    //Criando a depedencia.
    private final ContaRepository contaRepository;

    //Injetando dependencia
    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }


    //GET- read --> retorna uma lista de contas --> versao antiga
    //Agora contaRepository retorna contaRepository.
    //Agora com os dados persistidos com o postgreeSQL
    //O JPA/Hibernate abstrai boa parte do crude e já cria as tabelas SQL.
    public List<Conta> listarContas(){
         return contaRepository.findAll(); // Leia: Repository busque um dado para mim e me devolva

     }
     //GET - READ
     //Service get por id --> Pega o id que o cliente envia, verifica se existe e retorna conta.
     public Optional<Conta> buscarPorId(Long id ){
        return contaRepository.findById(id);
    }


    public Conta cadastrar(Conta conta) {
        return contaRepository.save(conta);
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
    public Conta atualizar(Long id,  Conta novosDados) {

        //Se existir o objeto correspondente ao ID, colocamos dentro de contaEcontrada. É um tipo Optional (Pode existir ou não).
        Optional<Conta> contaEncontrada = contaRepository.findById(id);

        //Se o objeto existir vamos colocar dentro de conta.
        if(contaEncontrada.isPresent()){

            //Tira conta dentro de Optional.
            //Objeto conta é pego e colocado dentro de conta
            Conta conta = contaEncontrada.get();

            //novosDados é o parametro recebido via JSON pelo cliente.
            //Leia: Pegue os NovosDados e altere o nome, titular e saldo.
            conta.setNomeConta(novosDados.getNomeConta());
            conta.setTitular(novosDados.getTitular());
            conta.setSaldo(novosDados.getSaldo());

            //Agora retorne e salve no banco essa atualizacao
            return contaRepository.save(conta);
        }
    return null;





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
    //Metodo é do tipo Optional (Ve se existe pelo id ou não)
    public Optional<Conta> deletarConta(Long id) {

        //A conta encontrada correspondente ao ID vai ser posta aqui.
        Optional<Conta> contaEncontrada = contaRepository.findById(id);

        //Verificamos se existe a conta
        if(contaEncontrada.isPresent()){

            //Se existir colocamos o objeto dentro de conta
            Conta conta = contaEncontrada.get();

            //Deletamos o objeto do banco
            contaRepository.delete(conta);

            //Retornamos pra controller a conta que foi deletada
            return contaEncontrada;

        }
        //
        return Optional.empty();

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
