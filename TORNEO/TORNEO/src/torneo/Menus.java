package torneo;

import java.io.IOException;

public class Menus {

	Auxiliar aux = new Auxiliar();
    int opcion = 0;
	boolean bucleMain=true;




    public void menuPrincipal(){
        System.out.println("MENU");
			System.out.println("----------------------");
			System.out.println("1_ Jugadores");
			System.out.println("2_ Arbitros");
			System.out.println("3_ Equipos");
			System.out.println("4_ Clasificaion");
			System.out.println("5_ Partidos");
			System.out.println("6_ Registrar usuario");
			System.out.println("7_ Cerra sesion");
            System.out.println("8_ Alt + f4");
    }

	//Menu para las personas, arbitros y jugadores
    public void menuJA(){
        System.out.println("  ______________________  ");
        System.out.println("||                      ||");
        System.out.println("||  Que desea hacer...  ||");
        System.out.println("||----------------------||");
        System.out.println("||  1_Registrar datos   ||");
        System.out.println("||  2_Ver persona       ||");
        System.out.println("||  3_Alterar datos     ||");
        System.out.println("||  4_Importar datos    ||");
        System.out.println("||  5_Salir             ||");
        System.out.println("||______________________||");
    }    
	
	
	//Menu para los equipos
	public void menuE(){
        System.out.println("  ______________________  ");
        System.out.println("||                      ||");
        System.out.println("||  Que desea hacer...  ||");
        System.out.println("||----------------------||");
        System.out.println("||  1_Registrar datos   ||");
        System.out.println("||  2_Ver Equipo        ||");
        System.out.println("||  3_Importar datos    ||");
        System.out.println("||  4_Salir             ||");
        System.out.println("||______________________||");
    }

	//Menu para la clasificacion
	public void menuC(){
        System.out.println("  ______________________  ");
        System.out.println("||                      ||");
        System.out.println("||  Que desea hacer...  ||");
        System.out.println("||----------------------||");
        System.out.println("||  1_Sorteo            ||");
        System.out.println("||  2_Consultar grupos  ||");
        System.out.println("||  3_Ver los brackets  ||");
        System.out.println("||  4_Salir             ||");
        System.out.println("||______________________||");
    }


	public void menuP(){
        System.out.println("  ________________________________________ ");
        System.out.println("||                                        ||");
        System.out.println("||  Que desea hacer...                    ||");
        System.out.println("||-----------------------------------     ||");
        System.out.println("||  1_Registrar estadisticas Partido      ||");
        System.out.println("||  2_Registrar partidos automaticamente  ||");
        System.out.println("||  3_Ver estadisticas pardido            ||");
        System.out.println("||  4_Salir                               ||");
        System.out.println("||________________________________________||");
    }


	public void ImportarGuia(){
        System.out.println("Para poder importar datos se necesita crear o pegar un ficero"
        + "en el directorio raiz del proyecto\ne insertar los datos de forma ordenada para"
        + " que pueda ser leido e insertado dentro del arraylist \n"
        + "El orden debe ser el siguiente:");
	}


    public void menuImportarJ(){
		ImportarGuia();
		System.out.println("-DNI\n -NOMBRE\n -APELLIDO\n -EDAD\n -SEXO\n"
        + " -NACIONALIDAD\n -ESTADO\n -POSICION\n -EQUIPO\n "
        + "-DORSAL\n -SALARIO\n"
        + "Ejemplo: 12345678K;Izan;Tornos Bernal;20;Hombre;España;Activo;EI;23;0;1200;\n \n");
    }

    public void menuImportarE(){
		ImportarGuia();
        System.out.println("-EQUIPO\n"
        + "Ejemplo: Madrid;\n");
    }

	public void menuImportarA(){
		ImportarGuia();
        System.out.println("-DNI\n -NOMBRE\n -APELLIDO\n -EDAD\n -SEXO\n -ESTADO\n"
        + "Ejemplo: 12345678K;Izan;Tornos Bernal;20;Hombre;Activo;\n \n");
    }

    public void brackets(){
        
    }


    public void faseGruposE(int posicionE){
		if(Registro.clubs.get(posicionE).club.length()<=7){
			System.out.print(Registro.clubs.get(posicionE).club +"\t\t\t");
		}else if(Registro.clubs.get(posicionE).club.length()<=14){
			System.out.print(Registro.clubs.get(posicionE).club +"\t\t");
		}else{
			System.out.print(Registro.clubs.get(posicionE).club +"\t");
		}
        System.out.println(Registro.clubs.get(posicionE).partidosJugados+"\t"+ Registro.clubs.get(posicionE).ganados +"\t"+
		Registro.clubs.get(posicionE).empates+"\t"+Registro.clubs.get(posicionE).derrotas+"\t"+Registro.clubs.get(posicionE).golesfavor+"\t"+Registro.clubs.get(posicionE).golescontra+"\t"+
		Registro.clubs.get(posicionE).difgoles+"\t"+Registro.clubs.get(posicionE).puntos+"\n");
    }  


