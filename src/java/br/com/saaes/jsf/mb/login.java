package br.com.saaes.jsf.mb;

import br.com.saaes.modelo.T999Acesso;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import br.com.saaes.app.util.JsfUtil;
import br.com.saaes.modelo.T900UsuarioPK;

/**
 *
 * @author f4679646
 */
@ManagedBean
public class login implements Serializable {

    private static final long serialVersionUID = 1L;

    private T900UsuarioPK usuarioPk;
    private T999Acesso usuario;

    public void login() {
    }

    @PostConstruct
    public void init() {

        EntityManager em = JsfUtil.getEm();
        this.usuario = new T999Acesso();
    }

    public void entrar() {
        if (null == usuario.getT999AcessoPK().getLogin()) {
            JsfUtil.addAlertMessage("Insira um nome de usuario!");
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

    public T999Acesso getUsuario() {
        return usuario;
    }

    public void setUsuario(T999Acesso usuario) {
        this.usuario = usuario;
    }

    public T900UsuarioPK getUsuarioPk() {
        return usuarioPk;
    }

    public void setUsuarioPk(T900UsuarioPK usuarioPk) {
        this.usuarioPk = usuarioPk;
    }

}
