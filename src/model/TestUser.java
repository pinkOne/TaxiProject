package model;

/**
 * Created by Iurii on 03.03.2016.
 */
public class TestUser {
    public static void main(String[] args) {

        Person first = new User("iurii","123");
        Person second = new User("Viktor","123");
        Model taxi = new Model();
        Person driver1 = new Driver("Shef", "poehali");
        taxi.addPerson(first);
        taxi.addPerson(second);
        taxi.addPerson(driver1);
        Person result = taxi.getPersons().get(1);
        System.out.println(result.toString());

        System.out.println(taxi.placeOrder(1,"Fizkultury", "Kurska" ));
      //  System.out.println(taxi.getPersons().get(1).getType());

        Person drivetest1 = taxi.getPersons().get(2);
        taxi.pickOrder(2,0);
        taxi.placeOrder(0,"Lenina", "Kirova" );
        taxi.placeOrder(1,"darn", "Soloma" );
        System.out.println(taxi.getOrders().get(0).toString());

    }
}
