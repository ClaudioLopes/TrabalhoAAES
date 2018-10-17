/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

/**
 *
 * @author claudio
 */
public class PromocaoEntregaGratis implements Promocao{

    public int obterDesconto() {
        return 5;
    }

    public String obterPromocao() {
        return "Entrega Grátis";
    }
    
}
