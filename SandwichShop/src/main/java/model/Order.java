package model;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Sandwich> sandwiches = new ArrayList<>();
    private final List<SideItem> sides = new ArrayList<>();

    public void addSandwich(Sandwich sandwich){
        sandwiches.add(sandwich);
    }

    public void addSide(SideItem sideItem){
        sides.add(sideItem);
    }

    public double calculateTotal(){
        double total = 0;
        for (Sandwich s : sandwiches) total += s.calculateTotalPrice();
        for ( SideItem s : sides) total += s.getPrice();
        return total;
    }

    public String getReceipt(){
        StringBuilder sb = new StringBuilder();
        sb.append("🧾 SUBSONIC RECEIPT\n----------------------------\n");
        for (Sandwich s : sandwiches) {
            sb.append(s.getSummary()).append("\n\n");
        }
        for(SideItem s : sides){
            sb.append("Side: ").append(s.getName())
                    .append(" ($").append(String.format("%.2f", calculateTotal()));

        }
        sb.append("---------------------\n");
        sb.append("TOTAL: $").append(String.format("%.2f", calculateTotal()));
        return sb.toString();
    }
}
