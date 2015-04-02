/**
* 
*/
package test1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

/**
* @author root
   * 
   */
//156161651651
public class JExplorer {

    public JExplorer() {
    }


    public static void main(String[] args) {
        // JFrame.setDefaultLookAndFeelDecorated(true);

        //System.out.print("132");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new UI(frame));
        frame.pack();
        
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int left = (screen.width - frame.getWidth()) / 2;
        int top = (screen.height - frame.getHeight()) / 2;

        frame.setLocation(left, top);
        frame.setVisible(true);
    }
}

class UI extends JPanel {
    // implements I_menuHandler{
    static final long serialVersionUID = 0l;
    static int LEFT_WIDTH = 200;
    static int RIGHT_WIDTH = 300;
    static int WINDOW_HEIGHT = 300;
    static int ABOVE_HEIGHT =  40;
    static int ABOVE_WIDTH =  160;
    
    JFrame frame = null;

    public UI(JFrame frame) {
        // EmptyBorder eb = new EmptyBorder(1,1,1,1);
        this.frame = frame;
        setPreferredSize(new Dimension(800, 630));
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        setLayout(new BorderLayout());

        FileList list = new FileList();
        FileTree tree = new FileTree(list);
        tree.setDoubleBuffered(true);
        list.setDoubleBuffered(true);

        JScrollPane treeView = new JScrollPane(tree);
        treeView.setPreferredSize(new Dimension(LEFT_WIDTH, WINDOW_HEIGHT));

        JScrollPane listView = new JScrollPane(list);
        listView.setPreferredSize(new Dimension(RIGHT_WIDTH, WINDOW_HEIGHT));

        JSplitPane pane1 =    new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeView,    listView);


        pane1.setDividerLocation(300);
        //pane1.setDividerSize(4);

        JButton jbtChange = new JButton("转化成HTML文档");
        JPanel panel2 = new JPanel();
        //jbtChange.setPreferredSize(new Dimension(ABOVE_WIDTH,ABOVE_HEIGHT));
        panel2.add(jbtChange);
        panel2.setPreferredSize(new Dimension(ABOVE_WIDTH,ABOVE_HEIGHT));
        JSplitPane pane2 =    new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel2,    pane1);
        pane2.setDividerLocation(40);

        add(pane2);



         ButtonListener listener = new ButtonListener();
        jbtChange.addActionListener(listener);



    }
    class ButtonListener implements ActionListener{
        public  void actionPerformed(ActionEvent e){
            System.out.println("123");
            //int[] a = list.getSelectedIndices();
            //for(int o : a){System.out.print(o);}
           // System.out.print("\n");
        }
    }
}