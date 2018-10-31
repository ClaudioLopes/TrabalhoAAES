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
    private int id;
    private Produto produto; //Vai ser do tipo Produto

    public Empresa(String nome, String produto) {
        this.nome = nome;
        this.produto = Factory.createProduto(produto);
        
    }

    public Empresa() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduto(String produto) {
        this.produto = Factory.createProduto(produto);
    }

    public void setPromocao(Promocao promocao) {
        produto.setPromocao(promocao);
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
    
    
}
