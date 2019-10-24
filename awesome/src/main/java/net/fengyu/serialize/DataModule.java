package net.fengyu.serialize;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataModule implements Serializable {

    private int id;

    private String name;

}
