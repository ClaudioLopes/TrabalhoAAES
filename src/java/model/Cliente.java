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
    private String senha;
    private int id;
    private String endereco;

    private static int cont = -1;

    public Cliente() {
        this.id = ++cont;
    }

    public Cliente(Observable pedido) {
        pedido.addObserver(this);
    }

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Cliente setEmail(String emial) {
        this.email = emial;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Cliente setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public int getId() {
        return id;
    }

    public Cliente setId(int id) {
        this.id = id;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getSenha() {
        return senha;
    }

    public Cliente setSenha(String senha) {
        this.senha = senha;
        return this;
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
