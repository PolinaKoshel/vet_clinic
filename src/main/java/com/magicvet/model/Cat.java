package main.java.com.magicvet.model;

public class Cat extends Pet{

    public Cat () {}
    public Cat(Age age) { super.setAge(age); }

    public Cat(Health healthState) {super.setHealth(healthState);}

    public void setAge(Age age) {
        this.setAge(age);
    }
    public Age getAge() {
        return super.getAge();
    }

    public void setHealth(Health healthState) {
        this.setHealth(healthState);
    }
    public Health getHealth() {
        return super.getHealth();
    }
}
