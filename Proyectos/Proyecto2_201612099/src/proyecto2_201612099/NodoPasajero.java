package proyecto2_201612099;

public class NodoPasajero {
    private int id = 0;
    private int CMaletas = 0;
    private int CDocumentos = 0;
    private int NRegistro = 0;
    private NodoPasajero siguiente = null;
    private NodoPasajero anterior = null;

    public NodoPasajero(int id, int CMaletas, int CDocumentos, int NRegistro, NodoPasajero siguiente, NodoPasajero anterior){
        this.id = id;
        this.CMaletas = CMaletas;
        this.CDocumentos = CDocumentos;
        this.NRegistro = NRegistro;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
    
    public NodoPasajero(){    
    }
    
    public int getid(){
        return id;
    }
    
    public void setid(int id){
        this.id = id;
    }
    
    public int getCMaletas(){
        return CMaletas;
    }
    
    public void setCMaletas(int CMaletas){
        this.CMaletas = CMaletas;
    }
    
    public int getCDocumentos(){
        return CDocumentos;
    }
    
    public void setCDocumentos(int CDocumentos){
        this.CDocumentos = CDocumentos;
    }
    
    public int getNRegistro(){
        return NRegistro;
    }
    
    public void setNRegistro(int NRegistro){
        this.NRegistro = NRegistro;
    }
    
    public NodoPasajero getsiguiente(){
        return siguiente;
    }
    
    public void setsiguiente(NodoPasajero siguiente){
        this.siguiente = siguiente;
    }
    
    public NodoPasajero getanterior(){
        return anterior;
    }
    
    public void setanterior(NodoPasajero anterior){
        this.anterior = anterior;
    }
}
