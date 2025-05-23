package model;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;
    private List<Sauces> sauces;

    public Order() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
        sauces = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich){sandwiches.add(sandwich);}

    public void addDrink(Drink drink){drinks.add(drink); }

    public void addChips(Chips chips){this.chips.add(chips);}

    public void addSauce(Sauces sauce){sauces.add(sauce);}

    public double calculateTotal() {
        double total = 0.0;
        for (Sandwich sandwich : sandwiches) {
            total += sandwich.getPrice();
        }
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }
        for (Chips chip : chips) {
            total += chips.getPrice();
        }
        return total;
    }
    public void clear() {
        sandwiches.clear();
        drinks.clear();
        chips.clear();
        sauces.clear();
    }


//region getters
        public List<Sandwich> getSandwiches () {
            return sandwiches;
        }

        public List<Drink> getDrinks () {
            return drinks;
        }

        public List<Chips> getChips () {
            return chips;
        }

        public List<Sauces> getSauces () {
            return sauces;
        }
//endregion

    }




