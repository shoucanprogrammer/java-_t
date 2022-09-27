package Stack;

public class Calculator {
    public static void main(String[] args) {
        //根据前面老师思路，完成表达四运算；
        String expression = "30+2*6-2";
        //创建两个栈，数据，一个符合栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        int index = 0;
        int num1 = 0;
        int num2 =0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        System.out.println(ch);
        while (true){
            //依次得到expression的字符
            ch = expression.substring(index,index+1).charAt(0);
            //判断ch是什么，然后做相应的处理
            if (operStack.isOper(ch)){
                //判断当前的符合栈是否为空
                if (!operStack.isEmpty()){
                 //如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或者等于栈中的操作符，就需要从pop中出两个数
                 //  在符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前操作符入符号栈
                    if (operStack.priority(ch)<= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        //把运算的结果入数栈
                        numStack.push(res);
                        //然后将当前的操作符入符号栈
                        operStack.push(ch);
                    }else {
                        //如果当前操作符优先级大于栈中的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                }else {
                    //如果为空直接入栈
                    operStack.push(ch);
                }
            }else {//如果是数，直接入数栈
                 //分析思路
                //1.当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                //2.在处理数，需要向expression的表达式2的index后再看一位，如果是数进行扫描，如果是符号才入栈
                //3.因此我们需要定义一个变量字符穿，用于拼接
                keepNum +=ch;

                //如果ch已经是expressiond的最后一位，就直接入栈
                if (index == expression.length() - 1){
                    numStack.push(ch-48);
                }else {
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        //如果后一位是运算符入栈
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
//                判断下一个字符是不是数字，如果是继续扫描
            }
            //让index+1，并判断是否扫描到expression最后
            index++;
            if (index>=expression.length()){
                break;
            }
        }
        while (true){
            //如果符号栈为空，则计算到最后的结果，数组中只有一个数字【结果】
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.printf("%s = %d",expression,numStack.pop());
    }
}
//

class ArrayStack2{
    private int maxSize;
    private  int[] stack;
    private int top = -1;

    public  ArrayStack2(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    public boolean isFull(){
        return top == maxSize -1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public void push(int value){
        //先判断栈是否满
        if (isFull()){
            System.out.println("isFull");
            return;
        }
        top++;
        stack[top] = value;
    }
    public  int pop(){
        //先判断是否为空格
        if (isEmpty()){
            //抛出异常
            throw new RuntimeException("isEmpty no data");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void showlist(){
        if (isEmpty()){
            System.out.println("isEmpty");
            return;
        }
        for (int i = top ;i>=0 ; i--){
            System.out.printf("Stack[%d]\n",i,stack[i]);
        }
    }
    //返回运算符的优先级，优先级使用数字表示
    //数字越大，则优先级越高。
    public int priority(int oper){
        if (oper=='*'||oper=='/'){
            return 1;
        }else if (oper=='+'||oper=='-'){
            return 0;
        }else {
            return -1;
        }
    }
    public boolean isOper(char val){
        return val=='+'|| val=='-'|| val=='*'||val=='/';

    }
    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1+num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
            default:
                break;
        }
        return res;

    }

    //增加一个方法，可以返回当前栈顶的值，但是不是真正的pop
    public int peek(){
        return stack[top];
    }



}
