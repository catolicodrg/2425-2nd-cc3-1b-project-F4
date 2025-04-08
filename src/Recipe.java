import java.util.List;

public class Recipe extends RecipeItem {
    private String description;
    private List<Ingredient> ingredients;
    private List<String> steps;
    private Category category;
    private List<Integer> ratings;

    public Recipe(int id, String name, String description, List<Ingredient> ingredients, List<String> steps, Category category) {
        super(id, name);
        this.description = description;
        this.ingredients = ingredients;
        this.steps = steps;
        this.category = category;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    public void editRecipe(String name, String description, List<String> steps) {
        this.name = name;
        this.description = description;
        this.steps = steps;
    }

    public void displayRecipe() {
        System.out.println("Recipe: " + name);
        System.out.println("Description: " + description);
        System.out.println("Ingredients: " + ingredients);
        System.out.println("Steps: " + steps);
        System.out.println("Category: " + category.getName());
    }

    public void rateRecipe(int rating) {
        ratings.add(rating);
    }

    public float getAverageRating() {
        if (ratings.isEmpty()) return 0;
        int sum = ratings.stream().mapToInt(Integer::intValue).sum();
        return (float) sum / ratings.size();
    }
}
