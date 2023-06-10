import java.util.Scanner;

public class sem1 {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        // task1();
        // task2();
        // task3();
        task4();
    }


    // Вычислить n-ое треугольного число (сумма чисел от 1 до n)
    // Вычислить n! (произведение чисел от 1 до n)
    public static void task1() {
        System.out.print("Введите число n: ");
        int n = Integer.parseInt(scan.nextLine());
        int sum = (n * (n + 1)) / 2;

        int i;
        int fac = 1;
        int stop = n + 1;
        for (i = 1; i < stop; i++){
            fac *= i;
        }
        System.out.print("Сумма: ");
        System.out.println(sum);

        System.out.print("Факториал: ");
        System.out.println(fac);
    }


    // Вывести все простые числа от 1 до 1000
    public static void task2() {
        int n = 1000;
        int i;
        for (i = 1; i < n; i++) {
            if (isSimple(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isSimple(int num) {
        if (num < 2) {
            return false;
        }
        int divider;
        int stop = num + 1;
        for (divider = 2; divider * divider < stop; divider++) {
            if (num % divider == 0) {
                return false;
            }
        }
        return true;
    }


    // Реализовать простой калькулятор
    public static void task3() {
        System.out.print("Введите первое число: ");
        double a = Double.parseDouble(scan.nextLine());

        System.out.print("Введите оператор: ");
        String op = scan.nextLine();

        System.out.print("Введите второе число: ");
        double b = Double.parseDouble(scan.nextLine());

        double res = 0;
        if (op.equals("+")) {
            res = a + b;
        }
        else if (op.equals("-")) {
            res = a - b;
        }
        else if (op.equals("*")) {
            res = a * b;
        }
        else if (op.equals("/")) {
            res = a / b;
        }
        else {
            System.out.println("Некорректный оператор!");
        }
        System.out.println(res);
    }


    // Задано уравнение вида q + w = e,  где q, w, e >= 0.
    // Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
    // Требуется восстановить выражение до верного равенства.
    // Знаки вопроса - одинаковые цифры.
    // Предложить хотя бы одно решение или сообщить, что его нет.
    // ?2? + ?5?? = 10528
    public static void task4() {
        System.out.print("Введите выражение: ");
        String expr = scan.nextLine();
        String[] items = expr.split(" ");

        int res = Integer.parseInt(items[4]);
        int op1 = Integer.parseInt(items[0].replace("?", "0"));
        int op2 = Integer.parseInt(items[2].replace("?", "0"));
        int op1Incr = opIncr(items[0]);
        int op2Incr = opIncr(items[2]);
        int i;
        int sum;
        for (i = 0; i < 10; i++) {
            sum = op1 + op2;
            if (sum == res) {
                System.out.println("? -> " + i);
                break;
            }
            else if (sum > res) {
                System.out.println("No solution");
                break;
            }
            op1 += op1Incr;
            op2 += op2Incr;
        }
    }

    public static int opIncr(String op) {
        int opLen = op.length();
        int exp = opLen - 1;
        int incr = 0;
        int i;
        for (i = 0; i < opLen; i++) {
            if (op.charAt(i) == '?') {
                incr += Math.pow(10, exp);
            }
            exp--;
        }
        return incr;
    }
}