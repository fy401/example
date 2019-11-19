package net.fengyu.transaction.controller;


import net.fengyu.transaction.service.CustomerService;
import net.fengyu.transaction.service.TrantestService;
import net.fengyu.transaction.vo.Customer;
import net.fengyu.transaction.vo.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/sample")
public class SampleController {

    private static final Logger log = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TrantestService trantestService;

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

    //事务测试
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

    //XA事务测试
    @RequestMapping("/xatrans")
    public String xaTrans() {
        try {
            this.trantestService.insertTrantest();
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    //访问webservice
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @RequestMapping("/webservice")
    public String callWebservice() {
        Quote quote = restTemplate.getForObject(
                "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());
        return quote.toString();
    }
}
