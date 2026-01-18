import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MonsterList {
    private final List<Entity> monsters = new ArrayList<>();
    private final Random random = new Random();


    public MonsterList(){
        monsters.add(new Entity("skeleton", 5, 5, 3));
        monsters.add(new Entity("goblin", 5, 2, 2));
        monsters.add(new Entity("ork", 15, 10, 5));
        monsters.add(new Entity("werewolf", 10, 20, 4));
        monsters.add(new Entity("vampire", 15, 7, 8));
    }

    public List<Entity> getMonsters() {
        return monsters;
    }

    public Entity getRandomMonster() {
        return monsters.get(random.nextInt(monsters.size()));
    }

}
