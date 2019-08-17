package cn.dinghao.sortAlgorithm;

import java.util.Arrays;

public class QuickSort {
    public int[] quickSort(int[] a,int start,int end){
        int key=a[start];
        int i=start;
        int j=end;
        while(i<j){
            while(i<j&&a[j]>=key){
                j--;
            }
            a[i]=a[j];
            a[j]=key;
            while(i<j&&a[i]<=key){
                i++;
            }
            a[j]=a[i];
            a[i]=key;
        }
        if (i-1>start) a=quickSort(a,start,i-1);
        if (j+1<end)   a=quickSort(a,j+1,end);
        return a;
    }


    public static void main(String[] args) {
        int[] a={2,3,5,7,1,4,6,15,5,2,7,9,10,9,17,12};
        QuickSort QuickSort=new QuickSort();
        System.out.println(Arrays.toString(QuickSort.quickSort(a,0,a.length-1)));
    }
}
