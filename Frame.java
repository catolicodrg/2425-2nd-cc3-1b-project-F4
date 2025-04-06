import javax.swing.*;
import java.awt.*;
 //size of the frame
public class frame extends JFrame {
    public frame() {
        setTitle("Recipes");
        setSize(1280,1024);
        setLayout(new BorderLayout());

        // Nav shi
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(new JLabel("Recipes"));
        topPanel.add(new JButton("Home"));
        topPanel.add(new JButton("Categories"));
        topPanel.add(new JButton("New"));
        topPanel.add(new JButton("🔍"));
        topPanel.add(new JButton("User"));

        // panel for featured
        JPanel featuredPanel = new JPanel(new BorderLayout());

        // image test
        ImageIcon tinolaImage = new ImageIcon("Onedrive/Desktop/2nd_Semester_UC/GROUP_WORKS/CC3_F4_STUFF/images/tinola.jpg");// idk why it no work
        if (tinolaImage.getIconWidth() == -1) {
            System.out.println("Error: Image not found. Check file path.");
        } else {
            Image img = tinolaImage.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
            tinolaImage = new ImageIcon(img);
        }

        JLabel featuredImage = new JLabel(tinolaImage);
        featuredImage.setPreferredSize(new Dimension(400, 200));
        featuredImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        featuredPanel.add(featuredImage, BorderLayout.CENTER);
        featuredPanel.add(new JLabel("Tinola", SwingConstants.CENTER), BorderLayout.SOUTH);

        // Quick dishes
        JPanel quickDishesPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        for (int i = 0; i > 4; i++) {
            JPanel dishPanel = new JPanel(new BorderLayout());
            JLabel imageLabel = new JLabel("Insert Image", SwingConstants.CENTER);
            imageLabel.setPreferredSize(new Dimension(100, 100));
            imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            dishPanel.add(imageLabel, BorderLayout.CENTER);
            dishPanel.add(new JLabel("Dish " + (i + 1), SwingConstants.CENTER), BorderLayout.SOUTH);
            quickDishesPanel.add(dishPanel);
        }

        // main panel for all
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(new JLabel("FEATURED", SwingConstants.CENTER), BorderLayout.NORTH);
        mainPanel.add(featuredPanel, BorderLayout.CENTER);

        // more dishes
        JPanel bottomPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        for (int i = 0; i < 3; i++) {
            JPanel dishPanel = new JPanel(new BorderLayout());
            JLabel imageLabel = new JLabel("Insert Image", SwingConstants.CENTER);
            imageLabel.setPreferredSize(new Dimension(100, 100));
            imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            dishPanel.add(imageLabel, BorderLayout.CENTER);
            dishPanel.add(new JLabel("Dish " + (i + 5), SwingConstants.CENTER), BorderLayout.SOUTH);
            bottomPanel.add(dishPanel);
        }

        // components to the frame
        add(topPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(quickDishesPanel, BorderLayout.SOUTH);

        // container of bottom panel
        JPanel bottomContainer = new JPanel(new BorderLayout());
        bottomContainer.add(bottomPanel, BorderLayout.CENTER);
        add(bottomContainer, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new frame());
    }
}
