import javax.swing.*;

public class Fenetre extends JFrame {
    PLoading pLoad;
    public Fenetre(){
        pLoad= new PLoading();
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pLoad);
        this.setVisible(true);
    }

}