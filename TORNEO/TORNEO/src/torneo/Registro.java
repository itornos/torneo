package torneo;

import java.util.ArrayList;

public class Registro {

    int numero = 0;

	Auxiliar aux = new Auxiliar();
	Arbitro arbitro = new Arbitro();
	Jugador jugador = new Jugador();
	Clasificacion juego = new Clasificacion();

	static ArrayList<Equipo> clubs = new ArrayList();
	static ArrayList<Jugador> FichaJugadores = new ArrayList();
	static ArrayList<Arbitro> FichaArbitros = new ArrayList();
	static ArrayList<Partido> partidos = new ArrayList();

	//alterar estado jugador
    public void alterarEstadoJ() {

		Auxiliar.repetido=true;
		String atributoEditar="";
		System.out.println("Dime el id del jugador al que quieres alterar algun dato");
		jugador.id= Auxiliar.registroNumero();
        
        while(Auxiliar.repetido){
			try {
				System.out.println("Dime cual es el dato que quieres cambiar sobre este jugador\nNombre, Apellido...");
				atributoEditar = Auxiliar.sc.nextLine();
				if(atributoEditar!="DNI"){
					atributoEditar = atributoEditar.toLowerCase();
				}
                atributoEditar = atributoEditar.replaceAll("\\s+", " ");
                System.out.println("Nuevo dato para " + atributoEditar+":");
                switch(atributoEditar){
                    case "nombre": FichaJugadores.get(jugador.id).nombre = Auxiliar.sc.nextLine(); break;
                    case "apellido": FichaJugadores.get(jugador.id).apellido = Auxiliar.sc.nextLine(); break;
                    case "edad": FichaJugadores.get(jugador.id).edad = (jugador.id = Auxiliar.registroNumero()); break;
                    case "nacionalidad": FichaJugadores.get(jugador.id).nacionalidad = Auxiliar.sc.nextLine(); break;
                    case "DNI": FichaJugadores.get(jugador.id).DNI = Auxiliar.sc.nextLine(); break;
                    case "salario": FichaJugadores.get(jugador.id).salario = (jugador.id = Auxiliar.registroNumero()); break;
                    case "posicion": FichaJugadores.get(jugador.id).posicion = Auxiliar.sc.nextLine(); break;
                }
				Auxiliar.repetido= false;
			} catch (Exception e) {
				System.out.println("El valor que se ha proporcionado no concuerdada con ninguno de la lista");
				Auxiliar.repetido= true;
			}
		}	
	}


	//alterar estado arbitro
	public void alterarEstadoA() {
        
		Auxiliar.repetido=true;
		String atributoEditar="";
		
		System.out.println("Dime el id del Arbitro al que quieres alterar algun dato");
        while(Auxiliar.repetido){
			try {
				System.out.println("Dime cual es el dato que quieres cambiar sobre este Arbitro\nNombre, Apellido...");
				atributoEditar = Auxiliar.sc.nextLine();
				if(atributoEditar!="DNI"){
					atributoEditar = atributoEditar.toLowerCase();
				}
                atributoEditar = atributoEditar.replaceAll("\\s+", " ");
                System.out.println("Nuevo dato para " + atributoEditar+":");
                switch(atributoEditar){
                    case "nombre": FichaArbitros.get(arbitro.id).nombre = Auxiliar.sc.nextLine(); break;
                    case "apellido": FichaArbitros.get(arbitro.id).apellido = Auxiliar.sc.nextLine(); break;
                    case "edad": FichaArbitros.get(arbitro.id).edad = (arbitro.id = Auxiliar.registroNumero()); break;
                }
				Auxiliar.repetido= false;
			} catch (Exception e) {
				System.out.println("El valor que se ha proporcionado no concuerdada con ninguno de la lista");
				Auxiliar.repetido= true;
			}
		}	
	}


	//ver registro jugador
    public void verRegistroJ() {

		Auxiliar.repetido=true;
		int idver=0;

		System.out.println("\nNumero de identificacion del jugador");
		idver = aux.buscarIdJ(FichaJugadores.size());
		if(idver!=-1){
			System.out.println("---------------------------------------------------------------");
			System.out.println("ID Jugador:\t \t"+FichaJugadores.get(idver).id);
			System.out.println("DNI:\t \t \t"+FichaJugadores.get(idver).DNI);
			System.out.println("nombre:\t \t \t"+FichaJugadores.get(idver).nombre);
			System.out.println("apellido:\t \t"+FichaJugadores.get(idver).apellido);
			System.out.println("edad:\t \t \t"+FichaJugadores.get(idver).edad);
			System.out.println("sexo:\t \t \t"+FichaJugadores.get(idver).sexo);
			System.out.println("nacionalidad :\t \t"+FichaJugadores.get(idver).nacionalidad);
			System.out.println("estado:\t \t \t"+FichaJugadores.get(idver).estado);
			System.out.println("Equipo :\t \t"+FichaJugadores.get(idver).equipo);
			System.out.println("posicion:\t \t"+FichaJugadores.get(idver).posicion);
			System.out.println("dorsal:\t \t \t"+FichaJugadores.get(idver).dorsal);
			System.out.println("Partidos Jugados :\t"+FichaJugadores.get(idver).partidosjugados);
			System.out.println("Goles :\t \t \t"+FichaJugadores.get(idver).goles);
			System.out.println("salario :\t \t"+FichaJugadores.get(idver).salario);
			System.out.println("---------------------------------------------------------------");	
			System.out.println("");
		}
		idver++;
	}

