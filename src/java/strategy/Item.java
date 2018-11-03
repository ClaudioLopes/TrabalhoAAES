package strategy;

/**
 *
 * @author claudio
 */
public class Item extends Produto{
    public Item () {
        
    }
    
    public Item(int valor, String nome){
        this.setNome(nome);
        this.setValor(valor);
    }
}
