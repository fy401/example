package net.fengyu.transaction.service;

import net.fengyu.transaction.dao.CustomerDao;
import net.fengyu.transaction.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

 
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CustomerDao customerDao;

    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    };

    @Transactional(rollbackFor = Exception.class)
    public boolean write2data() {

        customerDao.updateCustomerbyId(1,"重庆");
        customerDao.insertCustomer(2,"普通程序员","beijing",1);

        return true;
    };
}
