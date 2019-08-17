package cn.dinghao.sortAlgorithm;

import java.util.Arrays;

public class SelectSort {

    public int[] selectSort(int[] a){
        int temp=0;
        int minIndex=0;
        for(int i=0;i<a.length;i++){
            int min=a[i];
            for (int j=i;j<a.length;j++) {
                if (a[j]<min){
                    min=a[j];
                    minIndex=j;
                }
            }
            temp=a[i];
            a[i]=min;
            a[minIndex]=temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a={3,1,2,4,0,-1};
        SelectSort selectSort=new SelectSort();
        System.out.println(Arrays.toString(selectSort.selectSort(a)));
    }
}
