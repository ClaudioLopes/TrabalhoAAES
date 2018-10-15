package persistence;

/**
 *
 * @author claudio
 */
public class ClienteDAO {
    private static ClienteDAO instance = new ClienteDAO();
    private ClienteDAO(){}
    public static ClienteDAO getInstance(){
        return instance;
    }
}
