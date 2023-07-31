package home_work.exceptions_3;

public class DateException extends Exception {
    private String message = "Некорректно введена дата!";

    public String getMessage() {
        return message;
    }
}