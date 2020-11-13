package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Iterator;
import java.util.Stack;

public class Kalkulator extends JFrame{
    JFrame f;
    static JLabel tf;
    static Boolean divisionByZero;

    public static void addComponentsToPane(Container pane) {

        JButton button;
        JButton b_numerical;
        JButton b_sign;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        divisionByZero=false;

        tf.setHorizontalAlignment(JLabel.RIGHT);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.ipady = 20;
        c.insets = new Insets(5,5,15,5);
        c.gridy = 0;
        c.gridwidth = 5;
        pane.add(tf, c);

        button = new JButton("Del");
        c.gridwidth = 1;
        c.ipady = 0;
        c.gridx = 0;
        c.insets = new Insets(5,5,5,5);
        c.gridy = 1;
        pane.add(button, c);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!divisionByZero){
                    String text = tf.getText();
                    if (text.length() > 1)
                        tf.setText(text.substring(0, text.length() - 1));
                    if (text.length() == 1)
                        tf.setText("0");
                }
            }
        });

        b_sign = new JButton("/");
        c.weightx = 0.5;
        c.gridx = 1;
        pane.add(b_sign, c);

        b_sign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    signButtonReaction(e);
            }
        });

        b_sign = new JButton("*");
        c.weightx = 0.5;
        c.gridx = 2;
        pane.add(b_sign, c);

        b_sign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    signButtonReaction(e);

            }
        });

        b_sign = new JButton("-");
        c.weightx = 0.5;
        c.gridx = 3;
        pane.add(b_sign, c);

        b_sign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signButtonReaction(e);
            }
        });

        button = new JButton("C");
        c.weightx = 0.5;
        c.insets = new Insets(5,10,5,5);
        c.gridx = 4;
        pane.add(button, c);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            tf.setText("0");
            divisionByZero=false;
            }
        });

        button = new JButton("AC");
        c.weightx = 0.5;
        c.gridx = 4;
        c.gridy = 2;
        pane.add(button, c);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!divisionByZero){
                    String text = tf.getText();
                    int max = findLastSign(text);
                    if (max !=0)
                        tf.setText(text.substring(0, max+1));
                    else
                        tf.setText("0");
                }
            }
        });

        button = new JButton("(");
        c.weightx = 0.5;
        c.gridx = 4;
        c.gridy = 3;
        pane.add(button, c);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!divisionByZero){
                     JButton b = (JButton) e.getSource();
                     String text = tf.getText();
                     String b_text = b.getText();
                     char lastChar = text.charAt(text.length() - 1);
                     if (lastChar =='+' || lastChar=='-' || lastChar=='/' || lastChar=='*')
                         tf.setText(text + b_text);
                }
            }
        });

        button = new JButton(")");
        c.weightx = 0.5;
        c.gridx = 4;
        c.gridy = 4;
        pane.add(button, c);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!divisionByZero){
                    JButton b = (JButton) e.getSource();
                    String text = tf.getText();
                    String b_text = b.getText();
                    long count1 = text.chars().filter(ch -> ch == '(').count();
                    long count2 = text.chars().filter(ch -> ch == ')').count();
                    char lastChar = text.charAt(text.length() - 1);
                    if (lastChar !='+' && lastChar!='-' && lastChar!='/' && lastChar!='*'&& lastChar!='(' && count2<count1)
                        tf.setText(text + b_text);
                }
            }
        });

        button = new JButton("+/-");
        c.weightx = 0.5;
        c.gridx = 4;
        c.gridy = 5;
        pane.add(button, c);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!divisionByZero){
                    JButton b = (JButton) e.getSource();
                    String text = tf.getText();
                    int lastSign = findLastSignExtra(text);
                    if (lastSign == -1)
                        tf.setText('-' + text);
                    else if (text.charAt(lastSign)=='+')
                        tf.setText(text.substring(0,lastSign) + '-' + text.substring(lastSign+1));
                    else if (text.charAt(lastSign)=='-' && lastSign!=0 && text.charAt(lastSign-1)!='(')
                        tf.setText(text.substring(0,lastSign) + '+' + text.substring(lastSign+1));
                    else if (text.charAt(lastSign)=='-' && lastSign==0 || text.charAt(lastSign-1)=='(')
                        tf.setText(text.substring(0,lastSign) + text.substring(lastSign+1));
                    else if (text.charAt(lastSign)=='*')
                        tf.setText(text.substring(0,lastSign) + "*(-" + text.substring(lastSign+1));
                    else if (text.charAt(lastSign)=='/')
                        tf.setText(text.substring(0,lastSign) + "/(-" + text.substring(lastSign+1));
                    else if (text.charAt(lastSign)=='(')
                        tf.setText(text.substring(0,lastSign) + "(-" + text.substring(lastSign+1));
                }
            }
        });

        b_sign = new JButton("+");
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 3;
        c.gridheight = 2;
        c.gridy = 2;
        pane.add(b_sign, c);

        b_sign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signButtonReaction(e);
            }
        });

        button = new JButton("=");
        c.gridheight = 2;
        c.gridy = 4;
        pane.add(button, c);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!divisionByZero){
                    String text = tf.getText();
                    long count1 = text.chars().filter(ch -> ch == '(').count();
                    long count2 = text.chars().filter(ch -> ch == ')').count();
                    while(count1 >count2){
                        text = text + ')';
                        count2++;
                    }
                    text += ';';
                    String outcome = evaluate(text);
                    tf.setText(outcome);
                }

            }
        });

        b_numerical = new JButton("7");
        c.gridheight = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        pane.add(b_numerical, c);

        b_numerical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numericalButtonReaction(e);
            }
        });

        b_numerical = new JButton("8");
        c.gridx = 1;
        pane.add(b_numerical, c);

        b_numerical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numericalButtonReaction(e);
            }
        });

        b_numerical = new JButton("9");
        c.gridx = 2;
        pane.add(b_numerical, c);

        b_numerical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numericalButtonReaction(e);
            }
        });

        b_numerical = new JButton("4");
        c.gridx = 0;
        c.gridy = 3;
        pane.add(b_numerical, c);

        b_numerical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numericalButtonReaction(e);
            }
        });

        b_numerical = new JButton("5");
        c.gridx = 1;
        pane.add(b_numerical, c);

        b_numerical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numericalButtonReaction(e);
            }
        });

        b_numerical = new JButton("6");
        c.gridx = 2;
        pane.add(b_numerical, c);

        b_numerical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numericalButtonReaction(e);
            }
        });

        b_numerical = new JButton("1");
        c.gridx = 0;
        c.gridy = 4;
        pane.add(b_numerical, c);

        b_numerical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numericalButtonReaction(e);
            }
        });

        b_numerical = new JButton("2");
        c.gridx = 1;
        pane.add(b_numerical, c);

        b_numerical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numericalButtonReaction(e);
            }
        });

        b_numerical = new JButton("3");
        c.gridx = 2;
        pane.add(b_numerical, c);

        b_numerical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numericalButtonReaction(e);
            }
        });

        b_numerical = new JButton("0");
        c.gridx = 0;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 5;
        pane.add(b_numerical, c);

        b_numerical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numericalButtonReaction(e);
            }
        });

        button = new JButton(",");
        c.gridx = 2;       //aligned with button 2
        c.gridwidth = 1;   //2 columns wide
        pane.add(button, c);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!divisionByZero){
                    String text = tf.getText();
                    String b_text = ".";
                    char lastChar = text.charAt(text.length() - 1);
                    int lastSign = findLastSign(text);
                    String temp_text;
                    if (lastSign!=text.length()-1 && lastChar!=')' && lastChar!='(' ){
                        if (lastSign !=-1)
                            temp_text = text.substring(lastSign+1);
                        else
                            temp_text=text;
                        if(temp_text.indexOf('.') == -1)
                            tf.setText(text + b_text);

                }
            }
            }
        });

    }

    public static void signButtonReaction(ActionEvent e){
        if(!divisionByZero){
            JButton b = (JButton) e.getSource();
            String text = tf.getText();
            String b_text = b.getText();
            char lastChar = text.charAt(text.length() - 1);
            if (lastChar == '+' || lastChar == '-' || lastChar == '/' || lastChar == '*')
                tf.setText(text.substring(0, text.length() - 1) + b_text);
            else
                tf.setText(text + b_text);
        }
    }

    public static void numericalButtonReaction(ActionEvent e){
        if(!divisionByZero){
            JButton b = (JButton) e.getSource();
            String text = tf.getText();
            String b_text = b.getText();
            if (text.charAt(text.length() - 1) != ')')
                tf.setText(text + b_text);
            if (text.charAt(text.length() - 1) == ')')
                tf.setText(text + '*' + b_text);
            if (text.charAt(0) == '0' && text.length() == 1)
                tf.setText(b_text);
        }
    }


    public static int findLastSign(String text){
        int max = text.lastIndexOf("+");
        if (text.lastIndexOf("-")>max)
            max = text.lastIndexOf("-");
        if (text.lastIndexOf("/")>max)
            max=text.lastIndexOf("/");
        if (text.lastIndexOf("*")>max)
            max=text.lastIndexOf("*");
        return max;
    }

    public static int findLastSignExtra(String text){
        int max = findLastSign(text);
        if (text.lastIndexOf("(")>max)
            max = text.lastIndexOf("(");
        if (text.lastIndexOf(")")>max)
            max = text.lastIndexOf(")");
        return max;
    }

    public static String evaluate(String input) {
        String result = "0";
        Stack <Double> numbers = new Stack();
        Stack <Character> signs = new Stack();
        Boolean activeMinus = false;
        int i = 0;
        if (input.charAt(0)=='-') {
            activeMinus = true;
            input = input.substring(1);
        }
        while (input.charAt(0)!=';'){
            if ( input.charAt(0)>='0' && input.charAt(0)<='9' ){
                int signIndex = findFirstSignExtra(input);
                if (activeMinus) {
                    numbers.push(Double.valueOf('-' + input.substring(0, signIndex)));
                    activeMinus=false;
                }
                else
                    numbers.push(Double.valueOf(input.substring(0,signIndex)));
                input = input.substring(signIndex);
            }

            if (input.charAt(0)=='('){
                signs.push('(');
                input = input.substring(1);
                if(input.charAt(0)=='-'){
                    activeMinus=true;
                    input = input.substring(1);
                }
            }

            if (input.charAt(0)=='*' || input.charAt(0)=='/'){
                if( !signs.empty() && signs.peek()=='*'){
                    double number2 = numbers.pop();
                    double number1 = numbers.pop();
                    numbers.push(number1*number2);
                    signs.pop();
                    signs.push(input.charAt(0));
                    input = input.substring(1);
                }
                else if ( !signs.empty()  && signs.peek()=='/'){
                    double number2 = numbers.pop();
                    double number1 = numbers.pop();
                    if (number2 ==0) {
                        divisionByZero=true;
                        return "No one should divide by 0";
                    }
                    numbers.push(number1/number2);
                    signs.pop();
                    signs.push(input.charAt(0));
                    input = input.substring(1);
                }

                else{
                    signs.push(input.charAt(0));
                    input = input.substring(1);
                }
            }

            if (input.charAt(0)=='+' || input.charAt(0)=='-'){
                if( !signs.empty() && signs.peek()=='*'){
                    double number2 = numbers.pop();
                    double number1 = numbers.pop();
                    numbers.push(number1*number2);
                    signs.pop();
                    signs.push(input.charAt(0));
                    input = input.substring(1);
                }
                else if ( !signs.empty()  && signs.peek()=='/'){
                    double number2 = numbers.pop();
                    double number1 = numbers.pop();
                    if (number2 ==0) {
                        divisionByZero=true;
                        return "No one should divide by 0";
                    }
                    numbers.push(number1/number2);
                    signs.pop();
                    signs.push(input.charAt(0));
                    input = input.substring(1);
                }

                else if ( !signs.empty()  && signs.peek()=='+'){
                    double number2 = numbers.pop();
                    double number1 = numbers.pop();
                    numbers.push(number1+number2);
                    signs.pop();
                    signs.push(input.charAt(0));
                    input = input.substring(1);
                }

                else if ( !signs.empty()  && signs.peek()=='-'){
                    double number2 = numbers.pop();
                    double number1 = numbers.pop();
                    numbers.push(number1-number2);
                    signs.pop();
                    signs.push(input.charAt(0));
                    input = input.substring(1);
                }

                else{
                    signs.push(input.charAt(0));
                    input = input.substring(1);
                }
            }

            if(input.charAt(0)==')'){
                input = input.substring(1);
                while( signs.peek()!='('){
                    if(signs.peek() == '*'){
                        double number2 = numbers.pop();
                        double number1 = numbers.pop();
                        numbers.push(number1*number2);
                        signs.pop();
                    }
                    if(signs.peek() == '/'){
                        double number2 = numbers.pop();
                        double number1 = numbers.pop();
                        if (number2 ==0) {
                            divisionByZero=true;
                            return "No one should divide by 0";
                        }
                        numbers.push(number1/number2);
                        signs.pop();
                    }
                    if(signs.peek() == '+'){
                        double number2 = numbers.pop();
                        double number1 = numbers.pop();
                        numbers.push(number1+number2);
                        signs.pop();
                    }
                    if(signs.peek() == '-'){
                        double number2 = numbers.pop();
                        double number1 = numbers.pop();
                        numbers.push(number1-number2);
                        signs.pop();
                    }
                }
                signs.pop();

            }

            if(input.charAt(0)==';'){
                while(!signs.empty()){
                    if(signs.peek() == '*'){
                        double number2 = numbers.pop();
                        double number1 = numbers.pop();
                        numbers.push(number1*number2);
                        signs.pop();
                        continue;
                    }
                    if(signs.peek() == '/'){
                        double number2 = numbers.pop();
                        double number1 = numbers.pop();
                        if (number2 ==0) {
                            divisionByZero=true;
                            return "No one should divide by 0";
                        }
                        numbers.push(number1/number2);
                        signs.pop();
                        continue;
                    }
                    if(signs.peek() == '+'){
                        double number2 = numbers.pop();
                        double number1 = numbers.pop();
                        numbers.push(number1+number2);
                        signs.pop();
                        continue;
                    }
                    if(signs.peek() == '-'){
                        double number2 = numbers.pop();
                        double number1 = numbers.pop();
                        numbers.push(number1-number2);
                        signs.pop();
                        continue;
                    }
                }
            }

        }


        return String.valueOf(numbers.peek());
    }

    public static int findFirstSignExtra(String text){
        int min = Integer.MAX_VALUE;
        if (text.indexOf("+")<min && text.indexOf("+") != -1)
            min = text.indexOf("+");
        if (text.indexOf("-")<min && text.indexOf("-") != -1)
            min = text.indexOf("-");
        if (text.indexOf("/")<min && text.indexOf("/") != -1)
            min=text.indexOf("/");
        if (text.indexOf("*")<min && text.indexOf("*") != -1)
            min=text.indexOf("*");
        if (text.indexOf("(")<min && text.indexOf("(") != -1)
            min = text.indexOf("(");
        if (text.indexOf(")")<min && text.indexOf(")") != -1)
            min = text.indexOf(")");
        if (text.indexOf(";")<min && text.indexOf(";") != -1)
            min = text.indexOf(";");
        if(min == Integer.MAX_VALUE)
            min=-1;
        return min;
    }


    Kalkulator(){
        f=new JFrame();
        tf =new JLabel("0");
        addComponentsToPane(f.getContentPane());


        f.setSize(300,300);//400 width and 500 height
        f.setVisible(true);//making the frame visible
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
