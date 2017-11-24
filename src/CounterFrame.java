import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CounterFrame extends JFrame implements ActionListener {
    //ǰ̨��ʾ��ر�������
    GridLayout GLayout = new GridLayout(3,3,5,10);
    JButton num1,num2,num3,num4,num5,num6,num7,num8,num9;
    JTextField show;
    JButton op1,op2,op3,op4,op5;

    //ջ���Ʊ��λ
    int flag=1;

    //������λ
    int reflag=0;

    //��ż�������
    int result=0;

    public CounterFrame()
    {
        //����չʾ��
        setLayout(new BorderLayout(10,10));
        JPanel cp = new JPanel();

        show = new JTextField(25);
        show.setEditable(false);
        show.setBackground(Color.white);



        cp.add(show);
        add("North",cp);

        //���ְ�ť
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

        //��������ť
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
        //����������
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

        //����������
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

        //�����������
        else
        {
            String Sresult=show.getText();

            //���ʽ���������һ��Ϊ������ı��ʽ����
            if('/'==Sresult.charAt(Sresult.length()-1)||'*'==Sresult.charAt(Sresult.length()-1)||'-'==Sresult.charAt(Sresult.length()-1)||'+'==Sresult.charAt(Sresult.length()-1))
                show.setText("result=���ʽ����");
            else
                show.setText("result="+GetResult(Sresult));
            reflag=1;
            flag=1;
        }
    }



    private double GetResult(String temp)
    {
        if(""==temp.trim()) return 0;

        //ʵ����������Ų������Ͳ�������ջ�����
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

                //������ѹ�����ջ
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

                //������ѹ�����ջ
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

        SNum.push(Double.parseDouble(Snum));  //�����ʽ���һ������ջ
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
 
