import java.util.ArrayList;
import java.util.List;

public class RecipeDatabase {

    private List<Recipe> recipes;

    // Constructor
    public RecipeDatabase() {
        recipes = new ArrayList<>();
        // Add some sample recipes to the database (for testing purposes)
        List<String> steps1 = List.of("Step 1: Preheat oven", "Step 2: Mix ingredients", "Step 3: Bake for 20 minutes");
        recipes.add(new Recipe(1, "Chocolate Cake", "A rich chocolate cake.", "chocolate_cake.jpg", steps1));

        List<String> steps2 = List.of("Step 1: Boil pasta", "Step 2: Add sauce", "Step 3: Serve");
        recipes.add(new Recipe(2, "Pasta", "A simple pasta recipe.", "pasta.jpg", steps2));
    }

    // Method to get all recipes
    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    // Method to get a specific recipe by ID
    public Recipe getRecipeById(int id) {
        for (Recipe recipe : recipes) {
            if (recipe.getId() == id) {
                return recipe;
            }
        }
        return null; // If no recipe is found with the given ID
    }

    // Method to add a new recipe
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    // Method to remove a recipe
    public void removeRecipe(int id) {
        recipes.removeIf(recipe -> recipe.getId() == id);
    }
}
