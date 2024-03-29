package com.gucas.basic.ability;

import java.io.Serializable;

/**
 * Created by cxq on 2019-10-24 14:36
 */
public class Data implements Serializable {
    private static final long serialVersionUID = 2035546038986494352L;
    private Long id;
    private String name;

    public Data() {
    }

    public Data(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
