public class Ingredient extends RecipeItem {
    private String quantity;

    public Ingredient(int id, String name, String quantity) {
        super(id, name);
        this.quantity = quantity;
    }

    public String getDetails() {
        return name + " (" + quantity + ")";
    }
}
