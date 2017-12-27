package medievil;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class tablero{
    public int tamano = 0;
    public JPanel fondo = null;
    public JPanel fvida = null;
    public JPanel fvida1 = null;
    public int pos_x = 0;
    public int pos_y = 0;
    public int matriz [][];
    public JLabel matriz_t [][];
    public ImageIcon guerrero;
    public ImageIcon princesa;
    public ImageIcon mago;
    public ImageIcon bomba;
    public ImageIcon vida;
    public ImageIcon guerrero02;
    public ImageIcon princesa02;
    public ImageIcon mago02;
    public int casilla = 0;
    public tablero(int tamano, JPanel fondo){
        this.tamano = tamano;
        this.fondo = fondo;
        this.fvida = fvida;
        this.fvida1 = fvida1;
        llenar(tamano);
    }
    
         public void llenar(int tamano){
        casilla=800/tamano;
        matriz=new int[18][18];
        matriz_t=new JLabel[18][18];
        
        
        for(int i=1;i<tamano;i++){
          for(int j=0;j<tamano;j++){
            matriz[i][j]=0;
          }
        }           
        ImageIcon guerrerotmp = new ImageIcon(getClass().getResource("/Imagenes/guerrero.png"));
        Image tg = guerrerotmp.getImage();
        Image g = tg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        guerrero = new ImageIcon(g);
        
        ImageIcon guerrero2tmp = new ImageIcon(getClass().getResource("/Imagenes/guerrero2.png"));
        Image tg2 = guerrero2tmp.getImage();
        Image g2 = tg2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        guerrero02 =new ImageIcon(g2);
        
        ImageIcon princesatmp = new ImageIcon(getClass().getResource("/Imagenes/princesa.png"));
        Image tp = princesatmp.getImage();
        Image p = tp.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        princesa=new ImageIcon(p);
        
        ImageIcon princesa2tmp = new ImageIcon(getClass().getResource("/Imagenes/princesa2.png"));
        Image tp2 = princesa2tmp.getImage();
        Image p2 = tp2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        princesa02=new ImageIcon(p2);
        
        ImageIcon magotmp = new ImageIcon(getClass().getResource("/Imagenes/mago.png"));
        Image tm = magotmp.getImage();
        Image m = tm.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        mago=new ImageIcon(m);
        
        ImageIcon mago2tmp = new ImageIcon(getClass().getResource("/Imagenes/mago2.png"));
        Image tm2 = mago2tmp.getImage();
        Image m2 = tm2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        mago02=new ImageIcon(m2);
        
        ImageIcon bombatmp = new ImageIcon(getClass().getResource("/Imagenes/bomba.png"));
        Image tb = bombatmp.getImage();
        Image b = tb.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        bomba = new ImageIcon(b);
        
        ImageIcon vidatmp = new ImageIcon(getClass().getResource("/Imagenes/vida.png"));
        Image tv = vidatmp.getImage();
        Image v = tv.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        vida = new ImageIcon(v);
        
        
        repintar();
        
        }        
        
    public void repintar(){
        ImageIcon objetos[] = {guerrero, princesa, mago, bomba, vida, guerrero02, princesa02, mago02 };
        int numero = 0;
        int guerrero1 = 0;
        int princesa1 = 0;
        int mago1 = 0;
        int guerrero2 = 0;
        int princesa2 = 0;
        int mago2 = 0;
        int bomba1 = 0;
        int vida1 = 0;
        int x, y;
            for(int i=0;i<tamano;i++){
                for(int j=0;j<tamano;j++){
                JLabel tablero;
                if(matriz[i][j]==0){
                    tablero=new JLabel();
                    x = (i*40)+1;
                    y = (j*40)+1;
                    tablero.setOpaque(false);
                    tablero.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
                    tablero.setBounds(x, y, 40, 40);
                    matriz_t[i][j]=tablero;
                    fondo.add(matriz_t[i][j], BorderLayout.CENTER);
                    fondo.repaint();
                }
                else {
                }
                //bombas
                numero = (int) (Math.random() * 2);
                if (numero == 1 | numero == 7) {
                    numero = (int) ((Math.random() * 8)-0.5);
                    if (numero == 0 && bomba1 != (tamano*tamano)/10){
                        tablero = new JLabel(bomba);
                        x = (i*40)+1;
                        y = (j*40)+1;
                        tablero.setOpaque(false);
                        tablero.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
                        tablero.setBounds(x, y, 40, 40);
                        matriz_t[i][j]=tablero;
                        fondo.add(matriz_t[i][j], BorderLayout.CENTER);
                        fondo.repaint();
                        bomba1 ++;
                    }
                //vidas
                    if (numero == 1 && vida1 != (tamano*tamano*5)/100){
                        tablero = new JLabel(vida);
                        x = (i*40)+1;
                        y = (j*40)+1;
                        tablero.setOpaque(false);
                        tablero.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
                        tablero.setBounds(x, y, 40, 40);
                        matriz_t[i][j]=tablero;
                        fondo.add(matriz_t[i][j], BorderLayout.CENTER);
                        fondo.repaint();
                        vida1 ++;
                    }
                    //guerrrero
                    if (numero == 2 && guerrero1 != 1){
                        tablero = new JLabel(guerrero);
                        x = (i*40)+1;
                        y = (j*40)+1;
                        tablero.setOpaque(false);
                        tablero.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
                        tablero.setBounds(x, y, 40, 40);
                        matriz_t[i][j]=tablero;
                        fondo.add(matriz_t[i][j], BorderLayout.CENTER);
                        fondo.repaint();
                        guerrero1 ++;
                    }
                    //princesa
                    if (numero == 3 && princesa1 != 1){
                        tablero = new JLabel(princesa);
                        x = (i*40)+1;
                        y = (j*40)+1;
                        tablero.setOpaque(false);
                        tablero.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
                        tablero.setBounds(x, y, 40, 40);
                        matriz_t[i][j]=tablero;
                        fondo.add(matriz_t[i][j], BorderLayout.CENTER);
                        fondo.repaint();
                        princesa1++;
                    }
                    //mago
                    if (numero == 4 && mago1 != 1){
                        tablero = new JLabel(mago);
                        x = (i*40)+1;
                        y = (j*40)+1;
                        tablero.setOpaque(false);
                        tablero.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
                        tablero.setBounds(x, y, 40, 40);
                        matriz_t[i][j]=tablero;
                        fondo.add(matriz_t[i][j], BorderLayout.CENTER);
                        fondo.repaint();
                        mago1++;
                    }
                    //guerrero2
                    if (numero == 5 && guerrero2 != 1){
                        tablero = new JLabel(guerrero02);
                        x = (i*40)+1;
                        y = (j*40)+1;
                        tablero.setOpaque(false);
                        tablero.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
                        tablero.setBounds(x, y, 40, 40);
                        matriz_t[i][j]=tablero;
                        fondo.add(matriz_t[i][j], BorderLayout.CENTER);
                        fondo.repaint();
                        guerrero2 ++;
                    }
                    //princesa2
                    if (numero == 6 && princesa2 != 1){
                        tablero = new JLabel(princesa02);
                        x = (i*40)+1;
                        y = (j*40)+1;
                        tablero.setOpaque(false);
                        tablero.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
                        tablero.setBounds(x, y, 40, 40);
                        matriz_t[i][j]=tablero;
                        fondo.add(matriz_t[i][j], BorderLayout.CENTER);
                        fondo.repaint();
                        princesa2++;
                    }
                    //mago2
                    if (numero == 7 && mago2 != 1){
                        tablero = new JLabel(mago02);
                        x = (i*40)+1;
                        y = (j*40)+1;
                        tablero.setOpaque(false);
                        tablero.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
                        tablero.setBounds(x, y, 40, 40);
                        matriz_t[i][j]=tablero;
                        fondo.add(matriz_t[i][j], BorderLayout.CENTER);
                        fondo.repaint();
                        mago2++;
                    
                }
                else{
                }
                }
            }
        }
    }
    
}