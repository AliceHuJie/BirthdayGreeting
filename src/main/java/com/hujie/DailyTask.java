package com.hujie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

public class DailyTask extends TimerTask{
    private static String filepath = "employee_records.txt";

    @Override
    public void run() {
        try {
            ArrayList<Person> personList = TXTParseUtils.readTXT(filepath);
            for(Person person:personList){
                if (isBirthDay(person.getDate_of_birth())){
                    String subject = "Happy birtyday!";
                    String content = "Happy birtyday! dear " + person.getFirst_name() + "!";
                    String email = person.getEmail();

                    SendMailThread d = new SendMailThread(email, subject, content);
                    d.start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isBirthDay(Date personBirth){
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("MM/dd");
        String todayDateStr = simpleDateFormat.format(date);
        String birthDateStr = simpleDateFormat.format(personBirth);
        return todayDateStr.equals(birthDateStr);
    }
}
