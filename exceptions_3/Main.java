package home_work.exceptions_3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) {
        File dir = new File("Contacts");
        dir.mkdir();
        boolean ok = false;
        String fio = "";
        String date = "";
        String phoneNumber = "";
        String gender = "";

        while (!ok) {
            fio = input("Введите ФИО: ");
            try {
                checkFio(fio);
                ok = true;
            }
            catch (FioException e) {
                System.out.println(e.getMessage());
            }
        }
        ok = false;

        while (!ok) {
            date = input("Введите дату рождения в формате dd.mm.yyyy: ");
            try {
                checkDate(date);
                ok = true;
            }
            catch (DateException e) {
                System.out.println(e.getMessage());
            }
        }
        ok = false;

        while (!ok) {
            phoneNumber = input("Введите номер телефона: ");
            try {
                checkPhoneNumber(phoneNumber);
                ok = true;
            }
            catch (PhoneNumberException e) {
                System.out.println(e.getMessage());
            }
        }
        ok = false;

        while (!ok) {
            gender = input("Введите пол (m/f): ");
            try {
                checkGender(gender);
                ok = true;
            }
            catch (GenderException e) {
                System.out.println(e.getMessage());
            }
        }

        StringBuilder sb = new StringBuilder();
        String[] fioArr = fio.split(" ");
        String family = fioArr[0];
        sb.append("<").append(fioArr[0]).append("><").append(fioArr[1]).append("><").append(fioArr[2]).append(">");
        sb.append("<").append(date).append(">");
        sb.append("<").append(phoneNumber).append(">");
        sb.append("<").append(gender).append(">\n");

        try (FileOutputStream fos = new FileOutputStream("Contacts\\" + family, true);
             OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8")) {
            osw.write(sb.toString());
            System.out.print("Данные записаны!\n");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String input(String message) {
        System.out.print(message);
        return System.console().readLine().strip();
    }

    public static void checkFio(String fio) throws FioException {
        if(!fio.matches("([а-яА-ЯёЁ]{2,25} [а-яА-ЯёЁ]{2,25} [а-яА-ЯёЁ]{2,25})|([a-zA-Z]{2,25} [a-zA-Z]{2,25} [a-zA-Z]{2,25})")) {
            throw new FioException();
        }
    }

    public static void checkDate(String date) throws DateException {
        if (!date.matches("(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.([12][0-9]{3})")) {
            throw new DateException();
        }
    }

    public static void checkPhoneNumber(String phoneNumber) throws PhoneNumberException {
        if (!phoneNumber.matches("[1-9][0-9]{2,15}")) {
            throw new PhoneNumberException();
        }
    }

    public static void checkGender(String gender) throws GenderException {
        if (!gender.matches("m|f")) {
            throw new GenderException();
        }
    }
}