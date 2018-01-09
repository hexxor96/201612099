package proyecto2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inicio extends javax.swing.JFrame {
        
	public int contadorAviones = 1;
	public int numeroAviones = 0;
	public int contadorTurno = 1;
        public int contadorEscritorios = 1;
        public int contadorEstaciones = 1;
        public int equipaje = 1;
	public ColaSimple colaSimple = new ColaSimple();
	public int contadorPasajeros = 1;
        public int contadorMantenimiento = 1;
        public ColaDoblementeEnlazada cola;
	public ListaDoblementeEnlazada listaEscritorios;
	public ListaDobleCircular listaMaletas;
	public ColaSimpleAviones colaAviones;
	public ListaSimple listaMantenimiento;
        public int numeroAviones1;
        public int numeroEscritorios1;
        public int numeroEstaciones;
        public int turnos;
        
    public Inicio(){  
        initComponents();        
        jLabel1.setVisible(false);
        txtTurnos.setVisible(false);
    }
	public void graficarGrafo(){
                    try {                    
                    String guardar = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";                    
                    String fileInputPath = System.getProperty("user.dir")+"\\GrafoFinal1.txt";
                    String fileOutputPath = System.getProperty("user.dir")+"\\GrafoFinal1.jpg";                    
                    String tParam = "-Tjpg";
                    String tOParam = "-o";                    
                    String[] cmd = new String[5];
                    cmd[0] = guardar;
                    cmd[1] = tParam;
                    cmd[2] = fileInputPath;
                    cmd[3] = tOParam;
                    cmd[4] = fileOutputPath;         
                    Runtime rt = Runtime.getRuntime();      
                    rt.exec(cmd);      
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
    }            
    }
        
        public void graficarf(){
            try {
                File archive = new File(System.getProperty("user.dir")+"\\GrafoFinal1.txt");
                archive.delete();
                File archive1 = new File(System.getProperty("user.dir")+"\\GrafoFinal1.txt");
                FileWriter reescribir = new FileWriter(archive1,true);
                reescribir.write("digraph G\n{\n");
                reescribir.write("node [shape=box,style=filled,color=black,fontcolor=white,fontname=\"Helvetica\"]; \n");
                reescribir.write(ColaDoblementeEnlazada.escribirDOT(cola));
                reescribir.write(ColaSimple.escribirDOT(colaSimple));
                reescribir.write(ListaDoblementeEnlazada.escribirDOT(listaEscritorios));
                reescribir.write(ListaSimple.escribirDOT(listaMantenimiento));
                reescribir.write(ColaSimpleAviones.escribirDOT(colaAviones));
                reescribir.write("}\n");
                reescribir.close();           
            } catch (IOException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
         
        private int desabordaje(ColaDoblementeEnlazada cola){
                String texto="";
		if (cola.primero != null){
			if (cola.primero.avion.desabordaje > 0){
				texto = texto + "Avion desbordando: " + cola.primero.avion.id + ".\n";
				cola.primero.avion.desabordaje--;
			}
			else{
				for (int i = 1;i <= cola.primero.avion.pasajeros;i++){
					Pasajero pasajero = ColaSimple.crearPasajero(contadorPasajeros,cola.primero.avion.id);
					ColaSimple.queue(colaSimple,pasajero);
					for (int j = 0; j < pasajero.maletas; j++){
						ListaDobleCircular.insertar(listaMaletas);
					}
					contadorPasajeros++;
				}
				texto = texto + "Avion " + cola.primero.avion.id + " pasa a estacion de mantenimiento.\n";
				ColaSimpleAviones.queue(colaAviones,cola.primero.avion);
				ColaDoblementeEnlazada.dequeue(cola);
			}                        
                textEdit1.setText(texto);
		}
		return 0;
	}
        
        private int registrarPasajeros(){
		ldNodo aux = listaEscritorios.primero;
		while (aux != null){
			if (aux.escritorio.cola.length < 10){
				while ( ColaSimple.getSize(colaSimple) != 0 && aux.escritorio.cola.length < 10){
					ColaSimple.queue(aux.escritorio.cola,ColaSimple.primero(colaSimple));
					ColaSimple.dequeue(colaSimple);
				}
				aux = aux.siguiente;
			}
			else{
				aux = aux.siguiente;
			}
		}
		return 0;
	}
        
        private int atender(){
		ldNodo aux = listaEscritorios.primero;
		while (aux != null){
			if (aux.escritorio.cola.primero != null){
				if (aux.escritorio.cola.primero.pasajero.numeroTurnos > 0){
					if (aux.escritorio.pilaDocumentos.length != aux.escritorio.cola.primero.pasajero.documentos){
						for (int i = 0; i < aux.escritorio.cola.primero.pasajero.documentos;i++){
							Pila.push(aux.escritorio.pilaDocumentos);
						}
					}
					aux.escritorio.cola.primero.pasajero.numeroTurnos--;
				}
				else{
					for (int i = 0;i < aux.escritorio.cola.primero.pasajero.maletas;i++){
						ListaDobleCircular.eliminar(listaMaletas);
					}
					for (int i = 0;i < aux.escritorio.cola.primero.pasajero.documentos;i++){
						Pila.pop(aux.escritorio.pilaDocumentos);
					}
					ColaSimple.dequeue(aux.escritorio.cola);
				}
			}
			aux = aux.siguiente;
		}
		return 0;
	}
        
        private int darMantenimiento(){
		sNodo aux = listaMantenimiento.primero;
		while (aux != null){
			if (aux.avion == null){
				if (colaAviones.primero != null){
					aux.avion = colaAviones.primero.avion;
					ColaSimpleAviones.dequeue(colaAviones);
				}
				aux = aux.siguiente;
			}
			else{
				if (aux.avion.mantenimiento > 0){
					aux.avion.mantenimiento--;
					aux = aux.siguiente;
				}
				else{
					aux.avion = null;
					aux = aux.siguiente;
				}
			}
		}
		return 0;
	}
        
        public void pintarGrafo(){
        panel.removeAll();
        Grafo grafo = new Grafo();
        panel.setLayout(null);
        grafo.setBounds(0, 0, 976, 785);
        panel.add(grafo);
        panel.repaint();
        panel.setVisible(true);
        grafo.setGrafo(System.getProperty("user.dir")+"\\GrafoFinal1.jpg");
        
    
    }
        
        
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        textEdit1 = new javax.swing.JTextArea();
        txtAviones = new javax.swing.JTextField();
        txtEscritorios = new javax.swing.JTextField();
        txtEstaciones = new javax.swing.JTextField();
        txtTurnos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inicio = new javax.swing.JButton();
        btnTurno = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textEdit1.setColumns(20);
        textEdit1.setRows(5);
        jScrollPane2.setViewportView(textEdit1);

        txtEstaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstacionesActionPerformed(evt);
            }
        });

        txtTurnos.setText("500");

        jLabel1.setText("Turnos:");

        jLabel2.setText("Aviones:");

        jLabel3.setText("Escritorios:");

        jLabel4.setText("Mantenimiento:");

        inicio.setText("Iniciar ");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        btnTurno.setText("Siguiente");
        btnTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurnoActionPerformed(evt);
            }
        });

        btnImprimir.setText("Salir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEscritorios)
                                    .addComponent(txtAviones)
                                    .addComponent(txtEstaciones))
                                .addGap(44, 44, 44)
                                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(166, 166, 166))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 59, Short.MAX_VALUE)))
                        .addGap(45, 45, 45)))
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAviones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEscritorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEstaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        //Limpia el contador de aviones
	this.contadorAviones = 1;
	this.numeroAviones = 0;
	this.contadorTurno = 1;
        this.equipaje = 1;
	this.colaSimple = new ColaSimple();
	this.contadorPasajeros = 1;
        this.cola = new ColaDoblementeEnlazada();
	this.listaEscritorios = new ListaDoblementeEnlazada();
	this.listaMaletas = new ListaDobleCircular();
	this.colaAviones = new ColaSimpleAviones();
        this.listaMantenimiento = new ListaSimple();
        this.contadorAviones = 1;
	this.contadorTurno = 1;
        this.contadorEstaciones = 1;
        this.contadorEscritorios = 1;
        this.contadorMantenimiento = 1;
        this.numeroAviones1 = Integer.parseInt(txtAviones.getText());
        this.numeroEscritorios1 = Integer.parseInt(txtEscritorios.getText());
        this.numeroEstaciones = Integer.parseInt(txtEstaciones.getText());
		if (txtAviones.getText() == ""){
		}
		else{
                    numeroAviones = numeroAviones1;
		}
		ListaDoblementeEnlazada.crearLista(listaEscritorios);
		if (txtEscritorios.getText() == ""){
		}
		else{                      
			ListaDoblementeEnlazada.crearEscritorios(listaEscritorios, numeroEscritorios1);
                        listaEscritorios.numeroEscritorios = numeroEscritorios1;
		}
		ListaDobleCircular.crearLista(listaMaletas);
		ColaDoblementeEnlazada.crearCola(cola);
                ListaSimple.crearLista(listaMantenimiento);
		if (txtEstaciones.getText() == ""){
		}
		else{
                    ListaSimple.crearEstaciones(listaMantenimiento, numeroEstaciones);
		}
    }//GEN-LAST:event_inicioActionPerformed

    private void btnTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurnoActionPerformed
                        String actual1 = "";
                        int tturnos = Integer.parseInt(txtTurnos.getText());
			if (tturnos > 0){
				actual1 = actual1 + "/////////////////Turno " + contadorTurno + "////////////////\n\r";
				contadorTurno++;
                                
				if (contadorAviones < numeroAviones1){
					Avion nuevo = ColaDoblementeEnlazada.crearAvion(contadorAviones);
					ColaDoblementeEnlazada.queue(cola, nuevo);
					actual1 = actual1 + "Arriba el avion numero " + contadorAviones + ".\n";
					contadorAviones++;
                                }
                                desabordaje(cola);
				registrarPasajeros();
				atender();
				darMantenimiento();
				actual1 = actual1 + "Pasajeros en cola para ser atendidos: " + colaSimple.length + ".\n";
                                actual1 = actual1 + ListaSimple.escribirInformacion(listaMantenimiento);
				actual1 = actual1 + "Cantidad de maletas en el sistema: " + listaMaletas.length + ".\n";
                                actual1 = actual1 + ListaDoblementeEnlazada.escribirInformacion(listaEscritorios);
				actual1 = actual1 + "///////////////Fin turno " + (contadorTurno - 1) + "///////////////\n";
                
                        graficarGrafo();
                        graficarf();
                        pintarGrafo();               
                        textEdit1.setText(actual1);        
                        }
                      
                        
                        
    }//GEN-LAST:event_btnTurnoActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
            System.exit(0);
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void txtEstacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstacionesActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnTurno;
    private javax.swing.JButton inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label;
    private javax.swing.JScrollPane panel;
    private javax.swing.JTextArea textEdit1;
    private javax.swing.JTextField txtAviones;
    private javax.swing.JTextField txtEscritorios;
    private javax.swing.JTextField txtEstaciones;
    private javax.swing.JTextField txtTurnos;
    // End of variables declaration//GEN-END:variables
}
