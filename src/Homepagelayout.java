import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Homepagelayout extends JFrame {
    private RecipeDataBase recipeDataBase;

    public Homepagelayout() {
        recipeDataBase = new RecipeDataBase(); // Create a new instance of ProductDatabase

        // Initialize frame
        setTitle("Product App Homepage");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // === NAVIGATION BAR ===
        JPanel navBar = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton homeButton = new JButton("Home");
        homeButton.setEnabled(false); // Disable since we're on HomePage

        JButton categoriesButton = new JButton("Categories");
        categoriesButton.addActionListener(e -> goToCategoryPage());

        JButton newButton = new JButton("New");
        newButton.addActionListener(e -> showNewPage());

        JButton searchButton = new JButton("🔍");
        searchButton.addActionListener(e -> searchProducts());

        JButton userButton = new JButton("User");
        userButton.addActionListener(e -> goToUserPage());

        navBar.add(new JLabel("🛒 Products"));
        navBar.add(homeButton);
        navBar.add(categoriesButton);
        navBar.add(newButton);
        navBar.add(searchButton);
        navBar.add(userButton);

        add(navBar, BorderLayout.NORTH);

        // === FEATURED PANEL ===
        JPanel featuredPanel = new JPanel(new BorderLayout());
        featuredPanel.setBorder(BorderFactory.createTitledBorder("Featured Product"));

        JLabel featuredPlaceholder = new JLabel("Insert Image", SwingConstants.CENTER);
        featuredPlaceholder.setPreferredSize(new Dimension(600, 300));
        featuredPlaceholder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        featuredPanel.add(featuredPlaceholder, BorderLayout.CENTER);
        featuredPanel.add(new JLabel("Featured Product", SwingConstants.CENTER), BorderLayout.SOUTH);

        // === QUICK PRODUCTS PANEL ===
        JPanel quickProductsPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        quickProductsPanel.setBorder(BorderFactory.createTitledBorder("Quick Products"));

        List<Recipe> recipes = recipeDataBase.getAllProducts();
        for (Recipe product : recipes) {
            JButton productButton = new JButton(product.getName());
            productButton.setPreferredSize(new Dimension(100, 100));
            productButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            productButton.addActionListener(e -> new RecipeDetailFrame(product));
            quickProductsPanel.add(productButton);
        }

        // === CENTER PANEL (stacked vertically) ===
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        centerPanel.add(featuredPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(quickProductsPanel);

        // === SCROLL PANE WRAPPER ===
        JScrollPane scrollPane = new JScrollPane(centerPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    // Navigation actions
    private void goToCategoryPage() {
        dispose();
        new CategoryPage();
    }

    private void showNewPage() {
        JOptionPane.showMessageDialog(this, "New Page Coming Soon!");
    }

    private void searchProducts() {
        JOptionPane.showMessageDialog(this, "Search Functionality Coming Soon!");
    }

    private void goToUserPage() {
        JOptionPane.showMessageDialog(this, "User Page Coming Soon!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Homepagelayout());
    }
}
