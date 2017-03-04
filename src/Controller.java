import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Carlos on 22/02/2017.
 */
public class Controller {


    private Map<String,Eetakemon> eetakemonmap = new HashMap<String,Eetakemon>();
    private int currentID;

    public Eetakemon getEetakemonById (int id) {  //get Eetakemon by ID
        for (String key : eetakemonmap.keySet()) {
            Eetakemon e = eetakemonmap.get(key);
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public int counter (){     //obtain current ID counter
        return currentID;
    }

    public boolean addEetakemon (Eetakemon e){  //add Eetakemon
        Eetakemon res = this.eetakemonmap.putIfAbsent(e.getName(),e);
        if (res==null){
            currentID++;
            return true;
        }
        else{
            return false;
        }

    }

    public boolean deleteEetakemonByID(int id){ //delete Eetakemon by ID
       Eetakemon found =this.getEetakemonById(id);
       if (found != null){
           eetakemonmap.remove(found.getName());
           return true;
        }
        else {
           return false;
        }

    }

    public Map<String,Eetakemon> showAll(){  //return current Eetakemon list
        return this.eetakemonmap;
    }

    public Eetakemon findEetakemon(String name){  //obtain all Eetakemon with this name

        Eetakemon e = eetakemonmap.get(name);
        if (e != null){
            return e;
        }
        else {
            return null;
        }

    }

    public List<Eetakemon> findEtakemonContain(String name){  //return eetakemon list with a certain key word
        List<Eetakemon>resultlist = new ArrayList<Eetakemon>();
        for (String key: eetakemonmap.keySet()){
            Eetakemon e = eetakemonmap.get(key);
            if(e.getName().contains(name)){
                resultlist.add(e);
            }
        }
        return resultlist;
    }
}






