package torneo;

import java.util.Scanner;

//clase para guardar metodos de apoyo
public class Auxiliar {

    Persona persona = new Persona();

    static Scanner sc = new Scanner(System.in);
	static boolean repetido = true;
	
    //buscar y encontrar id en la lista jugador
    public int buscarIdJ(int tamano){
		
		int idprueba = registroNumero();
		repetido = true;//bucle
        while(repetido){
			if(tamano==0){//No hay datos, no hay busqueda
				System.out.println("No hay registros todavia");
				persona.id = -1;
				break;
			}
			for(int i=0;i<tamano;i++) {//Busqueda
				if(i==idprueba) {//Es igual?
					repetido = false;
					persona.id = i;
					break;
				}
				if(i==tamano-1){//Si la busqueda falla prueba otra vez... o no
					System.out.println("Este Id no esta vinculado a ningun jugador");
					System.out.println("Prueba con otro o sal: \n1_Buscar \t2_Salir");
					repetido=prueba();
					if(repetido){
						idprueba = registroNumero();
					}else{
						persona.id = -1;
					}
				}
			}
		}
        return persona.id;//devuelve la busqueda
    }


	//buscar y encontrar id en la lista Arbitro
	public int buscarIdA(int tamano){
		int idprueba= registroNumero();
		repetido = true;//bucle
        while(repetido){
			if(tamano==0){//No hay datos, no hay busqueda
				System.out.println("No hay registros todavia");
				persona.id = -1;
				break;
			}
			for(int i=0;i<tamano;i++) {//Busqueda
				if(i==idprueba) {//Es igual?
					repetido = false;
					persona.id = i;
					break;
				}
				if(i==tamano-1){//Si la busqueda falla prueba otra vez... o no
					System.out.println("Este Id no esta vinculado a ningun jugador");
					System.out.println("Prueba con otro o sal: \n1_Buscar \t2_Salir");
					repetido=prueba();
					if(repetido){
						idprueba = registroNumero();
					}else{
						persona.id = -1;
					}
				}
			}
		}
        return persona.id;//devuelve la busqueda
    }
    
	//Devuelve el id del Equipo
	public int buscarNombreE(int tamano,String club){
		club = club.toLowerCase();
		int idclub =-1;
		repetido = true;//bucle
        while(repetido){
			if(tamano==0){//No hay datos, no hay busqueda
				System.out.println("No hay registros todavia");
				idclub = -1;
				break;
			}
			for(int i=0;i<tamano;i++) {//Busqueda
				if(club.equals(Registro.clubs.get(i).club.toLowerCase())) {//Es igual?
					repetido = false;
					idclub = i;
					break;
				}
				if(i==tamano-1){//Si la busqueda falla prueba otra vez... o no
					System.out.println("Este Id no esta vinculado a ningun jugador");
					System.out.println("Prueba con otro o sal: \n1_Buscar \t2_Salir");
					repetido=prueba();
					if(repetido){
						club = sc.nextLine();
					}else{
						idclub = -1;
					}
				}
			}
		}
        return idclub;//devuelve la busqueda
    }

	//Devuelve el Nombre del equipo
	public String encontrarE(int tamano,String club){
		repetido = true;//bucle
        while(repetido){
			club = club.toLowerCase();
			for(int i=0;i<tamano;i++) {//Busqueda
				if(club.equals(Registro.clubs.get(i).club.toLowerCase())) {//Es igual?
					repetido=false;
					break;
				}
				if(i==tamano-1){//Si la busqueda falla no hay repetidos
					System.out.println("Este equipo no existe:");
					club = sc.nextLine();
					repetido = true;
					break;
				}
			}
		}
        return club;//devuelve la busqueda		
	}

	//Prueba para buscar el nombre y comprobar si este esta repetido, en ese caso, si pide otro
	public String reptidoNombreE(int tamano, String club){
		repetido = true;//bucle
		String original= club;
        while(repetido){
			club = club.toLowerCase();
			if(tamano==0){//No hay datos, no hay busqueda
				break;
			}
			for(int i=0;i<tamano;i++) {//Busqueda
				if(club.equals(Registro.clubs.get(i).club.toLowerCase())) {//Es igual?
					System.out.println("Este nombre ya ha sido seleccionado, Dame otro:");
					club = sc.nextLine();
					repetido = true;
					break;
				}
				if(i==tamano-1){//Si la busqueda falla no hay repetidos
					repetido=false;
					if(repetido){
						break;
					}
				}
			}
		}
        return original;//devuelve la busqueda
    }


	//Mirar dorsales de un equipo y buscar repetido, en ese caso, se pide otro
	public int reptidoDorsalE(int tamano,String equipo, int jugadores,int dorsal){
		if(jugadores==0){
			return dorsal;
		}
		for(int i=0;i<jugadores;i++) {//Busqueda
			if(equipo.equals(Registro.FichaJugadores.get(i).equipo.toLowerCase())) {//Es igual?
				if(dorsal == Registro.FichaJugadores.get(i).dorsal){
					System.out.println("Este dorsal ya pertenece a un jugador de este equipo\nDame otro dorsal para el jugador:");
					dorsal=registroNumero();
					i=0;
				}
			}
		}
		return dorsal;
	}


