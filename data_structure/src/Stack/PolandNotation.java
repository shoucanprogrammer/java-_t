package Stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author guizimo
 * @date 2020/4/6 12:25 下午
 */
public class PolandNotation {
    public static void main(String[] args) {
        //表达式
        String suffixExpression = "2*9+5*(4+7/3)";
        //中缀表达式对应的List
        System.out.println("中缀表达式对应的List");
        List<String> infixExpressionList = toInfixExpressionList(suffixExpression);
        System.out.println(infixExpressionList);
        //后缀表达式对应的List
        System.out.println("后缀表达式对应的List");
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println(suffixExpressionList);

        //计算逆波兰表达式
        System.out.printf("suffixExpression=%d", calculate(suffixExpressionList));

    }

    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<String>();  //符号栈
        List<String> s2 = new ArrayList<String>();  //结果

        for (String item : ls) {
            //如果是一个数
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    //将中缀表达式转换成list
    public static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<String>();
        int i = 0;
        String str;  //多位数
        char c;
        do {
            //非数字
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else { //数字，但是考虑到多位数
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

    //完成对逆波兰表达式的计算
    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            //使用正则表达式
            if (item.matches("\\d+")) {  //匹配多位数
                //入栈
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有问题");
                }
                //把结果入栈
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}


class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在");
                break;
        }
        return result;
    }
}