package tree.AVL;



public class avltest {
    private static int arr[]= {2,1,4,5,6,7,16,15,14,13,12,11,10,8,9};
          public static void main(String[] args) {
              int i;
              AvlNode root = new AvlNode(3);
              System.out.printf("== 依次添加: ");
              for(i=0; i<arr.length; i++) {
                  System.out.printf("%d ", arr[i]);
                  root = root.insert(arr[i]);
              }
              System.out.println("\n== preOrder: ");
              root.preOrder();
              root = root.remove(16);
              System.out.println("\n== preOrder: ");
              root.preOrder();
          }


}


class AvlNode {
    int value;
    AvlNode left;
    AvlNode right;
    int height;

    public AvlNode() {

    }

    public AvlNode(int value){
        this.value = value;
    }

    public AvlNode(int value, AvlNode left, AvlNode right) {
        this.value = value;
        this.left = left;
        this.right = right;

    }
    private int height(AvlNode t){
        return t == null ? -1 : t.height;
    }

    private AvlNode insert(int x , AvlNode t){
        if (t == null)
            return  new AvlNode(x,null,null);
        if (x < t.value){
            t.left = insert(x,t.left);
        }
        else if (x > t.value){
            t.right = insert(x,t.right);
        }
        else ;
        return balance(t);
    }
    public AvlNode insert(int value){
         return insert(value,this);
    }
    private static final int ALLOWED_IMBALANCE = 1;
    private AvlNode balance(AvlNode t){
        if (t == null)
            return t;
        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE)
            if (height(t.left.left)>=height(t.left.right))
                t = rotateWithLeftChild(t);
            else
                t = doubleWithLeftChild(t);
        else
        if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE)
            if (height(t.right.right)>=height(t.right.left))
                t = rotateWithRightChild(t);
            else
                t = doubleWithRightChid(t);
        t.height = Math.max(height(t.left),height(t.right))+1;
        return t;
    }

    private AvlNode rotateWithLeftChild(AvlNode k2){
        AvlNode k1 = k2.left;
        k2.left = k1.right;
         k1.right = k2;
         k2.height = Math.max(height(k2.left),height(k2.right))+1;
         k1.height = Math.max(height(k1.left),k2.height)+1;
         return k1;
    }
    private AvlNode rotateWithRightChild(AvlNode k1){
        AvlNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left),height(k1.right))+1;
        k2.height = Math.max(height(k2.left),k1.height)+1;
        return k2;
    }
    private AvlNode doubleWithLeftChild(AvlNode k3){
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }
    private AvlNode doubleWithRightChid(AvlNode k1){
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }
    private void preOrder(AvlNode tree) {
        if(tree != null) {
            System.out.println(tree.value);
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }
    public void preOrder(){
        preOrder(this);
    }
    private AvlNode remove(int x, AvlNode t){
        if (t==null)
            return t;
        if (x < t.value)
            t.left = remove(x,t.left);
        else if (x > t.value)
            t.right = remove(x,t.right);
        else if (t.left != null && t.right != null){
            t.value = t.right.minimum();
            t.right = remove(t.value,t.right);
        }
        else
            t = (t.left != null) ? t.left : t.right;
        return balance(t);
    }
    public AvlNode remove(int x){
        return remove(x,this);
    }


    private AvlNode minimum(AvlNode tree) {
        if (tree == null)
            return null;

         while(tree.left != null)
             tree = tree.left;
           return tree;
          }

       public int minimum() {
          AvlNode t = minimum(this);
          if (t != null)
                  return t.value;

           return -100000;
         }

    @Override
    public String toString() {
        return "AvlNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                ", height=" + height +
                '}';
    }
}