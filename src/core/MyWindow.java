package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame implements ActionListener{

    private JButton button;
    private volatile int counter;
    private Object object ;

    MyWindow(String title){
        super(title);
        setUpFrameParameters();
        instantiateWidget();
        bindingWidgetListener();
        bindingWidgetToFrame();
        System.out.println(Thread.currentThread().getName());
    }

    private void bindingWidgetToFrame() {
        this.getContentPane().add(button);
    }

    private void bindingWidgetListener() {
        button.addActionListener(this);
    }

    private void instantiateWidget() {
        button = new JButton("New");
        counter = 1;
    }

    private void setUpFrameParameters() {
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        synchronized (object){
            counter++;
        }

        new MyWindow("Hello : "+ counter);
      /*  (*//*new Thread(a)).start();*/
    }

    /*@Override
    public void run() {
        while (true){
            System.out.println();
        }
    }*/
}
