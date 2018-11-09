package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


public class Practice {
        

    static JFrame f = new JFrame ("Using Text Area");
    static JPanel MainPanel = new JPanel();
              
    static JPanel P1 = new JPanel();
    static JPanel P2 = new JPanel();
    static JPanel P3 = new JPanel();
    
    static JMenuBar mb = new JMenuBar();
    static JMenu men = new JMenu ("File");
    static JMenuItem item = new JMenuItem("Open");
    
    static JLabel lb = new JLabel ("Enter a Phrase: ");
    static JTextField tb = new JTextField(25);
    static JTextArea ta = new JTextArea(50, 35);
    static JButton bt = new JButton ("Click Me");
    
    
    public static void main(String[] args){
        item.addActionListener(new OpenFile());
        men.add(item);
        mb.add(men);
        
        f.setLocation(300, 400);
        bt.addActionListener(new AppendTota());
        
        f.setPreferredSize(new Dimension(500, 420));
        ta.setText("Here will be some phrases");
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        JScrollPane sc = new JScrollPane(ta);
        
        MainPanel.setPreferredSize(new Dimension(500, 320));
        MainPanel.setLayout(new FlowLayout());
        
        P1.setPreferredSize(new Dimension(500, 50));
        P1.setLayout(new FlowLayout());

        P2.setPreferredSize(new Dimension(500, 200));
        P2.setLayout(new GridLayout());
        
                
        P3.setPreferredSize(new Dimension(500, 50));
        P3.setLayout(new FlowLayout());

        
        P1.add(lb);
        P1.add(tb);
        
        P2.add(sc);
        
        P3.add(bt);
        
        MainPanel.add(P1);
        MainPanel.add(P2);
        MainPanel.add(P3);
        
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setJMenuBar(mb);
        f.pack();
        f.setResizable(true);
        f.setVisible(true);
    }
    public static class AppendTota implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            String texto = tb.getText();
            ta.append("\n"+texto);
        }
        
        
    }
    public static class OpenFile implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
           JFileChooser jfc = new JFileChooser (FileSystemView.getFileSystemView().getHomeDirectory()); 
           int returnValue = jfc.showSaveDialog(null);
           if (returnValue == JFileChooser.APPROVE_OPTION)
           {
               File selctedFile = jfc.getSelectedFile();
               try
               {
               FileReader reader = new FileReader (selctedFile.getAbsolutePath());
               BufferedReader br = new BufferedReader (reader);
               ta.read(br, null);
               br.close();
               ta.requestFocus();
               }
               catch(Exception e2){ System.out.println(e2);}
           }
        }
    }
}
    