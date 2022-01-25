
package Lliga_Esportiva;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marpo
 */
public class Lliga_Esportiva {
    
    static boolean exit=false;
    
    public static String carpeta="equips/equips.txt";
    static String Nom;
    static int pj;
    static int pg;
    static int pe;
    static int pp;
    static int pt;
    public static String [] Equips= new String[100];
    public static int [] Puntuacions= new int[100];
    public static int [] Prj= new int[100];
    public static int [] Prg= new int[100];
    public static int [] Pre= new int[100];
    public static int [] Prp= new int[100];
    public static void main(String [] args) throws IOException{
            
        Scanner teclat = new Scanner (System.in);
        Scanner st = new Scanner(System.in);
        inici();
            
        do{
            System.out.println("------Menu d'aplicació de gestió lliga esportiva-----");
            System.out.println("1. Visualitzar equips i la seva puntuació");
            System.out.println("2. Afegir un equip nou amb les seves puntuacions");
            System.out.println("3. Modificar les dades d'un equip");
            System.out.println("4. Visualitzar dades del lider i del cuer de la lliga");
            System.out.println("5. Sortir i guardar en el fitxer les dades");
                
            String sa = st.next();
            char opcio = sa.charAt(0);  
                
                
            switch(opcio){
                case '1':
                visualitzarequips();
                break;
                case '2':
                afegirequip();
                break;
                case '3':
                editarEquip();
                break;
                case '4':
                consultarComandes();
                break;
                case '5':
                guardarDades();
                break;
                case 's':
                   exit=true;
                   break;
                case 'S':
                   exit=true;
                   break;
               default:
                   System.out.println("L'Opció no és vàlida");
            }
            
            System.out.println(("\nHa escollit l'opció: ")+ opcio); 
        }
         while (!exit);

    }
    
    
    static void inici() throws FileNotFoundException, IOException{
        int contadorEquips=0;
        int contadorPuntuacions=0;
        int numero=0;
        int resultat=0;
        File fitxer = new File(carpeta);
        Scanner lector;
        FileReader reader = new FileReader (fitxer);
        BufferedReader buffer = new BufferedReader (reader);
        System.out.println("                                                -------------EQUIPS------------");
        System.out.println("Equip            Partits Jugats          Partits Guanyats        Partits Empatats                Partits Perduts           Punts Totals    ");
        System.out.println("--------     ---------------------     --------------------    --------------------            -------------------       ----------------    ");
        try{
            lector = new Scanner(fitxer);
            while(lector.hasNextLine()){
                String linea = lector.nextLine();
                Scanner sl = new Scanner(linea);
                sl.useDelimiter(":");
                System.out.print(Equips[contadorEquips]=sl.next());
                System.out.print("\t\t\t");
                System.out.print(Prj[contadorEquips]=sl.nextInt());
                System.out.print("\t\t\t");
                System.out.print(Prg[contadorEquips]=sl.nextInt());
                System.out.print("\t\t\t");
                System.out.print(Pre[contadorEquips]=sl.nextInt());
                System.out.print("\t\t\t\t");
                System.out.print(Prp[contadorEquips]=sl.nextInt());
                System.out.print("\t\t\t");
                System.out.println(numero=sl.nextInt());
                resultat=resultat+numero;
                Puntuacions[contadorEquips]=numero;
                contadorPuntuacions=resultat;    
                contadorEquips++;
                
        }

        lector.close();    
        }catch (FileNotFoundException e) {
			e.printStackTrace();
		}
                
    }
     static void visualitzarequips() throws FileNotFoundException{
        File fitxer = new File(carpeta);
        Scanner lector;
        FileReader reader = new FileReader (fitxer);
        BufferedReader buffer = new BufferedReader (reader);
        System.out.println("-------------PUNTUACIONS------------");
        System.out.println("Equip            Punts Totals    ");
        System.out.println("--------       ----------------    ");
        for (int i=0;i<Equips.length;i++){
            if(Equips[i]!=null){
             System.out.println("" + Equips[i] + "\t\t\t" + Puntuacions[i]);
           }
        //Diem quants productes té cada proveidor
        
        }
    }
     
