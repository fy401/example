package net.fengyu.orderdemo.tcc;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceConfirm {

    @Autowired
    private OrderDAO orderDAO;

    public void pay() {
        orderDAO.updateStatus(OrderStatus.PAYED);
    }
}
