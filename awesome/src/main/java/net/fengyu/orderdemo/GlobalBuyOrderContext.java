package net.fengyu.orderdemo;

import net.fengyu.orderdemo.OrderContext;

public class GlobalBuyOrderContext extends AbstractOrderContext {

    GlobalBuyProcessor processor = new GlobalBuyProcessor();
    @Override
    public void handle() {

        processor.handle(this);

    }
}
