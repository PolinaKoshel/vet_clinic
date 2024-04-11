package com.magicvet.model;

public class Dog extends Pet{

    private Size size;

    @Override
    public String toString() {
        return  "{ " + getType()
                + ", age = " + getAge()
                + ", name = " + getName()
                + ", sex = " + getSex()
                + ", size = " + getSize()
                + ", state of health = " + getHealth()
                + ", owner name = " + getOwnerName()
                + " }";

    }

    public Dog() {}
    public Dog(Size size) {
        this.size = size;
    }
    public Dog(Age age) { super.setAge(age); }

    public Dog(Health healthState) {super.setHealth(healthState);}

    public void setSize(Size size) {
        this.size = size;
    }
    public Size getSize() {
        return size;
    }

    public void setAge(Age age) { super.setAge(age);}
    public Age getAge() {
        return super.getAge();
    }

    public void setHealth(Health healthState) {
        super.setHealth(healthState);
    }
    public Health getHealth() {
        return super.getHealth();
    }
    public enum Size {

        XS(1),
        S(2),
        M(3),
        L(4),
        XL(5),
        UNKNOWN(0);

        private final int value;

        Size(int value) {
            this.value = value;
        }

        public static Size fromString (String value) {
            for(Size size: values()) {
                if(size.toString().equalsIgnoreCase(value)) {
                    return size;
                }
            }

            System.out.println("Unable to parse value '" + value + "'. Using default value: " + UNKNOWN);

            return UNKNOWN;
        }

        public int getValue() {
            return value;
        }


    }

}
