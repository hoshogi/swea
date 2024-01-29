
/*
Title   : 원재의 메모리 복구하기
Author  : Hoseok Lee
Date    : 2024/01/29
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN
https://github.com/hoshogi
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			char prev = '0';
			int result = 0;
			
			String bits = br.readLine().trim();
			for (int j = 0; j < bits.length(); j++) {
				if (bits.charAt(j) != prev) {
					result++;
					prev = bits.charAt(j);
				}
			}
			bw.write((new StringBuilder("#")).append(i).append(" ").append(result).append("\n").toString());
		}
		bw.flush();
		bw.close();
	}
}