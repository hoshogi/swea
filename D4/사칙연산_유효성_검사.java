/*
Title   : 사칙연산 유효성 검사
Author  : Hoseok Lee
Date    : 2024/02/06

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD
https://github.com/hoshogi
*/

import java.io.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int result = 1;
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                String[] orders = br.readLine().split(" ");
                if (isOperator(orders[1]) && orders.length < 4)
                    result = 0;
                if (!isOperator(orders[1]) && orders.length > 2)
                    result = 0;
            }
            answer.append("#").append(t).append(" ").append(result).append("\n");
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }

    private static boolean isOperator(String str) {
        switch (str) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
        }
        return false;
    }
}
