package Thread.Array;

import java.util.Arrays;

public class ParallelSort {
    public static void main(String[] args) {
        int arrayToSort[] = {10,4,8,29,22,11,5,1,31};
        int numOfThreads = 3;
        Thread sortingThreads[] = new Thread[numOfThreads];
        int segmentSize = arrayToSort.length / numOfThreads;
        for (int i= 0; i<numOfThreads; i++){
            final int startIndex = i * segmentSize;
            final int endIndex = (i==numOfThreads-1) ? arrayToSort.length : (i+1) * segmentSize;
            sortingThreads[i] = new Thread(()-> Arrays.parallelSort(arrayToSort,startIndex,endIndex));
            sortingThreads[i].setName("Thread :"+i);
            sortingThreads[i].start();

        }
        for (Thread thread : sortingThreads){

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Arrays.sort(arrayToSort);
        System.out.println("Sorted array : "+Arrays.toString(arrayToSort));
    }
}

