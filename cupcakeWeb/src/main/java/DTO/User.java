/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Christian
 */
public class User {
    private int id;
    private String Username;
    private String Password;
    private double Balance;

    public User(int id, String Username, String Password, double Balance) {
        this.id = id;
        this.Username = Username;
        this.Password = Password;
        this.Balance = Balance;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public double getBalance() {
        return Balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }
    
    
}
