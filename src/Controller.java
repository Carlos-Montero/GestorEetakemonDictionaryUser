import java.util.*;

/**
 * Created by Carlos on 22/02/2017.
 */
public class Controller {


    private Map<String,Eetakemon> eetakemonmap = new HashMap<String,Eetakemon>();  //NUEVO
    private int currentID;


    public Eetakemon getEetakemonById (int id) {  //HECHO NUEVO
        for (String key : eetakemonmap.keySet()) {
            Eetakemon e = eetakemonmap.get(key);
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public int counter (){     //obtain current ID counter  HECHO NUEVO
        return currentID;
    }

    public boolean addEetakemon (Eetakemon e){  //add Eetakemon  HECHO NUEVO
        Eetakemon res = this.eetakemonmap.putIfAbsent(e.getName(),e);
        if (res==null){
            currentID++;
            return true;
        }
        else{
            return false;
        }

    }



    public boolean deleteEetakemonByID(int id){ //delete Eetakemon by ID HECHO NUEVO
       Eetakemon found =this.getEetakemonById(id);
       Eetakemon e = eetakemonmap.remove(found.getName());
       if (e !=null){
           return true;
        }
        else {
           return false;
        }

    }

    public Map<String,Eetakemon> showAll(){  //return current Eetakemon list   HECHO NUEVO
        return eetakemonmap;
    }

    public Eetakemon findEetakemon(String name){  //obtain all Eetakemon with this name  HECHO NUEVO

        Eetakemon e = eetakemonmap.get(name);
        if (e != null){
            return e;
        }
        else {
            return null;
        }

    }
}






