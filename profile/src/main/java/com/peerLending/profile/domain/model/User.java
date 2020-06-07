package com.peerLending.profile.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class User {

    @Id
    private String username;
    private String firstName;
    private String lastName;
    private int age;
    private String occupation;
    private LocalDate registeredSince;

    public User() {
    }

    public User(String username, String firstName, String lastName, int age, String occupation, LocalDate registeredSince) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.occupation = occupation;
        this.registeredSince = registeredSince;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public LocalDate getRegisteredSince() {
        return registeredSince;
    }

    public void setRegisteredSince(LocalDate registeredSince) {
        this.registeredSince = registeredSince;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(username, user.username) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(occupation, user.occupation) &&
                Objects.equals(registeredSince, user.registeredSince);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, lastName, age, occupation, registeredSince);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                ", registeredSince=" + registeredSince +
                '}';
    }
}
