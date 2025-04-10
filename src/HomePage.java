import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HomePage extends JFrame {
    private RecipeDatabase recipeDatabase;

    public HomePage() {
        recipeDatabase = new RecipeDatabase(); // Create a new instance of RecipeDatabase

        // Initialize frame
        setTitle("Recipe App Homepage");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // === NAVIGATION BAR ===
        JPanel navBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        navBar.add(new JLabel("🍲 Recipes"));
        navBar.add(new JButton("Home"));
        navBar.add(new JButton("Categories"));
        navBar.add(new JButton("New"));
        navBar.add(new JButton("🔍"));
        navBar.add(new JButton("User"));
        add(navBar, BorderLayout.NORTH);

        // === FEATURED PANEL ===
        JPanel featuredPanel = new JPanel(new BorderLayout());
        featuredPanel.setBorder(BorderFactory.createTitledBorder("Featured Recipe"));

        JLabel featuredPlaceholder = new JLabel("Insert Image", SwingConstants.CENTER);
        featuredPlaceholder.setPreferredSize(new Dimension(600, 300));
        featuredPlaceholder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        featuredPanel.add(featuredPlaceholder, BorderLayout.CENTER);
        featuredPanel.add(new JLabel("Featured Recipe", SwingConstants.CENTER), BorderLayout.SOUTH);

        // === QUICK RECIPES PANEL ===
        JPanel quickRecipesPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        quickRecipesPanel.setBorder(BorderFactory.createTitledBorder("Quick Recipes"));

        List<Recipe> recipes = recipeDatabase.getAllRecipes();
        for (Recipe recipe : recipes) {
            JButton recipeButton = new JButton(recipe.getName());
            recipeButton.setPreferredSize(new Dimension(100, 100));
            recipeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            // Add an action listener to the button to open recipe details
            recipeButton.addActionListener(e -> new RecipeDetailPage(recipe)); // Open Recipe Detail on button click
            quickRecipesPanel.add(recipeButton);
        }

        // === CENTER PANEL (stacked vertically) ===
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        centerPanel.add(featuredPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(quickRecipesPanel);

        // === SCROLL PANE WRAPPER ===
        JScrollPane scrollPane = new JScrollPane(centerPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // smoother scrolling
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomePage());
    }
}
