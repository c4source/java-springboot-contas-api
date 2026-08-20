package com.gabriel.contasapi.model;

public class Conta {

    private Long id;
    private String nomeConta;
    private String titular;
    private double saldo;

    //Construtor vazio para o jackson criar o objeto
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
