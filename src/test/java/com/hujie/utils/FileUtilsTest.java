package com.hujie.utils;

import com.hujie.model.Employee;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FileUtilsTest {

    @Test
    public void EmployeesShouldEqualWithFileRecords() {
        Employee employee1 = new Employee("Doe","John", LocalDate.parse("1982/10/08", DateTimeFormatter.ofPattern("yyyy/MM/dd")),"john.doe@foobar.com");
        Employee employee2 = new Employee("Ann","Mary", LocalDate.parse("1975/08/04",DateTimeFormatter.ofPattern("yyyy/MM/dd")),"mary.ann@foobar.com");

        ArrayList<Employee> employeeList = FileUtils.parseFile2EmployeeList();
        assertEquals(employee1,employeeList.get(0));
        assertEquals(employee2,employeeList.get(1));
    }
}