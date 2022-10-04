package org.example;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 문제 32번 두개 뽑아서 더하기
 */
class Solution32 {
    public ArrayList<Integer> solution(int[] numbers) {
        // 1. 정답 ArrayList 객체
        ArrayList<Integer> answer = new ArrayList<>();
        // 2. 더한 결과의 중복을 확인하기 위한 배열, 데이터 최댓값인 100이 두 번 더해지는 200이 최대로 나올 수 있는 수.
        boolean[] check = new boolean[201];
        // 3. numbers탐색, 자신과 자신 앞의 데이터를 더하게 되므로 마지막 인덱스는 고려하지 않는다.
        for(int i =0;i<numbers.length-1;i++){
            int sum;
            // 3-1. 인덱스 1,2의 결과와 2,1의 결과는 같으므로, i+1부터 시작.
            for(int j = i+1;j<numbers.length;j++){
                sum = numbers[i]+numbers[j];
                // 3-2. 더한 값이 나오지 않았던 수라면, ArrayList에 삽입 후 방문처리.
                if(!check[sum]){
                    answer.add(sum);
                    check[sum] = true;
                }
            }
        }
        // 4. 구한 결과를 저장한 ArrayList를 정렬.
        Collections.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        int []numbers = { 2,1,3,4,1};
        System.out.println(solution32.solution(numbers));
    }
}