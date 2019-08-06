package com.hujie.service;

import com.hujie.model.Email;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EmailServiceTest {

    @Test
    public void send_should_return_true() {
        Email email = new Email("subject", "content","addr");
        boolean result = EmailService.send(email);
        assertTrue(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void send_throws_illegalArgumentException_for_null_addr() {
        Email email = new Email("subject", "content","");
        EmailService.send(email);
    }
}