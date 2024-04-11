package com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Pet {

    private String type;
    private String sex;
    private String name;
    private String ownerName;

    private Age age;
    private Health healthState;

    @Override
    public String toString() {
        return  "{ " + getType()
                + ", age = " + getAge()
                + ", name = " + getName()
                + ", sex = " + getSex()
                + ", state of health = " + getHealth()
                + ", owner name = " + getOwnerName()
                + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(type, pet.type)
                && Objects.equals(sex, pet.sex)
                && Objects.equals(age, pet.age)
                && Objects.equals(name, pet.name)
                && Objects.equals(ownerName, pet.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName);
    }

    public void setHealth(Health healthState) { this.healthState = healthState; }

    public Health getHealth() { return healthState; }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(Age age) {
        this.age = age;
    }
    public Age getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public enum Age {

        ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
        SEVEN(7), EIGHT(8), NINE(9), TEN(10), ELEVEN(11), TWELVE(12),
        THIRTEEN(13), FOURTEEN(14), FIFTEEN(15), SIXTEEN(16), SEVENTEEN(17),
        EIGHTEEN(18), NINETEEN(19), TWENTY(20), UNKNOWN(0);
        private final int value;
        Age (int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }

        public static Age fromString (String value) {
            for (Age age: values()) {
                if(age.toString().equalsIgnoreCase(value)) {
                    return age;
                }
            }

            System.out.println("Unable to parse value '" + value + "'. Using default value: " + UNKNOWN);

            return UNKNOWN;
        }
    }

    // TODO: add shortcart. For example, URGENT_REQUEST press 1, DISEASED press 2
    // TODO: add method findByValue (search by value and return health)
    public enum Health {

        URGENT_REQUEST(1),
        DISEASED(2),
        GET_WELL(3),
        HEALTHY(4),
        UNKNOWN(0);

        private final int value;
        Health (int value) { this.value = value; }

        public int getValue() {
            return value;
        }

        public static Health fromString (String value) {
            for (Health health: values()) {
                if(health.toString().equalsIgnoreCase(value)) {
                    return health;
                }
            }

            System.out.println("Unable to parse value '" + value + "'. Using default value: " + UNKNOWN);

            return UNKNOWN;
        }
    }

}
