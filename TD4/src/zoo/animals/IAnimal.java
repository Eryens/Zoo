package zoo.animals;

import zoo.enums.FoodQuantity;

public interface IAnimal {

    void eat(FoodQuantity quantity);

    void scream();

    void die();

    void awake();

    void sleep();

    void display();

    String getSpecieName();
}
