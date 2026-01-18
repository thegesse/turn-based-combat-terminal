import java.util.Random;


public class Combat {
    Random rand = new Random();
    private final MonsterList monsterList;
    private final PotionList potionList;

        public Combat(MonsterList monsterList, PotionList potionList) {
        this.monsterList = monsterList;
        this.potionList = potionList;
    }

    public Entity getRandomMonster() {
        return monsterList.getRandomMonster();
    }

    public int aiChoice() {
        int decision = rand.nextInt(1);
        if(decision == 0) {
            System.out.println("Monster used attack");
            return 1;
        }else {
            System.out.println("Monster used defense");
            return 2;
        }
    }

    public Potions loot() {
        return potionList.getRandomPotions();
    }
}
