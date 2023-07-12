package asort;

public class myInsertSort {
    public static void main(String[] args){
        int[] array = {38,65,97,76,13,27,49};
        insertSort(array);
    }

    public static void insertSort(int[] arr){
        //使用for循环简化代码
        for (int i = 1; i <arr.length;i++){

            int insertVal = arr[i];
            int insertIndex = i-1;//即arr[1]的前面这个的下标

            while (insertIndex >=0 && insertVal<arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertVal;
//              System.out.printf("%d epoch:%s\n",i, Arrays.toString(arr));
        }
    }

}


