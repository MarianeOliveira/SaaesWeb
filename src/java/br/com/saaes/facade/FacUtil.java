package br.com.saaes.facade;


import br.com.saaes.modelo.T900Usuario;
import br.com.saesdb.dao.DAO;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos Cariello F1765038
 */
public class FacUtil {

    public static T900Usuario t900UsuarioNome(String nome, EntityManager em) {
        return DAO.getSingleResultFromFromNamedQuery(T900Usuario.BUSCA_NOME, T900Usuario.class, em, nome);
    }

}
