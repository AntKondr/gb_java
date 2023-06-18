import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

public class sem3 {

    static Random random = new Random();

    public static void main(String[] args) {
        // Пусть дан произвольный список целых чисел.
        // 1) Нужно удалить из него чётные числа
        // 2) Найти минимальное значение
        // 3) Найти максимальное значение
        // 4) Найти среднее значение

        // произвольный список целых чисел
        int len = randInt(2, 20);
        int min = randInt(-10, -1);
        int max = randInt(0, 10);
        ArrayList<Integer> lst = randArrList(len, min, max);
        System.out.print("Исходный список:       ");
        System.out.println(lst);

        // удаляем из него чётные числа
        for (int i = 0; i < len; i++) {
            if (isEven(lst.get(i))) {
                lst.remove(i);
                i--;
                len--;
            }
        }

        System.out.print("После удаления чётных: ");
        System.out.println(lst);

        // максимальное значение
        System.out.println("max -> " + Collections.max(lst));

        // минимальное значение
        System.out.println("min -> " + Collections.min(lst));

        // среднее значение
        double average = listAverage(lst);
        System.out.println(average);
    }


    // генератор случайного целого числа из диапазона [min, max]
    public static int randInt(int min, int max) {
        if (min >= max) {
            throw new IllegalStateException("min must be less than max!");
        }
        max -= min;
        max += 1;
        return (int) (random.nextDouble() * max) + min;
    }


    // генератор рандомного списка
    public static ArrayList<Integer> randArrList(int len, int min, int max) {
        if (len < 1) {
            throw new IllegalStateException("len must be greater than 0!");
        }
        ArrayList<Integer> lst = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            lst.add(randInt(min, max));
        }
        return lst;
    }


    // проверка на чётность
    public static boolean isEven(int num) {
        if (num % 2 == 0) {
            return true;
        }
        return false;
    }


    // среднее арифметическое из списка
    public static double listAverage(ArrayList<Integer> lst) {
        int size = lst.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += lst.get(i);
        }
        return (double)sum / (double)size;
    }
}