     static void afegirequip() throws FileNotFoundException, IOException{
        File fitxer = new File(carpeta);
        FileWriter fw = new FileWriter (fitxer, true);
        Scanner teclat = new Scanner (System.in);
        //BufferedWriter bw = new BufferedWriter(fw);
        //PrintWriter pw = new PrintWriter(fw);

                System.out.println("Posar el nom de l'equip");
                Nom=teclat.nextLine();
                System.out.println("Posar els partits jugats");
                pj=teclat.nextInt();
                System.out.println("Posar els partits guanyats");
                pg=teclat.nextInt();
                System.out.println("Posar els partits empatas");
                pe=teclat.nextInt();
                System.out.println("Posar els partits perduts");
                pp=teclat.nextInt();
                pt=pg*3+pe*1;
                
                fw.write("\n" + Nom + ":" + pj+ ":" + pg+ ":" + pe+ ":" + pp+ ":"+pt);
                fw.close();
     }
     

     static void editarEquip() throws FileNotFoundException, IOException{
        int j=0;
        int f=0;
        boolean enrere=false;
        File fitxer = new File(carpeta);
        FileReader reader = new FileReader (fitxer);
        BufferedReader buffer = new BufferedReader (reader);
        Scanner teclat = new Scanner (System.in);
        Scanner lector;
        Scanner st = new Scanner(System.in);
        System.out.println("Quin equip vols modificar");
        Nom = teclat.nextLine();  
        for (int i=0;i<Equips.length;i++){
           if(Equips[i]!=null){
               System.out.println(Equips[i]);
               j=i;
            }if(Equips[j].equals(Nom)){
            do{
            System.out.println("Que vols canviar?");
            System.out.println("1. Puntuació");
            System.out.println("2. Nom");
            System.out.println("3. Partits Jugats");
            System.out.println("4. Partits Guanyats");
            System.out.println("5. Partits Empatats");
            System.out.println("6. Partits Perduts");
            System.out.println("s. Sortir");
            String sa = st.next();
            char opcio2 = sa.charAt(0);
            System.out.println("OPCIO: " + opcio2);
            System.out.println(Equips[j]);
             switch (opcio2) {
                case '1':  
                    if(Equips[j].equals(Nom)){
                    System.out.println("Puntuacio total");
                    Puntuacions[j]= teclat.nextInt();
                    System.out.println("L'equip: "+ Equips[j] + "  Té una nova punutació de: "+ Puntuacions[j]);
                    break;}
                case '2':  
                    if(Equips[j].equals(Nom)){
                    System.out.println("Nou Nom");
                    Equips[j]= teclat.nextLine();
                    System.out.println("El nou nom d'equip és   "+ Equips[j] + "     Punts Totals  "+ Puntuacions[j]);
                    break;}
                case '3':  
                    if(Equips[j].equals(Nom)){
                    System.out.println("Nous Partits Jugats");
                    Prj[j]= teclat.nextInt();
                    Puntuacions[j]=(Prg[j]*3+Pre[j]*1);
                    System.out.println("L'Equip: "+ Equips[j] + " Té "+ Puntuacions[j] + " Partits Jugats ");
                    break;}
                case '4':  
                    if(Equips[j].equals(Nom)){
                    System.out.println("Nous Partits Guanyats");
                    Prg[j]= teclat.nextInt();
                    Puntuacions[j]=(Prg[j]*3+Pre[j]*1);
                    Prj[j]=(Prg[j]+Pre[j]+Prp[j]);
                    System.out.println("L'Equip: "+ Equips[j] + " Té "+ Prg[j] + " Partits Guanyats, i una puntuació nova de " + Puntuacions[j] + " i amb un total de " + Prj[j] + " Partits jugats"  );
                    break;}
                case '5':  
                    if(Equips[j].equals(Nom)){
                    System.out.println("Nous Partits Empatats");
                    Pre[j]= teclat.nextInt();
                    Puntuacions[j]=(Prg[j]*3+Pre[j]*1);
                    Prj[j]=(Prg[j]+Pre[j]+Prp[j]);
                    System.out.println("L'Equip: "+ Equips[j] + " Té "+ Pre[j] + " Partits Empatats, i una puntuació nova de " + Puntuacions[j] + " i amb un total de " + Prj[j] + " Partits jugats"    );
                    break;}
                case '6':  
                    if(Equips[j].equals(Nom)){
                    System.out.println("Nous Partits Perduts");
                    Prp[j]= teclat.nextInt();
                    Puntuacions[j]=(Prg[j]*3+Pre[j]*1);
                    Prj[j]=(Prg[j]+Pre[j]+Prp[j]);
                    System.out.println("L'Equip: "+ Equips[j] + " Té "+ Prp[j] + " Partits Guanyats, i una puntuació nova de " + Puntuacions[j] + " i amb un total de " + Prj[j] + " Partits jugats"    );
                    break;}
                case 's':
                    enrere = true;
                    break;
                case 'S':
                    enrere = true;
                    break;
            }
        }while(!enrere);
        } } 
     }
     
