public class Topping {

    String name;
    Double price;

    Topping(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s : $%.2f\n", this.name, this.price);
    }
}
