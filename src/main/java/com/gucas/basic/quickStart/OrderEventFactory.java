package com.gucas.basic.quickStart;

import com.lmax.disruptor.EventFactory;

/**
 * Created by cxq on 2019-10-24 14:51
 */
public class OrderEventFactory implements EventFactory<OrderEvent> {

    public OrderEvent newInstance() {
        return new OrderEvent();		//这个方法就是为了返回空的数据对象（Event）
    }

}
