
package br.com.teste.db;

import br.com.saaes.modelo.T900Usuario;
import br.com.saaes.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MARI
 */
public class DBTeste {
    private EntityManager em;
    
    @Test
    public void testeConexaoMysql() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SaesDBasePU");
            em = emf.createEntityManager();
        } catch (Throwable e) {
            throw new IllegalArgumentException("Esse é o Error " +e.getMessage() + " || "+ e.toString() + " || "+ e.getLocalizedMessage());
        }
        T900Usuario user = em.find(T900Usuario.class,1L);
        
        assertTrue(user != null ? true : false);
    }
    
    @Test
    public void cad(){
    
      
    }
    
}
