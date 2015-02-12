package br.com.saaes.jsf.mb;

import br.com.saaes.facade.FacUtil;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import br.com.saaes.modelo.T900Usuario;
//import br.com.saaes.modelo.T900UsuarioPK;
import br.com.saesdb.util.JPAUtil;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author f4679646
 */
@ManagedBean
public class login implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String USUARIO = "usuario";

    private EntityManager em;
//    private T900UsuarioPK usuarioPk;
//    private T999Acesso usuario;
    private String nomeUsuario;
    private String senhaUsuario;
    private HttpSession session;

    public void login() {
    }

    @PostConstruct
    public void init() {
        em = JPAUtil.getEm();
        FacesContext context = FacesContext.getCurrentInstance();
        session = (HttpSession) context.getExternalContext().getSession(true);
    }
    public void entrar() {
        if (null != nomeUsuario) {
            T900Usuario usuario =  FacUtil.t900UsuarioNome(nomeUsuario, em);
           
            //verifica se é nulo
            
            //senao, verifica a senha
            
            if(usuario.getNome().equals(nomeUsuario)){
                System.out.println("CERTO");
                session.setAttribute(USUARIO, usuario);
                
            }else{
                System.out.println("ERRADO");
            }
            
        }

    }

    public void testaSenha() throws NoSuchAlgorithmException {
        String plaintext = "31021913";
        String hash = criptografa(plaintext, "MD5");
        hash = criptografa(hash, "SHA");

        System.out.println(hash);

    }

    public String criptografa(String plaintext, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance(algorithm);
        m.reset();
        m.update(plaintext.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String hashtext = bigInt.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

//    public T999Acesso getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(T999Acesso usuario) {
//        this.usuario = usuario;
//    }
//
//    public T900UsuarioPK getUsuarioPk() {
//        return usuarioPk;
//    }
//
//    public void setUsuarioPk(T900UsuarioPK usuarioPk) {
//        this.usuarioPk = usuarioPk;
//    }
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) throws NoSuchAlgorithmException {
        this.senhaUsuario = criptografa(senhaUsuario, "MD5");
        this.senhaUsuario = criptografa(this.senhaUsuario, "SHA");

    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
