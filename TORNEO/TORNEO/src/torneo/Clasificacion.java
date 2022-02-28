package torneo;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Clasificacion {
    static int numeroEquipos = 0;
    static int numeroGrupos = 0;
    static boolean sorteo = false;
    static ArrayList<Clasificacion> grupos = new ArrayList();
    
    String equipo;
    int grupo;
    Auxiliar aux = new Auxiliar();

    public Clasificacion(String equipo,int grupo) {
        this.equipo = equipo;
        this.grupo = grupo;
    }

    public Clasificacion(){}

    public void sorteo(){

        sorteo = true;

        Clasificacion sorteo = new Clasificacion();
        int[] bolascalientes = new int[numeroEquipos];

        int[] gruposcalientes = new int[numeroEquipos];
        int contadorEquiposGrupos = 0;

        int datosArray=0;

        for(int l=0;l<bolascalientes.length;l++){
            bolascalientes[l] = 99;
            gruposcalientes[l] = 99;
        }

        for(int i =0;i<numeroEquipos;i++){

            int manoInocenteEquipos = (int)Math.floor(Math.random()*Clasificacion.numeroEquipos);
            int manoInocenteGrupos = (int)Math.floor(Math.random()*numeroGrupos);

            contadorEquiposGrupos=0;

            for(int j =0;j<gruposcalientes.length;j++){
                if(manoInocenteGrupos==gruposcalientes[j]){
                    contadorEquiposGrupos++;
                    if(contadorEquiposGrupos==4){
                        manoInocenteGrupos = (int)Math.floor(Math.random()*numeroGrupos);
                        contadorEquiposGrupos = 0;
                        j=-1;
                    }
                }
            }


            for(int k =0;k<bolascalientes.length;k++){
                if(manoInocenteEquipos==bolascalientes[k]){
                    manoInocenteEquipos = (int)Math.floor(Math.random()*Clasificacion.numeroEquipos); 
                    k=-1;
                }
            }

            bolascalientes[datosArray] = manoInocenteEquipos;
            gruposcalientes[datosArray] = manoInocenteGrupos;
            datosArray++;

            sorteo.equipo = Registro.clubs.get((manoInocenteEquipos)).club;
            sorteo.grupo = manoInocenteGrupos;

            System.out.println(Registro.clubs.get(manoInocenteEquipos).club);

            Clasificacion valorgrupos = new Clasificacion(sorteo.equipo,sorteo.grupo);
            grupos.add(valorgrupos);
        }
        faseGrupos();
    }

    public void faseGrupos(){
        Menus menu = new Menus();
        int grupoi;
        int grupoList;
        int pos =0;
        String auxnombre [] = new String[4];
        
        for(int i = 0;i<numeroGrupos;i++){
            grupoi = i;
            menu.faseGruposT(i);
            pos =0;
            for(int j = 0;j<Registro.clubs.size();j++){
                grupoList = grupos.get(j).grupo;
                if(grupoi == grupoList){
                    auxnombre [pos] = grupos.get(j).equipo;
                    pos++;
                    //nadaquever();
                }
            }
            aux.ordenarE(auxnombre);
            System.out.println("");
        } 
    }


    public void brackets(){

    }

    public void nadaquever(){
        ImageIcon icon = new ImageIcon("sorteo.gif");
        JLabel label = new JLabel(icon);

        JFrame f = new JFrame("SORTEO ATENTOS");
        f.getContentPane().add(label);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        ImageIcon icono = new ImageIcon("sorteo-2.gif");
        JLabel labelo = new JLabel(icono);

        f.getContentPane().add(labelo);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        ImageIcon icono0 = new ImageIcon("sorteo-3.gif");
        JLabel labelo0 = new JLabel(icono0);

        f.getContentPane().add(labelo0);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
