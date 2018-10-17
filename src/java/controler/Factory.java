/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author claudio
 */
public class Factory {
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
}
