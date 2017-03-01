import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carlos on 01/03/2017.
 */
public class UserController {

    private Map<String,User> usermap = new HashMap<String,User>();

    public boolean registerUser (User user){
        User res = this.usermap.putIfAbsent(user.getUsername(),user);
        if (res == null) {
            return true;
        }
            else{
                return false;
            }


    }
}
