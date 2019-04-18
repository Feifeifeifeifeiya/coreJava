package com.haha.java;

public class FilterEmplayeeAsAge implements MyProdict<Employee> {
    @Override
    public Boolean MyConpare(Employee employee) {
        return employee.getAge()>35;
    }
}
