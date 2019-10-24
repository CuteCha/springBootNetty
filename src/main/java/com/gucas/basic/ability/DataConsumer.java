package com.gucas.basic.ability;

import com.lmax.disruptor.EventHandler;

/**
 * Created by cxq on 2019-10-24 14:41
 */
public class DataConsumer implements EventHandler<Data> {

    private long startTime;
    private int i;

    public DataConsumer() {
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void onEvent(Data data, long seq, boolean bool) throws Exception {
        i++;
        if (i == Constants.EVENT_NUM_OHM) {
            long endTime = System.currentTimeMillis();
            System.out.println("Disruptor costTime = " + (endTime - startTime) + "ms");
        }
    }
}
