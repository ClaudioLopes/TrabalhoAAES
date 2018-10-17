package strategy;

/**
 *
 * @author claudio
 */
public abstract class Produto {
    private Promocao promocao;
    private String nome;
    private int valor;

    public Produto() {
    }

    public Produto(Promocao promocao, String nome) {
        this.promocao = promocao;
        this.nome = nome;
    }

    public String getPromocao() {
        return promocao.obterPromocao();
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int desconto(){
        return promocao.obterDesconto();
    }
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
