package cn.dinghao.sortAlgorithm;

import java.util.Arrays;

public class InsertSort {

    public int[] insertSort(int[] a){
        if (a.length<2){
            return a;
        }
        for (int i=1;i<a.length;i++){
            for (int j=i-1;j>=0;j--){
                if(a[j]>a[j+1]){
                    int temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a={3,1,5,7,2,4,9,6};
        InsertSort insertSort=new InsertSort();
        System.out.println(Arrays.toString(insertSort.insertSort(a)));
    }
}
