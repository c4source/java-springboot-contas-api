package com.gabriel.contasapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity //Annotation JPA/HIBERNATE diz que esta classe é uma entidade
        //E que pode ser persistida no banco.
        //A classe assumi dois paapeis, de classe java e de uma tabela PostgreeSQL, HIBERNETE que faz isso. @Entity

@Table(name = "contas") // diz qual é o nome da tabela criada no postgreeSQL. contas.
public class Conta {


    @Id //Dizendo qual atributo é a CHAVE PRIMARIA do banco
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gera IDS automaticamente no banco para cada conta.
    private Long id;


    private String nomeConta;
    private String titular;
    private double saldo;

    //Construtor vazio para o jackson criar o objeto
    //Agora o HIBERNATE tbm usa o construtor vazio para instanciar a entidade.
    public Conta() {

    }

    public Conta(Long id, String nomeConta, String titular, double saldo) {
        this.id = id;
        this.nomeConta = nomeConta;
        this.titular = titular;
        this.saldo = saldo;
    }


    public Long getId() {
        return id;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
