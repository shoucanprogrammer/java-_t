package recursion;

public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部置为1
        for(int i = 0; i < 7; i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右置为1；
        for(int i = 0;i < 8; i++){
           map[i][0] = 1;
           map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][1] = 1;
        //输出地图
        for (int i = 0; i < 8; i++ ){
            for (int j = 0; j < 7; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        //使用递归给小球找路
//        setWay(map,1,1);
        setWay2(map,1,1);
        for (int i = 0; i < 8; i++ ){
            for (int j = 0; j < 7; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }


    }
    //使用递归回溯来给小球找路
    //说明
    //i,j表示从地图的那个位置开始出发
    //如果小球能到map[6][5]位置，则说明通路找到
    //约定：当map[i][j]为0表示该点没有走过 当为1表示墙 2表示通路可以走； 3表示该店已经走过，但是走不通
    //再走迷宫时，需要确定一个策略（方法）下 右 上 左 如果该点走不通，再回溯


    public static boolean setWay1(int[][] map,int i,int j){
        if (map[6][5]==2){//通路已经找到
            return true;
        }else {
            if (map[i][j] ==0 ){
                //策略 下 右 上 左
                map[i][j] = 2 ;//假设该点能走通
                if (setWay2(map,i-1,j)){
                    return true;
                }else if (setWay1(map, i, j+1)){
                    return true;
                }else if (setWay1(map, i+1, j)){
                    return true;
                }else if (setWay1(map, i, j-1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {//如果map[i][j]不等于 0   可能是1，2，3
                return false;
            }
        }
    }
    public static boolean setWay2(int[][] map,int i,int j){
        if (map[6][5]==2){//通路已经找到
            return true;
        }else {
            if (map[i][j] ==0 ){
                //安装策略 上下左右
                map[i][j] = 2 ;//假设该点能走通
                if (setWay2(map,i-1,j)){
                    return true;
                }else if (setWay2(map, i, j+1)){
                    return true;
                }else if (setWay2(map, i+1, j)){
                    return true;
                }else if (setWay2(map, i, j-1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {//如果map[i][j]不等于 0   可能是1，2，3
                return false;
            }
        }
    }




}
