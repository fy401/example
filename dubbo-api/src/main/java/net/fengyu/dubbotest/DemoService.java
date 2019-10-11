package net.fengyu.dubbotest;

public interface DemoService {
    String sayHello(String name);

    String whoAmI(User user);

    User getStaff();
}
