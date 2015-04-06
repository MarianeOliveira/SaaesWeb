
package br.com.teste.db;

import br.com.saaes.modelo.T900Usuario;
import br.com.saesdb.util.JPAUtil;
import javax.persistence.EntityManager;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MARI
 */
public class DBTeste {
    private EntityManager em = JPAUtil.getEm();
    
    @Test
    public void testeConexaoMysql() {
        
        T900Usuario user = em.find(T900Usuario.class,6L);
        
        assertTrue(user != null ? true : false);
    }
    
}
