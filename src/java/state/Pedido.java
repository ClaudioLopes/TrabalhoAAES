package state;

import controller.Memento;
import funcionario.Administrador;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import model.Funcionario;
import pagamento.FormaPagamento;
import strategy.Produto;

/**
 *
 * @author claudio
 */
public class Pedido  extends Observable{
    private PedidoEstado estado;
    private List<Produto> produto;
    private Funcionario funcionarioResponsavel;
    private int id;
    private String nome;
    private Double valor;
    private ArrayList<Memento> estadoSalvo = new ArrayList();
    private int formaPagamento;

    public Pedido(List<Produto> produto, String nome, Double valor, int formaPagamento) {
        this.produto = produto;
        this.nome = nome;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }
    
    public Pedido() {
        funcionarioResponsavel = new Administrador("Cozinheiro");
    }

    public Double getValor() {
        return valor;
    }

    public Pedido setValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Pedido setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public int getId() {
        return id;
    }

    public Pedido setId(int id) {
        this.id = id;
        return this;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public Pedido setProduto(List<Produto> produto) {
        this.produto = produto;
        return this;
    }
    

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }


    public PedidoEstado getPedidoEstado() {
        return estado;
    }

    public Pedido setPedidoEstado(PedidoEstado estado) {
        this.estado = estado;
        funcionarioResponsavel.responsavelPedido(estado);
        estadoSalvo.add(saveToMemento(estado));
        setChanged();
        notifyObservers();
        return this;
    }
    
    public void confirmar(){
        estado.confirmar(this);
    }
    
    public void emProducao(){
        estado.emProducao(this);
    }
    
    public void pronto(){
        estado.pronto(this);
    }
    
    public void emEntrega(){
        estado.emEntrega(this);
    }
    
    public void entrege(){
        estado.entrege(this);
    }
    
    public Memento saveToMemento(PedidoEstado estado){
        return new Memento(estado);
    }
    
    public void restoreFromMemento(Memento memento){
        estado = memento.getEstadoSalvo();
    }
    
    public void imprimiMemento(){
        for(Iterator i = estadoSalvo.iterator();i.hasNext();){
            System.out.println(i.next());
        }
    }
}
