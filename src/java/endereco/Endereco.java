/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endereco;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author claudio
 */
public class Endereco {
    private ArrayList endereco = new ArrayList();

    public void addConteudo(Conteudo conteudo){
        endereco.add(conteudo);
    }
    
    public void listarEmenta(){
        String descricaoEmenta = "";
        for(Iterator i = endereco.iterator(); i.hasNext();){
            Conteudo conteudo = (Conteudo) i.next();
            descricaoEmenta = descricaoEmenta + conteudo.getEndereco();
        }
        System.out.println(descricaoEmenta);
    }
}
