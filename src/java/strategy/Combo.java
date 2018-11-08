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
    private int id_combo;
    private String nome;
    private Double valor;
    private List<Produto> produtos = new ArrayList();
    
    public Combo(List<Produto> produtos, String nome){
        this.valor = 0.0;
        this.produtos = this.produtos;
        this.nome = nome;
        for (Produto produto : produtos) {
            this.valor = this.valor + produto.getValor();
        }
        this.valor = (Double) (this.valor - (this.valor * 0.1));
    }
    
    public Combo() {
        
    }

    public int getId_combo() {
        return id_combo;
    }

    public Combo setId_combo(int id_combo) {
        this.id_combo = id_combo;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Combo setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Double getValor() {
        return valor;
    }

    public Combo setValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public Produto getProduto(int id) {
        return (Produto) produtos.get(id);
    }

    public Combo setProduto(Produto produto) {
        this.produtos.add(produto);
        return this;
    }
    
    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public Combo setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        return this;
    }
}
