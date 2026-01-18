import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PotionList {
        private final List<Potions> potions = new ArrayList<>();
        private final Random random = new Random();

    public PotionList(){
        potions.add(new Potions("Healing-potion", "heals 5hp"));
        potions.add(new Potions("Strenght-potion", "raises attack of the user by 10 for 1 turn"));
    }

    public List<Potions> getPotions() {
        return potions;
    }

        public Potions getRandomPotions() {
        return potions.get(random.nextInt(potions.size()));
    }

}
