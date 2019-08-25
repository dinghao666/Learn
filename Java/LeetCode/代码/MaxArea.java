public class MaxArea{
	public static int maxArea(int[] height){
		int res = 0;
		int m = 0;
		int n = height.length-1;
		while(m<n) {
			if (height[m]>height[n]) {
				res = (height[n]*(n-m)>res)?height[n]*(n-m):res;
				n--;	
			}
			else{
				res =(height[m]*(n-m)>res)?height[m]*(n-m):res;
				m++;
		    }
		}
		return res;
	}
	public static void main(String[] args) {
		int[] height = {1,2,6,2,5,4,8,3,7};
		System.out.println(MaxArea.maxArea(height));

	}
}