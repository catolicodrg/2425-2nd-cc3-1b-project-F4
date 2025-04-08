public class Category extends RecipeItem {
    public Category(int id, String name) {
        super(id, name);
    }

    public String getCategoryName() {
        return name;
    }
}
