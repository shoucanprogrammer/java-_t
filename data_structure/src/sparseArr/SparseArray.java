package sparseArr;

public class SparseArray {
    public static void main(String[] args) {
//        创建一个元素数组 11*11；
//        0表示没有妻子  1表示黑 2表示白
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] =1;
        chessArr1[2][3] =2;
//        for(int[] row: chessArr1){
//            for (int data:row){
//                System.out.println("\t"+data);
//            }
//        }

        int sum = 0;
        for(int i=0;i<chessArr1.length;i++){
            for (int j=0;j<chessArr1[0].length;j++){
                if (chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        int sparseArray[][] = new int[sum+1][3];
        sparseArray[0][0] = chessArr1.length;
        sparseArray[0][1] = chessArr1[0].length;
        sparseArray[0][2] = sum;
        int num = 0;
        for(int i=0;i<chessArr1.length;i++){
            for (int j=0;j<chessArr1[0].length;j++){
                if (chessArr1[i][j]!=0){
                    num++;
                    sparseArray[num][0] = i;
                    sparseArray[num][1] = j;
                    sparseArray[num][2] =chessArr1[i][j];
                }
            }
        }
        for(int[] row: sparseArray){
            for (int data:row){
                System.out.print("\t"+data);
            }
            System.out.println("\n");
        }
    int row = sparseArray[0][0];
    int column = sparseArray[0][1];
    int num2 = sparseArray[0][2];
    int[][] chessArr2 = new int[row][column];
    for (int i=1; i<= num2 ;i++){
        chessArr2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }
    for(int[] row1: chessArr2){
        for (int data:row1){
            System.out.print("\t"+data);
        }
        System.out.println("\n");
    }



    }
}