	//Prueba error Scanner int
    public static int registroNumero(){
		int numero=0;//valor que se develve
		repetido = true;//bucle
		while(repetido){
            try {//en caso de fallo al escribir se repite
				numero = Integer.parseInt(sc.nextLine());//Recogida
                repetido = false;//termina el bucle
            }catch(Exception e) {//El valor Integer esta compuesto por valores no validos
                System.out.println("\nDebes dale un numero sin letras");
                repetido = true;
            }
        }
		return numero;//numero devuelto
    }


	//Prueba para elegir entre el 1 y el 2
	public boolean prueba(){
		while(1<2){//bluce infinito que se rompe con la decision correcta
			int decision = registroNumero();//valor de la decision
			if(decision==1){//continuar probando
				repetido = true;
				break;
			}else if(decision==2){//salir 
				repetido=false;
				break;
			}else{//decision incorrecta
				System.out.println("Debes darme un 1 o un 2");
			}
		}
		return repetido;//decision devuelta, true o false
	}


	//Ordenar los equipos teniendo en cuenta los puntos, en caso de empate, el que tenga mas goles estara por delante
	public void ordenarE(String[] orden){
		Menus menu = new Menus();
		for(int i = orden.length-2 ;i>=0;i--){
			for(int j =0 ;j<orden.length-i;j++){

				int primero = buscarNombreE(Registro.clubs.size(),orden[i]);
				int segundo = buscarNombreE(Registro.clubs.size(),orden[i+1]);

				if(Registro.clubs.get(primero).puntos<Registro.clubs.get(segundo).puntos){

					orden[i] = Registro.clubs.get(segundo).club;
					orden[i+1] = Registro.clubs.get(primero).club;

				}else if(Registro.clubs.get(primero).puntos==Registro.clubs.get(segundo).puntos){

					if(Registro.clubs.get(primero).difgoles<Registro.clubs.get(segundo).difgoles){

						orden[i] = Registro.clubs.get(segundo).club;
						orden[i+1] = Registro.clubs.get(primero).club;
					}
				}else if(Registro.clubs.get(primero).difgoles==Registro.clubs.get(segundo).difgoles){

					if(Registro.clubs.get(primero).golesfavor<Registro.clubs.get(segundo).golesfavor){

						orden[i] = Registro.clubs.get(segundo).club;
						orden[i+1] = Registro.clubs.get(primero).club;

					}
				}
			}
		}
		for(int i=0;i<orden.length;i++){
			menu.faseGruposE(buscarNombreE(Registro.clubs.size(), orden[i]));
		}	
	}

	
	//Buscar jugadores seleccionados para jugar y buscar repetido
	public int repetidoAlineacion(int[] orden,int id,String equipo){
		id = registroNumero();
		equipo = equipo.toLowerCase();
		while(1<2){
			if(equipo.equals(Registro.FichaJugadores.get(id).equipo.toLowerCase())){
				break;	
			}else{
				System.out.println("Este jugador no pertenece a este equipo");
				id = registroNumero();
			}
		}
		for(int i=0;i<orden.length;i++){
			if(orden[i]==id){
				System.out.println("Este jugador ya esta el alguna posicion, proporciona uno nuevo");
				id = registroNumero();
				i=-1;
			}
		}
		return id;
	}


	//crear toda la alineacion del equipo solo
	public int AlineacionAuto(int[] orden,int id,String equipo){
		id = (int) (Math.random()*Registro.FichaJugadores.size());
		equipo = equipo.toLowerCase();
		while(1<2){
			if(equipo.equals(Registro.FichaJugadores.get(id).equipo.toLowerCase())){
				break;	
			}else{
				id = (int) (Math.random()*Registro.FichaJugadores.size());
			}
		}
		for(int i=0;i<orden.length;i++){
			if(orden[i]==id){
				id = (int) (Math.random()*Registro.FichaJugadores.size());
				i=-1;
			}
		}
		return id;
	}


	//Buscar los partido que ya se han realizado y comprobar si hay alguna relacion con el nuevo para evitar repeticion
	public boolean repetidoPartido(String local,String visitante){
		boolean partidoRepetido=false;
		local = local.toLowerCase();
		visitante = visitante.toLowerCase();
		for(Partido i : Registro.partidos){
			if(local.equals(i.local.toLowerCase()) && visitante.equals(i.visistante.toLowerCase())){
				partidoRepetido=true;
				break;
			}
		}
		return partidoRepetido;
	}


	//buscar el partido
	public int buscarPartido(String local,String visitante){
		int idpartido=0;
		local = local.toLowerCase();
		visitante = visitante.toLowerCase();
		for(int i =0;i<Registro.partidos.size();i++){
			if(local.equals(Registro.partidos.get(i).local.toLowerCase()) && visitante.equals(Registro.partidos.get(i).visistante.toLowerCase())){
				idpartido=i;
				break;
			}
		}
		if(idpartido==0){
			System.out.println("No se ha encontrado el partido");
		}
		return idpartido;
	}

}

