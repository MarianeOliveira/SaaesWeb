package br.com.saaes.facade;

import br.com.saaes.modelo.T999Acesso;
import br.com.saes.jpa.DAO;
import javax.persistence.EntityManager;

/**
 *
 * @author
 */
public class FacUtil {

    public static T999Acesso getT99AcessoUsuario(T999Acesso usuario, EntityManager em) {
        return DAO.getSingleResultFromFromNamedQuery(T999Acesso.FIND_USUARIO, T999Acesso.class, em, usuario);
    }

}
