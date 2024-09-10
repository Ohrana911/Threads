package RKSP_FIRST_EXERSIZE;

import java.util.ArrayList;

public class Main {
    public final static int size = 10000;

    public static void main(String[] args) throws InterruptedException {

        ArrayList arrayList = new ArrayList();
        InputArray inputArray = new InputArray(size);
        ArrayList arr = inputArray.getArray(arrayList);

        // Запуск замера времени
        long startTime = System.nanoTime();


        Exe1_1 exe1 = new Exe1_1();
        int totalSum = exe1.FunctionOne(arr);

        // Завершение замера времени
        long endTime = System.nanoTime();
        long duration = endTime - startTime; // Время выполнения в наносекундах

        // Вывод результата и времени выполнения
        System.out.println("Total sum: " + totalSum);
        System.out.println("Time taken: " + duration / 1_000_000 + " ms"); // Конвертация в миллисекунды

    }
}
