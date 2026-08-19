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

    private List<Conta> contas = new ArrayList<>();

     public List<Conta> listarContas(){
         return contas;
     }

     public ResponseEntity<Conta> buscarPorId(@PathVariable long id ){
         for (Conta conta : contas) {

             if (conta.getId() == id) {
                 return ResponseEntity.ok(conta);
             }
         }
         return ResponseEntity.notFound().build();
    }
}
