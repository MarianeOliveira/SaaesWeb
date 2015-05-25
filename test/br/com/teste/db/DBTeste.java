package br.com.teste.db;

import br.com.saaes.modelo.T900Usuario;
import br.com.saaes.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Response;
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
            throw new IllegalArgumentException("Esse é o Error " + e.getMessage() + " || " + e.toString() + " || " + e.getLocalizedMessage());
        }
        T900Usuario user = em.find(T900Usuario.class, 1L);

        assertTrue(user != null ? true : false);
    }

    @Test
    public void cad() {
        String nome = "Sergio Antunes";
        nome = nome.trim();
        String nomeReduzido = "";
        int count = 0;
        for (int i = 0; i < nome.length(); i++) {
            if (nome.charAt(i) == ' ') {
                count++;
            }
            if (count < 2) {
                nomeReduzido = nomeReduzido + nome.charAt(i);
            }
        }

        String sobreNome = nome.substring(nome.indexOf(" ") + 1, nome.length());
        String nomeReduzido2 = nome.substring(0, nome.indexOf(" ")) + " " + sobreNome.substring(0, sobreNome.indexOf(" "));

    }

}
