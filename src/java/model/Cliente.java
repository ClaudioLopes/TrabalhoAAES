package model;

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
    private String endereco;//Vai virar um tipo com um padrao de projeto
    
    private static int cont = -1;

    public Cliente(String nome, String email, String telefone, String endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
