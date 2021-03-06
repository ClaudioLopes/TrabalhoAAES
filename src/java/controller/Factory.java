/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Funcionario;
import pagamento.FormaPagamento;
import strategy.Produto;

/**
 *
 * @author claudio
 */
public class Factory { // Padrao Factory Method
    public static Action create(String action) {
        Action actionObject = null;
        String nomeClass = "action." + action;
        Class classe = null;
        Object objeto = null;
        try{
           classe = Class.forName(nomeClass);
           objeto = classe.newInstance();
        }catch(Exception ex){
            return null;
        }
        if(!(objeto instanceof Action)){
            return null;
        }
        actionObject = (Action) objeto;
        return actionObject;
    }
    
    public static Produto createProduto(String produto) {
        Produto actionObject = null;
        String nomeClass = "strategy." + produto;
        Class classe = null;
        Object objeto = null;
        try{
           classe = Class.forName(nomeClass);
           objeto = classe.newInstance();
        }catch(Exception ex){
            return null;
        }
        if(!(objeto instanceof Produto)){
            return null;
        }
        actionObject = (Produto) objeto;
        return actionObject;
    }
    
    public static Funcionario createFuncionario(String funcao) {
        Funcionario actionObject = null;
        String nomeClass = "funcionario." + funcao;
        Class classe = null;
        Object objeto = null;
        try{
           classe = Class.forName(nomeClass);
           objeto = classe.newInstance();
        }catch(Exception ex){
            return null;
        }
        if(!(objeto instanceof Funcionario)){
            return null;
        }
        actionObject = (Funcionario) objeto;
        return actionObject;
    }
    
    public static FormaPagamento createFormaPagamento(String funcao) {
        FormaPagamento actionObject = null;
        String nomeClass = "pagamento." + funcao;
        Class classe = null;
        Object objeto = null;
        try{
           classe = Class.forName(nomeClass);
           objeto = classe.newInstance();
        }catch(Exception ex){
            return null;
        }
        if(!(objeto instanceof FormaPagamento)){
            return null;
        }
        actionObject = (FormaPagamento) objeto;
        return actionObject;
    }
}
