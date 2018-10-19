/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endereco;

/**
 *
 * @author claudio
 */
public abstract class Conteudo {
    protected String endereco;

    public Conteudo(String endereco) {
        this.endereco = endereco;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public abstract String getEndereco();
}
