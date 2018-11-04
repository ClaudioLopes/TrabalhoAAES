/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.util.ArrayList;

/**
 *
 * @author claudio
 */
public class Combo { // Padrão composite
    private String nome;
    private float valor;
    private ArrayList produtos = new ArrayList();
    
    public Combo(Produto produto1, Produto produto2, String nome){
        produtos.add(produto1);
        produtos.add(produto2);
        this.nome = nome;
        this.valor = (produto1.getValor() + produto2.getValor())/2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Produto getProdutos(int id) {
        return (Produto) produtos.get(id);
    }

    public void setProdutos(Produto produto) {
        this.produtos.add(produto);
    }
    
    
}
