import java.util.Objects;

public class Animal {

    String typeOfAnimal;
    String nameOfAnimal;

    public Animal(String typeOfAnimal, String nameOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
        this.nameOfAnimal = nameOfAnimal;
    }

    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public String getNameOfAnimal() {
        return nameOfAnimal;
    }

    public void setTypeOfAnimal(String typeOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
    }

    public void setNameOfAnimal(String nameOfAnimal) {
        this.nameOfAnimal = nameOfAnimal;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "typeOfAnimal='" + typeOfAnimal + '\'' +
                ", nameOfAnimal='" + nameOfAnimal + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(typeOfAnimal, animal.typeOfAnimal) &&
                Objects.equals(nameOfAnimal, animal.nameOfAnimal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfAnimal, nameOfAnimal);
    }
}
