package com.chiranjeevkashyap.model;

public class Employee {
    public long id;
    public String name;
    public int age;

    static private Employee instance;

    private Employee() {
    }

    public static Employee getInstance() {
        if (instance == null) {
            instance = new Employee();
        }
        return instance;
    }

    @Override
    public String toString() {
        return String.format("Employee [id=%d, age=%d, name=%s]", id, age, name);
    }
}