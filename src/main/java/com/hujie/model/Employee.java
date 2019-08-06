package com.hujie.model;

import com.hujie.utils.DateUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
    private String lastName;
    private String firstName;
    private LocalDate dateOfBirth;
    private String email;

    public Employee(String lastName, String firstName, LocalDate dateOfBirth, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            return firstName.equals(((Employee) obj).firstName)
                    && lastName.equals(((Employee) obj).lastName)
                    && email.equals(((Employee) obj).email)
                    && dateOfBirth.toString().equals(((Employee) obj).dateOfBirth.toString());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (lastName == null ? 0 : lastName.hashCode());
        result = 31 * result + (firstName == null ? 0 : firstName.hashCode());
        result = 31 * result + (email == null ? 0 : email.hashCode());
        result = 31 * result + (dateOfBirth == null ? 0 : dateOfBirth.toString().hashCode());
        return result;
    }

    public boolean todayIsBirthday() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd");
        String todayDateStr = date.format(dateTimeFormatter);
        String birthDateStr = dateOfBirth.format(dateTimeFormatter);
        if (birthDateStr.equals("02/28") && DateUtils.isLeapYear(dateOfBirth.getYear())) {
            return todayDateStr.equals("02/29");
        }
        return todayDateStr.equals(birthDateStr);
    }
}
