package com.chiranjeevkashyap.model;

public class Employee {
    public long id;
    public String name;
    public int age;

    @Override
    public String toString() {
        return String.format("Employee [id=%d, age=%d, name=%s]", id, age, name);
    }
}