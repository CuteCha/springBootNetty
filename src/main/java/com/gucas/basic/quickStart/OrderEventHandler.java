package com.gucas.basic.quickStart;

import com.lmax.disruptor.EventHandler;

/**
 * Created by cxq on 2019-10-24 14:52
 */
public class OrderEventHandler implements EventHandler<OrderEvent> {

    public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) throws Exception {
//		Thread.sleep(Integer.MAX_VALUE);
        System.out.println("消费者: " + event.getValue());
    }

}
