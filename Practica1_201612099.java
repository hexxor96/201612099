package practica1_201612099;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Teto
 */
public class Practica1_201612099 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String nombre[] = new String[1];
        String f_nacimiento[] = new String[1];
        String aux;
        Scanner in = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        
        while(!salir){
        System.out.println("1. Iniciar Juego ");
        System.out.println("2. Regresar al juego ");
        System.out.println("3. Historial ");
        System.out.println("4. Salir ");    
        try{
            System.out.print("Ingrese una opcion: ");
            opcion = in.nextInt();
            
            switch(opcion){
                case 1:
                    for (int i=0; i < nombre.length; i++){
                        System.out.print("Nombre: ");
                        aux = in.next();
                        nombre[i] = aux;
                    }
                    for (int i=0; i < f_nacimiento.length; i++){
                        System.out.print("Fecha de nacimiento: ");
                        aux = in.next();
                        f_nacimiento[i] = aux;
                    }
                    break;
                            
                case 2:
                    break;
                case 3:
                    for (int i=0; i < nombre.length; i++){
                        System.out.println(nombre[i] + f_nacimiento[i]);
                    }
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Ingrese un numero del 1 al 4 ");
            }
        } catch (InputMismatchException e){
            System.out.println("Porfavor ingrese un numero del 1 al 4 ");
            in.next();
        }
        
        }
    }
}
