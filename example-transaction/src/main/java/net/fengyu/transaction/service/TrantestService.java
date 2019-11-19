package net.fengyu.transaction.service;

import net.fengyu.transaction.dao1.CustomerDao;
import net.fengyu.transaction.dao2.TrantestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrantestService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TrantestDao trantestDao;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CustomerDao customerDao;

    @Transactional(rollbackFor = Exception.class)
    public void insertTrantest() {

        customerDao.updateCustomerbyId(2,"多伦多");
        trantestDao.insertTrantest(2,"秦始皇",50);
    }
}
