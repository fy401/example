package net.fengyu.proxy;

public class Farmerbrag implements Developer {

    Developer developer;

    public Farmerbrag(Developer developer) {
        this.developer = developer;
    }
    @Override
    public void code() {
        System.out.println("Farmerbrag is praying for the code!");
        this.developer.code();
    }

    @Override
    public void debug() {
        System.out.println("Farmerbrag's code is bug-free and does not require debugging");
    }
}
