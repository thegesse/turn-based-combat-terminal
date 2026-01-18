import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        MonsterList monsters = new MonsterList();
        PotionList potions = new PotionList();
        Combat combat = new Combat(monsters, potions);

        Entity player = new Entity("hero", 20, 10, 15);
        ArrayList<Potions> inventory = new ArrayList<>();
        boolean gameRunning = true;

        System.out.println("Reminder to update this to give explanaition and text");

        while(gameRunning == true && player.getHp() > 0) {
            Entity monster = combat.getRandomMonster();
            String effect = "";
            boolean strengthActive = false;

            while(monster.getHp() > 0 && player.getHp() > 0) {
                System.out.printf("Your HP: %d | Monster HP: %d%n", player.getHp(), monster.getHp());
                System.out.println("options: attack, defense, potions");
                String choice = scan.nextLine();

                switch(choice){
                    case "attack":
                        int monsterAction = combat.aiChoice();
                        int damage = player.getAttack();
                        if (strengthActive) {
                            damage += 10;
                        }

                        if (monsterAction == 2) { // monster defending
                            damage = Math.max(0, damage - monster.getDefense());
                        }

                        monster.setHp(monster.getHp() - damage);
                        System.out.println("You dealt " + damage + " damage!");
                        break;
                    case "defense" :
                        System.out.print("defending for the monsters attack");
                        break;
                    case "potions":
                        System.out.println(inventory);
                        effect = scan.nextLine();

                        if (effect.equals("Healing-potion")) {
                            player.setHp(player.getHp() + 5);
                        } else if (effect.equals("Strenght-potion")) {
                            strengthActive = true;
                        }
                        break;
                    default:
                        System.out.println("Command not recognised try again");
                        break;
                    }
                if(monster.getHp() > 0) {
                    int action = combat.aiChoice();
                    
                    if(action == 1 && choice == "defense") {
                        int damage = monster.getAttack() - player.getDefense();
                        player.setHp(player.getHp() - damage);
                        System.out.println(monster.getName() + " dealt " + damage + " damage!");

                    }else if (action == 1 && choice != "defense") {
                        int damage = monster.getAttack();
                        player.setHp(player.getHp() - damage);
                        System.out.println(monster.getName() + " dealt " + damage + " damage!");

                    }else {
                        System.out.println(monster.getName() + " is defending!");
                    }
                }
            }
                // Monster defeated
                if(monster.getHp() <= 0) {
                    System.out.println("You defeated the " + monster.getName() + "!");
                    inventory.add(combat.loot());
                }

                // Player defeated
                if(player.getHp() <= 0) {
                    System.out.println("You have been defeated!");
                    gameRunning = false;
                }
        }
    }

    
}
