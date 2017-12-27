package medievil;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class izquierda extends Thread {
    public int cantidad=0;
    public tablero tablero2 = null;
    public ImageIcon guerrero;
    
    public izquierda(int cantidad, tablero tablero2){
        this.cantidad = cantidad;
        this.tablero2 = tablero2;
    }
 
    public void mover1(int cantidad){
        
        ImageIcon guerrerotmp = new ImageIcon(getClass().getResource("/Imagenes/guerrero.png"));
        Image tg = guerrerotmp.getImage();
        Image g = tg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        guerrero = new ImageIcon(g);
        
        try {
            if(cantidad<=0){
                return;
            }
            
            tablero2.matriz_t[tablero2.pos_x][tablero2.pos_y].setIcon(guerrero);
            tablero2.matriz[tablero2.pos_x][tablero2.pos_y]=0;
            tablero2.repintar();
            tablero2.pos_x=tablero2.pos_x-1;
            tablero2.pos_y=tablero2.pos_y;
            tablero2.matriz[tablero2.pos_x][tablero2.pos_y]=1;
            tablero2.repintar();
            cantidad--;
            Thread.sleep(500);

            
            mover1(cantidad);
        } catch (InterruptedException ex) {
            Logger.getLogger(derecha.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void run(){
        mover1(cantidad);
    }
    
    
}