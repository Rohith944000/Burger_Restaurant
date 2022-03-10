public class BasicBurger extends Burger {
    private String rollType;

    BasicBurger(){
        super("Basic Burger",3.56,4);
        this.rollType = "White Roll";
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
