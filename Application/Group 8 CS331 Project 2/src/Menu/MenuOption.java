package menu;

public abstract class MenuOption {

    private String option;
    private String menuDescriptor;

    public MenuOption(String option, String menuDescriptor) {
        this.option = option;
        this.menuDescriptor = menuDescriptor;
    }

    public boolean matchesInput(String Input){
        return (option.equalsIgnoreCase(Input));
    }

    @Override
    public String toString() {
        return this.option + ". - " + this.menuDescriptor;
    }

    public abstract void doAction();


}