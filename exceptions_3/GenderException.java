package home_work.exceptions_3;

public class GenderException extends Exception {
    private String message = "Некорректно указан пол!\nm - мужчина\nf - женщина";

    public String getMessage() {
        return message;
    }
}