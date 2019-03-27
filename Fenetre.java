import javax.swing.*;

public class Fenetre extends JFrame {
    PLoading pLoad;
    PCity pCity;
    PEntree pEntree;
    public Fenetre(){
        pLoad= new PLoading();
        pCity= new PCity();
        pEntree= new PEntree();
        this.setSize(800,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pEntree);
        this.setVisible(true);
        this.setResizable(false);
    }

}
