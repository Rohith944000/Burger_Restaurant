import java.util.ArrayList;

public class Fridge {

    public static ArrayList<Burger> prepareBurgers(){
        ArrayList<Burger> allBurgers = new ArrayList<>();

        BasicBurger bb = new BasicBurger();
        HealthyBurger hb = new HealthyBurger();
        DeluxeBurger db = new DeluxeBurger();

        allBurgers.add(bb);
        allBurgers.add(hb);
        allBurgers.add(db);

        return allBurgers;
    }

    public static ArrayList<Topping> prepareToppings(){
        ArrayList<Topping> allToppings = new ArrayList<>();

        Topping tomato = new Topping("Tomato",1.27);
        Topping lettuce = new Topping("Lettuce",2.37);
        Topping cheese = new Topping("Cheese",2.77);
        Topping carrot = new Topping("Carrot",2.27);
        Topping pepper = new Topping("Pepper",0.57);
        Topping olives = new Topping("Olives",1.77);

        allToppings.add(tomato);
        allToppings.add(lettuce);
        allToppings.add(cheese);
        allToppings.add(carrot);
        allToppings.add(pepper);
        allToppings.add(olives);

        return allToppings;
    }

}
