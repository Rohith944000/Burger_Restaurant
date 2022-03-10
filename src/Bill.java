public class Bill {

    Burger burger;

    public Bill(Burger burger){
        this.burger = burger;
    }

    public String generateReciept(){
        String s;
        double total = calculateTotal(this.burger);
        double tax = total * 0.15;
        double netTotal= total + tax;
        s = String.format("\nAmount: $%.2f  + (Tax: $%.2f)\nTotal Bill: $%.2f\n",total,tax,netTotal);
        return s;
    }


    private double calculateTotal(Burger burger){
        double tempTotal = 0;

        tempTotal += burger.getPrice();

        for (Topping topping: burger.getToppings()) {
            tempTotal += topping.getPrice();
        }

        return tempTotal;
    }


}
