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
    private String senha;
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

    public String getSenha() {
        return senha;
    }

    public Funcionario setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Funcionario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Funcionario setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getId() {
        return id;
    }

    public Funcionario setId(int id) {
        this.id = id;
        return  this;
    }
    
    public String getFuncao(){
        return funcao;
    }
    
    public Funcionario setFuncao(String funcao){
        this.funcao = funcao;
        return this;
    }

    public Funcionario getFuncionarioSuperior() {
        return funcionarioSuperior;
    }

    public Funcionario setFuncaoSuperior(String funcionarioSuperior) {
        this.funcionarioSuperior = Factory.createFuncionario(funcionarioSuperior);
        return this;
    }
    
    public Funcionario setResponsavel(PedidoEstado pedido){
        responsavel = pedido.getEstado();
        return this;
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
