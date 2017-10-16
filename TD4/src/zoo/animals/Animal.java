package zoo.animals;

import zoo.enums.*;

import java.util.Random;

public abstract class Animal implements IAnimal {

    protected String specieName;

    protected Sexs sex ;
    protected double weight;
    protected double height;
    protected int age ;

    protected boolean isPregnant;
    protected int pregancyDuration; // Days
    protected int pregnantSince;

    protected boolean isHungry;
    protected int hungerLevel ;
    protected boolean isSleeping;
    protected Health health;

    protected int numberMinChild;
    protected int numberMaxChild;

    /*
        Hunger level
        0 pas faim
        1 un peu faim
        2 faim
        3 très faim
        4 rip
     */


    // Default
    public Animal() {
        this.specieName = "?";

        generateAnimal();
    }

    public Animal(String specieName, Sexs sex, float weight, float height, int age, boolean isHungry, int hungerLevel, boolean isSleeping, Health health) {
        this.specieName = specieName;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.isHungry = isHungry;
        this.hungerLevel = hungerLevel;
        this.isSleeping = isSleeping;
        this.health = health;
    }

    protected void generateAnimal() {
        hungerLevel = 0 ;
        updateHunger();
        isSleeping = false ;
        health = Health.Healthy;
        isPregnant = false;
        pregnantSince = 0;
        age= 0;
        sex = generateSex();

    }// generateAnimal

    protected Sexs generateSex() {

        Random randomGenerator = new Random() ;
        int randomSex ;
        randomSex = randomGenerator.nextInt(1);
        if (randomSex == 0) {
            return Sexs.Female;
        }
        else {
            return Sexs.Male;
        }
    } // generate sex


    public void eat(FoodQuantity quantity) {
        if (!isSleeping) {
            if (quantity == FoodQuantity.ALot) {
                hungerLevel = 0;
            }
            else if (quantity == FoodQuantity.Normal) {
                hungerLevel -= 2;
            }
            else if (quantity == FoodQuantity.Little) {
                hungerLevel -= 1;
            }
        }
    } // eat

    public abstract void scream();

    public void beHealed() {
        health = Health.Healthy;
    }

    // --------------------- Fonctions générique ------------------------

    public void awake() {
        isSleeping = false;
    }

    public void sleep() {
        isSleeping = true;
    }

    public void updateHunger() {
        if (hungerLevel >= 4) {
            die() ;
        }
        if (hungerLevel < 0) {
            hungerLevel = 0;
        }
        if (hungerLevel != 0) {
            isHungry = true;
        }
        else {
            isHungry = false;
        }
    }

    public void die() {
        health = Health.Dead;
    }

    public boolean isDead() {
        if (health == Health.Dead) {
            return true;
        }
        return false;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    //----------------- GETTERS et SETTERS et ToString ---------------------------

    // -------- Getters

    public Sexs getSex() {
        return sex;
    }

    public String getSpecieName() {
        return specieName;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public boolean isSleeping() {
        return isSleeping;
    }

    public Health getHealth() {
        return health;
    }

    public boolean isPregnant() {
        return isPregnant;
    }

    // ---------- ToString

    public void display() {
        System.out.println("Nom: " + getSpecieName());
        System.out.println("Sexe: "+ getSex());
        System.out.println("Age: " + getAge());
        System.out.println("Poids: " + getWeight());
        System.out.println("Taille: " + getHeight());
        System.out.println("Faim: "+ isHungry());
        System.out.println("Santé: "+ getHealth());
        System.out.println("Dort: " + isSleeping());
    }
}
