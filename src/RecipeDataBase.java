// ProductDatabase.java
import java.util.List;
import java.util.ArrayList;

public class RecipeDataBase {
    private List<Recipe> recipes;

    public RecipeDataBase() {
        this.recipes = new ArrayList<>();
        // Add some dummy data for testing
        recipes.add(new Recipe(1, "Product 1", "Description of Product 1", List.of("Step 1", "Step 2")));
        recipes.add(new Recipe(2, "Product 2", "Description of Product 2", List.of("Step 1", "Step 2")));
    }

    public List<Recipe> getAllProducts() {
        return recipes;
    }

    public Recipe getProductById(int id) {
        return recipes.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }
}
