import java.util.*;
class Solution {
    // 테스트
    private void test(int[][] arr, int num) {
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    // 늘린 lock에 기존 lock 위치에 넣기
    private int[][] init(int[][] arr, int[][] lock, int k, int l) {
        for (int i = k - 1; i < k - 1 + l; i++) {
            for (int j = k - 1; j < k - 1 + l; j++) {
                arr[i][j] = lock[i - (k - 1)][j - (k - 1)];
            }
        }
        return arr;
    }
    
    // 메서드2) 오른쪽으로 90도 회전 후 메서드1로
    private int[][] rotate(int[][] key, int k) {
        int[][] temp = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                temp[j][k - i - 1] = key[i][j];
            }
        }
        return temp;
    }
    
    // check 메서드
    private boolean check(int l, int k, int[][] arr) {
        for (int x1 = k - 1; x1 < k - 1 + l; x1++) {
            for (int y1 = k - 1; y1 < k - 1 + l; y1++) {
                if (arr[x1][y1] != 1) return false;
            }
        }
        return true;
    }
    
    private boolean play(int num, int k, int[][] arr, int[][] key, int l) {
        for (int i = 0; i <= num - k; i++) {
            for (int j = 0; j <= num - k; j++) {
                // key + lock
                for (int x = 0; x < k; x++) {
                    for (int y = 0; y < k; y++) {
                        arr[i + x][j + y] += key[x][y];
                    }
                }
                
                // 메서드3) check
                if (check(l, k, arr)) return true;
                
                // 원상복구
                for (int x = 0; x < k; x++) {
                    for (int y = 0; y < k; y++) {
                        arr[i + x][j + y] -= key[x][y];
                    }
                }
            }
        }
        return false;
    }
    public boolean solution(int[][] key, int[][] lock) {
        int k = key.length;
        int l = lock.length;
        int num = l + 2 * (k - 1);
            
        // lock의 크기를 열쇠 크기만큼 더 늘리기
        int[][] arr = new int[num][num];
        
        // 늘린 lock에 기존 lock 위치에 넣기
        arr = init(arr, lock, k, l);
        
        
        // 4번 반복
        for (int i = 0; i < 4; i++) {
            // 메서드1) lock을 1개씩 늘려나가며 비교
            if (play(num, k, arr, key, l)) return true;

            // 메서드2) 오른쪽으로 90도 회전 후 메서드1로
            key = rotate(key, k);
        }       
        
        // 맞는 것이 없다면 false 호출
        return false;
    }
}