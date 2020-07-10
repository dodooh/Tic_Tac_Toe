import java.util.Scanner; 

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[][] cinema = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                cinema[i][j] = sc.nextInt();
            }
        }
        
        int k = sc.nextInt();
        int row = 0;
        boolean flag = true;
        for(int i = 0; i < n && flag ; i++) {
            int count = 0;
            for(int j = 0; j < m; j++) {
                if (cinema[i][j] == 0) {
                    count++;
                } else if (cinema[i][j] == 1) {
                    count = 0;
                }
                if (count == k) {
                    row = i + 1;
                    flag = false;
                    break;
                }
            }
        }
        System.out.println(row);
    }
}
