package cn.dinghao.sortAlgorithm;

import java.util.Arrays;

public class HeapSort{
	public static void adjustHeap(int[] a,int currentRoot,int size){
		if (currentRoot<size) {
			int left = 2 * currentRoot + 1;
			int right = 2 * currentRoot + 2;

			int max = currentRoot;
			if (left < size) {
				if (a[max] < a[left]) {
					max = left;
				}

			}
			if (right < size) {
				if (a[max] < a[right]) {
					max = right;
				}

			}
			if (max != currentRoot) {
				int temp = a[currentRoot];
				a[currentRoot] = a[max];
				a[max] = temp;

				adjustHeap(a,max,size);
			}
		}

	}

	public static int[] createHeap(int[] a,int size){
		for (int i=size-1 ; i>=0 ; i-- ) {
			adjustHeap(a,i,size);	
		}
		return a;
	}

	public static int[] heapSort(int[] a,int size){
		while (size>1){
			int temp=a[0];
			a[0]=a[size-1];
			a[size-1]=temp;
			size--;
			createHeap(a,size);

		}

		return a;
	}

	public static void main(String[] args) {
		int[] a={3,1,5,7,2,4,9,6};
		System.out.println(Arrays.toString(heapSort(createHeap(a,a.length),a.length)));
	}
}