package strategy;

/**
 *
 * @author claudio
 */
public class PromocaoNatal implements Promocao{
    public int obterDesconto(){
        return 10;
    }
    
    public String obterPromocao(){
        return "Promocao de Natal";
    }
}
