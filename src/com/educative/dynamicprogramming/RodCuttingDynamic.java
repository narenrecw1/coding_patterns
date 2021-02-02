package com.educative.dynamicprogramming;

public class RodCuttingDynamic {

	public static void main(String[] args) {
		RodCuttingDynamic cuttingDynamic = new RodCuttingDynamic();
		int [] lengths = {1,2,3,4,5};
		int [] prices = {2,6,7,10,13};
		int maxProfit = cuttingDynamic.solveRodCutting(lengths, prices,5);
		System.out.print("The Max Profit we can get is "+ maxProfit);

	}

	private int solveRodCutting(int[] lengths, int[] prices, int n) {
		
		if(n<=0 || prices.length==0 || prices.length != lengths.length) return 0;
		
		
		int lengthCount = lengths.length;
		int [][]dp = new int[lengthCount][n+1];
		for(int i = 0 ; i <lengthCount; i++ ) {
			for(int len= 1; len<= n; len++) {
				int p1 = 0, p2 = 0;
				if(lengths[i] <= len) {
					p1 = prices[i]+dp[i][len-lengths[i]];
				}
				if(i>0) {
					p2 = dp[i-1][len];
				}
				dp[i][len] = Math.max(p1, p2);
				
			}
		}
		
		return dp[lengthCount-1][n];
	}
	
	
	

}
