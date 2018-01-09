package proyecto2;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Grafo extends JPanel {
    private Image grafo;
    
    public void paint(Graphics g){
        int alto = this.getSize().height, largo = this.getSize().width;
        
        if(this.grafo !=null){
        g.drawImage(this.grafo, 0,0, largo, alto, null);
        }
        
        super.paint(g);
    }
    
    public void setGrafo(String direccion){
        
        try {
            this.grafo = ImageIO.read(new File(direccion));
            this.setOpaque(false);
        }catch(IOException e){
        this.grafo = null;
        }
        repaint();
        repaint();
    }
    
    public Image getGrafo(Image grafo){
        return this.grafo;
    }
    
    public void setGrafo(){
        
        this.grafo = null;
        repaint();
        
        
    }    
    
    
}
