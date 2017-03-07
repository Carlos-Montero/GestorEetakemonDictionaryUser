import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carlos on 01/03/2017.
 */
public class UserController {

    private Map<String,User> usermap = new HashMap<String,User>();

    public String hashCompute(String toHash){   //obtain the password's hush

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(toHash.getBytes());
            byte byteData[] = md.digest();
            return String.format("%064x", new java.math.BigInteger(1, byteData)).toUpperCase();
        }
        catch (NoSuchAlgorithmException ex){
            return null;
        }
    }

    public boolean registerUser (User user){   //register user
        user.setPasswordHash(hashCompute(user.getPasswordHash()));
        User res = this.usermap.putIfAbsent(user.getUsername(),user);
        if (res == null) {
            return true;
        }
            else{
                return false;
            }


    }

    public boolean logInUser (String username, String password){    //login user
        User u = usermap.get(username);
        if (u!=null){
            if (u.getPasswordHash().equals(hashCompute(password))){
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
