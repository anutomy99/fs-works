package Thread.Array;

import java.util.Arrays;
class ThreadSort extends  Thread{
    private int array[];
    public ThreadSort(int array[]) {
        this.array = array;
    }
    @Override
    public void run() {
        bubbleSort(array);
        System.out.println(Thread.currentThread().getName()+" sorted array: "+Arrays.toString(array));

    }
    private void bubbleSort(int[] array) {
        int size = array.length;
        for (int i =0;i<size-1;i++){
            for (int j=0;j<size-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1]= temp;
                }
            }
        }
    }
}
public class ArraySorting {
    public static void main(String[] args) throws InterruptedException {
        int[] unSorted={11,29,8,22,97,13,99,5};
        System.out.println("Before Sorting: "+Arrays.toString(unSorted));
        int mid=(unSorted.length)/2;
        int[] leftArray= Arrays.copyOfRange(unSorted,0,mid);
        int [] rightArray=Arrays.copyOfRange(unSorted,mid,unSorted.length);

        Thread thread1= new Thread(new ThreadSort(leftArray));
        thread1.setName("Left-Thread");
        thread1.start();

        Thread thread2= new Thread(new ThreadSort(rightArray));
        thread2.setName("Right-Thread");
        thread2.start();

        thread1.join();
        thread2.join();

        merge(leftArray,rightArray);

    }
    public static void merge(int[] leftArray,int[] rightArray){
        int[] result=new int[leftArray.length+rightArray.length];
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                result[k++] = leftArray[i++];

            } else {
                result[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            result[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            result[k++] = rightArray[j++];
        }

        System.out.print("After Sorting: "+Arrays.toString(result));
    }
}