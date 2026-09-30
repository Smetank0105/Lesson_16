package org.example;

import com.google.gson.annotations.Expose;

import java.util.List;

public class User {
    @Expose
    private String login;
    private String password;
    @Expose
    private Address address;
    @Expose
    private List<String> hobbies;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
