package model;

public class Chip implements SideItem{

    private final ChipOption option;
    private final String name;

    @Override
    public String getName() {
        return name;
    }

    public Chip(ChipOption option, String name) {
        this.option = option;
        this.name = name;
    }

    public ChipOption getOption() {
        return option;
    }

    public double getPrice() {
        return option.getPrice();
    }

    @Override
    public String toString() {
        return option.toString();
    }
}


