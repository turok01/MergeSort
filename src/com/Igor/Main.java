package com.Igor;

class MergeSort{
    public int [] sortArray (int [] array){
        if (array == null){
            return null;

        }
        if (array.length < 2){
            return array;
        }
        int [] arrayLeft = new int[array.length/2];
        System.arraycopy(array, 0, arrayLeft, 0, array.length/2);

        int [] arrayRight = new int[array.length - array.length/2];
        System.arraycopy(array, array.length/2, arrayRight, 0, array.length - array.length/2);

        arrayLeft = sortArray(arrayLeft);
        arrayRight = sortArray(arrayRight);

        array = mergeArray(arrayLeft,arrayRight);

        return array;
    }
    public int [] mergeArray (int [] arrayLeft,int []arrayRight){
        int lindex=0, rindex=0;
        int [] array;

        if (arrayLeft.length + arrayRight.length < 1) {
            return null;
        }
        else {
            array = new int [ arrayLeft.length + arrayRight.length];
        }
        for (int i = 0; i < arrayLeft.length + arrayRight.length; i++){
            if (lindex < arrayLeft.length){
                if (rindex < arrayRight.length){
                    if (arrayLeft[lindex] < arrayRight[rindex]){
                        array[i]=arrayLeft[lindex];
                        lindex++;
                    }
                    else{
                        array[i] = arrayRight[rindex];
                        rindex++;
                    }
                }
                else {//arrayRight is over
                    for (;i<arrayLeft.length + arrayRight.length;i++) {
                        array[i] = arrayLeft[lindex];
                        lindex++;
                    }
                }
            }
            else{//arrayLeft is over
                for(;i < arrayLeft.length + arrayRight.length;i++){
                    array[i] = arrayRight[rindex];
                    rindex++;
                }
            }
        }
        return array;
    }
}
public class Main{

    public static void main(String []args){
        MergeSort mergeSort = new MergeSort();

        int[] arrayToTest = new int [] {11,2,10,5,1};
        System.out.println("Array:");
        for(int i: arrayToTest){
            System.out.print(i + " ");
        }
        System.out.println("\nArray after merge sorting:");
        for(int i: mergeSort.sortArray(arrayToTest)){
            System.out.print(i + " ");
        }


    }
}
