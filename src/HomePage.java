import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HomePage extends JFrame {
    private RecipeDatabase recipeDatabase;

    public HomePage() {
        recipeDatabase = RecipeDatabase.getInstance(); // Get the instance of RecipeDatabase

        // Initialize frame
        setTitle("Recipe App Homepage");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // === NAVIGATION BAR ===
        JPanel navBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        // Creating navigation buttons
        JButton homeButton = new JButton("Home");
        homeButton.setEnabled(false); // Disable since we are on HomePage

        JButton categoriesButton = new JButton("Categories");
        categoriesButton.addActionListener(e -> goToCategoryPage());

        JButton newButton = new JButton("New");
        newButton.addActionListener(e -> goToAddRecipePage());

        JButton searchButton = new JButton("🔍");
        searchButton.addActionListener(e -> searchRecipes());

        JButton userButton = new JButton("User");
        userButton.addActionListener(e -> goToUserPage());

        // Adding buttons to the navigation bar
        navBar.add(new JLabel("🍲 Recipes"));
        navBar.add(homeButton);
        navBar.add(categoriesButton);
        navBar.add(newButton);
        navBar.add(searchButton);
        navBar.add(userButton);
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
            // Create a panel for each recipe (to hold the button and delete button)
            JPanel recipePanel = new JPanel(new BorderLayout());

            JButton recipeButton = new JButton(recipe.getName());
            recipeButton.setPreferredSize(new Dimension(100, 100));
            recipeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            recipeButton.addActionListener(e -> new RecipeDetailPage(recipe));

            // Create a delete button
            JButton deleteButton = new JButton("Delete");
            deleteButton.setPreferredSize(new Dimension(80, 30));
            deleteButton.setBackground(Color.RED);
            deleteButton.setForeground(Color.WHITE);
            deleteButton.addActionListener(e -> {
                recipeDatabase.deleteRecipe(recipe);
                refreshRecipesPanel(quickRecipesPanel); // Refresh the panel after deletion
            });

            recipePanel.add(recipeButton, BorderLayout.CENTER);
            recipePanel.add(deleteButton, BorderLayout.SOUTH);

            quickRecipesPanel.add(recipePanel);
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

    private void goToCategoryPage() {
        dispose();
        new CategoryPage(); 
    }

    private void goToAddRecipePage() {
        dispose();
        new AddRecipePage(); 
    }

    private void searchRecipes() {
        JOptionPane.showMessageDialog(this, "Search Functionality Coming Soon!");
    }

    private void goToUserPage() {
        JOptionPane.showMessageDialog(this, "User Page Coming Soon!");
    }

    // Method to refresh the "Quick Recipes" panel after a recipe is deleted
    private void refreshRecipesPanel(JPanel quickRecipesPanel) {
        quickRecipesPanel.removeAll(); // Remove all existing components

        List<Recipe> recipes = recipeDatabase.getAllRecipes();
        for (Recipe recipe : recipes) {
            // Create a panel for each recipe (to hold the button and delete button)
            JPanel recipePanel = new JPanel(new BorderLayout());

            JButton recipeButton = new JButton(recipe.getName());
            recipeButton.setPreferredSize(new Dimension(100, 100));
            recipeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            recipeButton.addActionListener(e -> new RecipeDetailPage(recipe));

            // Create a delete button
            JButton deleteButton = new JButton("Delete");
            deleteButton.setPreferredSize(new Dimension(80, 30));
            deleteButton.setBackground(Color.RED);
            deleteButton.setForeground(Color.WHITE);
            deleteButton.addActionListener(e -> {
                recipeDatabase.deleteRecipe(recipe);
                refreshRecipesPanel(quickRecipesPanel); // Refresh the panel after deletion
            });

            recipePanel.add(recipeButton, BorderLayout.CENTER);
            recipePanel.add(deleteButton, BorderLayout.SOUTH);

            quickRecipesPanel.add(recipePanel);
        }

        quickRecipesPanel.revalidate(); // Revalidate the layout
        quickRecipesPanel.repaint();    // Repaint the panel to reflect changes
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomePage());
    }
}
