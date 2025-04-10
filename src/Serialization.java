import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String username;
    private String password;
    private List<Recipe> recipes;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.recipes = new ArrayList<>();
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void logout() {
        System.out.println("User logged out.");
    }

    public boolean register(String username, String password) {
        this.username = username;
        this.password = password;
        return true;
    }

    public void createRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public void editRecipe(int recipeId, Recipe recipe) {
        recipes.set(recipeId, recipe);
    }

    public void deleteRecipe(int recipeId) {
        recipes.remove(recipeId);
    }

    public Recipe viewRecipe(int recipeId) {
        return recipes.get(recipeId);
    }
}
