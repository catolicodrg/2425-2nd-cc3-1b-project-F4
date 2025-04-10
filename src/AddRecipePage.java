import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRecipePage extends JFrame {
    private RecipeDatabase recipeDatabase;

    public AddRecipePage() {
        recipeDatabase = RecipeDatabase.getInstance(); // Get the instance of RecipeDatabase

        setTitle("Add New Recipe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window on screen
        setLayout(new GridBagLayout()); // Use GridBagLayout for better control

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Set padding for each component
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Allow components to fill horizontally

        // Recipe name
        JLabel nameLabel = new JLabel("Recipe Name:");
        gbc.gridx = 0; // Position column 0
        gbc.gridy = 0; // Position row 0
        add(nameLabel, gbc);

        JTextField nameField = new JTextField(20);
        gbc.gridx = 1; // Position column 1
        gbc.gridy = 0; // Keep row 0
        add(nameField, gbc);

        // Recipe description
        JLabel descriptionLabel = new JLabel("Description:");
        gbc.gridx = 0; // Position column 0
        gbc.gridy = 1; // Position row 1
        add(descriptionLabel, gbc);

        JTextArea descriptionArea = new JTextArea(5, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane descriptionScroll = new JScrollPane(descriptionArea);
        gbc.gridx = 1; // Position column 1
        gbc.gridy = 1; // Keep row 1
        gbc.gridheight = 2; // Let it span two rows (description area)
        add(descriptionScroll, gbc);

        // Ingredients
        JLabel ingredientsLabel = new JLabel("Ingredients:");
        gbc.gridx = 0; // Position column 0
        gbc.gridy = 3; // Position row 3
        gbc.gridheight = 1; // Reset grid height
        add(ingredientsLabel, gbc);

        JTextField ingredientsField = new JTextField(20);
        gbc.gridx = 1; // Position column 1
        gbc.gridy = 3; // Keep row 3
        add(ingredientsField, gbc);

        // Steps
        JLabel stepsLabel = new JLabel("Steps:");
        gbc.gridx = 0; // Position column 0
        gbc.gridy = 4; // Position row 4
        add(stepsLabel, gbc);

        JTextArea stepsArea = new JTextArea(5, 20);
        stepsArea.setLineWrap(true);
        stepsArea.setWrapStyleWord(true);
        JScrollPane stepsScroll = new JScrollPane(stepsArea);
        gbc.gridx = 1; // Position column 1
        gbc.gridy = 4; // Keep row 4
        gbc.gridheight = 2; // Let it span two rows (steps area)
        add(stepsScroll, gbc);

        // Save and Cancel buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));  // Center the buttons
        JButton saveButton = new JButton("Save Recipe");
        JButton cancelButton = new JButton("Cancel");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String description = descriptionArea.getText();
                String ingredients = ingredientsField.getText();
                String steps = stepsArea.getText();

                if (!name.isEmpty() && !description.isEmpty() && !ingredients.isEmpty() && !steps.isEmpty()) {
                    Recipe newRecipe = new Recipe(name, description, ingredients, steps);
                    recipeDatabase.addRecipe(newRecipe);

                    // Navigate to HomePage after adding a recipe
                    navigateToHomePage();
                } else {
                    JOptionPane.showMessageDialog(AddRecipePage.this, "All fields must be filled out.");
                }
            }
        });

        cancelButton.addActionListener(e -> navigateToHomePage());

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        gbc.gridx = 0; // Position column 0
        gbc.gridy = 6; // Position row 6
        gbc.gridwidth = 2; // Let the button panel span two columns
        add(buttonPanel, gbc);

        setVisible(true);
    }

    // Method to navigate back to the HomePage
    private void navigateToHomePage() {
        dispose(); // Close the current window (AddRecipePage)
        new HomePage(); // Open the HomePage
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AddRecipePage());
    }
}
