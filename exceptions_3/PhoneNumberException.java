package home_work.exceptions_3;

public class PhoneNumberException extends Exception {
    private String message = "Некорректно указан номер телефона!";

    public String getMessage() {
        return message;
    }
}