/*
Title   : 괄호 짝짓기
Author  : Hoseok Lee
Date    : 2024/02/02

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD
https://github.com/hoshogi
*/

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int result = 1;
            Deque<Character> dq = new ArrayDeque<>();
            int bracketLen = Integer.parseInt(br.readLine());
            String bracketList = br.readLine();

            for (int i = 0; i < bracketLen; i++) {
                char bracket = bracketList.charAt(i);
                if (isOpenBracket(bracket)) {
                    dq.addLast(bracket);
                    continue;
                }

                if (dq.isEmpty() || findCoupleBracket(dq.peekLast()) != bracket) {
                    result = 0;
                    break;
                }
                dq.pollLast();
            }

            if (!dq.isEmpty())
                result = 0;

            answer.append("#").append(t).append(" ").append(result).append("\n");
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }

    private static boolean isOpenBracket(char bracket) {
        switch (bracket) {
            case '(':
            case '[':
            case '{':
            case '<':
                return true;
        }
        return false;
    }

    private static char findCoupleBracket(char bracket) {
        switch (bracket) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
            case '<':
                return '>';
        }
        return ' ';
    }
}
