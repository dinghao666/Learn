public class FindDiagonalOrder{
	public int[] findDiagonalOrder(int[][] a){
		int m = a.length;
		int n = a[0].length;
		int sum = 0;
		int k = 0;
		int[] arr = new int[m*n];
		for (sum=0;sum<n ;sum++ ) {
			for (int i=sum;i>=0;i-- ) {
				if (sum%2 == 0) {
					arr[k++] = a[i][sum-i];
			    }
			    else{
			    	arr[k++] = a[sum-i][i];
			    }	
			}
		}
		sum = n;
		for (int i=0;i<m-n+1 ;i++ ) {
			if (sum%2 == 0) {
				arr[k++] = a[i][sum-i];
				sum++;	
			}
			else{
				arr[k++] = a[sum-i][i];
				sum++;
			}
		}

		for (sum=n+1;sum<m+n ;sum++ ) {
			for (int i=sum;i>=0;i-- ) {
				if (sum%2 == 0) {
				arr[k++] = a[i][sum-i];
				sum++;	
			}
			else{
				arr[k++] = a[sum-i][i];
				sum++;
			}
				
			}
			
		}


	}
}