package net.fengyu.orderdemo.tcc;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {

    //车源服务，库存服务
    @Autowired
    private CarSource carSource;
    //
    @Autowired
    private WmsService wmsService;

    @Autowired
    private OrderDAO orderDAO;

    //支付这个订单
    public void pay() {
        //数据库层面更改订单状态为已支付
        orderDAO.updateStatus(OrderStatus.PAYED);
        //锁定车源，扣减库存
        carSource.lockStock();
        //创建交付任务
        wmsService.createDelivery();
    }
}
