import java.util.List;

public class RecipeManager {
    private List<Recipe> recipes;

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public void deleteRecipe(int recipeId) {
        recipes.removeIf(recipe -> recipe.getId() == recipeId);
    }

    public void updateRecipe(int recipeId, Recipe recipe) {
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getId() == recipeId) {
                recipes.set(i, recipe);
                break;
            }
        }
    }

    public Recipe getRecipe(int recipeId) {
        return recipes.stream().filter(recipe -> recipe.getId() == recipeId).findFirst().orElse(null);
    }

    public List<Recipe> listRecipes() {
        return recipes;
    }
}