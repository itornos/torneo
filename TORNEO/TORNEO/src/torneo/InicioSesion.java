package torneo;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InicioSesion {

    Auxiliar aux = new Auxiliar();

    String usuario;
    String contrasena;
    boolean existe = false;
    int saltoDeLinea =0;
    String palabra = "";
    int caracter;
    
    
    //Registro de un usuario nuevo (solo puede el admin)
    public void registrarRol() throws IOException{

        BufferedWriter escribir = null;
        try {
            FileWriter ficheroE = new FileWriter("usuarios.txt", true);
            escribir = new BufferedWriter(ficheroE);
        
        }catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println("nombre de usuario");
        usuario = Auxiliar.sc.nextLine();

        System.out.println("Contraseña de usuario");
        contrasena = Auxiliar.sc.nextLine();  
        
        System.out.println("Rol para el nuevo usario\n1_Administrador\t\t2_Usuario\t3_Organizador");
        int caso = Auxiliar.registroNumero();
        String rol= "";
        switch (caso){
            case 1: rol="admin"; break;
            case 2: rol="usuario"; break;
            case 3: rol="organizador"; break;
        }

       escribir.write(usuario+";"+contrasena+";"+rol+";\n");
       escribir.close();
    }



    public void registrarUsu() throws IOException{

        boolean repetido=true;

        BufferedWriter escribir = null;
        try {
            FileWriter ficheroE = new FileWriter("usuarios.txt", true);
            escribir = new BufferedWriter(ficheroE);
        
        }catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        existe=false;
        System.out.println("nombre de usuario");
        while(!existe){
            usuario = Auxiliar.sc.nextLine();
            pruebaUsu();
        }

        while(repetido){
            System.out.println("Contraseña de usuario");
            contrasena = Auxiliar.sc.nextLine();
            
            System.out.println("Repite la contraseña");
            String Pcontrasena = Auxiliar.sc.nextLine();

            if(contrasena.equals(Pcontrasena)){
                System.out.println("Contraseña guardada");
                break;
            }else{
                System.out.println("Te has equivocado");
            }
        }

        String rol= "usuario";

        escribir.write(usuario+";"+contrasena+";"+rol+";\n");
        escribir.close();
    }



    public int iniciarUsu() throws IOException{

        int main=0;
        int contador=0;
        saltoDeLinea =0;
        existe = false;
        palabra="";
        caracter=0;

        try (FileReader fichero = new FileReader("usuarios.txt")) {
            System.out.println("Usuario");
            usuario = Auxiliar.sc.nextLine();

            System.out.println("Contraseña");
            contrasena = Auxiliar.sc.nextLine();

            while((caracter = fichero.read()) != -1) { 

                if((char)caracter!=';') {
                	palabra = palabra + (char)caracter;
                }
            	else if(usuario.equals(palabra) && !existe){
                    contador++;
                    existe=true;
                    palabra="";
                }else if (!existe){
                    saltoDeLinea++;
                    if(saltoDeLinea==3){
                        caracter = fichero.read();
                        saltoDeLinea=0;
                        }
                    palabra="";

                }else if(contador==1 && existe){
                    int intentos=3;
                    while(intentos>0){
                        intentos--;
                        if(contrasena.equals(palabra)){
                            System.out.println("Se ha iniciado sesion");
                            contador++;
                            palabra="";
                            break;
                        }else{
                            System.out.println("La contraseña no coincide con el nombre de usuario");
                            System.out.println("Tienes "+ (intentos+1) +" mas");
                            System.out.println("Prueba otra vez:");
                            contrasena = Auxiliar.sc.nextLine();
                        }
                    }
                    if(intentos==0){
                        break;
                    }

                }else if (contador==2 && existe){
                    switch(palabra){
                        case "admin": main=1; break;
                        case "usuario": main=2; break;
                        case "organizador": main=3; break;
                    }
                    break;
                }
                
            }
            fichero.close();
        }
        return main;
    }



    public void pruebaUsu() throws IOException{

        try (FileReader fichero = new FileReader("usuarios.txt")) {
            existe=true;
            while((caracter = fichero.read()) != -1 && existe) { 
                if((char)caracter!=';') {
                    palabra = palabra + (char)caracter;
                }
                else if(usuario.equals(palabra) && existe){
                    existe=false;
                    palabra="";
                    System.out.println("Este usuario ya esta registrado, escoge otro nombre");
                    break;
                }else if (existe){
                    saltoDeLinea++;
                    if(saltoDeLinea==3){
                        caracter = fichero.read();
                        saltoDeLinea=0;
                        }
                    palabra="";
                 }
            }
        }
    }
}
