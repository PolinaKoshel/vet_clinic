package main.java.com.magicvet.model;

public class Dog extends Pet{

    private Size size;
    private int age;

    @Override
    public String toString() {
        return  getType()
                + ", age = " + getAge()
                + ", name = " + getName()
                + ", sex = " + getSex()
                + ", size = " + getSize();
    }

    public Dog() {}

    public Dog(Size size) {
        this.size = size;
    }

    public Dog(int age) {
        this.age = age;
    }
    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public enum Size {

        XS(1),
        S(2),
        M(3),
        L(4),
        XL(5),
        unknown(0);

        private final int value;

        Size(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }


    }

}
