import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeDatabase implements Serializable {
    private static final long serialVersionUID = 1L;

    private static RecipeDatabase instance;
    private List<Recipe> recipes;

    private static final String FILE_NAME = "recipes.dat"; // File to store recipes

    private RecipeDatabase() {
        recipes = new ArrayList<>();
    }

    public static RecipeDatabase getInstance() {
        if (instance == null) {
            instance = loadFromFile();
        }
        return instance;
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        saveToFile();
    }

    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    // Method to delete a recipe from the database
    public void deleteRecipe(Recipe recipe) {
        recipes.remove(recipe);
        saveToFile(); // Save the updated list after deletion
    }

    private static void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(instance);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static RecipeDatabase loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (RecipeDatabase) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new RecipeDatabase(); // Return a new database if no file is found
        }
    }
}
