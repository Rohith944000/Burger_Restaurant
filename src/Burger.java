import java.util.ArrayList;

public class Burger {
    private Double price;
    private String name;
    private int maxToppings;
    private ArrayList<Topping> toppings = new ArrayList<>();

    Burger (String name, Double price, int maxToppings){
        this.name = name;
        this.price = price;
        this.maxToppings = maxToppings;
    }


    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getMaxToppings() {
        return maxToppings;
    }

    public void setToppings(Topping topping){
        this.toppings.add(topping);
    }

    public ArrayList<Topping> getToppings(){
        return this.toppings;
    }
}
