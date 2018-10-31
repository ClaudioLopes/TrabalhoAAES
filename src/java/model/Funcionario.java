/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import state.Pedido;
import state.PedidoEstado;
import controller.Factory;

/**
 *
 * @author claudio
 */
public abstract class Funcionario {
    private String nome;
    private String email;
    private String funcao;
    private int id;
    private Funcionario funcionarioSuperior;
    private String responsavel;

    public Funcionario(String nome, String email, String funcao, String funcionarioSuperior) {
        this.nome = nome;
        this.email = email;
        this.funcionarioSuperior = Factory.createFuncionario(funcionarioSuperior);
        this.funcao = funcao;
    }

    public Funcionario() {
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

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFuncao(){
        return funcao;
    }
    
    public void setFuncao(String funcao){
        this.funcao = funcao;
    }

    public Funcionario getFuncionarioSuperior() {
        return funcionarioSuperior;
    }

    public void setFuncaoSuperior(String funcionarioSuperior) {
        this.funcionarioSuperior = Factory.createFuncionario(funcionarioSuperior);
    }
    
    public void setResponsavel(PedidoEstado pedido){
        responsavel = pedido.getEstado();
    }
    
    public abstract String responsavel();
    
    public Funcionario responsavelPedido(PedidoEstado pedido){
        if(pedido.getEstado().equals(responsavel)){
            return this;
        }else{
            if(funcionarioSuperior != null){
                return funcionarioSuperior.responsavelPedido(pedido);
            }else{
                System.out.println("Não possui responsavel");
                return null;
            }
        }
    }
}
