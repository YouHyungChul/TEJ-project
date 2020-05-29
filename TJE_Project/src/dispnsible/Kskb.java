package dispnsible;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.Scrollable;
import javax.swing.UIManager;

public class Kskb {
	boolean flag = true;
    private int row;
    int x;

    class SomethingPanel extends JPanel implements Scrollable {

        public SomethingPanel(LayoutManager manager){
            super(manager);
        }

        @Override
        public Dimension getPreferredScrollableViewportSize(){
            return getPreferredSize();
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction){
            return 1;
        }

        @Override
        public boolean getScrollableTracksViewportHeight(){
            return false;
        }

        @Override
        public boolean getScrollableTracksViewportWidth(){
            return true;
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction){
            return 1;
        }
    }

    public Kskb(){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setPreferredSize(new Dimension(800, 600));
//      final JPanel content = new JPanel(new GridBagLayout());
        final SomethingPanel content = new SomethingPanel(new GridBagLayout());

//      final JPanel empty = new JPanel();
//      empty.setPreferredSize(new Dimension(0, 0));
//      GridBagConstraints gbc = new GridBagConstraints();
//      content.add(empty, gbc);
        content.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "��");
        content.getActionMap().put("��", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                JPanel p = new JPanel(new BorderLayout());
                p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                p.setBackground(Color.YELLOW);
                //p.setBackground(Color.GRAY);

                GridBagConstraints gbc = new GridBagConstraints();
                if(flag) {
                    gbc.insets = new Insets(10, 0, 10, 100);
                }else {
                    gbc.insets = new Insets(10, 100, 10, 0);
                }
                flag = !flag;
                gbc.weightx = 1;
                //gbc.gridx = 20;
                gbc.gridy = x++;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                
                

//              content.remove(empty);
//              gbc.gridy = row;
//              gbc.weighty = 1.0;
//              content.add(empty, gbc);

                JTextArea text = new JTextArea(
                        Math.random() > 0.5 ? 
                        "��������������������������������������������" : 
                        "����������������������������������������������");
                text.setLineWrap(true);
                text.setBackground(Color.YELLOW);
                p.add(text);
                content.add(p, gbc);
                content.revalidate();
                text.setCaretPosition(text.getDocument().getLength());
            }
        });
        JScrollPane scrollPane = new JScrollPane(content);
        scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());


        f.pack();
        f.setLocationRelativeTo(null);
        f.add(scrollPane);
        f.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new Kskb();
    }
}

 