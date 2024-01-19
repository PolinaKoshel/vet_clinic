package main.java.com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Pet {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    private String type;
    private String sex;
    private Age age;
    private String name;
    private String ownerName;
    private final LocalDateTime registrationDate = LocalDateTime.now();

    @Override
    public String toString() {
        return  "Pet = " + getType()
                + ", age = " + getAge()
                + ", name = " + getName()
                + ", sex = " + getSex()
                + ", registration date = " + registrationDate.format(FORMATTER);

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

        one(1), two(2), three(3), four(4), five(5), six(6),
        seven(7), eight(8), nine(9), ten(10), eleven(11), twelve(12),
        thirteen(13), fourteen(14), fifteen(15), sixteen(16), seventeen(17),
        eighteen(18), nineteen(19), twenty(20), unknown(0);
        private final int value;
        Age (int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

}
