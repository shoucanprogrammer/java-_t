import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] enemies = new int[n][2];
        for (int i = 0; i < n; i++) {
            enemies[i][0] = scanner.nextInt();
            enemies[i][1] = scanner.nextInt();
        }
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int count = 0;
                for (int k = i; k <= j; k++) {
                    boolean valid = true;
                    for (int l = i; l <= j; l++) {
                        if (Math.abs(enemies[k][0] - enemies[l][0]) > a || Math.abs(enemies[k][1] - enemies[l][1]) > b) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        count++;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }
        System.out.println(maxCount);
    }
}
