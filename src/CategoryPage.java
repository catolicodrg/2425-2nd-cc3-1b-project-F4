import javax.swing.*;
import java.awt.*;

public class CategoryPage extends JFrame {

    public CategoryPage() {
        setTitle("Category Page");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // === NAVIGATION BAR ===
        JPanel navBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        navBar.add(new JLabel("📋 THE MENU"));

        JButton homeBtn = new JButton("Home");
        homeBtn.addActionListener(e -> {
            dispose();
            new HomePage();
        });

        navBar.add(homeBtn);
        navBar.add(new JButton("Categories"));
        navBar.add(new JButton("New"));
        navBar.add(new JButton("🔍"));
        navBar.add(new JButton("User"));

        add(navBar, BorderLayout.NORTH);

        // === MAIN PANEL ===
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        mainPanel.add(createCategorySection("Hot Dishes"));
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(createCategorySection("Cold Dishes"));

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createCategorySection(String title) {
        JPanel section = new JPanel();
        section.setLayout(new BorderLayout());

        JLabel label = new JLabel(title);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel grid = new JPanel(new GridLayout(1, 4, 10, 10));
        grid.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        for (int i = 1; i <= 4; i++) {
            JPanel card = new JPanel();
            card.setLayout(new BorderLayout());

            JLabel image = new JLabel(" ", SwingConstants.CENTER);
            image.setPreferredSize(new Dimension(150, 100));
            image.setOpaque(true);
            image.setBackground(Color.LIGHT_GRAY);

            JLabel name = new JLabel("Dish " + i, SwingConstants.CENTER);

            card.add(image, BorderLayout.CENTER);
            card.add(name, BorderLayout.SOUTH);
            grid.add(card);
        }

        section.add(label, BorderLayout.NORTH);
        section.add(grid, BorderLayout.CENTER);
        return section;
    }
}