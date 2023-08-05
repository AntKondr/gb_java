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


    // задание 1:
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


    // задание 4:
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


    // Задание 2:
    // Поместил код в метод, иначе он как-то бессмысленно выглядит.
    public static void task2(int[] intArray, int index, int d) {
        try {
            double catchedRes1 = intArray[index] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        }
        catch (ArithmeticException | IndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Catching exception: " + e.getMessage());
        }
    }
}


// Задание 3:
class task3 {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        }
        catch (ArithmeticException e) {
            System.out.println("Dividing by zero");
        }
        catch (NullPointerException e) {
            System.out.println("Exception: a or b is null");
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Индекс за пределами массива!");
        }
        catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) throws NullPointerException {
        System.out.println(a + b);
    }
}