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
    private Integer id;
    private int id_empresa;
    private Integer id_funcionario;
    private int id_cliente;
    private PedidoEstado estado;
    private List<Produto> produto;
    private Funcionario funcionarioResponsavel;
    private String nomeEstado;
    private Double valor;
    private ArrayList<Memento> estadoSalvo = new ArrayList();
    private FormaPagamento formaPagamento;

    public Pedido(List<Produto> produto, String nome, Double valor, FormaPagamento formaPagamento) {
        this.produto = produto;
        this.nomeEstado = nome;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }
    
    public Pedido() {
        funcionarioResponsavel = new Administrador("Cozinheiro");
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public Pedido setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
        return this;
    }

    public Integer getId_funcionario() {
        return id_funcionario;
    }

    public Pedido setId_funcionario(Integer id_funcionario) {
        this.id_funcionario = id_funcionario;
        return this;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public Pedido setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
        return this;
    }

    public Double getValor() {
        return valor;
    }

    public Pedido setValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public Pedido setNomeEstado(String nome) {
        this.nomeEstado = nome;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Pedido setId(Integer id) {
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
    

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public Pedido setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
        return this;
    }


    public PedidoEstado getPedidoEstado() {
        return estado;
    }

    public Pedido setPedidoEstado(PedidoEstado estado) {
        this.estado = estado;
        this.nomeEstado = estado.getEstado();
        funcionarioResponsavel.responsavelPedido(estado);
        estadoSalvo.add(saveToMemento(this));
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
    
    public Memento saveToMemento(Pedido pedido){
        return new Memento(pedido);
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
