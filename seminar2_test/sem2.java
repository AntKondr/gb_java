import java.util.Scanner;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

public class sem2 {
    private static Scanner scaner = new Scanner(System.in);
    private static Logger logger = Logger.getLogger(sem2.class.getName());
    private static SimpleFormatter simple_formatter = new SimpleFormatter();
    public static void main(String[] args) {
        try {
            FileHandler fileH = new FileHandler("sem2_log.log", true);
            fileH.setFormatter(simple_formatter);
            logger.addHandler(fileH);
            task1();
            task2();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 1) Реализуйте алгоритм сортировки пузырьком числового массива,
    // результат после каждой итерации запишите в лог-файл.
    public static void task1() {
        int[] arr = {5, 2, 6, 8, 3, 4, 1, 6, 0};

        logger.info(Arrays.toString(arr) + " исходное состояние\n");
        // сортировка пузырьком
        int tmp;
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
            logger.info(Arrays.toString(arr) + " итерация " + j + "\n");
        }
    }




    // 2) К калькулятору из предыдущего ДЗ добавить логирование.
    public static void task2() {
        StringBuilder strbld = new StringBuilder();

        System.out.print("Введите первое число: ");
        String str_a = scaner.nextLine();
        double a = Double.parseDouble(str_a);

        System.out.print("Введите оператор: ");
        String op = scaner.nextLine();

        System.out.print("Введите второе число: ");
        String str_b = scaner.nextLine();
        double b = Double.parseDouble(str_b);

        double res = 0;

        strbld.append(str_a)
              .append(op)
              .append(str_b)
              .append("=");

        if (op.equals("+")) {
            res = a + b;
            strbld.append(res);
            logger.info(strbld.toString());
        }
        else if (op.equals("-")) {
            res = a - b;
            strbld.append(res);
            logger.info(strbld.toString());
        }
        else if (op.equals("*")) {
            res = a * b;
            strbld.append(res);
            logger.info(strbld.toString());
        }
        else if (op.equals("/")) {
            res = a / b;
            strbld.append(res);
            logger.info(strbld.toString());
        }
        else {
            logger.log(Level.WARNING, "unsupported operator " + op);
        }
        strbld.delete(0, strbld.length());
    }
}