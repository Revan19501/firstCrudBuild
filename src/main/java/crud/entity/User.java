package crud.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Size(min = 1, message = "Имя не должно быть пустым")
    @Pattern(regexp = "^(|[A-Za-zА-Яа-яЁё]+)$", message = "Имя должно содержать только буквы")
    @Column(name = "firstname")
    private String firstName;

    @Size(min = 1, message = "Фамилия не должна быть пустой")
    @Pattern(regexp = "^(|[A-Za-zА-Яа-яЁё]+)$", message = "Фамилия должна содержать только буквы")
    @Column(name = "lastname")
    private String lastName;

    @Min(value = 13, message = "Сервис доступен только пользователям от 13 лет")
    @Column(name = "age")
    private int age;

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
