package main.java.com.magicvet.model;

public class Cat extends Pet{

    public Cat () {}
    public Cat(Age age) { super.setAge(age); }

    public void setAge(Age age) {
        this.setAge(age);
    }
    public Age getAge() {
        return super.getAge();
    }
}
