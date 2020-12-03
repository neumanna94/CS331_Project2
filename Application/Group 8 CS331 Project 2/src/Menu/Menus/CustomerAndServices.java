package Menu.Menus;

import Menu.Menu;
import Menu.MenuOption;

public class CustomerAndServices extends MenuOption {
    Menu menu = new Menu();

    public CustomerAndServices(String option, String menuDescriptor)
    {
        super(option, menuDescriptor);
    }

    @Override
    public void doAction() {
        menu.add(new MenuOption("1", "Analyze the progress of the business") {
            @Override
            public void doAction() {
                System.out.println("I'm in cust and services option 1");
            }
        });

        menu.add(new MenuOption("2", "Services") {
            @Override
            public void doAction() {
                System.out.println("I'm in cust and services option 2");
            }
        });

        menu.add(new MenuOption("3", "Customers") {
            @Override
            public void doAction() {
                System.out.println("I'm in cust and services option 3");
            }
        });

        menu.add(new MenuOption("0", "Exit") {
            @Override
            public void doAction() {
                System.out.println("Exiting...");
            }
        });
    }
}
