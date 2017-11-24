
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Counter {

    public static void main(String[] args) {
        CounterFrame window = new CounterFrame();
        window.setTitle("CardWindow Application");
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(300,250);
        window.setResizable(false);
        window.setVisible(true);
    }
}