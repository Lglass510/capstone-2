package model;

public class Chip {

    private final ChipOption option;

    public Chip(ChipOption option) {
        this.option = option;
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


