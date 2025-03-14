import java.util.List;

class User {
    protected int id;
    protected String username;
    protected String password;
    protected List<Recipe> recipes;
    
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    
    public void logout() {}
    
    public boolean register(String username, String password) {
        this.username = username;
        this.password = password;
        return true;
    }
    
    public void createRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
    
    public void editRecipe(int recipeId, Recipe recipe) {}
    
    public void deleteRecipe(int recipeId) {}
    
    public Recipe viewRecipe(int recipeId) {
        return recipes.stream().filter(r -> r.id == recipeId).findFirst().orElse(null);
    }
}

