package torneo;

public class Preguntas {

    Auxiliar aux = new Auxiliar();
    Persona persona = new Persona();
    Registro registro = new Registro();
    Menus menu = new Menus();

    //preguntas persona
	public void preguntasP(){

		System.out.println("Nombre de la persona");
		persona.nombre = Auxiliar.sc.nextLine();
				
		System.out.println("\napellido de la persona");
		persona.apellido = Auxiliar.sc.nextLine();
		
		System.out.println("\nedad de la persona");
		persona.edad = Auxiliar.registroNumero();
		
		System.out.println("\nDNI de la persona");
		persona.DNI = Auxiliar.sc.nextLine();
				
		System.out.println("\nestado de la persona");
		persona.estado = Auxiliar.sc.nextLine();
				
		System.out.println("\nsexo de la persona");
		persona.sexo = Auxiliar.sc.nextLine();	
	}


	//Preguntas jugador
	public void preguntasJ(){
		Jugador jugador = new Jugador();
		jugador.id = Registro.FichaJugadores.size();
		System.out.println("\nNumero de Identificacion de la persona: "+ jugador.id);
		
		//Pregunta respuesta para almacenar datos del jugador
		preguntasP();
		jugador.nombre = persona.nombre;
		jugador.apellido = persona.apellido;
		jugador.edad = persona.edad;
		jugador.DNI = persona.DNI;
		jugador.estado = persona.estado;
		jugador.sexo = persona.sexo;

		System.out.println("\nNacionalidad del jugador");
		jugador.nacionalidad = Auxiliar.sc.nextLine();//Recogida
		
		System.out.println("\nPosicion del jugador");
		jugador.posicion = Auxiliar.sc.nextLine();//Recogida
		
		System.out.println("\nSalario del jugador");
		jugador.salario = Auxiliar.registroNumero();//Recogida

		System.out.println("\nEquipo del jugador");
		jugador.equipo = Auxiliar.sc.nextLine();
		jugador.equipo = aux.encontrarE(Registro.clubs.size(),jugador.equipo);//Recogida	

		System.out.println("\nDorsal del jugador");
		jugador.dorsal = Auxiliar.registroNumero();
		jugador.dorsal = aux.reptidoDorsalE(Registro.clubs.size(),jugador.equipo, Registro.FichaJugadores.size(),jugador.dorsal);
		
		jugador.partidosjugados = 0;
		jugador.goles = 0;

		Registro.FichaJugadores.add(jugador);//Se añade a la lista 

		System.out.println("Algun registro mas...");
		preguntasJ();

	}

	//preguntas arbitro
	public void preguntasA(){
		Arbitro arbitro = new Arbitro();

		arbitro.id = Registro.FichaArbitros.size();
		System.out.println("\nNumero de Identificacion de la persona: "+ arbitro.id);

		preguntasP();
		arbitro.nombre = persona.nombre;
		arbitro.apellido = persona.apellido;
		arbitro.edad = persona.edad;
		arbitro.DNI = persona.DNI;
		arbitro.estado = persona.estado;
		arbitro.sexo = persona.sexo;

		arbitro.tarjetasamarillas = 0;
		arbitro.tarjetasrojas = 0;
		arbitro.faltaspitadas = 0;
		arbitro.corners = 0;
		Registro.FichaArbitros.add(arbitro);

		System.out.println("Algun registro mas...");
		preguntasA();

	}
	


	public void preguntasE(){
		
		Equipo equipo = new Equipo();

		System.out.println("Nombre del Club");
		equipo.club = Auxiliar.sc.nextLine();
		equipo.club = aux.reptidoNombreE(Registro.clubs.size(),equipo.club);
		equipo.puntos = 0;
		equipo.golesfavor = 0;
		equipo.golescontra = 0;
		equipo.difgoles = 0;
		equipo.partidosJugados = 0;
		equipo.ganados = 0;
		equipo.empates = 0;
		equipo.derrotas = 0;
			
		Registro.clubs.add(equipo);

		System.out.println("Quieres hacer algun registro mas\n1_SI \t2_NO");
		boolean sino= aux.prueba();
		if(sino){
			int numeroclubs=Registro.clubs.size();
			if(numeroclubs==Clasificacion.numeroEquipos){
				System.out.println("Ya hay " + Clasificacion.numeroEquipos + " equipos registrados, no se pueden añadir mas");
			}else{
				preguntasE();
			}
		}
	}


