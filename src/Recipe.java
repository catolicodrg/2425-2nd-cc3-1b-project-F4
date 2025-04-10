// Product.java
import java.util.List;

public class Recipe extends RecipeItem {
    private String description;
    private List<String> steps;

    public Recipe(int id, String name, String description, List<String> steps) {
        super(id, name);
        this.description = description;
        this.steps = steps;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }
}
