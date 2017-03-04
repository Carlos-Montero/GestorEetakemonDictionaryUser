import javax.naming.ldap.Control;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Controller control = new Controller();
        UserController usercontrol = new UserController();

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));


        int indice = 75;
        while (indice != 0) {

            System.out.println("\n Select option");
            System.out.println("**************************");
            System.out.println("1: Add Eetakemon");
            System.out.println("2: Delete Eetakemon by ID");
            System.out.println("3: List all Eetakemons");
            System.out.println("4: Find Eetakemon by name");
            System.out.println("5: Find Eetakemon by a certain keyword");
            System.out.println("6: Create user");
            System.out.println("7: Log In");
            System.out.println("8: List users");
            System.out.println("0: Exit");

            int option = Integer.parseInt(buff.readLine());
            switch (option) {

                    case 1: //add Eetakemon    FUNCIONA  HECHO NUEVO
                        System.out.println("Introduce name");
                        String name = buff.readLine();
                        System.out.println ("Introduce level");
                        int level = Integer.parseInt(buff.readLine());
                        int id = control.counter();
                        Eetakemon e = new Eetakemon(name,id, level);
                        boolean res = control.addEetakemon(e);
                        if(res==true){
                            System.out.println ("Eetakemon introducido correctamente");
                        }
                        else{
                            System.out.println ("Fallo al añadir");
                        }
                        break;

                    case 2:// delete Eetakemon by ID   HECHO NUEVO
                            System.out.println("Introduce ID");
                            int ID = Integer.parseInt(buff.readLine());
                            boolean res2 = control.deleteEetakemonByID(ID);
                            System.out.println();
                            if (res2 == false) {
                                System.out.println("No results found by id: " + ID);
                            } else {
                                System.out.println("Eetakemon delete correctly");
                            }
                        break;

                    case 3:  //list all Eetakemons   FUNCIONA
                       
                        //for (int i=0; i<control.showAll().size(); i++){
                          //  System.out.println("Name: "+ control.showAll().get(i).getName() +" Id: "+control.showAll().get(i).getId()+" Level: "+control.showAll().get(i).getLevel());
                        //}
                        break;

                    case 4://Find Eetakemon by Name    FUNCIONA
                        System.out.println("Introduce name");
                        String name2 = buff.readLine();
                        for (int i=0; i<control.showAll().size(); i++){
                            if (control.showAll().get(i).getName().equals(name2)){
                                System.out.println("Name: "+ control.showAll().get(i).getName() +" Id: "+control.showAll().get(i).getId()+" Level: "+control.showAll().get(i).getLevel());
                            }
                        }
                        break;

                    case 0:
                        System.out.println("Hasta luego");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Incorrect option, try again");

                }
            }

        }
    }
