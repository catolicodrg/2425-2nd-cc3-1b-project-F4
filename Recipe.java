import java.util.List;

class Recipe extends RecipeItem {
    private String description;
    private List<Ingredient> ingredients;
    private List<String> steps;
    private Category category;
    private List<Integer> ratings;
    
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
    }
    
    public void rateRecipe(int rating) {
        ratings.add(rating);
    }
    
    public float getAverageRating() {
        return (float) ratings.stream().mapToInt(i -> i).average().orElse(0);
    }
    
}