	public void faseGruposT(int numGrupo){
        System.out.println("_________________");
        System.out.println("");
        System.out.println("Grupo "+ (numGrupo+1) +"\t\t\tPJ\tG\tE\tP\tGF\tGC\tDG\tP");
		System.out.println("");
        System.out.println("-----------------");
		System.out.println("");
    }  


	public void estadisticasPartidos(int posicion){
		System.out.println("LOCAL\t\t\tVISITANTE");

		if(Registro.partidos.get(posicion).local.length()<=7){
			System.out.print(Registro.partidos.get(posicion).local +"\t\t\t");
		}else if(Registro.partidos.get(posicion).local.length()<=14){
			System.out.print(Registro.partidos.get(posicion).local +"\t\t");
		}else{
			System.out.print(Registro.partidos.get(posicion).local +"\t");
		}

		if(Registro.partidos.get(posicion).visistante.length()<=7){
			System.out.print(Registro.partidos.get(posicion).visistante +"\t\t\t");
		}else if(Registro.partidos.get(posicion).visistante.length()<=14){
			System.out.print(Registro.partidos.get(posicion).visistante +"\t\t");
		}else{
			System.out.print(Registro.partidos.get(posicion).visistante +"\t");
		}
		System.out.println();
		System.out.println(Registro.partidos.get(posicion).golesLocal+"\t\t\t"+Registro.partidos.get(posicion).golesVisitante);
	}


	public void alineacion(int id,int plantilla[]){
		System.out.println("");
		System.out.println(Registro.FichaJugadores.get(plantilla[9]).nombre+" "+Registro.FichaJugadores.get(plantilla[9]).dorsal+"\t"+Registro.FichaJugadores.get(plantilla[9]).nombre+" "+Registro.FichaJugadores.get(plantilla[9]).dorsal+"\t"+Registro.FichaJugadores.get(plantilla[10]).nombre+" "+Registro.FichaJugadores.get(plantilla[10]).dorsal);
		System.out.println(Registro.FichaJugadores.get(plantilla[6]).nombre+" "+Registro.FichaJugadores.get(plantilla[6]).dorsal+"\t\t\t"+Registro.FichaJugadores.get(plantilla[7]).nombre+" "+Registro.FichaJugadores.get(plantilla[7]).dorsal);
		System.out.println("\t\t"+Registro.FichaJugadores.get(plantilla[5]).nombre+" "+Registro.FichaJugadores.get(plantilla[5]).dorsal);
		System.out.println(Registro.FichaJugadores.get(plantilla[1]).nombre+" "+Registro.FichaJugadores.get(plantilla[1]).dorsal+"\t"+Registro.FichaJugadores.get(plantilla[2]).nombre+" "+Registro.FichaJugadores.get(plantilla[2]).dorsal+"\t"+Registro.FichaJugadores.get(plantilla[3]).nombre+" "+Registro.FichaJugadores.get(plantilla[3]).dorsal+"\t"+Registro.FichaJugadores.get(plantilla[4]).nombre+" "+Registro.FichaJugadores.get(plantilla[4]).dorsal);
		System.out.println("\t\t"+Registro.FichaJugadores.get(plantilla[0]).nombre+" "+Registro.FichaJugadores.get(plantilla[0]).dorsal);
	}


