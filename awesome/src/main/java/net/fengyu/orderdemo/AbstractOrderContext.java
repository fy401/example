package net.fengyu.orderdemo;

public abstract  class AbstractOrderContext implements OrderContext {

    private String orderId;

    private Object business;

    //当前节点所处理订单的版本，这个版本的具体形式也可以使一个订单类的版本属性
    private int orderVersion;

    //支持处理的订单版本
    private int supportOrderVersion;

    //标记当前上下文所处的节点
    private ProcessEnum process;

    @Override
    public String getOrderId() {
        return this.orderId;
    }

    @Override
    public Object getBusiness() {
        return business;
    }

    @Override
    public int getOrderVersion() {
        return this.orderVersion;
    }

    @Override
    public ProcessEnum getProcess() {
        return this.process;
    }

    //如果传入的订单版本高于该节点处理版本，抛出异常。在构造该上下文时调用
    protected void checkOrderVersion() {
        if(orderVersion > supportOrderVersion) {
            //throw 一个非终止的异常
        }
    }
}
