package strategy_pattern;

// Step 1: Define the interfaces for FlyBehavior and QuackBehavior

interface FlyBehavior {
    void fly();
}

interface QuackBehavior {
    void quack();
}

// Step 2: Implement the concrete behaviors for flying

class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("I'm flying with wings!");
    }
}

class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I can't fly.");
    }
}

// Step 3: Implement the concrete behaviors for quacking

class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("Quack! Quack!");
    }
}

class Squeak implements QuackBehavior {
    public void quack() {
        System.out.println("Squeak! Squeak!");
    }
}

class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("...");
    }
}

// Step 4: Define the Duck class that uses these behaviors

abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    // Ducks can perform these actions by delegating to the behavior objects
    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    // Set the behaviors dynamically at runtime
    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

    // Abstract display method for each duck
    public abstract void display();
}

// Step 5: Create specific types of ducks

class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I am a Mallard Duck.");
    }
}

class RedheadDuck extends Duck {
    public RedheadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I am a Redhead Duck.");
    }
}

class RubberDuck extends Duck {
    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }

    public void display() {
        System.out.println("I am a Rubber Duck.");
    }
}

class DecoyDuck extends Duck {
    public DecoyDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    public void display() {
        System.out.println("I am a Decoy Duck.");
    }
}

// Step 6: Main class to test the strategy pattern

public class DuckTestDrive {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();

        System.out.println("\nSwitching behavior dynamically:\n");

        // Dynamically change behaviors at runtime
        mallard.setFlyBehavior(new FlyNoWay());
        mallard.setQuackBehavior(new MuteQuack());

        mallard.display();
        mallard.performFly();
        mallard.performQuack();
    }
}
