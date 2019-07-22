package com.hujie;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.util.Properties;


public class SendMailThread extends Thread {
    private static String myEmailAddr = "1262741800@qq.com";
    private static String myAuthToken = "ioooyyxkydujgccj";
    private String mailAdr;
    private String content;
    private String subject;

    SendMailThread(String mailAdr, String subject, String content) {
        super();
        this.mailAdr = mailAdr;
        this.subject = subject;
        this.content = content;
    }

    @Override
    public void run() {
        try {
            sendMail(mailAdr, subject, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMail(String mailAdr, String subject, String content)
            throws Exception {
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);

        final Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.qq.com");
        props.setProperty("mail.debug", "true");
        props.put("mail.user", myEmailAddr);
        props.put("mail.password", myAuthToken);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };

        Session mailSession = Session.getInstance(props, authenticator);
        MimeMessage message = new MimeMessage(mailSession);

        try {
            InternetAddress from = new InternetAddress(
                    props.getProperty("mail.user"));
            message.setFrom(from);

            InternetAddress to = new InternetAddress(mailAdr);
            message.setRecipient(RecipientType.TO, to);

            message.setSubject(subject);
            message.setContent(content, "text/html;charset=UTF-8");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
