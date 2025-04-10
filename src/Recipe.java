import java.util.List;

public class Recipe {
    private int id;
    private String name;
    private String description;
    private String imagePath;
    private List<String> steps; // List to store the steps for the recipe

    // Constructor
    public Recipe(int id, String name, String description, String imagePath, List<String> steps) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.steps = steps; // Initialize the steps
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getImagePath() { return imagePath; }
    public List<String> getSteps() { return steps; } // Add this getter for steps

    // Optionally, you can provide a toString method if needed
    @Override
    public String toString() {
        return name + " (" + description + ")";
    }
}
