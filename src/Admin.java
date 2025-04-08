public class Admin extends User {
    private int adminLevel;

    public Admin(int id, String username, String password, int adminLevel) {
        super(id, username, password);
        this.adminLevel = adminLevel;
    }

    public void manageUsers() {
        System.out.println("Managing users...");
    }

    public void deleteAnyRecipe(int recipeId) {
        System.out.println("Deleting recipe with ID: " + recipeId);
    }
}
