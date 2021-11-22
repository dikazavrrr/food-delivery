package com.tmjonker.food2u.entities.user;

public class ReturningUserForm {

    private String username;
    private Boolean alreadyExists;

    public ReturningUserForm(String email, Boolean alreadyExists) {

        this.username = email;
        if (alreadyExists == null)
            this.alreadyExists = false;
        else
            this.alreadyExists = alreadyExists;
    }

    public Boolean getAlreadyExists() {
        return alreadyExists;
    }

    public void setAlreadyExists(Boolean alreadyExists) {
        this.alreadyExists = alreadyExists;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getUsername() {
        return username;
    }
}
