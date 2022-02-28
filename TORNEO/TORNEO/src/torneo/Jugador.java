package torneo;

public class Jugador extends Persona{
	String equipo;
	String nacionalidad;
	String posicion;
	int salario;
	int dorsal;
	int partidosjugados;
	int goles;

	public Jugador (int id, String equipo, String nombre, String apellido, int edad, String DNI, String estado, String sexo, String nacionalidad, 
	String posicion, int salario, int dorsal,int partidosjugados, int goles){
		this.id = id;
		this.equipo= equipo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.DNI = DNI;
		this.estado = estado;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.posicion= posicion;
		this.salario= salario;
		this.dorsal= dorsal;
		this.partidosjugados= partidosjugados;
		this.goles= goles;
	}
	public Jugador (){}

}