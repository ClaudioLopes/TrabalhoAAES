package model;

import controller.Factory;
import strategy.Produto;
import strategy.Promocao;

/**
 *
 * @author claudio
 */
public class Empresa {
    private String nome;
    private String senha;
    private String email;
    private int id;
    private Produto produto;

    public Empresa(String nome, String produto) {
        this.nome = nome;
        this.produto = Factory.createProduto(produto);

    }

    public Empresa() {
    }

    public String getEmail() {
        return email;
    }

    public Empresa setEmail(String email) {
        this.email = email;
        return this;
    }

    public Empresa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Empresa setId(int id) {
        this.id = id;
        return this;
    }

    public Empresa setProduto(String produto) {
        this.produto = Factory.createProduto(produto);
        return this;
    }

    public Empresa setPromocao(Promocao promocao) {
        produto.setPromocao(promocao);
        return this;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public String getPromocao() {
        return produto.getPromocao();
    }

    public String getSenha() {
        return senha;
    }

    public Empresa setSenha(String senha) {
        this.senha = senha;
        return this;
    }



}
