package com.hujie;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class TXTParseUtils {
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
    private static final String fileName = "/employee_records.txt";

    static ArrayList<Person> readTXT() {
        ArrayList<Person> personList = new ArrayList<>();
        BufferedReader br = null;
        InputStream is = null;
        try {
            is = TXTParseUtils.class.getResourceAsStream(fileName);
            br = new BufferedReader(new InputStreamReader(is));
            String line = "";
            br.readLine();
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                Person p = parseString2Person(line);
                if (p != null) {
                    personList.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return personList;
    }

    private static Person parseString2Person(String line) {
        Person person = null;
        String[] fields = line.split(",");

        if (fields.length == 4) {
            Date date_of_birth;
            try {
                date_of_birth = formatter.parse(fields[2]);
                person = new Person(fields[0], fields[1], date_of_birth, fields[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return person;
    }
}
