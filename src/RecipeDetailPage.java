import javax.swing.*;
import java.awt.*;

public class RecipeDetailPage extends JFrame {
    private Recipe recipe;

    public RecipeDetailPage(Recipe recipe) {
        this.recipe = recipe;

        // Initialize frame
        setTitle(recipe.getName());
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // === RECIPE DETAILS PANEL ===
        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("Recipe: " + recipe.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel descriptionLabel = new JLabel("Description: " + recipe.getDescription());
        JLabel stepsLabel = new JLabel("Steps: " + recipe.getSteps());

        detailPanel.add(nameLabel);
        detailPanel.add(descriptionLabel);
        detailPanel.add(stepsLabel);

        // === IMAGE PANEL ===
        if (recipe.getImagePath() != null) {
            ImageIcon imageIcon = new ImageIcon(recipe.getImagePath());
            JLabel imageLabel = new JLabel(imageIcon);
            detailPanel.add(imageLabel);
        }

        add(detailPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
