/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claudio
 */
public class Combo { // Padrão composite
    private String nome;
    private float valor;
    private ArrayList produtos = new ArrayList();
    
    public Combo(List<Produto> produtos, String nome){
        this.valor = 0;
        this.produtos = this.produtos;
        this.nome = nome;
        for (Produto produto : produtos) {
            this.valor = this.valor + produto.getValor();
        }
        this.valor = (float) (this.valor - (this.valor * 0.1));
    }
    
    public Combo() {
        
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
    
    public List<Produto> getProdutos() {
        return this.produtos;
    }
}
