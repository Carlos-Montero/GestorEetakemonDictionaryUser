import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Controller eetakemonController = new Controller();
        UserController userController = new UserController();
        for(;;) {
            System.out.println();
            int option = chooseOption();

            switch (option) {
                case 1: addEetakemon(eetakemonController);
                    break;
                case 2: deleteById(eetakemonController);
                    break;
                case 3: listEetakemons(eetakemonController);
                    break;
                case 4: findByName(eetakemonController);
                    break;
                case 5: findByNameContain(eetakemonController);
                    break;
                case 6: createUser(userController);
                    break;
                case 7: logUser(userController);
                    break;
                case 8: listUsers(userController);
                    break;
                case 9: System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect option, try again");
            }
        }
    }

    public static int chooseOption() {
        System.out.println("MENU:");
        System.out.println("********************************************");
        System.out.println("1.Add Eetakemon");
        System.out.println("2.Delete Eetakemon by id");
        System.out.println("3.List all Eetakemons");
        System.out.println("4.Find by name");
        System.out.println("5.Find by contain in name");
        System.out.println("********************************************");
        System.out.println("6.Register User");
        System.out.println("7.Log In");
        System.out.println("8.List all Users");
        System.out.println("********************************************");
        System.out.println("9.Exit");
        System.out.print("Enter your choice: ");

        try {
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            System.out.println();
            return option;

        }
        catch (InputMismatchException ex) {
            System.out.println();
            System.out.print("Please, enter just a number: ");
            return 0;
        }
    }

    public static void addEetakemon(Controller eetakemonController) {
        try {
            System.out.print("Enter eetackemon name: ");
            Scanner input = new Scanner(System.in);
            String name = input.next();
            System.out.print("Enter eetackemon level: ");
            int level = input.nextInt();
            int id = eetakemonController.counter();
            Eetakemon e = new Eetakemon(name, id, level);
            boolean res = eetakemonController.addEetakemon(e);
            System.out.println();

            if(!res) {
                System.out.println("Name exists, please pick another name");
            }
            else {
                System.out.println("Eeteckemon added correctly (Name: " + name + ", id: " + id + ", level: " + level + ")");
            }
        }
        catch (InputMismatchException ex) {
            System.out.println();
            System.out.println("Please, enter the data in the correct format");
        }
    }

    public static void deleteById(Controller eetakemonController) {
        try {
            System.out.print("Enter id to remove: ");
            Scanner input = new Scanner(System.in);
            int id = input.nextInt();
            Eetakemon e = eetakemonController.getEetakemonById(id);
            boolean res = eetakemonController.deleteEetakemonByID(id);
            System.out.println();
            if (!res) {
                System.out.println("No results found by id: " + id);
            }
            else {
                System.out.println("Eetakemon deleted correctly (Name: " + e.getName() + ", id: " + id + ", level: " + e.getLevel() +")");
            }
        }
        catch (InputMismatchException ex) {
            System.out.println();
            System.out.println("Please, enter the id in the correct format");
        }
    }

    public static void listEetakemons(Controller eetakemonController) {
        Map<String, Eetakemon> printmap = eetakemonController.showAll();
        if(printmap.size() == 0) {
            System.out.println("Empty List");
        }
        else {
            for (String key: printmap.keySet()){
                Eetakemon e = printmap.get(key);
                System.out.println("Name: " + e.getName() + ", Id: " + e.getId() + ", Level: " + e.getLevel());
            }
        }
    }

    public static void findByName(Controller eetakemonController) {
        System.out.print("Enter eetakemon name to find: ");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        Eetakemon res = eetakemonController.findEetakemon(name);
        System.out.println();
        if(res == null) {
            System.out.println("No results found by name: " + name);
        }
        else {
            System.out.println("Name: " + res.getName() + ", Id: " + res.getId() + ", Level: " + res.getLevel());
        }
    }

    public static void findByNameContain(Controller eetakemonController) {
        System.out.print("Enter eetakemon name to find: ");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        List<Eetakemon> printlist = eetakemonController.findEetakemonContain(name);
        System.out.println();
        if(printlist.size() == 0) {
            System.out.println("No results found by name: " + name);
        }
        else {
            for (Eetakemon e : printlist) {
                System.out.println("Name: " + e.getName() + ", Id: " + e.getId() + ", Level: " + e.getLevel());
            }
        }
    }

    public static void createUser(UserController userController) {
        try {
            System.out.print("Enter username: ");
            Scanner input = new Scanner(System.in);
            String username = input.next();
            System.out.print("Enter email: ");
            String email = input.next();
            System.out.print("Enter password: ");
            String password = input.next();
            System.out.print("Enter password confirmation: ");
            String passwordconfirmation = input.next();
            if(password.equals(passwordconfirmation)) {
                User u = new User(username, email, password);
                boolean res = userController.registerUser(u);
                System.out.println();

                if (!res) {
                    System.out.println("Username exists, please pick another name");
                } else {
                    System.out.println("User added correctly (Username: " + username + ", email: " + email + ")");
                }
            }
            else
            {
                System.out.println("Password doesn't match, try again");
            }
        }
        catch (InputMismatchException ex) {
            System.out.println();
            System.out.println("Please, enter the data in the correct format");
        }
    }

    public static void logUser(UserController userController) {
        try {
            System.out.print("Enter username: ");
            Scanner input = new Scanner(System.in);
            String username = input.next();
            System.out.print("Enter password: ");
            String password = input.next();

            boolean res = userController.logInUser(username, password);
            System.out.println();

            if (!res) {
                System.out.println("Username or password not correct, try again");
            } else {
                User u = userController.getMap().get(username);
                System.out.println("User logged correctly (Username: " + username + ", email: " + u.getMail() + ", password: " + password + ", HASH: " + u.getPasswordHash() + ")");
            }
        }
        catch (InputMismatchException ex) {
            System.out.println();
            System.out.println("Please, enter the data in the correct format");
        }
    }

    public static void listUsers(UserController pUserController) {
        Map<String, User> printmap = pUserController.getMap();
        if(printmap.size() == 0) {
            System.out.println("Empty List");
        }
        else {
            for (String key: printmap.keySet()){
                User u = printmap.get(key);
                System.out.println("Username: " + u.getUsername() + ", email: " + u.getMail() + ", HASH: " + u.getPasswordHash());
            }
        }
    }

}