package S832_flipAndInvertImage;

public class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int m = image.length;
        int n = image[0].length;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n / 2; j++){
                int tem = image[i][j];
                image[i][j] = image[i][m - 1 - j];
                image[i][m - 1 - j] = tem;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (image[i][j] == 0) {
                    image[i][j] = 1;
                }else {
                    image[i][j] = 0;
                }
            }
        }
        return image;
    }
}
