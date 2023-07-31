package home_work.exceptions_3;

public class FioException extends Exception {
    private String message = "Некорректно введены ФИО!";

    public String getMessage() {
        return message;
    }
}