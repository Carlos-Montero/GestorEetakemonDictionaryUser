/**
 * Created by Carlos on 22/02/2017.
 */
public class Eetakemon {

    private String name;  //en vez de public seria mejor ponerlo privado (los atributos)
    private int id;
    private int level;

    public Eetakemon(){}

    public Eetakemon (String name, int id, int level){
        this.name = name;
        this.id = id;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

