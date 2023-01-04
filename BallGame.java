package Jgame;

import javax.swing.*;
import java.awt.*;

public class BallGame extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("Images/ball.png");       //导入球图片
    Image desk = Toolkit.getDefaultToolkit().getImage("Images/desk.jpg");       //导入桌台图片

    double x = 0;       //使得球到位置变化
    double y = 100;     //同上
    boolean con = true;     //使得小球遇到边缘回弹的开关

    public void paint(Graphics g){
        System.out.println("窗口调用一次");       //每次使用都会输出
        g.drawImage(desk,0,0,null);     //桌面在框中到位置
        g.drawImage(ball,(int)x,(int)y,null);       //同上
        if(con){
            x=x+5;      //使得球向右移动
        }else{
            x=x-5;      //向左
        }
        if(x>786){
            con=false;          //遇到边缘改变数值变方向
        }else if(x<2){
            con=true;           //同上
        }


    }

    void IaunchFrame(){
        setSize(856,501);       //框的大小
        setLocation(100,100);       //框的位置
        setVisible(true);       //弹窗开关
        while(true){
            repaint();
            try {
                Thread.sleep(200);       //每秒绘制次数25 1000/40=25
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public static void main(String[] args){
        System.out.println("My game is coming");
        BallGame game = new BallGame();
        game.IaunchFrame();             //调用方法

    }
}
