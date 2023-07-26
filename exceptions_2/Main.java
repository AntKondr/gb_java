import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        float fl = task1();
        System.out.println("Результат: " + fl);


        try {
            String txt = task4();
            System.out.println(txt);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static float task1() {
        // Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
        // и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
        // вместо этого, необходимо повторно запросить у пользователя ввод данных.
        String input;
        float fl = 0.0f;
        boolean ok = false;
        while (!ok) {
            System.out.print("Введите float число: ");
            input = System.console().readLine().strip();
            try {
                fl = Float.parseFloat(input);
                ok = true;
            }
            catch (NumberFormatException e) {
                System.out.print("Некорректный ввод, попробуйте ещё раз:\n");
            }
        }
        return fl;
    }

    public static String task4() throws Exception {
        // Разработайте программу, которая выбросит Exception,
        // когда пользователь вводит пустую строку.
        // Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
        System.out.print("Введите что-нибудь: ");
        String input = System.console().readLine();
        if (input.length() < 1) {
            throw new Exception("Пустые строки вводить нельзя");
        }
        return input;
    }
}