package proyecto2_201612099;

public class Avion
{
	private int id;
	private int turnos;
	private int mantenimiento;
	private int tipo; 

	public Avion(int id, int turnos, int mantenimiento, int tipo){
		this.id = id;
		this.turnos = turnos;
		this.mantenimiento = mantenimiento;
		this.tipo = tipo;
	}
	public final String toString(){
		String avion = "";
		avion = "id: " + id + "\n turnos: " + turnos + "\n mantenimiento: " + mantenimiento + "\n tipo: " + tipo;
		return avion;
	}
	public Avion(){

	}
        
	public final int getId(){
		return id;
	}
        
	public final void setId(int value){
		id = value;
	}

	public final int getTurnos(){
		return turnos;
	}
        
	public final void setTurnos(int value){
		turnos = value;
	}

        public final int getMantenimiento(){
		return mantenimiento;
	}
	
        public final void setMantenimiento(int value){
		mantenimiento = value;
	}
	
        public final int getTipo(){
		return tipo;
	}
	
        public final void setTipo(int value){
		tipo = value;
	}
}
