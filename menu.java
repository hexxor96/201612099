package snake;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Teto
 */
public class menu {
    
    private mapa escenario[][];
    int pos_x=1;
    int pos_y=1;
    
    public int contador=0;
    public int punteo=10;
    public int movimientos=0;
    public String nombre="";
    public String [][] historial = new String [10][4]; 
    
    public menu(){
    
    escenario = new mapa[35][70];
    estructura();
    }

    //Tipos de casilla; 
    //0=contorno
    //1=snake
    //2=muros
    //3=comida
    //4=vacio
    public void crearMapa(){
        for (int i = 0; i < 35; i++) {
            for (int j = 0; j < 70; j++) {
                mapa casilla = new mapa();
                if (i == 0 && j != 69) {
                    casilla.valor = "#";
                    casilla.tipo = 0;
                } else if (j == 0 && i != 34) {
                    casilla.tipo = 0;
                    casilla.valor = "#";
                } else if (j == 69 && i != 34) {
                    casilla.tipo = 0;
                    casilla.valor = "#";
                } else if (i == 34 && j != 69) {
                    casilla.tipo = 0;
                    casilla.valor = "#";
                } else {
                    casilla.valor = " ";
                }
                escenario[i][j] = casilla;
            }
        }     
    }

    public void mover(String m) {

        if (m.equals("s")) {
            movimientos++;

            if (escenario[pos_x + 1][pos_y].tipo == 0) {

            } else if (escenario[pos_x + 1][pos_y].tipo == 2) {

            } else if (escenario[pos_x + 1][pos_y].tipo == 3) {
                //sumar a puntos 
                punteo += escenario[pos_x + 1][pos_y].puntos;
                escenario[pos_x + 1][pos_y].valor = escenario[pos_x][pos_y].valor;
                escenario[pos_x + 1][pos_y].tipo = escenario[pos_x][pos_y].tipo;
                escenario[pos_x][pos_y].tipo = 4;
                escenario[pos_x][pos_y].valor = " ";
                pos_x++;

            } else {
                escenario[pos_x + 1][pos_y].valor = escenario[pos_x][pos_y].valor;
                escenario[pos_x + 1][pos_y].tipo = escenario[pos_x][pos_y].tipo;
                escenario[pos_x + 1][pos_y].puntos = 0;
                escenario[pos_x][pos_y].tipo = 4;
                escenario[pos_x][pos_y].valor = " ";
                escenario[pos_x][pos_y].puntos = 0;
                pos_x++;
            }
        }
        if (m.equals("d")) {
            movimientos++;

            if (escenario[pos_x][pos_y + 1].tipo == 0) {

            } else if (escenario[pos_x][pos_y + 1].tipo == 2) {

            } else if (escenario[pos_x][pos_y + 1].tipo == 3) {
                punteo += escenario[pos_x][pos_y + 1].puntos;
                escenario[pos_x][pos_y + 1].valor = escenario[pos_x][pos_y].valor;
                escenario[pos_x][pos_y + 1].tipo = escenario[pos_x][pos_y].tipo;
                for(int i=1; i < pos_y; i--){
                escenario[pos_x][pos_y - i].cola = escenario[pos_x][pos_y].cola;
                }
                escenario[pos_x][pos_y].tipo = 4;
                escenario[pos_x][pos_y].valor = " ";
                pos_y++;
            } else {
                escenario[pos_x][pos_y + 1].valor = escenario[pos_x][pos_y].valor;
                escenario[pos_x][pos_y + 1].tipo = escenario[pos_x][pos_y].tipo;
                escenario[pos_x][pos_y + 1].puntos = 0;
                escenario[pos_x][pos_y].tipo = 4;
                escenario[pos_x][pos_y].valor = " ";
                escenario[pos_x][pos_y].puntos = 0;
                pos_y++;
            }
        }
        if (m.equals("w")) {
            movimientos++;
            if(escenario[pos_x-1][pos_y]==escenario[0][39]){
            escenario[pos_x-1][pos_y]=escenario[24][39];
            
            
            }
            if (escenario[pos_x - 1][pos_y].tipo == 0) {

            } else if (escenario[pos_x - 1][pos_y].tipo == 2) {

            } else if (escenario[pos_x - 1][pos_y].tipo == 3) {
                punteo += escenario[pos_x - 1][pos_y].puntos;
                escenario[pos_x - 1][pos_y].valor = escenario[pos_x][pos_y].valor;
                escenario[pos_x - 1][pos_y].tipo = escenario[pos_x][pos_y].tipo;
                escenario[pos_x][pos_y].tipo = 4;
                escenario[pos_x][pos_y].valor = " ";
                pos_x--;
            } else {
                escenario[pos_x - 1][pos_y].valor = escenario[pos_x][pos_y].valor;
                escenario[pos_x - 1][pos_y].tipo = escenario[pos_x][pos_y].tipo;
                escenario[pos_x - 1][pos_y].puntos = 0;
                escenario[pos_x][pos_y].tipo = 4;
                escenario[pos_x][pos_y].valor = " ";
                escenario[pos_x][pos_y].puntos = 0;
                pos_x--;
            }
        }
        if (m.equals("a")) {
            movimientos++;
            if (escenario[pos_x][pos_y - 1].tipo == 0) {

            } else if (escenario[pos_x][pos_y - 1].tipo == 2) {

            } else if (escenario[pos_x][pos_y - 1].tipo == 3) {
                punteo += escenario[pos_x][pos_y - 1].puntos;
                escenario[pos_x][pos_y - 1].valor = escenario[pos_x][pos_y].valor;
                escenario[pos_x][pos_y - 1].tipo = escenario[pos_x][pos_y].tipo;
                escenario[pos_x][pos_y - 1].puntos = 0;
                escenario[pos_x][pos_y].tipo = 4;
                escenario[pos_x][pos_y].valor = " ";
                escenario[pos_x][pos_y].puntos = 0;
                pos_y--;
            } else {
                escenario[pos_x][pos_y - 1].valor = escenario[pos_x][pos_y].valor;
                escenario[pos_x][pos_y - 1].tipo = escenario[pos_x][pos_y].tipo;
                escenario[pos_x][pos_y].tipo = 4;
                escenario[pos_x][pos_y].valor = " ";
                pos_y--;
            }
        }
    }

