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
public class Numero extends Conteudo{
    public Numero(String endereco) {
        super(endereco);
    }

    public String getEndereco() {
        return endereco + "\n";
    }
}
