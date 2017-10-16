package zoo.animals;

import java.util.ArrayList;

public interface Mammal extends IAnimal {

    void getPregnant() ;

    ArrayList<Mammal> giveBirth() ;

}
