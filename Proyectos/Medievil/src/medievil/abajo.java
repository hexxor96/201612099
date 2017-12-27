package medievil;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class abajo extends Thread {
    public int cantidad=0;
    public tablero tablero4 = null;
    public ImageIcon guerrero;
    
    public abajo(int cantidad, tablero tablero4){
        this.cantidad = cantidad;
        this.tablero4 = tablero4;
    }
 
    public void mover3(int cantidad){
        
        ImageIcon guerrerotmp = new ImageIcon(getClass().getResource("/Imagenes/guerrero.png"));
        Image tg = guerrerotmp.getImage();
        Image g = tg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        guerrero = new ImageIcon(g);
        
        try {
            if(cantidad<=0){
                return;
            }
            
            tablero4.matriz_t[tablero4.pos_x][tablero4.pos_y].setIcon(guerrero);
            tablero4.matriz[tablero4.pos_x][tablero4.pos_y]=0;
            tablero4.repintar();
            tablero4.pos_x=tablero4.pos_x;
            tablero4.pos_y=tablero4.pos_y+1;
            tablero4.matriz[tablero4.pos_x][tablero4.pos_y]=1;
            tablero4.repintar();
            cantidad--;
            Thread.sleep(500);

            
            mover3(cantidad);
        } catch (InterruptedException ex) {
            Logger.getLogger(derecha.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void run(){
        mover3(cantidad);
    }
    
    
}