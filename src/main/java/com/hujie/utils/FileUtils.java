package com.hujie.utils;

import com.hujie.model.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;


public final class FileUtils {
    private FileUtils() {
    }

    private static final String FILE_NAME = "employee_records.txt";

    public static ArrayList<Employee> parseFile2EmployeeList() {
        List<Employee> employeeList;
        List<String> lines;
        try {
            lines = Files.lines(Paths.get("src", "main", "resources", FILE_NAME)).collect(toList());
            lines.remove(0);
            employeeList = lines.stream().map(FileUtils::parseString2Employee).collect(toList());
        } catch (IOException e) {
            throw new RuntimeException("读取文件employee_records.txt异常", e);
        }
        return (ArrayList<Employee>) employeeList;
    }

    private static Employee parseString2Employee(String line) {
        Employee employee = null;
        String[] fields = line.split(",( )*");
        if (fields.length == 4) {
            LocalDate dateOfBirth;
            String formatter = "yyyy/MM/dd";
            dateOfBirth = LocalDate.parse(fields[2], DateTimeFormatter.ofPattern(formatter));
            employee = new Employee(fields[0], fields[1], dateOfBirth, fields[3]);
        }
        return employee;
    }
}
