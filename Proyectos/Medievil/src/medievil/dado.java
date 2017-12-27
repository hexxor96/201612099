package medievil;

import java.awt.Image;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class dado extends Thread{
    public Integer cambiod = ThreadLocalRandom.current().nextInt(1, 5 + 1);
    public JPanel fdado = null;    
    public JLabel tirar;
    public ImageIcon dado;
    boolean cambio = true;
    public int dado1 = 1;
    
    public dado(JLabel tirar){
        this.tirar = tirar;
    }
    
    public void settirar(JLabel tirar) {
        this.tirar = tirar;
    }
    public JLabel gettirar() {
        return tirar;
    }
    public void run(){
        try {
            while(cambio){
                if(dado1 == 1){
                    dado = new ImageIcon("/Imagenes/dado1.png"); 
                    Image td = dado.getImage();
                    Image d = td.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    dado = new ImageIcon(d);
                    tirar.setToolTipText("1");
                }
                if(dado1 == 2){
                    dado = new ImageIcon("/Imagenes/dado2.png"); 
                    Image td = dado.getImage();
                    Image d = td.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    dado = new ImageIcon(d);
                    tirar.setToolTipText("2");
                }
                if(dado1 == 3){
                    dado = new ImageIcon("/Imagenes/dado3.png"); 
                    Image td = dado.getImage();
                    Image d = td.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    dado = new ImageIcon(d);
                    tirar.setToolTipText("3");
                }
                if(dado1 == 4){
                    dado = new ImageIcon("/Imagenes/dado4.png"); 
                    Image td = dado.getImage();
                    Image d = td.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    dado = new ImageIcon(d);
                    tirar.setToolTipText("4");
                }
                if(dado1 == 5){
                    dado = new ImageIcon("/Imagenes/dado5.png"); 
                    Image td = dado.getImage();
                    Image d = td.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    dado = new ImageIcon(d);
                    tirar.setToolTipText("5");
                }
                if(dado1 == 6){
                    dado = new ImageIcon("/Imagenes/dado6.png"); 
                    Image td = dado.getImage();
                    Image d = td.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    dado = new ImageIcon(d);
                    tirar.setToolTipText("6");
                }
                tirar.setIcon(dado);
                dado1++;
                Thread.sleep(400);
                if(dado1 > cambiod){ 
                    cambio = false; 
                }
            }
            this.interrupt();
        }
        catch(Exception e){
        }
    }
    
}
