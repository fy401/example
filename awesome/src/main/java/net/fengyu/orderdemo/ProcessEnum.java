package net.fengyu.orderdemo;

/**
 * 订单处理流程的某个阶段
 */
public enum ProcessEnum {
    START("新建订单",1),
    GETCAR("收车成功",2),
    PAYED("已付款",3);


    ProcessEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    int value;
    String name;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


}
