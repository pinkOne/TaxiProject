package model;

/**
 * Created by Iurii on 03.03.2016.
 */
public class TestUser {
    public static void main(String[] args) {

        Person first = new User("iurii","123");
        Person second = new User("Viktor","123");
        Model taxi = new Model();
        taxi.addPerson(first);
        taxi.addPerson(second);

        Person result = taxi.getPersons().get(1);
        System.out.println(result.toString());

        System.out.println(taxi.placeOrder(1,"Fizkultury", "Kurska" ));
      //  System.out.println(taxi.getPersons().get(1).getType());



    }
}
