import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carlos on 01/03/2017.
 */
public class UserController {

    private Map<String,User> usermap = new HashMap<String,User>();

    public boolean registerUser(User pUser, String pPassword) {
        byte[] salt = CryptoUtils.getInstance().generateSalt(32);
        byte[] hash = CryptoUtils.getInstance().hashCompute(pPassword, salt);
        User newUser = new User(pUser.getUsername(), pUser.getMail(), CryptoUtils.getInstance().bytesToBase64(hash), CryptoUtils.getInstance().bytesToBase64(salt));
        User res = this.usermap.putIfAbsent(pUser.getUsername(), newUser);
        if (res == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean logInUser (String username, String password){    //login user
        User u = usermap.get(username);
        if (u!=null){
            byte[] salt = CryptoUtils.getInstance().base64ToBytes(u.getPasswordSalt());
            byte[] expectedHash = CryptoUtils.getInstance().hashCompute(password, salt);
            if (u.getPasswordHash().equals(CryptoUtils.getInstance().bytesToBase64(expectedHash))){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public Map<String, User> getMap(){
        return this.usermap;
    }

    public boolean removeUser (String username) {  //delete user by name

        User u =this.usermap.remove(username);
        if (u == null) {
            return false;
        }
        else{
            return true;
        }

    }

    public User findingUser(String username){  //obtain the user with this username

        User u = usermap.get(username);
        if (u != null){
            return u;
        }
        else {
            return null;
        }

    }
}
