/*
Title   : 농작물 수확하기
Author  : Hoseok Lee
Date    : 2024/01/30

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB
https://github.com/hoshogi
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {
	
	private static StringBuilder sb = new StringBuilder("");
	
	private static boolean isPossible(int r, int c, int n) {
		if (Math.abs(r - n / 2) + Math.abs(c - n / 2) <= n / 2)
			return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			int result = 0;
			int n = Integer.parseInt(br.readLine());
			
			
			for (int j = 0; j < n; j++) {
				String str = br.readLine();
				for (int k = 0; k < n; k++) {
					if (isPossible(j, k, n))
						result += str.charAt(k) - '0';
				}
			}
			
			sb.append("#").append(i).append(" ").append(result).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}