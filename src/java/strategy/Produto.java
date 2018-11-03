package strategy;

/**
 *
 * @author claudio
 */
public abstract class Produto {
    private Promocao promocao;
    private String nome;
    private float valor;
    private int id;

    public Produto() {
    }

    public Produto(Promocao promocao, String nome) {
        this.promocao = promocao;
        this.nome = nome;
    }

    public String getPromocao() {
        return promocao.obterPromocao();
    }

    public Produto setPromocao(Promocao promocao) {
        this.promocao = promocao;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }
    
    public int desconto(){
        return promocao.obterDesconto();
    }
    
    public float getValor() {
        return valor;
    }

    public Produto setValor(float valor) {
        this.valor = valor;
        return this;
    }

    public int getId() {
        return id;
    }

    public Produto setId(int id) {
        this.id = id;
        return this;
    }
}
