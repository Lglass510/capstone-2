package model;

public abstract class Topping {
  public String name;
  public boolean isPremium;
  public boolean isExtra;

// region getters
    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public boolean isExtra() {
        return isExtra;
    }
 //endregion

    public Topping(String name, boolean isPremium, boolean isExtra){
      this.name = name;
      this.isPremium = isPremium;
      this.isExtra = isExtra;
  }

  public abstract double getPrice(SandwichSize size);

  }

