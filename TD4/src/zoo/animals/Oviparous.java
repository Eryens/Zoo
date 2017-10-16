package zoo.animals;

import java.util.ArrayList;

public interface Oviparous extends IAnimal {

    ArrayList<Oviparous> layEggs() ; // On assume que les oeufs sont des enfants, le statut ou la classe "oeuf" n'existant pas

}
