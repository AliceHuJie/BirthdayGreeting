package com.hujie.service;

import com.hujie.model.Email;

public final class EmailService {
    private EmailService() {
    }

    public static boolean send(Email email) {
        if (isValid(email)) {
            System.out.println(email.getSubject());
            System.out.println(email.getContent());
            return true;
        } else {
            throw new IllegalArgumentException("发送邮件出错");
        }
    }

    private static boolean isValid(Email email) {
        if (email.getToEmailAddr() == null || email.getToEmailAddr().equals("")) {
            return false;
        }
        return email.getSubject() != null && !email.getSubject().equals("");
    }
}
