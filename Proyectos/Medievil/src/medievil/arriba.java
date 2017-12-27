package medievil;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class arriba extends Thread {
    public int cantidad=0;
    public tablero tablero3 = null;
    public ImageIcon guerrero;
    
    public arriba(int cantidad, tablero tablero3){
        this.cantidad = cantidad;
        this.tablero3 = tablero3;
    }
 
    public void mover2(int cantidad){
        
        ImageIcon guerrerotmp = new ImageIcon(getClass().getResource("/Imagenes/guerrero.png"));
        Image tg = guerrerotmp.getImage();
        Image g = tg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        guerrero = new ImageIcon(g);
        
        try {
            if(cantidad<=0){
                return;
            }
            
            tablero3.matriz_t[tablero3.pos_x][tablero3.pos_y].setIcon(guerrero);
            tablero3.matriz[tablero3.pos_x][tablero3.pos_y]=0;
            tablero3.repintar();
            tablero3.pos_x=tablero3.pos_x;
            tablero3.pos_y=tablero3.pos_y-1;
            tablero3.matriz[tablero3.pos_x][tablero3.pos_y]=1;
            tablero3.repintar();
            cantidad--;
            Thread.sleep(500);

            
            mover2(cantidad);
        } catch (InterruptedException ex) {
            Logger.getLogger(derecha.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void run(){
        mover2(cantidad);
    }
    
    
}