     static void consultarComandes() throws IOException{
        Scanner teclat = new Scanner (System.in);
        Scanner lector;
        Scanner st = new Scanner(System.in);
        boolean enrere = false;
        int j=0;
        int a=0;
        int y=0;
        int min=Puntuacions[0];
        int max=Puntuacions[0];  

            if(Equips[j].equals(Nom)){
                    System.out.println("Puntuacio total");
                    Puntuacions[j]= teclat.nextInt();
                    System.out.println("Equip   "+ Equips[j] + "     Punts Totals  "+ Puntuacions[j]);
            }
        
        
         for(int i=0;i<Equips.length;i++){
            if(Equips[i]!=null){
                if(Puntuacions[i]<min){
                min=Puntuacions[i];
                a=i;
                }
            }
        }System.out.println("L'equip " + Equips[a] + " és el equip cuer amb un total de " +  Prj[a] + " Partits jugats/ "+ Prg[a]+ " Partits guanyats/ "+Pre[a]+ " Partits empatats/ "+Prp[a]+ " Partits perduts/ I amb la puntuació més baixa: "+min);
        
        for(int i=0;i<Equips.length;i++){
            if(Equips[i]!=null){
                if(Puntuacions[i]>max){
                
                max=Puntuacions[i];
                y=i;
                }
            }
        }System.out.println("L'equip " + Equips[y] + " és el equip líder amb un total de " +  Prj[y] + " Partits jugats/ "+ Prg[y]+ " Partits guanyats/ "+Pre[y]+ " Partits empatats/ "+Prp[y]+ " Partits perduts/ I amb la puntuació més alta: "+max);
    }
    
     static void guardarDades() throws IOException{
        int j=0;
        File fitxer = new File(carpeta);
        FileWriter fw = new FileWriter (fitxer);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        Scanner teclat = new Scanner (System.in);
        //BufferedWriter bw = new BufferedWriter(fw);
        //PrintWriter pw = new PrintWriter(fw);
         System.out.println("S'ha desat les DADES;");
         System.out.println("                                                -------------EQUIPS------------");
         System.out.println("Equip            Partits Jugats          Partits Guanyats        Partits Empatats                Partits Perduts           Punts Totals    ");
         System.out.println("--------     ---------------------     --------------------    --------------------            -------------------       ----------------    ");
        for (int i=0;i<Equips.length;i++){
            if(Equips[i]!=null){
	    Puntuacions[i]=(Prg[i]*3+Pre[i]*1);
            System.out.println(Equips[i]+"\t\t\t"+Prj[i]+"\t\t\t"+Prg[i]+"\t\t\t"+Pre[i]+"\t\t\t"+Prp[i]+"\t\t\t"+Puntuacions[i]);
            j=i;
            pw.println(Equips[i]+":"+Prj[i]+":"+Prg[i]+":"+Pre[i]+":"+Prp[i]+":"+Puntuacions[i]);
           }
            
        //Diem quants productes té cada proveidor
        
        }pw.close(); 
     }
}


