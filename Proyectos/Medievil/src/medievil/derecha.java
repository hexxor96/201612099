package medievil;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class derecha extends Thread {
    public int cantidad=0;
    public tablero tablero1 = null;
    public ImageIcon guerrero;
    
    public derecha(int cantidad, tablero tablero1){
        this.cantidad = cantidad;
        this.tablero1 = tablero1;
    }
 
    public void mover(int cantidad){
        
        ImageIcon guerrerotmp = new ImageIcon(getClass().getResource("/Imagenes/guerrero.png"));
        Image tg = guerrerotmp.getImage();
        Image g = tg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        guerrero = new ImageIcon(g);
        
        try {
            if(cantidad<=0){
                return;
            }
            
            tablero1.matriz_t[tablero1.pos_x][tablero1.pos_y].setIcon(guerrero);
            tablero1.matriz[tablero1.pos_x][tablero1.pos_y]=0;
            tablero1.repintar();
            tablero1.pos_x=tablero1.pos_x+1;
            tablero1.pos_y=tablero1.pos_y;
            tablero1.matriz[tablero1.pos_x][tablero1.pos_y]=1;
            tablero1.repintar();
            cantidad--;
            Thread.sleep(500);

            
            mover(cantidad);
        } catch (InterruptedException ex) {
            Logger.getLogger(derecha.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void run(){
        mover(cantidad);
    }
    
    
}