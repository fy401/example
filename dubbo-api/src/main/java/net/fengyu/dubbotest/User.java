package net.fengyu.dubbotest;

public enum  User {
    STAFF(1,"员工"),
    CUSTOMER(2, "客户"),
    WAIBAO(3, "外包");

    private int id;
    private String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[" + this.id + ", " + this.name +"]";
    }
}
