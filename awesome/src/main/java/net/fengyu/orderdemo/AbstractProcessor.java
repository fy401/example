package net.fengyu.orderdemo;

public abstract class AbstractProcessor {



    public void handle(OrderContext context) {

        //这里可以开发一个公共功能，比如通用的校验等

        //如果有必要，也可以在这里植入过滤器

        process(context);
    }

    //由具体时间
    protected abstract void process(OrderContext context);

}
