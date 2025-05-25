package model;
import model.SandwichSize;

public interface Topping {
    double getPrice(SandwichSize size, boolean extra);

}
