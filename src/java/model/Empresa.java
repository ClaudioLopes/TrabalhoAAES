package model;

/**
 *
 * @author claudio
 */
public class Empresa {
    private String nome;
    private int id;
    private String produto; //Vai ser do tipo Produto
    private String promocao; // Vai ser do tipo promoção

    public Empresa(String nome) {
        this.nome = nome;
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
        this.produto = produto;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getProduto() {
        return produto;
    }

    public String getPromocao() {
        return promocao;
    }
    
    
}
