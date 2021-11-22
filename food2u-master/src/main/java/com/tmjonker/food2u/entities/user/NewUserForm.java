package com.tmjonker.food2u.entities.user;

import javax.validation.constraints.*;

public class NewUserForm {

    @NotNull
    @Size(min=5)
    private String email;
    @NotNull
    @Size(min=8)
    private String password;
    @NotNull
    @Size(min=8)
    private String password2;
    @NotNull
    @Size(min=1)
    private String firstName;
    @NotNull
    @Size(min=1)
    private String lastName;
    @NotNull
    @Size(min=5)
    private String address;
    @NotNull
    @Size(min=2)
    private String city;
    @NotNull
    @Size(min=2)
    private String state;
    @NotNull
    private Boolean passwordsMatch;

    public NewUserForm() {
        passwordsMatch = true;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getState() {
        return state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public Boolean getPasswordsMatch() {
        return passwordsMatch;
    }

    public void setPasswordsMatch(Boolean passwordsMatch) {
        this.passwordsMatch = passwordsMatch;
    }

    public User toUser() {
        return new User(email, password, firstName, lastName, address, city, state);
    }
}
