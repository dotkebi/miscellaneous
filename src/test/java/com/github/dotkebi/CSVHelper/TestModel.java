package com.github.dotkebi.CSVHelper;

/**
 * @author by dotkebi@gmail.com on 2017-5-1.
 */
public class TestModel {

    private int row;
    private String name;
    private int age;

    public TestModel(int row, String name, int age) {
        this.row = row;
        this.name = name;
        this.age = age;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
