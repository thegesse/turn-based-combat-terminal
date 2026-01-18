public class Potions {
    private String name;
    private String effect;

    // Constructor
    public Potions(String name, String effect) {
        this.name = name;
        this.effect = effect;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for effect
    public String getEffect() {
        return effect;
    }

    // Setter for effect
    public void setEffect(String effect) {
        this.effect = effect;
    }
}
