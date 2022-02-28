package torneo;

import java.io.FileReader;
import java.io.IOException;

public class Importar{

	Registro registro = new Registro();
	Auxiliar aux = new Auxiliar();   


	//Impotar registro de los Jugadores
    public void importarRegistrosJ() throws IOException {
        
		Jugador jImportar = new Jugador();//objeto de clase jugador para acceder a los valores de la clase

		int contador=0;//contador de palabras
		Auxiliar.repetido=true;//bucle
		FileReader fichero = null;//fichero a observar
		int caracter;//valor leido
		String palabra = "";//cadena de caracteres leidos

		//buscar fichero
		while(Auxiliar.repetido){
			try {
				System.out.println("Nombre de Fichero");
				String nombreFichero = Auxiliar.sc.nextLine();
				fichero = new FileReader(nombreFichero+".txt");
				Auxiliar.repetido = false;
			} catch (Exception e) {
				System.out.println("fichero no encontrado\n1_Prueba otra vez\t2_Salir");
				Auxiliar.repetido = aux.prueba();
				if(!Auxiliar.repetido)return;
			}
		}
		
		//importacion de valores
		while((caracter = fichero.read()) != -1) {
			if((char)caracter!=';') {
		    	palabra = palabra + (char)caracter;
		    }
			else {
				contador++;
		    	switch(contador) {
		    		case 1:
						try {
							jImportar.id = Registro.FichaJugadores.size();
						} catch (Exception e) {
							System.out.println("Fallo al importar jugador " + jImportar.id);
						}
						try {
							jImportar.DNI =palabra;break;
						} catch (Exception e) {
							System.out.println("Fallo al importar el DNI del jugador " + jImportar.id);
						}
		    		case 2:
						try {
							jImportar.nombre =palabra;break;
						} catch (Exception e) {
							System.out.println("Fallo al importar el nombre del jugador " + jImportar.id);
						}
		    		case 3:
						try {
							jImportar.apellido=palabra;break;
						} catch (Exception e) {
							System.out.println("Fallo al importar el apellido del jugador " + jImportar.id);
						}						
		    		case 4:
						try {
							jImportar.edad=Integer.parseInt(palabra);break;
						} catch (Exception e) {
							System.out.println("Fallo al importar la edad del jugador " + jImportar.id);
						}						
		    		case 5:
						try {
							jImportar.sexo=palabra;break;
						} catch (Exception e) {
							System.out.println("Fallo al importar el sexo del jugador " + jImportar.id);
						}						
		    		case 6:
						try {
							jImportar.nacionalidad=palabra;break;
						} catch (Exception e) {
							System.out.println("Fallo al importar la nacionalidad del jugador " + jImportar.id);
						}					
		    		case 7:
						try {
							jImportar.estado=palabra;break;
						} catch (Exception e) {
							System.out.println("Fallo al importar el estado del jugador " + jImportar.id);
						}						
		    		case 8:
						try {
							jImportar.posicion=palabra;break;
						} catch (Exception e) {
							System.out.println("Fallo al importar la posicion del jugador " + jImportar.id);
						}						
		    		case 9:
						try {
							jImportar.equipo = aux.encontrarE(Registro.clubs.size(),palabra);//Recogida	
						} catch (Exception e) {
							System.out.println("Fallo al importar el equipo del jugador " + jImportar.id);
						}
				
						break;						
		    		case 10:
						try {
							jImportar.dorsal=Integer.parseInt(palabra);
							jImportar.dorsal=aux.reptidoDorsalE(Registro.clubs.size(),jImportar.equipo, Registro.FichaJugadores.size(),jImportar.dorsal);
						} catch (Exception e) {
							System.out.println("Fallo al importar el dorsal del jugador " + jImportar.id);
						}
						
						break;
					case 11:
						try {
							jImportar.salario=Integer.parseInt(palabra);
						} catch (Exception e) {
							System.out.println("Fallo al importar el salario del jugador " + jImportar.id);
						}
						jImportar.partidosjugados=0;
						jImportar.goles=0;

						contador=0;//reseteo para nueva importacion
						try {
							Jugador jugador = new Jugador(jImportar.id,jImportar.equipo,jImportar.nombre,jImportar.apellido,jImportar.edad,jImportar.DNI,jImportar.estado,jImportar.sexo,jImportar.nacionalidad,jImportar.posicion,jImportar.salario,jImportar.dorsal,jImportar.partidosjugados,jImportar.goles);
							Registro.FichaJugadores.add(jugador);
							System.out.println("Importacion del jugador "+ jImportar.id +" completada con exito");
						} catch (Exception e) {
							System.out.println("No se a podido importar los datos del jugdor " + jImportar.id);
						}
						//limpiar salto de linea del fichero
						int cont=1;
						while((caracter = fichero.read()) != -1) { 
							if(cont==2) {
								break;
							}
							cont++;
						}
		    	}
				palabra = "";//reset de palabra para meter un campo nuevo
		    }
		}
	}


