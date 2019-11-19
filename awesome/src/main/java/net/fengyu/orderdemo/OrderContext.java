package net.fengyu.orderdemo;

public interface OrderContext {
    //得到订单ID
    String getOrderId();

    //订单版本号，重大调整增加版本号
    int getOrderVersion();

    //得到订单所属业务（严选、全国购、淘宝、开放平台……），可以定义一个能够描述这个结构的类
    Object getBusiness();

    //得到当前上下文处理的流程节点
    ProcessEnum getProcess();

    //处理这个环节需要做的具体事情
    public void handle();


    //以下注释内容可视情况添加
//    //是否流程初始节点
//    boolean isStrart();
//    //是否流程结束节点
//    boolean isEnd();
//    //得到下一流程上下文
//    List<OrderContext> getPreOrderContexts();
//    //得到上一流程上下文
//    List<OrderContext> getNextOrderContexts();

}
