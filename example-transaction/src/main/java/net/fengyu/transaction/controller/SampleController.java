package net.fengyu.transaction.controller;


import net.fengyu.transaction.service.CustomerService;
import net.fengyu.transaction.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class SampleController {

    private static final Logger log = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private CustomerService customerService;


    @RequestMapping("/hellocus")
    public Customer helloCustomer(@RequestParam(value="name", defaultValue="World") String name) {
        String template = "Hello, %s!";

        log.info(String.format(template, name));
        return new Customer(123,name,"beijing",0);
    }


    @RequestMapping("/hello")
    public String hello() {


        if(customerService == null) {
            System.out.println("customerService is null");
            return "customerService is null";
        }
        //System.out.println();
        return customerService.getCustomerById(1).toString();
    }

    @RequestMapping("/testtrans")
    public String testTrans() {
        try {
            this.customerService.write2data();
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }
}
