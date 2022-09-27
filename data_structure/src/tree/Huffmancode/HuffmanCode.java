package tree.Huffmancode;

import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        //测试压缩文件
        String scrFile = "C:\\Users\\tllll\\Desktop\\1.png";
        String dstFile = "C:\\Users\\tllll\\Desktop\\2.zip";
        zipFile(scrFile,dstFile);
//        测试解压文件
        String zipFile = "C:\\Users\\tllll\\Desktop\\2.zip";
        String desFile1 = "C:\\Users\\tllll\\Desktop\\3.png";
        unZipFile(zipFile,desFile1);


//        String content = "i like like like java do you like a java";
//        byte[] conmtentbytes = content.getBytes();
//        System.out.println("conmtentbytes:"+Arrays.toString(conmtentbytes));
//        byte[] huffmanCodesBytes = huffmanZip(conmtentbytes);
//        System.out.println("ZIP_result:"+Arrays.toString(huffmanCodesBytes));
////
//        //测试一把byteToBitString方法
//        byte[] sourceBytes = decode(huffmanCodes,huffmanCodesBytes);
//        System.out.println("original str"+ Arrays.toString(sourceBytes));
//        System.out.println("original str: "+ new String(sourceBytes));

        //分布的过程
        /*
        List<Node> nodes = getNodes(conmtentbytes);
        System.out.println("nodes = "+nodes);
        //test
        System.out.println("huffmantree");
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        preOrder(huffmanTreeRoot);

        //test是否征程相对于的哈夫曼编码
        getCodes(huffmanTreeRoot);
        System.out.println("haffumanCodes"+huffmanCodes);
        //test
        byte[] huffmanCodeBytes = zip(conmtentbytes,huffmanCodes);
        System.out.println("huffmanCodeBytes="+Arrays.toString(huffmanCodeBytes));
        //发送huffmanCodeBytes数组

         */


    }
    //编写一个方法，完成对压缩文件的解压

    /**
     *
     * @param zipFile 准备解压的文件
     * @param detFile 解压之后的路径
     */
    public static void unZipFile(String zipFile, String detFile){
        //定义文件输入流
        InputStream is = null;
        //定义一个对象输入流
        ObjectInputStream ois = null;
        //定义文件的输入流
        OutputStream os = null;
        try {
            //创建文件输入流
            is = new FileInputStream(zipFile);
            //创建一个和is关联的对象输入流
            ois = new ObjectInputStream(is);
            //读取byte数组 huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取哈夫曼编码报表HashMap<Byte, String>()
            Map<Byte,String> huffmanCodes = (HashMap<Byte, String>) ois.readObject();
            //解码
            os = new FileOutputStream(detFile);
            byte[] bytes = decode(huffmanCodes,huffmanBytes);
            //将bytes数组写入到目标文件
            //写出数据到文件中
            os.write(bytes);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }



    //编写方法，将一个文件进行压缩
    /**
     *
     * @param scrFile 你传入的希望压缩的文件路径
     * @param dstFile 我们压缩后将压缩文件放在那个目录
     */
    public static void zipFile(String scrFile, String dstFile) {
        //创建输出流
        FileInputStream is = null;
        ObjectOutputStream oos = null;
        OutputStream os = null;
        try {
            //创建文件的输入流
            is = new FileInputStream(scrFile);
            //创建一个和源文件大小一样的byte[]
            byte[] b = new byte[is.available()];
            is.read(b);
            //直接对源文件压缩
            byte[] huffmanBytes = huffmanZip(b);
            //创建文件的输出流，存放压缩文件
            os = new FileOutputStream(dstFile);
            //创建一个和文件输出流相关联ObjectOutStream
            oos = new ObjectOutputStream(os);
            //把哈夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);//我们是把
            //这里我们以 对象流的方式写入哈夫曼编码，是为了恢复源文件时使用
            //一定要把哈夫曼编码写入压缩文件
            oos.writeObject(huffmanCodes);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();
                oos.close();
                os.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
    //使用一个方法，将前面的方法封装起来，便于我们调用
    /*
    byte 原始的字符对应的字节数组
    是经过哈夫曼编码处理后的字节数组
     */

    //完成数据的解压
    //思路
    //1、将huffmanCodeBytes [-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]\
    //重新转成哈夫曼编码对应的二进制字符1010100010111....
    //2.哈夫曼编码对应的二进制的字符串 1010100010111... 对照哈夫曼编码

    //编写一个方法，完成对压缩数据的解码

    /**
     *
     * @param huffmanCodes 哈夫曼编码map
     * @param huffmanBytes 哈夫曼编码得到的字节数组
     * @return 原来的字符对应的数组
     */
    private static byte[] decode(Map<Byte,String> huffmanCodes, byte[] huffmanBytes){
        //1 先得到huffumanBytes对应的二进制字符串，形式101010001011...
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二进制的字符串
        for (int i = 0;i <huffmanBytes.length; i++){
            byte b = huffmanBytes[i];
            boolean flag =( i ==huffmanBytes.length -1 );
            stringBuilder.append(byteToBitString(!flag,b));
        }
        System.out.println("heffuman decode  Binary code:"+ stringBuilder.toString());
        //把字符穿安装指定的哈夫曼编码进行编码
        //把哈夫曼编码标进行调换吗，因为反向查询a->100 100->a
        Map<String,Byte> map = new HashMap<String,Byte>();
        for (Map.Entry<Byte,String> entry : huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
        //创建要给的集合，存放byte
        List<Byte> list = new ArrayList<>();
        //i 可以理解成就是索引扫描，扫描stringBuilder
        for (int i = 0; i < stringBuilder.length(); ){
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag){
                //10010100010111...
                //递增取出一个'1' '0'
                String key = stringBuilder.substring(i,i+count);//i 不动，让count移动，指定匹配搭配一个字符
                b = map.get(key);
                if (b==null){//说明没有匹配到
                    count++;
                }else {
                    //匹配到
                    flag = false;
                }
            }
            list.add(b);
            i += count;// i直接移动到count
        }
        //当for循环结束后，我们list中存放所有的字符 “i like like like java do you like a java”
        //把list 中的数据放入byte[]并返回
        byte b[] = new byte[list.size()];
        for (int i = 0; i<b.length;i++){
            b[i] = list.get(i);
        }
        return b;
    }


    /*
    b传入的byte转换成一个二进制的字符串，如果看不懂，可以参考二进制原码反码补码
    flag标志是否需要补高位如果是True，表示需要补高位，如果是false表示不补·
    reture 是该b 对应的二进制的字符串（注意是按补码返回）
     */
    private static String byteToBitString(boolean flag, byte b){
        //使用变量保存b
        int temp = b; //将b转成int
        //如果是正数我们还存在补高位
        if (flag){
            temp |= 256; //按位或 256   1 0000 0000 | 0000 0001 => 1 0000 0001
        }
        String str = Integer.toBinaryString(temp);//返回的是temp对应的二进制补码
//        System.out.println("str="+str);
        if (flag){
            return str.substring(str.length()-8);
        }else {
            return str;
        }

    }


    private static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        //根据nodes 创建的哈夫曼树
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        //对应的哈夫曼编码（根据 哈夫曼树）
        Map<Byte,String> huffmanCodes = getCodes(huffmanTreeRoot);
        //根据生成的哈夫曼编码，压缩得到压缩后的哈夫曼编码字节数
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }





    //编写一个方法，将字符串对应的byte[]数组，通过生成的哈夫曼编码表，返回一个哈夫曼编码压缩后的byte[]
    /*
    bytes 这时原始的字符串对应的byte[]
    huffmanCodes生成的哈夫曼编码map
    reture 返回哈夫曼编码处理后的byte[]
     */
    private static byte[] zip(byte[] bytes,Map<Byte,String>huffmanCodes){
          //1.利用huffmanCodes将bytes转成哈夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes数组
        for (byte b : bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        System.out.println("test stringBuilder="+stringBuilder.toString());
        //将10101000101111..转换成byte[]数组
        //统计返回byte[] huffmanCodeBytes长度
        int len;
        if (stringBuilder.length() % 8 == 0){
            len = stringBuilder.length()/8;
        }else {
            len = stringBuilder.length() /8 +1;
        }
        //创建存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length();i += 8){
            String strByte;
            if (i+8 > stringBuilder.length()){//不够八位
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i,i + 8);
            }
            //将strByre转成byte，放入到huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte,2);
            index++;
        }

        return huffmanCodeBytes;

    }

    //生成哈夫曼树对应的哈夫曼编码
    //思路:
    //1.将哈夫曼编码表放在Map<Byte,String>形式
    // 32->01 97->100 100->11000等等
    static Map<Byte,String> huffmanCodes = new HashMap<Byte, String>();
    //2.在生成哈夫曼编码表示，需要去拼接路径，定义StringBuilder存储某个叶子结点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    //为了调用方便，我们重载getCodes
    private static Map<Byte,String> getCodes(Node root){
        if (root == null){
            return null;
        }
        //处理root的左子树
        getCodes(root.left,"0",stringBuilder);
        //处理root的右子树
        getCodes(root.right,"1",stringBuilder);
        return huffmanCodes;
    }
    /*
        功能：将传入的node结点的所有叶子结点的哈夫曼编码得到，并存放到huffmanCodes集合
        node 传入结点
        code 路径：左子节点是0 右子结点是0
        stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node,String code, StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //讲code加入stringBuilder2
        stringBuilder2.append(code);
        if (node != null){
            //如果node == null不处理
            //判断当前node是叶子结点还是非叶子结点
            if (node.data == null ){//非叶子结点
                //递归处理
                //向左递归
                getCodes(node.left,"0",stringBuilder2);
                //向右递归
                getCodes(node.right,"1",stringBuilder2);
                 }else {//说明是一个叶子结点
                //就表示找到某个叶子结点的最后
                huffmanCodes.put(node.data, stringBuilder2.toString());

            }
        }
    }

    private static List<Node> getNodes(byte[] bytes){
        //1创建一个ArrayList
        ArrayList<Node> nodes = new ArrayList<Node>();
        //存储bytes，统计每一个byte出现的次数->map[key,value]
        HashMap<Byte,Integer > counts = new HashMap<>();
        for (byte b : bytes){
            Integer count = counts.get(b);
            if (count == null){//Map 还没有这个字符数据，第一次
                counts.put(b,1);
            }else {
                counts.put(b,count + 1);
            }
        }
        //把每个键值对转成一个Node对象，并加入到node集合
        //遍历map
        for (Map.Entry<Byte, Integer> entry: counts.entrySet()){
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size() > 1){
            //排序,从小到大
            Collections.sort(nodes);
            //取出第一颗最小的二叉树
            Node leftNode = nodes.get(0);
            Node rightnode = nodes.get(1);
            //创建一颗新的二叉树，它的根节点没有data，只有权值
            Node parent = new Node(null, leftNode.weight+rightnode.weight);
            parent.left = leftNode;
            parent.right = rightnode;
            //将两颗已经处理的二叉树删除
            nodes.remove(leftNode);
            nodes.remove(rightnode);
            //将新的二叉树没加入nodes
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    //前序遍历
    private static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("empty");
        }
    }


}
//创建Node，待数据和权值
class Node implements Comparable<Node>{
    Byte data;//待存放数据本身，入'a' = 97
    int weight;//权值,表示字符出现的次数
    Node right;
    Node left;
    public Node(Byte data, int weight){
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
}