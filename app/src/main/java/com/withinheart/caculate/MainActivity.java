package com.withinheart.caculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn0,btn1,btn2,btn3,btn4,
            btn5,btn6,btn7,btn8,btn9,
            btnJia,btnJian,btnCheng,btnChu,
            btnDian,btnDengyu,btnQingchu,btnHuishan,
            btnsin,btncos,btntan;
    EditText etInput;
    String getText ="";  //存放输入的值
    String str="";
    //判断是否计算过
    private boolean isCounted = false;
    /*
     * 以负号开头，且运算符不是是减号
     *  -(1+2)
     */
    private boolean startWithOperator = false;

    private boolean startWithSubtract = false;

    private boolean noStartWithOperator = false;

    private static final String SERVICE = "输出";

    private boolean isInStack = false;

    private boolean calculateOne = true;

    Stack<String> st = new Stack<String>(); //操作数栈,初始化

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getButton();

    }
    public void getButton(){
        //获取按钮组件
        btn0= (Button) findViewById(R.id.btn0);
        btn1= (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2);
        btn3= (Button) findViewById(R.id.btn3);
        btn4= (Button) findViewById(R.id.btn4);
        btn5= (Button) findViewById(R.id.btn5);
        btn6= (Button) findViewById(R.id.btn6);
        btn7= (Button) findViewById(R.id.btn7);
        btn8= (Button) findViewById(R.id.btn8);
        btn9= (Button) findViewById(R.id.btn9);

        btnJia= (Button) findViewById(R.id.btnJia);
        btnJian= (Button) findViewById(R.id.btnJian);
        btnCheng= (Button) findViewById(R.id.btnCheng);
        btnChu= (Button) findViewById(R.id.btnChu);

        btnDian= (Button) findViewById(R.id.btnDian);
        btnDengyu= (Button) findViewById(R.id.btnDengyu);
        btnQingchu= (Button) findViewById(R.id.btnQingchu);
        btnHuishan= (Button) findViewById(R.id.btnHuishan);

        btnsin=(Button)findViewById(R.id.btnsin);
        btncos=(Button)findViewById(R.id.btncos);
        btntan=(Button)findViewById(R.id.btntan);

        etInput = (EditText) findViewById(R.id.tvResult);
        //绑定监听
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnJia.setOnClickListener(this);
        btnJian.setOnClickListener(this);
        btnCheng.setOnClickListener(this);
        btnChu.setOnClickListener(this);

        btnDian.setOnClickListener(this);
        btnDengyu.setOnClickListener(this);
        btnQingchu.setOnClickListener(this);
        btnHuishan.setOnClickListener(this);

        btnsin.setOnClickListener(this);
        btncos.setOnClickListener(this);
        btnsin.setOnClickListener(this);


        //输入的字符
        getText =etInput.getText().toString();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            //数字按钮
            case R.id.btn0:
                getText = bianjie(getText,"0");
                break;
            case R.id.btn1:
                getText = bianjie(getText,"1");
                break;
            case R.id.btn2:
                getText = bianjie(getText,"2");
                break;
            case R.id.btn3:
                getText = bianjie(getText,"3");
                break;
            case R.id.btn4:
                getText = bianjie(getText,"4");
                break;
            case R.id.btn5:
                getText = bianjie(getText,"5");
                break;
            case R.id.btn6:
                getText = bianjie(getText,"6");
                break;
            case R.id.btn7:
                getText = bianjie(getText,"7");
                break;
            case R.id.btn8:
                getText = bianjie(getText,"8");
                break;
            case R.id.btn9:
                getText = bianjie(getText,"9");
                break;

            //运算按钮
            case R.id.btnJia:
                /**
                 * 运算符
                 */
                /**
                 * 判断已有的字符是否是科学计数
                 * 是 置零
                 * 否 进行下一步
                 *
                 * 判断表达式是否可以进行计算
                 * 是 先计算再添加字符
                 * 否 添加字符
                 *
                 * 判断计算后的字符是否是 error
                 * 是 置零
                 * 否 添加运算符
                 */
                if (!getText.contains("e")) {

                    if (judgeExpression()) {//判断表达式是否可以进行计算

                        if (getText.equals("error")){ //判断计算后的字符是否是 error

                        } else {
                            getText += "+";
                        }
                    } else {

                        if (isCounted) {  //已经运算
                            isCounted = false;
                        }

                        if ((getText.substring(getText.length() -1)).equals("-")) {
                            getText = getText.replace("-", "+");
                        } else if ((getText.substring(getText.length() -1)).equals("*")) {
                            getText = getText.replace("*", "+");
                        } else if ((getText.substring(getText.length() - 1)).equals("/")) {
                            getText = getText.replace("/", "+");
                        } else if (!(getText.substring(getText.length() - 1)).equals("+")) {
                            getText += "+";
                        }
                    }
                } else {
                    getText = "0";  //没有进行科学计数
                }

                break;
            case R.id.btnJian:
                if (!getText.contains("e")) {

                    if (judgeExpression()) {//判断表达式是否可以进行计算

                        if (getText.equals("error")){ //判断计算后的字符是否是 error

                        } else {
                            getText += "-";
                        }
                    } else {

                        if (isCounted) {  //已经运算
                            isCounted = false;
                        }

                        if ((getText.substring(getText.length()-1 )).equals("+")) {
                            getText = getText.replace("+", "-");
                        } else if ((getText.substring(getText.length()-1 )).equals("*")) {
                            getText = getText.replace("*", "-");
                        } else if ((getText.substring(getText.length()-1 )).equals("/")) {
                            getText = getText.replace("/", "-");
                        } else if (!(getText.substring(getText.length()-1 )).equals("-")) {
                            getText += "-";
                        }
                    }
                } else {
                    getText = "0";  //没有进行科学计数
                }

                break;
            case R.id.btnCheng:
                if (!getText.contains("e")) {

                    if (judgeExpression()) {//判断表达式是否可以进行计算

                        if (getText.equals("error")){ //判断计算后的字符是否是 error

                        } else {
                            getText += "*";
                        }
                    } else {

                        if (isCounted) {  //已经运算
                            isCounted = false;
                        }

                        if ((getText.substring(getText.length() - 1)).equals("-")) {
                            getText = getText.replace("-", "*");
                        } else if ((getText.substring(getText.length() - 1)).equals("+")) {
                            getText = getText.replace("+", "*");
                        } else if ((getText.substring(getText.length() - 1)).equals("/")) {
                            getText = getText.replace("/", "*");
                        } else if (!(getText.substring(getText.length() - 1)).equals("*")) {
                            getText += "*";
                        }
                    }
                } else {
                    getText = "0";  //没有进行科学计数
                }

                break;
            case R.id.btnChu:
                if (!getText.contains("e")) {

                    if (judgeExpression()) {//判断表达式是否可以进行计算

                        if (getText.equals("error")){ //判断计算后的字符是否是 error

                        } else {
                            getText += "/";
                        }
                    } else {

                        if (isCounted) {  //已经运算
                            isCounted = false;
                        }

                        if ((getText.substring(getText.length() - 1)).equals("-")) {
                            getText = getText.replace("-", "/");
                        } else if ((getText.substring(getText.length() - 1)).equals("*")) {
                            getText = getText.replace("*", "/");
                        } else if ((getText.substring(getText.length() - 1)).equals("+")) {
                            getText = getText.replace("+", "/");
                        } else if (!(getText.substring(getText.length() - 1)).equals("/")) {
                            getText += "/";
                        }
                    }
                } else {
                    getText = "0";  //没有进行科学计数
                }

                break;



            case R.id.btnDian:
                /**
                 * 判断是否运算过
                 * 否
                 *   判断是否有运算符，有 判断运算符之后的数字，无 判断整个数字
                 *   判断数字是否过长，是则不能添加小数点，否则可以添加
                 *   判断已经存在的数字里是否有小数点
                 * 是
                 *   字符串置为 0.
                 */
                if (!isCounted){

                    if (getText.contains("+") || getText.contains("-") ||
                            getText.contains("*") || getText.contains("/") ){

                        String str1 = null;
                        String str2 = null;

                        if (getText.contains("+")) {
                            str1 = getText.substring(0, getText.indexOf("+"));
                            str2 = getText.substring(getText.indexOf("+") + 1);
                        } else if (getText.contains("-")) {
                            str1 = getText.substring(0, getText.indexOf("-"));
                            str2 = getText.substring(getText.indexOf("-") + 1);
                        } else if (getText.contains("*")) {
                            str1 = getText.substring(0, getText.indexOf("*"));
                            str2 = getText.substring(getText.indexOf("*") + 1);
                        } else if (getText.contains("/")) {
                            str1 = getText.substring(0, getText.indexOf("/"));
                            str2 = getText.substring(getText.indexOf("/") + 1);
                        }

                        boolean isContainedDot = str2.contains(".");
                        if (str2.length() >= 9){

                        } else if (!isContainedDot){
                            if (str2.equals("")){
                                getText += "0.";
                            } else {
                                getText += ".";
                            }
                        } else {
                            return;
                        }
                    } else {
                        boolean isContainedDot = getText.contains(".");
                        if (getText.length() >= 9){

                        } else if (!isContainedDot){
                            getText += ".";
                        } else {
                            return;
                        }
                    }
                    isCounted = false;

                } else {
                    getText = "0.";
                    isCounted = false;
                }
                break;
            case R.id.btnDengyu:
                try {
                   String aa= converPostfix(getText);
                    Log.i(SERVICE,"后缀表达式"+aa);
                    getText = String.valueOf(numberCalculate(aa));

                } catch (Exception e) {
                    e.printStackTrace();
                }
                isCounted = true;
                calculateOne =true;
                break;
            //清除按钮
            case R.id.btnQingchu:
                getText = "0";
                calculateOne =true;
                break;
            case R.id.btnHuishan:
                /**
                 * 字符串长度大于 0 时才截取字符串
                 * 如果长度为 1，则直接把字符串设置为 0
                 */
                if (getText.equals("error")){
                    getText = "0";
                } else if (getText.length() > 0){
                    if (getText.length() == 1) {
                        getText = "0";
                    } else {
                        getText = getText.substring(0,getText.length()-1);
                    }
                }
                break;
            case R.id.btnsin:
                sin();
                break;
            case R.id.btncos:
                cos();
                break;
            case R.id.btntan:
                tan();
                break;

        }

        etInput.setText(getText);
    }


    public String converPostfix(String expression) throws Exception{
        Stack<Character> st = new Stack<Character>(); //运算符栈
        expression = expression+"#";  //最后一位添加“#”以表示运算结束
        String postFix = ""; //后缀表达式
        String c2 = "";
        for (int i=0; i<expression.length()&&expression !=null;i++){
            char c= expression.charAt(i);
            if (c != ' '){
/*                if (c == '('){
                    st.push(c); //优先级最高
                }else if (c == ')'){
                    //右括号就将所有操作符出栈,直到遇到左括号为止
                        Character ac = st.pop();
                        while (c =='('){
                            postFix +=ac.toString(); //将运算符直接添加到后缀表达式后面
                            ac = st.pop();  //如果取出了左括号直接丢弃
                        }
                }*/
                if (isOperator(c)){  //符号判断
                    /**
                     * 1、如果栈为空，直接进栈，如果栈非空，需要将栈顶的运算符的优先级和要入栈的运算符优先级比较
                     * 2、将栈中比入栈的运算符优先级高的出栈，（添加到后缀表达式）然后将该运算符入栈，
                     */
                        isInStack =true; //进栈  boolean值为true
                    if (isInStack ==true || c == '#'){ //如果进栈了，如果是#号，就不进行下面的判断，表示已经到最后一个数了。
                        postFix +=c2+" ";  //将先前存储的值添加到后缀式后面
                        c2 ="";     //将该值清楚，以便进行下次存储
                        isInStack =false;
                    }
                        if (!st.isEmpty()&& c!='#'){  //如果栈非空，则需要判断
                            Character ac = st.pop();
                            while (ac !=null
                                    &&priority(ac.charValue())>priority(c) ){  //判断运算符优先级
                                postFix +=ac;
                                ac = null;
                                //先取出来后判断，如果要跳出循环，将ac值设为null
                            }
                            if(ac!=null){
                                st.push(ac);  //如果没有进行前面的运算符优先级判断，则要将取出的运算符重新压入栈中。
                            }
                        }
                        st.push(c);//运算符入栈
                }
                else {
                    Character c1 = (Character) c;
                    c2 +=c1 ;  //暂时存储该数
                    //postFix +=c;
                }
            }
        }
        while (!st.isEmpty()){
            if (calculateOne ==true){  //将最后的‘#’号出栈，因为涉及到每次更新数据以后都会产生一个‘#’号，所以需要设置boolean值来将‘#号移除栈’
                st.pop();
                calculateOne = false;
            }
            postFix +=" "+st.pop().toString(); //如果栈非空，需要将栈中所有运算符串联到后缀表达式的末尾
        }
        return postFix;  //返回后缀表达式
    }


    public String numberCalculate(String postFix) throws Exception{
        String c5 = "";
        for (int i =0;i<postFix.length();i++){
            char c= postFix.charAt(i);
            if (c == ' '){
                    st.push(c5.toString());
                c5 ="";
                if (st.contains(" ")){
                    st.pop();
                }
            }
            if (isOperator(c)){

                double d2 = Double.valueOf(st.pop().toString());
                double d1 = Double.valueOf(st.pop().toString());
                Log.i(SERVICE,"d2"+d2);
                Log.i(SERVICE,"d1"+d1);
                double result=0;
                switch (c){
                    case '+':
                        result=d1+d2;
                        break;
                    case '-':
                        result=d1-d2;
                        break;
                    case '*':
                        result=d1*d2;
                        break;
                    case '/':
                        if (d2 == 0){
                            getText = "error";
                        }
                        result=d1/d2;

                        break;
                    default:
                        break;
                }
                String value =String.valueOf(result);
                if (value.indexOf(".")>0){
                    value = value.replaceAll("0+?$", "");//去掉多余的0
                    value = value.replaceAll("[.]$", "");//如最后一位是.则去掉
                }
                st.push(value);  //操作后的结果入栈
            }
            else {
                Character c4 = (Character) c;
                c5 += c4;
               // st.push(String.valueOf(c)); //数字入栈

            }
        }
        return st.pop();
    }


    private int priority(char c){
        switch (c){
            case '+':
            case  '-':
            case '*':
            case  '/':
                return 2;
        }
        return 0;
    }


    private boolean isOperator(char c){
        if ('+' ==c||'-' == c||'/'==c||'*'==c || '#' ==c){
            return true;
        }
        return false;
    }


    private String bianjie(String getText, String s) {

        if (!isCounted){

            if (getText.contains("e")){
                getText = "0";
            }

            if (getText.equals("0")){
                getText = "";
            }

            if (getText.contains("+") || getText.contains("-") ||
                    getText.contains("*") || getText.contains("/")){

                String str2 = null;
                if (getText.contains("+")){
                    str2 = getText.substring(getText.indexOf("+")+1);
                } else if (getText.contains("-")){
                    str2 = getText.substring(getText.indexOf("-")+1);
                } else if (getText.contains("*")){
                    str2 = getText.substring(getText.indexOf("*")+1);
                } else if (getText.contains("/")){
                    str2 = getText.substring(getText.indexOf("/")+1);
                }

                if (getText.substring(getText.length()-1).equals("+") ||
                        getText.substring(getText.length()-1).equals("-") ||
                        getText.substring(getText.length()-1).equals("*") ||
                        getText.substring(getText.length()-1).equals("/")){
                    getText += s;
                } else {
                    if (str2.contains(".")){
                        if (str2.length() >= 10){

                        } else {
                            getText += s;
                        }
                    } else {
                        if (str2.length() >= 9){

                        } else {
                            getText += s;
                        }
                    }
                }
            } else {

                if (getText.contains(".")){
                    if (getText.length() >= 10){

                    } else {
                        getText += s;
                    }
                } else {
                    if (getText.length() >= 9){

                    } else {
                        getText += s;
                    }
                }
            }

            isCounted = false;

        } else {

            getText = s;
            isCounted = false;

        }


        return getText;
    }

    private void tan(){
        String s= etInput.getText().toString();
        double d=Double.parseDouble(s);
        double tan=Math.tan((d/180)*Math.PI);
        getText=tan+"";
    }
    private void cos(){
        String s=etInput.getText().toString();
        double d=Double.parseDouble(s);
        double cos=Math.cos((d/180)*Math.PI);
        getText=cos+"";
    }
    private void sin(){
        String s=getText;
        double d=Double.parseDouble(s);
        double sin=Math.sin((d/180)*Math.PI);
        getText=sin+"";
    }
    private boolean judgeExpression() {

        getCondition();

        String tempstr2 = null;

        if ( startWithOperator|| noStartWithOperator || startWithSubtract) {

            if (getText.contains("+")) {
                /**
                 * 先获取第二个参数
                 */
                tempstr2 = getText.substring(getText.indexOf("+") + 1);
                /**
                 * 如果第二个参数为空，表达式不成立
                 */
                if (tempstr2.equals("")) {
                    return false;
                } else {
                    return true;
                }
            } else if (getText.contains("*")) {

                tempstr2 = getText.substring(getText.indexOf("*") + 1);

                if (tempstr2.equals("")) {
                    return false;
                } else {
                    return true;
                }

            } else if (getText.contains("/")) {

                tempstr2 = getText.substring(getText.indexOf("/") + 1);

                if (tempstr2.equals("")) {
                    return false;
                } else {
                    return true;
                }

            } else if (getText.contains("-")) {

                /**
                 * 这里是以最后一个 - 号为分隔去取出两个参数
                 * 进到这个方法，必须满足有运算公式
                 * 而又避免了第一个参数是负数的情况
                 */
                tempstr2 = getText.substring(getText.lastIndexOf("-") + 1);

                if (tempstr2.equals("")) {
                    return false;
                } else {
                    return true;
                }

            }
        }
        return false;
    }

    private void getCondition() {

        startWithOperator = getText.startsWith("-") && ( getText.contains("+") ||
                getText.contains("*") || getText.contains("/") );

        startWithSubtract = getText.startsWith("-") && ( getText.lastIndexOf("-") != 0 );

        noStartWithOperator = !getText.startsWith("-") && ( getText.contains("+") ||
                getText.contains("-") || getText.contains("*") || getText.contains("/"));
    }
}
