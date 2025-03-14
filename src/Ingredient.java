class Ingredient extends RecipeItem {
    private String quantity;
    
    public String getDetails() {
        return name + " - " + quantity;
    }
}