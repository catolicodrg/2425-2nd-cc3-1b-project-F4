import java.util.List;

class RecipeManager {
    private List<Recipe> recipes;
    
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
    
    public void deleteRecipe(int recipeId) {}
    
    public void updateRecipe(int recipeId, Recipe recipe) {}
    
    public Recipe getRecipe(int recipeId) {
        return recipes.stream().filter(r -> r.id == recipeId).findFirst().orElse(null);
    }
    
    public List<Recipe> listRecipes() {
        return recipes;
    }
}
