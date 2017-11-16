package chap14.ryan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class RyanQuizCardBuilder {
    private JFrame frame;
    private JTextArea question;
    private JTextArea answer;
    priavet ArrayList<QuizCard> cardList;

    public static void main(String[] args) {
        RyanQuizCardBuilder builder = new RyanQuizCardBuilder();
        builder.go();
    }

    public void go() {
        frame = new JFrame("Quiz Card Builder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
