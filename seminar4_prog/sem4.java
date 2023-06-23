import java.util.Deque;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Random;


public class sem4 {
    static Random random = new Random();
    public static void main(String[] args) {
        // Даны два Deque, представляющие два целых числа.
        // Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
        // 1) Умножьте два числа и верните произведение в виде связанного списка.
        // 2) Сложите два числа и верните сумму в виде связанного списка.
        // Одно или два числа могут быть отрицательными.

        // Даны два Deque, цифры в обратном порядке.
        // [3,2,1,-] - пример Deque
        // [5,4,3]- пример второго Deque
        // 1) -123 * 345 = -42 435
        // Ответ всегда - связный список, в обычном порядке
        // [-,4,2,4,3,5] - пример ответа

        int len1 = randInt(2, 5);
        int len2 = randInt(2, 5);

        Deque<Object> dq1 = intToDeque(randIntLen(len1));
        Deque<Object> dq2 = intToDeque(randIntLen(len2));
        System.out.println("dq1 => " + dq1);
        System.out.println("dq2 => " + dq2 + "\n");

        int num1 = intFromDeque(dq1);
        int num2 = intFromDeque(dq2);
        System.out.println("num1 => " + num1);
        System.out.println("num2 => " + num2 + "\n");

        int sum = num1 + num2;
        int mul = num1 * num2;
        System.out.println("sum => " + sum);
        System.out.println("mul => " + mul + "\n");

        System.out.println(intToLinkedList(sum));
        System.out.println(intToLinkedList(mul));
    }


    // из int в перевёрнутую Deque
    public static Deque<Object> intToDeque(int num) {
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num *= -1;
        }
        Deque<Object> dq = new ArrayDeque<>();
        while (num != 0) {
            dq.addLast(num % 10);
            num /= 10;
        }
        if (negative) {
            dq.addLast("-");
        }
        return dq;
    }


    // из Deque в int
    public static int intFromDeque(Deque<Object> dq) {
        int sign = 1;
        int multipler = 1;
        int res = 0;
        if (dq.peekLast() == "-") {
            sign = -1;
            dq.pollLast();
        }
        for (Object number : dq) {
            res += (int)number * multipler;
            multipler *= 10;
        }
        return res * sign;
    }


    // из int в LinkedList
    public static LinkedList<Object> intToLinkedList(int num) {
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num *= -1;
        }
        LinkedList<Object> lst = new LinkedList<>();
        while (num != 0) {
            lst.addFirst(num % 10);
            num /= 10;
        }
        if (negative) {
            lst.addFirst("-");
        }
        return lst;
    }


    // сколько цифр в числе
    // метод НЕ понадобился, но пусть останется тут :)
    public static int digitsAmt (int num) {
        int amt = 1;
        num /= 10;
        while (num != 0) {
            amt += 1;
            num /= 10;
        }
        return amt;
    }


    // генератор рандомного числа определённой длины
    public static int randIntLen(int len) {
        if (len < 1) {
            throw new IllegalStateException("len must be greater than 0!");
        }
        int min = (int)Math.pow(10, len - 1);
        int max = (int)Math.pow(10, len) - 1;
        int number = randInt(min, max);

        if (isNegative()) {
            number *= -1;
        }
        return number;
    }


    // генератор случайного целого числа из диапазона [min, max]
    public static int randInt(int min, int max) {
        if (min >= max) {
            throw new IllegalStateException("min must be less than max!");
        }
        max -= min;
        max += 1;
        return (int)(random.nextDouble() * max) + min;
    }


    // roll отрицательности числа
    public static boolean isNegative() {
        if (randInt(0, 1) == 1) {
            return true;
        }
        return false;
    }
}