package chap12.ryan;

import javax.swing.*;
import java.awt.*;

// class MyDrawPanel extends JPanel {
//     public void paintComponent(Graphics g) {
//         g.setColor(Color.orange);
//         g.fillRect(0, 0, 100, 100);

//         g.setColor(Color.blue);
//         g.fillRect(80, 30, this.getWidth() - 80, this.getHeight());
//         int red = (int)(Math.random() * 255);
//         int green = (int)(Math.random() * 255);
//         int blue = (int)(Math.random() * 255);
//         Color randomColor = new Color(red, green, blue);
//         g.setColor(randomColor);
//         g.fillOval(10, 70, 100, 100);

//         Image image = new ImageIcon("c:/Users/Ryan/Pictures/Google+ Auto Backup/2014-08-22/segway1.JPG").getImage();
//         g.drawImage(image, 100, 100, this);
//     }
// }

public class DrawPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        chap12.MyDrawPanel panel = new chap12.MyDrawPanel();
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
