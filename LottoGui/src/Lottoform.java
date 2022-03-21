import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.concurrent.Flow;
import java.awt.FlowLayout;

public class Lottoform extends JFrame{

    public JPanel mainPnl = new JPanel();
    public JPanel northPnl = new JPanel();
    public JPanel eastPnl = new JPanel();
    public JPanel westPnl = new JPanel();
    public JPanel southPnl = new JPanel();
    public JPanel centerPnl = new JPanel();
    public JPanel drawPnl = new JPanel();
    public JPanel buttonPnl = new JPanel();
    public JLabel drawLbl = new JLabel("Számok: ");
    public JLabel resultLbl = new JLabel("Találatok: ");
    public JButton exitBtn = new JButton("Kilépés");
    public JButton drwaBtn = new JButton("Húzás");
    

    public Lottoform(){
        initComponents();
        this.setVisible(true);
    }
    private void initComponents(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,400);
        this.setLayout(new GridLayout(1,1));
        mainPnl.setLayout(new BorderLayout());
        this.add(mainPnl);

        northPnl.setLayout(new FlowLayout(FlowLayout.CENTER));
        northPnl.add(resultLbl);
        mainPnl.add(northPnl,BorderLayout.NORTH);

        eastPnl.setSize(10,400);
        mainPnl.add(eastPnl,BorderLayout.EAST);

        southPnl.setLayout(new GridLayout(1,2));
        drawPnl.setLayout(new FlowLayout(FlowLayout.CENTER));
        drawPnl.add(drawLbl);
        buttonPnl.setLayout(new FlowLayout(FlowLayout.RIGHT));
        drwaBtn.setEnabled(false);
        buttonPnl.add(drwaBtn);
        buttonPnl.add(exitBtn);
        southPnl.add(drawPnl);
        southPnl.add(buttonPnl);
        mainPnl.add(southPnl,BorderLayout.SOUTH);

        westPnl.setSize(10,400);
        mainPnl.add(westPnl);

        centerPnl.setLayout(new GridLayout(10,9));
        mainPnl.add(centerPnl,BorderLayout.CENTER);
    }
}

