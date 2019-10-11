package net.fengyu.dubbotest;


import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class DefaultDemoService implements DemoService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        System.out.println("remote calling, name="+name);
        return String.format("[%s] : Hello, %s", serviceName, name);
    }

    @Override
    public String whoAmI(User user) {
        if(user == null) {
            System.out.println("user is null,xxxxxxxxx");
            return "";
        }
        System.out.println("this user is " + user.getName());
        return user.toString();
    }

    @Override
    public User getStaff() {
        return User.STAFF;
    }
}
