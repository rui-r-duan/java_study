// This file demonstrates a different solution to event handling from the inner
// class solution.
//
// While the inner class solution receives all the events from the components
// by the outer class (usually the main class) which "holds" (actually doesn't
// hold, just intimate friends) the instances of the inner classes, this
// solution dispatches events to the components and let the components handle
// those events.
//
// Pros:
//
// 1. The subclasses of the widgets can be reusable, which means other
// program might instantiate them.  If we find the reactions of the widgets to
// the events are likely to be reused, we can choose this solution.
//
// Cons:
//
// 1. It is tedious to subclass each standard widget only to add an event
// handler, sometimes we have to provide the constructor which is not necessary
// in inner class solution.
//
// 2. If the subclass event handler has to access the main classes' private
// instance variables, it would be difficult to do it.

package chap12.ryan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyDrawPanel extends JPanel implements ActionListener {

    public void paintComponent(Graphics g) {    
        g.fillRect(0,0,this.getWidth(), this.getHeight());

        // make random colors to fill with
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(70,70,100,100);
    }

    public void actionPerformed(ActionEvent event) {
        repaint();
    }
}

class MyLabel extends JLabel implements ActionListener {

    public MyLabel(String label) {
        super(label);
    }

    public void actionPerformed(ActionEvent event) {
        setText("Ouch!");
    }
}

public class SeparateListener {
    public static void main(String[] args) {
        SeparateListener gui = new SeparateListener();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        JButton colorButton = new JButton("Change Circle");
        MyLabel label = new MyLabel("I'm a label");
        MyDrawPanel drawPanel = new MyDrawPanel();

        labelButton.addActionListener(label);
        colorButton.addActionListener(drawPanel);

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(420, 300);
        frame.setVisible(true);
    }
}
