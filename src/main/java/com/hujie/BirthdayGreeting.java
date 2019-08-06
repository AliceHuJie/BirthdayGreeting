package com.hujie;

import com.hujie.model.Email;
import com.hujie.model.Employee;
import com.hujie.service.EmailService;
import com.hujie.utils.FileUtils;

public class BirthdayGreeting {
    public static void send() {
        FileUtils.parseFile2EmployeeList().stream()
                .filter(Employee::todayIsBirthday)
                .map(employee -> new Email(
                        "Happy birthday!",
                        "Happy birthday, dear " + employee.getFirstName(),
                        employee.getEmail())
                )
                .forEach(EmailService::send);
    }

    public static void main(String[] args) {
        send();
    }
}
