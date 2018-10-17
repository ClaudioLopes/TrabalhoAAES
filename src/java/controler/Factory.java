/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import strategy.Produto;

/**
 *
 * @author claudio
 */
public class Factory { // Padrao Factory Method
    public static Usuario create(String usuario) {
        Usuario actionObject = null;
        String nomeClass = "usuario." + usuario;
        Class classe = null;
        Object objeto = null;
        try{
           classe = Class.forName(nomeClass);
           objeto = classe.newInstance();
        }catch(Exception ex){
            return null;
        }
        if(!(objeto instanceof Usuario)){
            return null;
        }
        actionObject = (Usuario) objeto;
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
}
