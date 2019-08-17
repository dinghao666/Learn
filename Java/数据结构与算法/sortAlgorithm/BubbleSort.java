package cn.dinghao.sortAlgorithm;

import java.util.Arrays;

public class BubbleSort {
    public int[] bubbleSort(int[] a){

        for (int i=0;i<a.length;i++){
            for (int j=0;j<a.length-1;j++){
                if(a[j]>a[j+1]){
                    int t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }
        return a;
    }
    public static void main(String[] args) {
        int[] a={3,1,2,4,0,-1};
        BubbleSort bubbleSort=new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.bubbleSort(a)));
    }
}