    public void menuAdmin() throws IOException{

		Registro registro = new Registro();
		Importar importar = new Importar();
		InicioSesion sesion = new InicioSesion();
		Menus menus = new Menus();
		Clasificacion clasificacion = new Clasificacion();
		Preguntas preguntas = new Preguntas();

		int numeroclubs;

		while(bucleMain) {

			opcion=0;
			Boolean bucleswitch=true;

			menus.menuPrincipal();
			opcion= Auxiliar.registroNumero();
			System.out.println();

			switch(opcion) {
				case 1:
					while(bucleswitch) {
						menus.menuJA();
						opcion= Auxiliar.registroNumero();

						switch(opcion) {
							case 1:
								if(Registro.clubs.size()==0){
									System.out.println("No hay ningun equipo registrado, si no hay equipo no hay jugadores\n");
								}else{
									preguntas.preguntasJ();
								}
								break;
							case 2:
								registro.verRegistroJ();
								break;
							case 3:
								registro.alterarEstadoJ();
								break;
							case 4:
								menus.menuImportarJ();
								importar.importarRegistrosJ();
								break;
							case 5:
								break;
						}
						System.out.println("Alguna consulta mas sobre Los Jugadores\n1_SI \t2_NO");
						bucleswitch = aux.prueba();
					}
					break;

				case 2:
					while(bucleswitch) {
						menus.menuJA();
						opcion= Auxiliar.registroNumero();

						switch(opcion) {
							case 1:
								preguntas.preguntasA();
								break;
							case 2:
								registro.verRegistroA();
								break;
							case 3:
								registro.alterarEstadoA();
								break;
							case 4:
								menus.menuImportarA();
								importar.importarRegistrosA();
								break;
							case 5:
								break;
						}

						System.out.println("Alguna consulta mas sobre Los Arbitros\n1_SI \t2_NO");
						bucleswitch = aux.prueba();
					}
					break;
				
				case 3:
					while(bucleswitch) {
						menus.menuE();
						opcion= Auxiliar.registroNumero();
						switch(opcion) {
							case 1:
								if(Clasificacion.numeroEquipos==0){
									System.out.println("Cuantos Grupos quieres que haya:\n1_ 4 Grupos\t \t2_ 8 Grupos");
									Boolean numgrupos = aux.prueba();
									if(numgrupos){
										Clasificacion.numeroGrupos=4;
										Clasificacion.numeroEquipos=16;
										System.out.println("Habra un total de 16 equipos, no se podran registrar mas");
										preguntas.preguntasE();
									}else{
										Clasificacion.numeroGrupos=8;
										Clasificacion.numeroEquipos=32;
										System.out.println("Habra un total de 32 equipos, no se podran registrar mas");
										preguntas.preguntasE();
									}
								}else{
									numeroclubs=Registro.clubs.size();
									if(numeroclubs==Clasificacion.numeroEquipos){
										System.out.println("Ya hay " + Clasificacion.numeroEquipos + " equipos registrados, no se pueden añadir mas");
									}else{
										preguntas.preguntasE();
									}
								}
								break;
							case 2:
								registro.verRegistroE();
								break;
							case 3:
								if(Clasificacion.numeroEquipos==0){
									System.out.println("Cuantos Grupos quieres que haya:\n1_ 4 Grupos\t \t2_ 8 Grupos");
									Boolean numgrupos = aux.prueba();
								if(numgrupos){
									Clasificacion.numeroGrupos=4;
									Clasificacion.numeroEquipos=16;
									System.out.println("Habra un total de 16 equipos, no se podran registrar mas");
									importar.importarRegistrosE();
								}else{
									Clasificacion.numeroGrupos=8;
									Clasificacion.numeroEquipos=32;
									System.out.println("Habra un total de 32 equipos, no se podran registrar mas");
									importar.importarRegistrosE();
								}
								}else{
									numeroclubs=Registro.clubs.size();
									if(numeroclubs==Clasificacion.numeroEquipos){
										System.out.println("Ya hay " + Clasificacion.numeroGrupos + " equipos registrados, no se pueden añadir mas");
									}else{
										importar.importarRegistrosE();
									}
								}								
								break;
							case 4:
								break;
						}

						System.out.println("Alguna consulta mas sobre Los Equipo\n1_SI \t2_NO");
						bucleswitch = aux.prueba();
					}
					break;
				
				case 4:
					while(bucleswitch) {
						menus.menuC();
						opcion= Auxiliar.registroNumero();
						if(Clasificacion.sorteo && opcion == 1){
							System.out.println("El sorteo ya se ha hecho");
							opcion = 4;
						}
						switch(opcion) {
							case 1:
								numeroclubs=Registro.clubs.size();
								if(numeroclubs==16 || numeroclubs==32){
									clasificacion.sorteo();
								}else{
									System.out.println("No estan registrado todos los equipos");
								}
								break;
							case 2:
								numeroclubs=Registro.clubs.size();
								if(numeroclubs==16 || numeroclubs==32){
									clasificacion.faseGrupos();
								}else{
									System.out.println("No estan registrado todos los equipos");
								}
								break;
							case 3:
								numeroclubs=Registro.clubs.size();
								if(numeroclubs==16 || numeroclubs==32){
									clasificacion.brackets();
								}else{
									System.out.println("No estan registrado todos los equipos");
								}							
								break;
							case 4:
								break;
						}

						System.out.println("Alguna consulta mas sobre la Clasificacion\n1_SI \t2_NO");
						bucleswitch = aux.prueba();
					}
					break;

				case 5:
					while(bucleswitch) {
						menus.menuP();
						opcion= Auxiliar.registroNumero();
						switch(opcion) {
							case 1:
								if(Clasificacion.sorteo && Registro.partidos.size()!=(Clasificacion.numeroEquipos*3)*2){
									preguntas.preguntasPartido();
								}else{
									System.out.println("Todavia no se ha realizado el sorteo o ya se ha realizado la fase de grupos");
								}
								break;
							case 2:
								if(Clasificacion.sorteo && Registro.partidos.size()!=(Clasificacion.numeroEquipos*3)*2){
									preguntas.preguntasPartidoAutomatico();
								}else{
									System.out.println("Todavia no se ha realizado el sorteo o ya se ha realizado la fase de grupos");
								}
								break;
							case 3:
								registro.verRegistroPartido();					
								break;
							case 4:
								break;
						}

						System.out.println("Alguna consulta mas sobre la Clasificacion\n1_SI \t2_NO");
						bucleswitch = aux.prueba();
					}
					break;
                
                case 6:	
					sesion.registrarUsu();
					break;
                    
				case 7:
					System.out.println("Se ha cerrado la sesion");
					Main.repetirBucleDos=false;
					bucleMain=false;
					Auxiliar.repetido=true;
					break;

				case 8:
					System.out.println("Se va a terminar la ejecucion");
					Auxiliar.repetido = false;
					bucleMain= false;
					Main.repetirBucleDos=false;
					break;
					
				default:
					System.out.println("debes dar un numero entre 1 y 5");
					break;
			}
		}
    }

}