	//Impotar registro de los Arbitros
    public void importarRegistrosA() throws IOException {

		Arbitro aImportar = new Arbitro();//objeto de clase arbitro para acceder a los valores de la clase

		int contador=0;//contador de palabras
		Auxiliar.repetido=true;//bucle
		FileReader fichero = null;//fichero a observar
		int caracter;//valor leido
		String palabra = "";//cadena de caracteres leidos

		//buscar fichero
		while(Auxiliar.repetido){
			try {
				System.out.println("Nombre de Fichero");
				String nombreFichero = Auxiliar.sc.nextLine();
				fichero = new FileReader(nombreFichero+".txt");
				Auxiliar.repetido = false;
			} catch (Exception e) {
				System.out.println("fichero no encontrado\n1_Prueba otra vez\t2_Salir");
				Auxiliar.repetido = aux.prueba();
				if(!Auxiliar.repetido)return;
			}
		}

		//importacion de valores
		while((caracter = fichero.read()) != -1) { 
		    if((char)caracter!=';') {
		    	palabra = palabra + (char)caracter;
		    }
			else {
				contador++;
		    	switch(contador) {
		    		case 1:
						try {
							aImportar.id = Registro.FichaArbitros.size();
						} catch (Exception e) {
							System.out.println("Fallo al importar jugador " + aImportar.id);
						}
						try {
							aImportar.DNI = palabra;break;
						} catch (Exception e) {
							System.out.println("Fallo al importar el DNI del aImportar " + aImportar.id);
						}
		    			break;

		    		case 2:
						try {
							aImportar.nombre =palabra;break;
						} catch (Exception e) {
							System.out.println("Fallo al importar el nombre del aImportar " + aImportar.id);
						}
		    			break;

		    		case 3:
						try {
							aImportar.apellido=palabra;break;
						} catch (Exception e) {
							System.out.println("Fallo al importar el apellido del aImportar " + aImportar.id);
						}
						break;

		    		case 4:
						try {
							aImportar.edad=Integer.parseInt(palabra);break;
						} catch (Exception e) {
							System.out.println("Fallo al importar la edad del aImportar " + aImportar.id);
						}
		    			break;

		    		case 5:
						try {
							aImportar.sexo=palabra;break;
						} catch (Exception e) {
							System.out.println("Fallo al importar el sexo del aImportar " + aImportar.id);
						}
		    			break;

		    		case 6:
						try {
							aImportar.estado=palabra;
						} catch (Exception e) {
							System.out.println("Fallo al importar el estado del aImportar " + aImportar.id);
						}
		    			contador=0;//reseteo para nueva importacion
						try {
							Arbitro arbitro = new Arbitro(aImportar.id,aImportar.nombre,aImportar.apellido,aImportar.edad,aImportar.DNI,aImportar.estado,aImportar.sexo,aImportar.corners,aImportar.faltaspitadas,aImportar.tarjetasrojas,aImportar.tarjetasamarillas);
							Registro.FichaArbitros.add(arbitro);
							System.out.println("Importacion del Arbitro "+ aImportar.id +" completada con exito");
						} catch (Exception e) {
							System.out.println("No se a podido importar los datos del jugdor " + aImportar.id);
						}
						//limpiar salto de linea del fichero
						int cont=1;
						while((caracter = fichero.read()) != -1) { 
							if(cont==2) {
								break;
							}
							cont++;
						}
		    			break;
		    	}
				palabra = "";//reset de palabra para meter un campo nuevo
		    }
		}
	}



	public void importarRegistrosE() throws IOException{
		
		Equipo eImportar = new Equipo();//objeto de clase arbitro para acceder a los valores de la clase

		int contador=0;//contador de palabras
		Auxiliar.repetido=true;//bucle
		FileReader fichero = null;//fichero a observar
		int caracter;//valor leido
		String palabra = "";//cadena de caracteres leidos

		//buscar fichero
		while(Auxiliar.repetido){
			try {
				System.out.println("Nombre de Fichero");
				String nombreFichero = Auxiliar.sc.nextLine();
				fichero = new FileReader(nombreFichero+".txt");
				Auxiliar.repetido = false;
			} catch (Exception e) {
				System.out.println("fichero no encontrado\n1_Prueba otra vez\t2_Salir");
				Auxiliar.repetido = aux.prueba();
				if(!Auxiliar.repetido)return;
			}
		}

		//importacion de valores
		while((caracter = fichero.read()) != -1) { 
			if(Registro.clubs.size()<Clasificacion.numeroEquipos){
				if((char)caracter!=';') {
					palabra = palabra + (char)caracter;
				}
				else {
					contador++;
					switch(contador) {
						case 1:
						eImportar.club = aux.reptidoNombreE(Registro.clubs.size(),palabra);
						contador=0;//reseteo para nueva importacion
							try {
								Equipo equipo = new Equipo(eImportar.club, eImportar.puntos, eImportar.golesfavor, eImportar.golescontra, eImportar.difgoles,
								eImportar.partidosJugados, eImportar.ganados,eImportar.empates, eImportar.derrotas);
								Registro.clubs.add(equipo);
								System.out.println("Importacion del Equipo "+ eImportar.club +" completada con exito");
							} catch (Exception e) {
								System.out.println("No se a podido importar los datos del equipo " + eImportar.club);
							}
							//limpiar salto de linea del fichero
							int cont=1;
							while((caracter = fichero.read()) != -1) { 
								if(cont==2) {
									break;
								}
								cont++;
							}
							break;
					}
					palabra = "";//reset de palabra para meter un campo nuevo
				}
			}else{
				System.out.println("El cupo esta lleno, ya no se pueden registrar mas equipos");
				break;
			}
		}
	}
}
