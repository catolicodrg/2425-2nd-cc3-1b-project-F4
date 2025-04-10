import java.io.Serializable;

public class Recipe implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String description;
    private String steps;
    private String imagePath;

    // Constructor
    public Recipe(String name, String description, String steps, String imagePath) {
        this.name = name;
        this.description = description;
        this.steps = steps;
        this.imagePath = imagePath;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSteps() {
        return steps;
    }

    public String getImagePath() {
        return imagePath;
    }
}
