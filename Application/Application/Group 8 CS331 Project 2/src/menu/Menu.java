/*
 *@author Mac DeCourcy
 */
package menu;

import core.Main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Menu {

    private static final String EXIT_TERM = "0";
    private static final String INDENTATION = "    ";
    private List<MenuOption> menuOptions = new ArrayList<>();
    private int level = 0;

    public Menu(){}

    public Menu(int level){
        this.level = level;
    }

    public void add(MenuOption m){
        this.menuOptions.add(m);
    }

    public int menuLoop(){

        String input;
            while (true) {
                Scanner sc = new Scanner(System.in);
                System.out.println(this);
                System.out.println();
                input = sc.next();
                if (input.equals(EXIT_TERM)) {
                    return 0;
                }
                AtomicBoolean optionFound = new AtomicBoolean(false);
                String finalInput = input;
                menuOptions.forEach(m -> {
                    if(m.matchesInput(finalInput)) {
                        try {
                            m.doAction();
                        } catch (SQLException | IOException throwables) {
                            throwables.printStackTrace();
                        }
                        optionFound.set(true);
                    }
                });

                if (!optionFound.get()) {
                    System.out.println("Option is not recognized.");
                }
            }

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Choose an option. Press " + EXIT_TERM + " to exit.\n");

        menuOptions.forEach(m -> {
            for(int i=0; i < level; i++){
                sb.append(INDENTATION);
            }
            sb.append(m).append("\n");
        });

        return sb.toString();
    }
}