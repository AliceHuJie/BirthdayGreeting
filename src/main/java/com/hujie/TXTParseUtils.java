package com.hujie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class TXTParseUtils {
    private static SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd");

    static ArrayList<Person> readTXT(final String filepath) throws IOException {
        ArrayList<Person> personList = new ArrayList<>();
        BufferedReader file = new BufferedReader(new FileReader(filepath));
        String line;
        file.readLine();
        while ((line = file.readLine()) != null) {
            if (!line.equals("0"))
            {
                if (!line.equals(""))
                {
                    String l = new String(line.getBytes());
                    Person p = parseString2Person(l);
                    if(p != null){
                        personList.add(p);
                    }
                }
            }
        }
        file.close();
        return personList;
    }

    private static Person parseString2Person(String line) {
        Person person = null;
        String[] fields = line.split(",");

        if(fields.length == 4){
            Date date_of_birth;
            try {
                date_of_birth = formatter.parse(fields[2]);
                person = new Person(fields[0], fields[1],date_of_birth,fields[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return person;
    }
}
