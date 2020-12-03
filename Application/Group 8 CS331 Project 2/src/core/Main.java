package core;

import Menu.Menu;
import Menu.*;

public class Main {

    static Menu menu = new Menu();

    public static void main(String[] args){
        populateMenu();
        menu.menuLoop();
    }

    public static void populateMenu(){

        System.out.println("CLEAN N GO MENU");

        Menu equipAndSupplies = new Menu(1);
        Menu custAndServices = new Menu(1);

        custAndServices.add(new MenuOption("1", "Analyze the progress of the business") {
            @Override
            public void doAction() {
                System.out.println("I'm in cust and services option 1");
            }
        });

        custAndServices.add(new MenuOption("2", "Services") {
            @Override
            public void doAction() {
                System.out.println("I'm in cust and services option 2");
            }
        });

        custAndServices.add(new MenuOption("3", "Customers") {
            @Override
            public void doAction() {
                System.out.println("I'm in cust and services option 3");
            }
        });

        custAndServices.add(new MenuOption("0", "Exit") {
            @Override
            public void doAction() {
                System.out.println("Exiting...");
            }
        });

        menu.add(new MenuOption("1","Equipment & Supplies") {
            @Override
            public void doAction() {
                System.out.println("I'm in equipment and supplies");
                equipAndSupplies.menuLoop();
            }
        });

        menu.add(new MenuOption("2","Customers & Services") {
            @Override
            public void doAction() {
                System.out.println("Customers & Services");
                custAndServices.menuLoop();
            }
        });

    }
}
