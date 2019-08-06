package com.hujie.model;

public class Email {
    private String subject;
    private String content;
    private String toEmailAddr;

    public Email(String subject, String content, String toEmailAddr) {
        this.subject = subject;
        this.content = content;
        this.toEmailAddr = toEmailAddr;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getToEmailAddr() {
        return toEmailAddr;
    }
}
