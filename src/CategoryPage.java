import javax.swing.*;
import java.awt.*;

public class CategoryPage extends JFrame {

    public CategoryPage() {
        // Setup frame for Category page
        setTitle("Categories");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only the Category page, not the whole app
        setLayout(new BorderLayout());

        // === NAVIGATION BAR ===
        JPanel navBar = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Create and add buttons with respective action commands for this page's navbar
        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(e -> goToHomePage());

        JButton categoriesButton = new JButton("Categories");
        categoriesButton.setEnabled(false); // Disable the Categories button on the Categories page

        JButton newButton = new JButton("New");
        newButton.addActionListener(e -> goToNewPage());

        JButton searchButton = new JButton("🔍");
        searchButton.addActionListener(e -> searchProducts());

        JButton userButton = new JButton("User");
        userButton.addActionListener(e -> goToUserPage());

        // Add buttons to the navigation bar
        navBar.add(homeButton);
        navBar.add(categoriesButton);
        navBar.add(newButton);
        navBar.add(searchButton);
        navBar.add(userButton);

        // Add navigation bar to the frame
        add(navBar, BorderLayout.NORTH);

        // === CATEGORY CONTENT ===
        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new GridLayout(3, 2, 10, 10)); // Example layout (3 rows, 2 columns)

        // Add example category buttons (can be dynamic in future)
        for (int i = 1; i <= 6; i++) {
            // Make `i` final by using a final variable
            final int categoryId = i; // Final copy of i

            JButton categoryButton = new JButton("Category " + i);
            categoryButton.addActionListener(e -> viewCategoryDetails(categoryId)); // Pass the final variable
            categoryPanel.add(categoryButton);
        }

        // Add the category panel to the center of the frame
        add(categoryPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Go back to the home page
    private void goToHomePage() {
        dispose(); // Close the current Category page
        new Homepagelayout(); // Open HomePage
    }

    // Open the New page (this is just a placeholder)
    private void goToNewPage() {
        JOptionPane.showMessageDialog(this, "New Page Coming Soon!");
    }

    // Trigger search functionality (this is just a placeholder)
    private void searchProducts() {
        JOptionPane.showMessageDialog(this, "Search Functionality Coming Soon!");
    }

    // Navigate to the User page (this is just a placeholder)
    private void goToUserPage() {
        JOptionPane.showMessageDialog(this, "User Page Coming Soon!");
    }

    // View category details (for now just display category number)
    private void viewCategoryDetails(int categoryId) {
        JOptionPane.showMessageDialog(this, "Viewing details for Category " + categoryId);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CategoryPage());
    }
}
