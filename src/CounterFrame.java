import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CounterFrame extends JFrame implements ActionListener {
    //前台显示相关变量声明
    GridLayout GLayout = new GridLayout(3,3,5,10);
    JButton num1,num2,num3,num4,num5,num6,num7,num8,num9;
    JTextField show;
    JButton op1,op2,op3,op4,op5;

    //栈控制标记位
    int flag=1;

    //结果标记位
    int reflag=0;

    //存放计算机结果
    int result=0;

    public CounterFrame()
    {
        //界面展示区
        setLayout(new BorderLayout(10,10));
        JPanel cp = new JPanel();

        show = new JTextField(25);
        show.setEditable(false);
        show.setBackground(Color.white);



        cp.add(show);
        add("North",cp);

        //数字按钮
        JPanel p1 = new JPanel();
        p1.setLayout(GLayout);

        num1 = new JButton("  1  ");
        num2 = new JButton("  2  ");
        num3 = new JButton("  3  ");
        num1.addActionListener(this);
        num2.addActionListener(this);
        num3.addActionListener(this);
        num4 = new JButton("4");
        num5 = new JButton("5");
        num6 = new JButton("6");
        num4.addActionListener(this);
        num5.addActionListener(this);
        num6.addActionListener(this);
        num7 = new JButton("7");
        num8 = new JButton("8");
        num9 = new JButton("9");
        num7.addActionListener(this);
        num8.addActionListener(this);
        num9.addActionListener(this);

        p1.add(num1);
        p1.add(num2);
        p1.add(num3);
        p1.add(num4);
        p1.add(num5);
        p1.add(num6);
        p1.add(num7);
        p1.add(num8);
        p1.add(num9);
        add("Center",p1);

        //操作符按钮
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(5,1,5,5));
        op1 = new JButton("  +  ");
        op2 = new JButton("  -  ");
        op3 = new JButton("  *  ");
        op4 = new JButton("  /  ");
        op5 = new JButton("  =  ");
        op1.addActionListener(this);
        op2.addActionListener(this);
        op3.addActionListener(this);
        op4.addActionListener(this);
        op5.addActionListener(this);
        p2.add(op1);
        p2.add(op2);
        p2.add(op3);
        p2.add(op4);
        p2.add(op5);
        add("East",p2);

    }

    public void actionPerformed(ActionEvent e)
    {
        //操作数处理
        if(1==reflag&&(JButton)e.getSource()!=op5)
            show.setText("");
        if((JButton)e.getSource()==num1)
        {
            show.setText(show.getText()+"1");
            flag=0;
            reflag=0;
        }
        else if((JButton)e.getSource()==num2)
        {
            show.setText(show.getText()+"2");
            flag=0;
            reflag=0;
        }
        else if((JButton)e.getSource()==num3)
        {
            show.setText(show.getText()+"3");
            flag=0;
            reflag=0;
        }
        else if((JButton)e.getSource()==num4)
        {
            show.setText(show.getText()+"4");
            flag=0;
            reflag=0;
        }
        else if((JButton)e.getSource()==num5)
        {
            show.setText(show.getText()+"5");
            flag=0;
            reflag=0;
        }
        else if((JButton)e.getSource()==num6)
        {
            show.setText(show.getText()+"6");
            flag=0;
            reflag=0;
        }
        else if((JButton)e.getSource()==num7)
        {
            show.setText(show.getText()+"7");
            flag=0;
            reflag=0;
        }
        else if((JButton)e.getSource()==num8)
        {
            show.setText(show.getText()+"8");
            flag=0;
            reflag=0;
        }
        else if((JButton)e.getSource()==num9)
        {
            show.setText(show.getText()+"9");
            flag=0;
            reflag=0;
        }

        //操作符处理
        else if((JButton)e.getSource()==op1)
        {
            if(1==flag) return;
            show.setText(show.getText()+"+");
            flag=1;
            reflag=0;
        }
        else if((JButton)e.getSource()==op2)
        {
            if(1==flag) return;
            show.setText(show.getText()+"-");
            flag=1;
            reflag=0;
        }
        else if((JButton)e.getSource()==op3)
        {
            if(1==flag) return;
            show.setText(show.getText()+"*");
            flag=1;
            reflag=0;
        }
        else if((JButton)e.getSource()==op4)
        {
            if(1==flag) return;
            show.setText(show.getText()+"/");
            flag=1;
            reflag=0;
        }

        //计算结果并输出
        else
        {
            String Sresult=show.getText();

            //表达式错误处理（最后一个为运算符的表达式错误）
            if('/'==Sresult.charAt(Sresult.length()-1)||'*'==Sresult.charAt(Sresult.length()-1)||'-'==Sresult.charAt(Sresult.length()-1)||'+'==Sresult.charAt(Sresult.length()-1))
                show.setText("result=表达式错误");
            else
                show.setText("result="+GetResult(Sresult));
            reflag=1;
            flag=1;
        }
    }



    private double GetResult(String temp)
    {
        if(""==temp.trim()) return 0;

        //实例化用来存放操作数和操作符的栈并清空
        Stack<Object> SNum = new Stack();
        Stack<Object> SOp = new Stack();
        SNum.removeAllElements();
        SOp.removeAllElements();

        String Snum="";
        double Inum=0;

        for(int i=0;i<temp.length();i++)
        {
            char c = temp.charAt(i);
            if(c=='+'||c=='-')
            {
                Inum=Double.parseDouble(Snum);
                if(SOp.empty())
                    SNum.push(Inum);
                else
                {
                    switch((char)SOp.peek())
                    {
                        case '+':
                            SNum.push((double)SNum.pop()+Inum);
                            SOp.pop();
                            break;
                        case '-':
                            SNum.push((double)SNum.pop()-Inum);
                            SOp.pop();
                            break;
                        case '*':
                            SNum.push((double)SNum.pop()*Inum);
                            SOp.pop();
                            break;
                        case '/':
                            SNum.push((double)SNum.pop()/Inum);
                            SOp.pop();
                            break;
                    }
                }

                //将符号压入符号栈
                switch (c)
                { case '+':
                    SOp.push('+');
                    break;
                    case '-':
                        SOp.push('-');
                        break;
                }
                Snum="";
            }
            else if(c=='*'||c=='/')
            {
                Inum=Double.parseDouble(Snum);
                if(SOp.empty())
                    SNum.push(Inum);
                else
                {
                    switch((char)SOp.peek())
                    { case '*':
                        SNum.push((double)SNum.pop()*Inum);
                        SOp.pop();
                        break;
                        case '/':
                            SNum.push((double)SNum.pop()/Inum);
                            SOp.pop();
                            break;
                        default:
                            SNum.push(Inum);
                            break;
                    }
                }

                //将符号压入符号栈
                switch (c)
                {
                    case '*':
                        SOp.push('*');
                        break;
                    case '/':
                        SOp.push('/');
                        break;
                }
                Snum="";
            }
            else
            {
                Snum=Snum+c;
            }
        }

        SNum.push(Double.parseDouble(Snum));  //将表达式最后一个数入栈
        double a,b;
        while(!SOp.empty())
        {
            a=(double)SNum.pop();
            b=(double)SNum.pop();

            switch((char)SOp.pop())
            {
                case '+':
                    SNum.push(b+a);
                    break;
                case '-':
                    SNum.push(b-a);
                    break;
                case '*':
                    SNum.push(b*a);
                    break;
                case '/':
                    SNum.push(b/a);
                    break;
            }
        }

        return (double)SNum.pop();
    }
}
 