	//ver registro arbitro
	public void verRegistroA() {

		Auxiliar.repetido=true;
		int idver=0;

		System.out.println("\nNumero de identificacion del jugador");
		idver = aux.buscarIdA(FichaArbitros.size());
		if(idver!=-1){
			System.out.println("---------------------------------------------------------------");
			System.out.println("ID Jugador:\t \t"+FichaArbitros.get(idver).id);
			System.out.println("DNI:\t \t \t"+FichaArbitros.get(idver).DNI);
			System.out.println("nombre:\t \t \t"+FichaArbitros.get(idver).nombre);
			System.out.println("apellido:\t \t"+FichaArbitros.get(idver).apellido);
			System.out.println("edad:\t \t \t"+FichaArbitros.get(idver).edad);
			System.out.println("sexo:\t \t \t"+FichaArbitros.get(idver).sexo);
			System.out.println("estado:\t \t \t"+FichaArbitros.get(idver).estado);
			System.out.println("Tarjetas Amarillas:\t"+FichaArbitros.get(idver).tarjetasamarillas);
			System.out.println("Tarjetas Rojas:\t \t"+FichaArbitros.get(idver).tarjetasrojas);
			System.out.println("Corners :\t \t"+FichaArbitros.get(idver).corners);
			System.out.println("Faltas Pitadas :\t"+FichaArbitros.get(idver).faltaspitadas);
			System.out.println("---------------------------------------------------------------");	
			System.out.println("");
		}
	}

	public void verRegistroE() {
		System.out.println("\nNombre del equipo");
		String nombreE = Auxiliar.sc.nextLine();
		int idclub = aux.buscarNombreE(clubs.size(),nombreE);
		if(idclub!=-1){
			System.out.println("---------------------------------------------------------------");
			System.out.println("Nombre:\t \t \t"+ clubs.get(idclub).club);
			System.out.println("Puntos:\t \t \t"+clubs.get(idclub).puntos);
			System.out.println("Partidos Jugados:\t"+clubs.get(idclub).partidosJugados);
			System.out.println("Ganados:\t \t"+clubs.get(idclub).ganados);
			System.out.println("Empates:\t \t"+clubs.get(idclub).empates);
			System.out.println("Derrotas:\t \t"+clubs.get(idclub).derrotas);
			System.out.println("Goles a favor:\t \t"+clubs.get(idclub).golesfavor);
			System.out.println("Goles en contra:\t"+clubs.get(idclub).golescontra);
			System.out.println("Dif de goles:\t \t"+clubs.get(idclub).difgoles);
			System.out.println("---------------------------------------------------------------");	
			System.out.println("");
		}
	}

	public void listaJdeEquipo(int ide){
		System.out.println("\n\n\n");
		String nombreClub = clubs.get(ide).club.toLowerCase();
		System.out.println(nombreClub.toUpperCase());
		System.out.println("ID_JUGADOR\tNOMBRE\t\t\t\tPOS\tDOR\tPJ\tG");

		for(Jugador i : FichaJugadores){
			if(nombreClub.equals(i.equipo.toLowerCase())){
				System.out.print(i.id+"\t\t");

				if(i.nombre.length()<=7){
					System.out.print(i.nombre +"\t\t\t");
				}else if(i.nombre.length()<=14){
					System.out.print(i.nombre +"\t\t");
				}else{
					System.out.print(i.nombre +"\t");
				}

				System.out.print("\t"+i.posicion);
				System.out.print("\t"+i.dorsal);
				System.out.print("\t"+i.partidosjugados);
				System.out.print("\t"+i.goles);
				System.out.println();
			}
		}
		System.out.println();
	}

	public void listaArbitros(){
		System.out.println("ID_ARBITRO\tNOMBRE");
		for(Arbitro i : FichaArbitros){
			System.out.print(i.id);
			System.out.print("\t\t"+i.nombre);
			System.out.println();
		}
	}

	public void verRegistroPartido(){
		Menus menu = new Menus();

		int grupoloc = 0;//Grupo del equipo local
        String local="";//Nombre del equipo local
        int idclubl = 0;//id del equipo local

		int grupovis = 0;//Grupo del equipo visitante
		String visitante="";//Nombre del equipo visitante
		int idclubv = 0;//id del equipo visitante
		
		boolean partidoinvalido = false;

		while(!partidoinvalido){
			System.out.println("Equipo local");
			local = Auxiliar.sc.nextLine();
			local = aux.encontrarE(Registro.clubs.size(),local);
			local = local.toLowerCase();

			System.out.println("Equiop visitante");
			visitante = Auxiliar.sc.nextLine();
			visitante = aux.encontrarE(Registro.clubs.size(),visitante);
			visitante = visitante.toLowerCase();

			for(Clasificacion i : Clasificacion.grupos){
				if(visitante.equals(i.equipo.toLowerCase())){
					grupoloc = i.grupo;
				}
				if(local.equals(i.equipo.toLowerCase())){
					grupovis = i.grupo;
				}
			}

			if(grupoloc == grupovis){
				idclubl = aux.buscarNombreE(Registro.clubs.size(),local);
				listaJdeEquipo(idclubl);
				idclubv = aux.buscarNombreE(Registro.clubs.size(),visitante);
				listaJdeEquipo(idclubv);
				break;
			}else{
				System.out.println("Estos equipos pertenecen a difrentes grupos\n");
			}

			partidoinvalido = aux.repetidoPartido(local, visitante);		
		}
		menu.estadisticasPartidos(aux.buscarPartido(local,visitante));
	}
}
