package ui;

import model.*;

public class Main {
    public static void main(String[] args) {
        Sandwich subsonic = new Sandwich(BreadType.RYE, SandwichSize.EIGHT);
        subsonic.addTopping(new Meat("Turkey", false));
        subsonic.addTopping(new Meat("Bacon", true));
        System.out.println(subsonic.getSummary());
    }
}
