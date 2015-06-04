package br.com.teste.db;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.faces.application.FacesMessage;
import javax.swing.JOptionPane;
import net.sf.ehcache.transaction.xa.commands.Command;
import org.junit.Test;

public class LoginTest {

    public LoginTest() {

    }

    @Test
    public void testGenerico() throws NoSuchAlgorithmException {
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

    @Test
    public void conta() {
        
//        JOptionPane.showConfirmDialog(null,"Tem certeza?","Sair da Calculadora",JOptionPane.YES_NO_OPTION) ;
        
        double size = (double) 7;
        int nota = 0;
        double cont = 100.0;
        double percent = (cont / size);

        if (percent < 15.0) {
            nota = 1;
        } else if (percent < 30.0) {
            nota = 2;
        } else if (percent < 50.0) {
            nota = 3;
        } else if (percent < 75.0) {
            nota = 4;
        } else if (percent >= 75.0) {
            nota = 5;
        }

        System.out.println(nota);
    }

}
