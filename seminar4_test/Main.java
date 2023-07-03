package home_work.seminar4_test;

public class Main {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();

        System.out.println(stack.internalSize());      // 16
        System.out.println("size: " + stack.size());   // 0
        System.out.println(stack.isEmpty());           // true
        System.out.println();

        stack.push(0);
        System.out.println(stack.isEmpty());      // false
        stack.push(1);
        stack.push(2);
        stack.show();         // 0 1 2 null null ... null
        System.out.println("size: " + stack.size());  // 3

        System.out.println(stack.peek());  // 2
        // 2 всё равно находится на вершине стека

        System.out.println(stack.pop());   // 2

        stack.show();    // 0 1 2 null null ... null

        // при извлечении элемента из стека, по факту значение в массиве не затирается
        // для экономии времени (какой смысл затирать, если при пуше значение перезапишется и так)
        // просто указатель сдвигается назад на 1 позицию

        stack.push(3);
        stack.show();  // 0 1 3 null null ... null
        // двойка перезаписалась тройкой

        for (int i = 4; i < 18; i++) {
            stack.push(i);
        }
        System.out.println(stack.internalSize());  // 32 (размер массива удвоился)
        System.out.println(stack.size());          // 17 элементов в стеке

        for (int i = 0; i < 17; i++) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.isEmpty());   // true
        System.out.println(stack.size());      // 0
    }
}