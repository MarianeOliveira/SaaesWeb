package br.com.teste.db;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.junit.Test;

/**
 *
 * @author f4679646
 */
public class LoginTest {
    
    public LoginTest() {
        
    }
    
    @Test
    public void testGenerico() throws NoSuchAlgorithmException{
        String plaintext = "31021913";
        String hash = criptografa( plaintext, "MD5" );
        hash = criptografa(hash, "SHA");
        
        System.out.println( hash );
 
    }

    public String criptografa( String plaintext, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance(  algorithm );
        m.reset();
        m.update(plaintext.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
        }
        return hashtext;
    }
        
    
}
