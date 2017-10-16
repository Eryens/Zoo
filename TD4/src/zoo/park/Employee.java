package zoo.park;

import zoo.animals.Animal;
import zoo.enums.FoodQuantity;
import zoo.enums.Sexs;

public class Employee {

    public String name;
    public Sexs sex;
    public int age;

    public Employee() {
        name = "Pierre Paul";
        sex = Sexs.Hermaphrodite;
        age = 14;
    }

    public Employee(String name, Sexs sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void checkCage(Cage cage) {
        System.out.println("L'employé vérifie la cage");
        cage.display();
    }

    public void cleanCage(Cage cage) {
        System.out.println("L'employé tente de nettoyer la cage");
        cage.clean();
    }

    public void feedCage(Cage cage, FoodQuantity foodQuantity) {
        System.out.println("L'employé donne de la nourriture a la cage");
        cage.feedAnimals(foodQuantity);
    }

    public void switchAnimalFromCage(Cage cageFrom, Cage cageTo, Animal animal) {
        if (cageFrom.numbersOfAnimalsInCage != 0) {
            try {
                cageTo.addAnimal(animal);
                cageFrom.removeAnimal(animal);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("L'animal n'a pas pu être déplacé");
        }
    }
}
