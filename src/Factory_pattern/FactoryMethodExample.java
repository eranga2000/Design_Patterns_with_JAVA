package Factory_pattern;

// Step 1: Define the Product Interface
interface User {
    void getUserInfo();
    void performAction();
}

// Step 2: Concrete Products implementing User interface
class Admin implements User {
    @Override
    public void getUserInfo() {
        System.out.println("Admin User: Has full access.");
    }

    @Override
    public void performAction() {
        System.out.println("Admin can create, update, and delete user accounts.");
    }
}

class Guest implements User {
    @Override
    public void getUserInfo() {
        System.out.println("Guest User: Can only view content.");
    }

    @Override
    public void performAction() {
        System.out.println("Guest can only view content.");
    }
}

class RegisteredUser implements User {
    @Override
    public void getUserInfo() {
        System.out.println("Registered User: Can view and edit own profile.");
    }

    @Override
    public void performAction() {
        System.out.println("Registered User can edit their profile.");
    }
}

// Step 3: Creator class with a factory method
abstract class UserFactory {
    // Factory Method
    public abstract User createUser(String userType);
}

// Step 4: Concrete Creator classes
class ConcreteUserFactory extends UserFactory {
    @Override
    public User createUser(String userType) {
        if (userType == null) {
            return null;
        }
        if (userType.equalsIgnoreCase("Admin")) {
            return new Admin();
        } else if (userType.equalsIgnoreCase("Guest")) {
            return new Guest();
        } else if (userType.equalsIgnoreCase("RegisteredUser")) {
            return new RegisteredUser();
        }
        return null;
    }
}

// Step 5: Testing the Factory Pattern in a System
 class FactoryPatternExample2 {
    public static void main(String[] args) {
        UserFactory userFactory = new ConcreteUserFactory();

        // Create an Admin user
        User admin = userFactory.createUser("Admin");
        admin.getUserInfo(); // Output: Admin User: Has full access.
        admin.performAction(); // Output: Admin can create, update, and delete user accounts.

        // Create a Guest user
        User guest = userFactory.createUser("Guest");
        guest.getUserInfo(); // Output: Guest User: Can only view content.
        guest.performAction(); // Output: Guest can only view content.

        // Create a Registered User
        User registeredUser = userFactory.createUser("RegisteredUser");
        registeredUser.getUserInfo(); // Output: Registered User: Can view and edit own profile.
        registeredUser.performAction(); // Output: Registered User can edit their profile.
    }
}