	public void preguntasPartido(){
		
		Partido partido = new Partido();

		int grupoloc = 0;//Grupo del equipo local
        String local="";//Nombre del equipo local
        int idclubl = 0;//id del equipo local
        int[] jugadoresLocal = new int[11];//Jugadores del equipo local que participan en el partido


		int grupovis = 0;//Grupo del equipo visitante
		String visitante="";//Nombre del equipo visitante
		int idclubv = 0;//id del equipo visitante
        int[] jugadoresV = new int[11];//Jugadores del equipo visitante que participan en el partido

        String equipo="";//Auxiliar equipo
		int idJugador = 0;//id del jugado para actualizar datos del mismo
		
		boolean partidoinvalido = true;
		


		while(partidoinvalido){
			System.out.println("Equipo local");
			local = Auxiliar.sc.nextLine();
			local = aux.encontrarE(Registro.clubs.size(),local);
			partido.local = local.toLowerCase();

			System.out.println("Equiop visitante");
			visitante = Auxiliar.sc.nextLine();
			visitante = aux.encontrarE(Registro.clubs.size(),visitante);
			partido.visistante = visitante.toLowerCase();

			for(int i =0;i<Clasificacion.grupos.size();i++){
				if(visitante.equals(Clasificacion.grupos.get(i).equipo.toLowerCase())){
					grupoloc = Clasificacion.grupos.get(i).grupo;
				}
				if(local.equals(Clasificacion.grupos.get(i).equipo.toLowerCase())){
					grupovis = Clasificacion.grupos.get(i).grupo;
				}
			}
			if(grupoloc == grupovis){
				idclubl = aux.buscarNombreE(Registro.clubs.size(),local);
				registro.listaJdeEquipo(idclubl);
				idclubv = aux.buscarNombreE(Registro.clubs.size(),visitante);
				registro.listaJdeEquipo(idclubv);
				break;
			}else{
				System.out.println("Estos equipos pertenecen a difrentes grupos\n");
			}

			partidoinvalido = aux.repetidoPartido(partido.local, partido.visistante);
			
		}

		System.out.println("Alinacion del Partido:");
		System.out.println("Se debe proporcionar el id del jugador");
		for(int i =0;i<2;i++){
			System.out.println("\n");

			if(i==0){
				System.out.println(local.toUpperCase());
				equipo=local;
			}else{
				System.out.println(visitante.toUpperCase());
				equipo=visitante;
			}

			int contadorJ=0;

			System.out.print("PORTERIA:");
				if(i==0){
					idJugador=aux.repetidoAlineacion(jugadoresLocal,idJugador,equipo);
					jugadoresLocal[contadorJ]=idJugador;
				}else{
					idJugador=aux.repetidoAlineacion(jugadoresV,idJugador,equipo);
					jugadoresV[contadorJ]=idJugador;
				}
				Registro.FichaJugadores.get(idJugador).partidosjugados++;
				contadorJ++;
				

			for(int j = 0 ; j<4;j++){
				System.out.print("DEFENSAS " + (j+1) + ":");
				if(i==0){
					idJugador=aux.repetidoAlineacion(jugadoresLocal,idJugador,equipo);
					jugadoresLocal[contadorJ]=idJugador;
				}else{
					idJugador=aux.repetidoAlineacion(jugadoresV,idJugador,equipo);
					jugadoresV[contadorJ]=idJugador;
				}
				Registro.FichaJugadores.get(idJugador).partidosjugados++;
				contadorJ++;
			}

			for(int j = 0 ; j<3;j++){
				System.out.print("MEDIOCENTROS " + (j+1) + ":");
				if(i==0){
					idJugador=aux.repetidoAlineacion(jugadoresLocal,idJugador,equipo);
					jugadoresLocal[contadorJ]=idJugador;
				}else{
					idJugador=aux.repetidoAlineacion(jugadoresV,idJugador,equipo);
					jugadoresV[contadorJ]=idJugador;
				}
				Registro.FichaJugadores.get(idJugador).partidosjugados++;
				contadorJ++;
			}

			for(int j = 0 ; j<3;j++){
				System.out.print("DELANTEROS " + (j+1) + ":");
				if(i==0){
					idJugador=aux.repetidoAlineacion(jugadoresLocal,idJugador,equipo);
					jugadoresLocal[contadorJ]=idJugador;
				}else{
					idJugador=aux.repetidoAlineacion(jugadoresV,idJugador,equipo);
					jugadoresV[contadorJ]=idJugador;
				}
				Registro.FichaJugadores.get(idJugador).partidosjugados++;
				contadorJ++;
			}
					
		}
		System.out.println(partido.local.toUpperCase());
		menu.alineacion(idclubl,jugadoresLocal);
		System.out.println("\n\n"+partido.visistante.toUpperCase());
		menu.alineacion(idclubv,jugadoresV);
				
		System.out.println("Cuantos goles a marcado el "+ local);
		partido.golesLocal=Auxiliar.registroNumero();
		for(int i =1;i<=partido.golesLocal;i++){
			System.out.println("Quien ha marcado el "+ i +"º gol:");
			Registro.FichaJugadores.get(Auxiliar.registroNumero()).goles++;
			Registro.clubs.get(idclubl).golesfavor++;
			Registro.clubs.get(idclubv).golescontra++;
		}

		System.out.println("Cuantos goles a marcado el "+ visitante);
		partido.golesVisitante=Auxiliar.registroNumero();
		for(int i =1;i<=partido.golesVisitante;i++){
			System.out.println("Quien ha marcado el "+ i +"º gol:");
			Registro.FichaJugadores.get(Auxiliar.registroNumero()).goles++;
			Registro.clubs.get(idclubv).golesfavor++;
			Registro.clubs.get(idclubl).golescontra++;
		}

		if(partido.golesLocal>partido.golesVisitante){
			Registro.clubs.get(idclubl).ganados++;
			Registro.clubs.get(idclubl).puntos=Registro.clubs.get(idclubl).puntos + 3;
			Registro.clubs.get(idclubv).derrotas++;
		}else if(partido.golesLocal==partido.golesVisitante){
			Registro.clubs.get(idclubl).empates++;
			Registro.clubs.get(idclubv).empates++;
			Registro.clubs.get(idclubl).puntos++;
			Registro.clubs.get(idclubv).puntos++;
		}else{
			Registro.clubs.get(idclubl).derrotas++;
			Registro.clubs.get(idclubv).ganados=Registro.clubs.get(idclubv).ganados + 3;
			Registro.clubs.get(idclubv).puntos++;
		}

		Registro.clubs.get(idclubl).partidosJugados++;
		Registro.clubs.get(idclubv).partidosJugados++;

		
		registro.listaArbitros();
		System.out.println("Quien a arbitrado el partido");
		System.out.println("Debes proporcionar el id");
		int idArbitro = Auxiliar.registroNumero();

		System.out.print("Corners pitados :");
		Registro.FichaArbitros.get(idArbitro).corners+= Auxiliar.registroNumero();

		System.out.print("Faltas pitadas :");
		Registro.FichaArbitros.get(idArbitro).faltaspitadas += Auxiliar.registroNumero();

		System.out.print("Tarjetas Amarillas :");
		Registro.FichaArbitros.get(idArbitro).tarjetasamarillas += Auxiliar.registroNumero();

		System.out.print("Tarjetas Rojas :");
		Registro.FichaArbitros.get(idArbitro).tarjetasrojas += Auxiliar.registroNumero();

		Registro.partidos.add(partido);
		menu.estadisticasPartidos(aux.buscarPartido(partido.local, partido.visistante));

		System.out.println("Quieres hacer algun registro mas\n1_SI \t2_NO");
		boolean sino= aux.prueba();
		if(sino){
				preguntasPartido();
		}
	}
	public void preguntasPartidoAutomatico(){
		
		Partido partido = new Partido();

		int grupoloc = 0;//Grupo del equipo local
        String local="";//Nombre del equipo local
        int idclubl = 0;//id del equipo local
        int[] jugadoresLocal = new int[11];//Jugadores del equipo local que participan en el partido


		int grupovis = 0;//Grupo del equipo visitante
		String visitante="";//Nombre del equipo visitante
		int idclubv = 0;//id del equipo visitante
        int[] jugadoresV = new int[11];//Jugadores del equipo visitante que participan en el partido

        String equipo="";//Auxiliar equipo
		int idJugador = 0;//id del jugado para actualizar datos del mismo
		
		boolean partidoinvalido = true;
		


		for(int i = 0;i<Registro.clubs.size();i++){
			local = Registro.clubs.get(i).club.toLowerCase();
			partido.local= local;
			for(int j = 0;j<Registro.clubs.size();j++){
				visitante = Registro.clubs.get(j).club.toLowerCase();
				partido.visistante = visitante;
				if(local.equals(visitante)){}
				else{
					for(int k =0;k<Clasificacion.grupos.size();k++){
						if(local.equals(Clasificacion.grupos.get(k).equipo.toLowerCase())){
							grupoloc = Clasificacion.grupos.get(k).grupo;
						}
						if(visitante.equals(Clasificacion.grupos.get(k).equipo.toLowerCase())){
							grupovis = Clasificacion.grupos.get(k).grupo;
						}
					}
					if(grupoloc == grupovis){
						idclubl = aux.buscarNombreE(Registro.clubs.size(),local);
						idclubv = aux.buscarNombreE(Registro.clubs.size(),visitante);
						partidoinvalido = aux.repetidoPartido(partido.local, partido.visistante);
						if(local.equals(visitante)){
							partidoinvalido = true;
						}
					}
				}
				if(!partidoinvalido){
					break;
				}
			}
			if(!partidoinvalido){
				break;
			}
		}

		for(int i =0;i<2;i++){
			if(i==0){
				equipo=local;
			}else{
				equipo=visitante;
			}

			int contadorJ=0;

			if(i==0){
				idJugador=aux.AlineacionAuto(jugadoresLocal,idJugador,equipo);
				jugadoresLocal[contadorJ]=idJugador;
			}else{
				idJugador=aux.AlineacionAuto(jugadoresV,idJugador,equipo);
				jugadoresV[contadorJ]=idJugador;
			}
			Registro.FichaJugadores.get(idJugador).partidosjugados++;
			contadorJ++;
				

			for(int j = 0 ; j<4;j++){
				if(i==0){
					idJugador=aux.AlineacionAuto(jugadoresLocal,idJugador,equipo);
					jugadoresLocal[contadorJ]=idJugador;
				}else{
					idJugador=aux.AlineacionAuto(jugadoresV,idJugador,equipo);
					jugadoresV[contadorJ]=idJugador;
				}
				Registro.FichaJugadores.get(idJugador).partidosjugados++;
				contadorJ++;
			}

			for(int j = 0 ; j<3;j++){
				if(i==0){
					idJugador=aux.AlineacionAuto(jugadoresLocal,idJugador,equipo);
					jugadoresLocal[contadorJ]=idJugador;
				}else{
					idJugador=aux.AlineacionAuto(jugadoresV,idJugador,equipo);
					jugadoresV[contadorJ]=idJugador;
				}
				Registro.FichaJugadores.get(idJugador).partidosjugados++;
				contadorJ++;
			}

			for(int j = 0 ; j<3;j++){
				if(i==0){
					idJugador=aux.AlineacionAuto(jugadoresLocal,idJugador,equipo);
					jugadoresLocal[contadorJ]=idJugador;
				}else{
					idJugador=aux.AlineacionAuto(jugadoresV,idJugador,equipo);
					jugadoresV[contadorJ]=idJugador;
				}
				Registro.FichaJugadores.get(idJugador).partidosjugados++;
				contadorJ++;
			}
					
		}
		
		partido.golesLocal= (int) (Math.random()*3);
		for(int i =1;i<=partido.golesLocal;i++){
			Registro.FichaJugadores.get((int) (Math.random()*Registro.FichaJugadores.size())).goles++;
			Registro.clubs.get(idclubl).golesfavor++;
			Registro.clubs.get(idclubv).golescontra++;
		}

		partido.golesVisitante=(int) (Math.random()*3);
		for(int i =1;i<=partido.golesVisitante;i++){
			Registro.FichaJugadores.get((int) (Math.random()*Registro.FichaJugadores.size())).goles++;
			Registro.clubs.get(idclubv).golesfavor++;
			Registro.clubs.get(idclubl).golescontra++;
		}

		if(partido.golesLocal>partido.golesVisitante){
			Registro.clubs.get(idclubl).ganados++;
			Registro.clubs.get(idclubl).puntos=Registro.clubs.get(idclubl).puntos + 3;
			Registro.clubs.get(idclubv).derrotas++;
		}else if(partido.golesLocal==partido.golesVisitante){
			Registro.clubs.get(idclubl).empates++;
			Registro.clubs.get(idclubv).empates++;
			Registro.clubs.get(idclubl).puntos++;
			Registro.clubs.get(idclubv).puntos++;
		}else if(partido.golesLocal<partido.golesVisitante){
			Registro.clubs.get(idclubl).derrotas++;
			Registro.clubs.get(idclubv).puntos=Registro.clubs.get(idclubv).ganados + 3;
			Registro.clubs.get(idclubv).ganados++;
		}

		Registro.clubs.get(idclubl).partidosJugados++;
		Registro.clubs.get(idclubv).partidosJugados++;


		int idArbitro = (int) (Math.random()*Registro.FichaArbitros.size());
		Registro.FichaArbitros.get(idArbitro).corners+= (int) (Math.random()*3);
		Registro.FichaArbitros.get(idArbitro).faltaspitadas += (int) (Math.random()*3);
		Registro.FichaArbitros.get(idArbitro).tarjetasamarillas += (int) (Math.random()*3);
		Registro.FichaArbitros.get(idArbitro).tarjetasrojas += (int) (Math.random()*3);

		Registro.partidos.add(partido);
		
		if(Registro.partidos.size()<=Clasificacion.numeroEquipos*6){
			System.out.println("Se ha añadido el partido : " +Registro.partidos.size());
			preguntasPartidoAutomatico();
		}else{
			System.out.println("Se han realizado todos los partidos");
			preguntasBackets();
		}
		
	}


	public void preguntasBackets() {
		System.out.println("Se ha acabado la fase de grupos, comienza el fuego real");
		System.out.println("1_Continuar o 2_Salir");
		
	}
}
