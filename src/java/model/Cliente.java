package model;

import endereco.Bairro;
import endereco.Endereco;
import endereco.Numero;
import endereco.Rua;
import state.Pedido;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author claudio
 */
public class Cliente implements Observer{
    private String nome;
    private String email;
    private String telefone;
    private int id;
    private Endereco endereco;//Vai virar um tipo com um padrao de projeto
    
    private static int cont = -1;

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.id = ++cont;
    }
    
    public Cliente(Observable pedido) {
        pedido.addObserver(this);
    }
    
    public Cliente(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emial) {
        this.email = emial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(String bairro, String rua, String numero) {
        Bairro b = new Bairro(bairro);
        Rua r = new Rua(rua);
        Numero n = new Numero(numero);
        r.addConteudo(n);
        b.addConteudo(r);
        endereco.addConteudo(b);
    }
    

    public void update(Observable pedido, Object arg) {
        if(pedido instanceof Pedido){
            Pedido p = (Pedido) pedido;
            System.out.println("Atenção " + nome + "o pedido ja está em" + p.getPedidoEstado().getEstado());
        }else{
            System.out.println("Deu algum erro");
        }
    }
    
    
}
