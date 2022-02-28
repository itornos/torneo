package torneo;

public class Arbitro extends Persona{
	int tarjetasamarillas;
    int tarjetasrojas;
    int faltaspitadas;
    int corners;

    public Arbitro(int id, String nombre, String apellido, int edad, String DNI, String estado, String sexo, int tarjetasamarillas, int tarjetasrojas, int faltaspitadas,int corners){
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.DNI = DNI;
		this.estado = estado;
		this.sexo = sexo;
		this.tarjetasamarillas = tarjetasamarillas;
		this.tarjetasrojas= tarjetasrojas;
		this.faltaspitadas= faltaspitadas;
		this.corners= corners;
	}
	public Arbitro(){}
}