    public void comida() {
        String comida[] = {"%", "$", "#"};
        int comida1 = 0;
        int comida2 = 0;
        int pared = 0;
        int numero;

        for (int i = 2; i < 34; i++) {
            for (int j = 1; j < 69; j++) {
                numero = (int) (Math.random() * 35);
                if (numero == 1 | numero == 3) {
                    numero = (int) (Math.random() * 3);
                    if (numero == 0 && comida1 != 40) {
                        escenario[i][j].valor = comida[numero];
                        escenario[i][j].tipo = 3;
                        escenario[i][j].puntos = 10;
                        comida1++;
                    }
                    if (numero == 1 && comida2 != 30) {
                        escenario[i][j].valor = comida[numero];
                        escenario[i][j].tipo = 3;
                        escenario[i][j].puntos = -10;
                        comida2++;
                    }
                    if (numero == 2 && pared != 20) {
                        escenario[i][j].valor = comida[numero];
                        escenario[i][j].tipo = 2;
                        pared++;
                    }
                } else {
                }
            }
        }
    }    
    
    public void Imprimir() {
        for (int i = 0; i < 35; i++) {
            for (int j = 0; j < 70; j++) {
                System.out.print(escenario[i][j].valor);
            }
            System.out.println("");

        }

    }
    Scanner teclado = new Scanner(System.in);

    Scanner m = new Scanner(System.in);
    Scanner n = new Scanner(System.in);
    Scanner no = new Scanner(System.in);
    Scanner fe = new Scanner(System.in);

    public void estructura() {
        System.out.println("1. Iniciar Juego");
        System.out.println("2. Regresar al juego");
        System.out.println("3. Historial");
        System.out.println("4. Salir");
        System.out.print("Ingrese una opcion: ");
        int opcion = teclado.nextInt();
        System.out.println("_________________ ");
        System.out.println(" ");
        switch (opcion) {
            case (1): {
                crearMapa();
                escenario[pos_x][pos_y].valor = "●";
                escenario[1][1].tipo = 1;
                System.out.print("Nombre: ");
                String nombre1 = teclado.next();
                System.out.print("Fecha de nacimiento: ");
                String fecha = teclado.next();
                comida();

                while (punteo > 0 && punteo < 100) {
                    Imprimir();
                    System.out.println("CONTROLES");
                    System.out.println("w = Arriba, s = Abajo, a = Izquierda, d = Derecha, 3 = Regresar al menu");
                    System.out.println("Puntos: " + punteo);
                    System.out.println("Movimientos: " + movimientos);
                    System.out.println("Nombre: " + nombre);
                    System.out.print("Esperando movimiento... ");
                    String moverse = m.nextLine();
                    mover(moverse);
                    System.out.println(" ");
                    System.out.println(" ");
                }
                                    
                    if(punteo<=0){
                    punteo=0;
                    System.out.println("Juego perdido " + nombre);
                    System.out.println(" ");
                    System.out.println(" ");
                }
                if(punteo>0){
                    punteo=100;
                    System.out.println("Juego ganado " + nombre);
                    System.out.println(" ");
                    System.out.println(" ");
                }
                    String mov,pts;
                    mov=Integer.toString(movimientos);
                    pts=Integer.toString(punteo);
                    historial[contador][0]=nombre1;
                    historial[contador][1]=fecha;
                    historial[contador][2]=mov;
                    historial[contador][3]=pts;
                    contador++;
                    movimientos=0;
                    punteo=10;
                    pos_x=1;
                    pos_y=1;
                    estructura();
                  
                break;
            }
            case (2): {
                
                
                break;
            }
            case (3): {
                System.out.println("-------------------- Historial -----------------------");
                for (int i = 0; i< contador; i++) {
                    System.out.println("| Nombre:"+historial[i][0]+" "+" Fecha: "+historial[i][1]+" Movimientos: "+historial[i][2]+" Puntos: "+historial[i][3]+" |");
                }
                System.out.println("---------------------------------------------------------");
                System.out.println("Presione 1 para regresar al menu: ");
                int opcion2 = n.nextInt();
                if(opcion2==1){
                estructura();
                }
                else{
                System.exit(0);
                }
            }
            case (4): {
               System.exit(0);
                break;
            }

        }
    }
}
