import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Carlos on 01/03/2017.
 */
public class User {
    private String username;
    private String mail;
    private String passwordhash;

    public User(){}

    public User (String username, String mail, String passwordhash){
        this.username = username;
        this.mail = mail;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(passwordhash.getBytes());
            byte[] digest = md.digest();
            this.passwordhash = String.format("%064x", new java.math.BigInteger(1, digest)).toUpperCase();
            }
        catch (NoSuchAlgorithmException ex){
            this.passwordhash = null;
        }


    }

    public String getUsername() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPasswordHash() {
        return passwordhash;
    }

    public void setPasswordHash(String passwordhash) {
        this.passwordhash = passwordhash;
    }
}
