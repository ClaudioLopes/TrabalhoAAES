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
public class Rua extends Conteudo{
    private Conteudo conteudo;
    
    public Rua(String endereco) {
        super(endereco);
    }

    public void addConteudo(Conteudo conteudo){
        this.conteudo = conteudo;
    }
    
    public String getEndereco() {
        String descricaoSaida = this.endereco + "\n";
        return descricaoSaida;
    }
}
