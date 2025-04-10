// ProductDetailPage.java
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RecipeDetailFrame extends JFrame {
    private Recipe recipe;

    public RecipeDetailFrame(Recipe recipe) {
        this.recipe = recipe;

        setTitle(recipe.getName() + " - Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel productNameLabel = new JLabel(recipe.getName(), SwingConstants.CENTER);
        productNameLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel productDescriptionLabel = new JLabel("<html><div style='width: 500px;'>" + recipe.getDescription() + "</div></html>", SwingConstants.CENTER);

        JTextArea productStepsArea = new JTextArea();
        productStepsArea.setEditable(false);
        StringBuilder stepsText = new StringBuilder();
        List<String> steps = recipe.getSteps();
        for (String step : steps) {
            stepsText.append(step).append("\n");
        }
        productStepsArea.setText(stepsText.toString());

        add(productNameLabel, BorderLayout.NORTH);
        add(productDescriptionLabel, BorderLayout.CENTER);
        add(new JScrollPane(productStepsArea), BorderLayout.SOUTH);

        setVisible(true);
    }
}
