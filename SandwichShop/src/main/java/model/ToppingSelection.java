package model;

import model.Topping;

public class ToppingSelection {
        private final Topping topping;
        private final boolean extra;

        public ToppingSelection(Topping topping, boolean extra) {
            this.topping = topping;
            this.extra = extra;
        }

        public Topping getTopping() {
            return topping;
        }

        public boolean isExtra() {
            return extra;
        }

        public double getPrice(SandwichSize size) {
            return topping.getPrice(size, extra);
        }

        @Override
        public String toString() {
            return (extra ? "Extra " : "") + topping.toString();
        }
    }


