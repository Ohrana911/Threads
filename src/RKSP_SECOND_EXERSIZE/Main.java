package RKSP_SECOND_EXERSIZE;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public final static int size = 10000;

    public static void main(String[] args) throws Exception {

        ArrayList arrayList = new ArrayList();
        InputArray inputArray = new InputArray(size);
        ArrayList<Integer> arr = inputArray.getArray(arrayList);


        long startTime = System.nanoTime();


        ExecutorService executorService = Executors.newFixedThreadPool(4);
        int chunkSize = size / 4;
        ArrayList<Future<Integer>> futures = new ArrayList<>();


        for (int i = 0; i < 4; i++) {
            final int start = i * chunkSize;
            final int end = (i == 3) ? size : start + chunkSize;

            Callable<Integer> task = () -> {
                int sum = 0;
                for (int j = start; j < end; j++) {
                    sum += arr.get(j);
                    Thread.sleep(1);
                }
                return sum;
            };

            Future<Integer> future = executorService.submit(task);
            futures.add(future);
        }


        int totalSum = 0;
        for (Future<Integer> future : futures) {
            totalSum += future.get();
        }


        executorService.shutdown();

        // Завершение замера времени
        long endTime = System.nanoTime();
        long duration = endTime - startTime; // Время выполнения в наносекундах

        // Вывод результата и времени выполнения
        System.out.println("Total sum: " + totalSum);
        System.out.println("Time taken: " + duration / 1_000_000 + " ms"); // Конвертация в миллисекунды
    }
}
