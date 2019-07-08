package net.fengyu.transaction.vo;

public class Customer {

    private int id;
    private String username;
    private String city;
    private int gender;

    public Customer(int id, String username, String city, int gender) {
        this.id = id;
        this.username = username;
        this.city = city;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(this.id).append(" ");
        sb.append("username=").append(this.username).append(" ");
        sb.append("city=").append(this.city).append(" ");
        sb.append("gender=").append(this.gender);
        return sb.toString();
    }
}
