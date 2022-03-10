public class DeluxeBurger extends Burger {
    private String rollType;

    DeluxeBurger(){
        super("Deluxe Burger",8.12,2);
        this.rollType = "Sousage";
    }

    public String getRollType() {
        return rollType;
    }

    @Override
    public String toString() {
        return String.format("%s with %s :- \nCost:  $%.2f, \nMax Toppings: %d\n",
                this.getName(),this.getRollType(),this.getPrice(),this.getMaxToppings());
    }
}
