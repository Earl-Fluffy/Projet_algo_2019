import javax.swing.*;

public class Fenetre extends JFrame {
    PLoading pLoad;
    PCity pCity;
    public Fenetre(){
        pLoad= new PLoading();
        pCity= new PCity();
        this.setSize(800,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pCity);
        this.setVisible(true);
    }

}
