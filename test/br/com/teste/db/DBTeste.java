
package br.com.teste.db;

import br.com.saaes.modelo.T900Usuario;
import br.com.saaes.modelo.T902Cursos;
import br.com.saesdb.dao.DAO;
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
    public void testeConexaoMysql() throws Exception {
        
        T900Usuario user = em.find(T900Usuario.class,6L);
        
        assertTrue(user != null ? true : false);
        
        T902Cursos t901 = new T902Cursos();
        
        DAO.save(t901, null, em, Boolean.FALSE);

        assertTrue(t901 != null ? true : false);
    }
    
}
