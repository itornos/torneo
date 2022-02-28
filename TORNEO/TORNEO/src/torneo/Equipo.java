package torneo;

public class Equipo {
    String club;
    int puntos;
    int golesfavor;
    int golescontra;
    int difgoles;
    int partidosJugados;
    int ganados;
    int empates;
    int derrotas;

    public Equipo (String club, int puntos, int golesfavor, int golescontra, int difgoles,
	int partidosJugados, int ganados,int empates, int derrotas){
		this.club = club;
		this.puntos = puntos;
		this.golesfavor = golesfavor;
		this.golescontra = golescontra;
		this.difgoles = difgoles;
		this.partidosJugados = partidosJugados;
		this.ganados = ganados;
		this.empates = empates;
		this.derrotas= derrotas;
	}
	public Equipo (){}
}
