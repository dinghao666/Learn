package cn.dinghao.sortAlgorithm;

import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] array,int l,int r){
        if (l==r){
            return new int[] {array[l]};
        }
        int mid=(r+l)/2;
        int[] a=mergeSort(array,l,mid);  //左有序数组
        int[] b=mergeSort(array,mid+1,r);  //右有序数组
        int[] merge=new int[a.length+b.length];   //新数组
        int k=0;
        int i=0;
        int j=0;
        while(i<a.length&&j<b.length){
            if (a[i]<b[j]){
                merge[k++]=a[i++];
            }
            else {
                merge[k++]=b[j++];
            }
        }
        while (i<a.length){
            merge[k++]=a[i++];
        }
        while (j<b.length){
            merge[k++]=b[j++];
        }

        return merge;
    }

    public static void main(String[] args) {
        int[] a={3,1,5,7,2,4,9,6};
        MergeSort mergeSort=new MergeSort();
        System.out.println(Arrays.toString(mergeSort.mergeSort(a,0,a.length-1)));
    }
}
