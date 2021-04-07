import java.util.ArrayList;
import java.util.Scanner;

public class HashChainingMethod {
    private static Integer[] table;
    private static int size;
    private static ArrayList<Integer> stack;
    private static ArrayList<Integer> links;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Введите количество элементов: ");
        size = input.nextInt();
        table = new Integer[size];
        stack = new ArrayList<>();
        links = new ArrayList<>();

        System.out.print("Введите числа: ");
        input.nextLine();

        for (int i = 0; i < size; i++) {
            int numbers = input.nextInt();
            chainingMethod(numbers);
        }
//        if (input.hasNextInt()) {
//            int numbers = input.nextInt();
//            hashSimple(numbers, numbers);
//        }

        System.out.println(stack.toString());
        System.out.println(links.toString());

        System.out.print("Введите число для поиска: ");
        input.nextLine();
        int number = input.nextInt();

        findChainingMethod(number);
    }

    public static void chainingMethod(int number) {

        if (table[number % size] == null){
            stack.add(number);
            links.add(null);
            table[number % size] = stack.size() - 1;
        } else {

            int i = table[number % size];

            while (stack.get(i) != number || links.get(i) != null){
                if (stack.get(i) == number) {
                    System.out.println("Таблица уже содержит это значение");
                } else {
                    if (links.get(i) != null){
                        i = links.get(i);
                    } else {
                        stack.add(number);
                        links.add(null);
                        //links.set(i, links.size() - 1);
                    }
                }
            }
        }
    }

    public static int findChainingMethod(int number) {
        if (table[number % size] != null){
            int i = table[number % size];
            while (true) {
                if (stack.get(i) == number){
                    System.out.println("Индекс числа равен " + Integer.toString(i));
                    return i;
                } else {
                    if (links.get(i) != null){
                        i = links.get(i);
                    } else System.out.println("Таблица не содержит введенное число");
                    return -1;
                }
            }
        }
        else {
            System.out.println("Таблица не содержит введенное число");
        }
        return -1;
    }
}
