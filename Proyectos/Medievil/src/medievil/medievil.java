package medievil;

public class medievil {

    public static void main(String[] args) {
        // TODO code application logic here
        menu m = new menu();
        m.setVisible(true);
        
        seleccion s = new seleccion();
        s.setVisible(false);
        
        jugar j = new jugar();
        j.setVisible(false);
    }
}
