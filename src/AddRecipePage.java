import javax.swing.*;
import java.awt.*;

public class AddRecipePage extends JFrame {
    private RecipeDatabase recipeDatabase;

    public AddRecipePage() {
        recipeDatabase = RecipeDatabase.getInstance(); // Get the instance of RecipeDatabase

        // Initialize frame
        setTitle("Add New Recipe");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Fields for adding new recipe
        JTextField nameField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextArea stepsArea = new JTextArea();
        JTextField imageField = new JTextField();
        JButton saveButton = new JButton("Save Recipe");

        saveButton.addActionListener(e -> {
            // Create a new recipe
            String name = nameField.getText();
            String description = descriptionField.getText();
            String steps = stepsArea.getText();
            String imagePath = imageField.getText();

            Recipe newRecipe = new Recipe(name, description, steps, imagePath);
            recipeDatabase.addRecipe(newRecipe); // Add the recipe to the database

            JOptionPane.showMessageDialog(this, "Recipe Added!");
            dispose(); // Close this window
        });

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Description:"));
        add(descriptionField);
        add(new JLabel("Steps:"));
        add(stepsArea);
        add(new JLabel("Image Path:"));
        add(imageField);
        add(saveButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AddRecipePage();
    }
}
