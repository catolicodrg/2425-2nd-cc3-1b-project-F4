import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RecipeDetailPage extends JFrame {
    private Recipe recipe;

    public RecipeDetailPage(Recipe recipe) {
        this.recipe = recipe;

        setTitle(recipe.getName() + " - Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel recipeNameLabel = new JLabel(recipe.getName(), SwingConstants.CENTER);
        recipeNameLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel recipeDescriptionLabel = new JLabel("<html><div style='width: 500px;'>" + recipe.getDescription() + "</div></html>", SwingConstants.CENTER);

        JTextArea recipeStepsArea = new JTextArea();
        recipeStepsArea.setEditable(false);
        StringBuilder stepsText = new StringBuilder();
        List<String> steps = recipe.getSteps(); // This will need a method to get steps
        for (String step : steps) {
            stepsText.append(step).append("\n");
        }
        recipeStepsArea.setText(stepsText.toString());

        add(recipeNameLabel, BorderLayout.NORTH);
        add(recipeDescriptionLabel, BorderLayout.CENTER);
        add(new JScrollPane(recipeStepsArea), BorderLayout.SOUTH);

        setVisible(true);
    }
}
