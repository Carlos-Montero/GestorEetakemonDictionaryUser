import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Carlos on 01/03/2017.
 */
public class User {
    private String username;
    private String mail;
    private String passwordhash;
    private String passwordSalt;

    public User(String username, String email, String password){}

    public User (String username, String mail, String passwordhash, String salt){
        this.username = username;
        this.mail = mail;
        this.passwordhash = passwordhash;
        this.passwordSalt = salt;
    }

    public String getUsername() {
        return this.username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPasswordHash() {
        return this.passwordhash;
    }

    public void setPasswordHash(String passwordhash) {

        this.passwordhash = passwordhash;
    }

    public String getPasswordSalt(){
        return this.passwordSalt;
    }
}
