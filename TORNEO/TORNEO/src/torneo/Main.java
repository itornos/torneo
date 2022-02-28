package torneo;

import java.io.IOException;

public class Main {

	static boolean repetirBucleDos = true;
	public static void main(String[] args) throws IOException {

		Menus menu = new Menus();
		InicioSesion sesion = new InicioSesion();
		Auxiliar aux = new Auxiliar();

		Auxiliar.repetido=true;

		while(Auxiliar.repetido){
			System.out.println("Tienes Cuenta?\n1_SI\t\t2_NO\t\t3_Cerrar");
			int cuenta = Auxiliar.registroNumero();
			repetirBucleDos=true;
			switch(cuenta){
				case 1:
					while(repetirBucleDos){
						int autorizacion = sesion.iniciarUsu();
						switch(autorizacion){
							case 0: System.out.println("No se ha podido encontran al usuario o contraseña especificada\n1_Prueba otra vez\t2_Salir");
							repetirBucleDos = aux.prueba();
							break;
							case 1: menu.menuAdmin();break;
							case 2: ;break;
							case 3: ;break;
						}
					}
					break;
				case 2:
					sesion.registrarUsu();
					Auxiliar.repetido= true;
					break;
				case 3:
					Auxiliar.repetido = false;
					break;
				default:
					System.out.println("Numero 1 o 2");
					Auxiliar.repetido = aux.prueba();
			}
		}
	}
}
