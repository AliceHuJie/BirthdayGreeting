package com.hujie;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

public class DailyTask extends TimerTask {
    @Override
    public void run() {
        ArrayList<Person> personList = TXTParseUtils.readTXT();
        for (Person person : personList) {
            if (isBirthDay(person.getDate_of_birth())) {
                String subject = "Happy birtyday!";
                String content = "Happy birtyday! dear " + person.getFirst_name() + "!";
                String email = person.getEmail();
                SendMailThread d = new SendMailThread(email, subject, content);
                d.start();
            }
        }
    }

    private static boolean isBirthDay(Date personBirth) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd");
        String todayDateStr = simpleDateFormat.format(date);
        String birthDateStr = simpleDateFormat.format(personBirth);
        return todayDateStr.equals(birthDateStr);
    }
}
