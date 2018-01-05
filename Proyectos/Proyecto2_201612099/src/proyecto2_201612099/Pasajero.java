package proyecto2_201612099;

public class Pasajero {
	private int documento;
	private int maletas;
	private int id;
	private int turnos;
        
	public Pasajero(int documento, int maletas, int id, int turnos){
		this.documento = documento;
		this.maletas = maletas;
		this.id = id;
		this.turnos = turnos;
	}
        
	public Pasajero(){
            
	}
        
	public final int getDocumento(){
		return this.documento;
	}
        
	public final void setDocumento(int value){
		this.documento = value;
	}
        
	public final int getMaletas(){
		return this.maletas;
	}
        
	public final void setMaletas(int value){
		this.maletas = value;
	}
        
	public final int getId(){
		return this.id;
	}
        
	public final void setId(int value){
		this.id = value;
	}
        
	public final int getTurnos(){
		return this.turnos;
	}
        
	public final void setTurnos(int value){
		this.turnos = value;
	}
        
	public final String toString(){
		String cadena = "";
		cadena += "id: " + to_string(id) + "\n documento: " + to_string(documento) + "\n maletas: " + to_string(maletas) + "\n Turnos: " + to_string(turnos);
		return cadena;
	}
}
