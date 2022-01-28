
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
    static boolean enrere=false;
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
                System.out.print(Puntuacions[contadorEquips++]=sl.nextInt());
                System.out.print("\t\t\t");
                System.out.print(Puntuacions[contadorEquips++]=sl.nextInt());
                System.out.print("\t\t\t");
                System.out.print(Puntuacions[contadorEquips++]=sl.nextInt());
                System.out.print("\t\t\t\t");
                System.out.print(Puntuacions[contadorEquips++]=sl.nextInt());
                System.out.print("\t\t\t");
                System.out.println(numero=sl.nextInt());
                resultat=resultat+numero;
                Puntuacions[contadorEquips++]=numero;
                contadorPuntuacions=resultat;    
                contadorEquips++;
                
        }
  
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
        System.out.println("Equip            Partits Jugats          Partits Guanyats        Partits Empatats                Partits Perduts           Punts Totals    ");
        System.out.println("--------     ---------------------     --------------------    --------------------            -------------------       ----------------    ");
        for (int i=0;i<Equips.length;i++){
            if(Equips[i]!=null){
             int y=i;
             Puntuacions[y+4]=(Puntuacions[y+1]*3+Puntuacions[y+2]*1);
            Puntuacions[y]=(Puntuacions[y+1]+Puntuacions[y+2]+Puntuacions[y+3]);
             System.out.println("" + Equips[i]+"\t\t\t" + Puntuacions[y]+"\t\t\t" + Puntuacions[y+1]+"\t\t\t" + Puntuacions[y+2]+"\t\t\t" + Puntuacions[y+3]+"\t\t\t" + Puntuacions[y+4]);
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
         int a=0;
        int y=0;
        File fitxer = new File(carpeta);
        FileReader reader = new FileReader (fitxer);
        BufferedReader buffer = new BufferedReader (reader);
        Scanner teclat = new Scanner (System.in);
        Scanner lector;
        
        System.out.println("Quin equip vols modificar");
        Nom = teclat.nextLine();  
        for (int i=0;i<Equips.length;i++){
           if(Equips[i]!=null){
               y=i;
            }if(Equips[y].equals(Nom)){
            do{
             System.out.println("Que vols canviar?");
            System.out.println("1. Puntuació");
            System.out.println("2. Nom");
            System.out.println("3. Partits Jugats");
            System.out.println("4. Partits Guanyats");
            System.out.println("5. Partits Empatats");
            System.out.println("6. Partits Perduts");
            System.out.println("s. Sortir");
            Scanner st = new Scanner(System.in);
            String sa = st.next();
            char opcio = sa.charAt(0);
            System.out.println("OPCIO: " + opcio);
             switch (opcio) {
                case '1':  
                    if(Equips[y].equals(Nom)){
                    System.out.println("Puntuació total");
                    Puntuacions[y+1]= teclat.nextInt();
                    System.out.println("L'equip: "+ Equips[y] + "  Té una nova punutació de: "+ Puntuacions[y+4]);
                    break;}
                case '2':  
                    if(Equips[y].equals(Nom)){
                    System.out.println("Nou Nom");
                    Equips[y]= teclat.nextLine();
                    System.out.println("El nou nom d'equip és   "+ Equips[y] + "     Punts Totals  "+ Puntuacions[y+4]);
                    break;}
                case '3':  
                    if(Equips[y].equals(Nom)){
                    System.out.println("Nous Partits Jugats");
                    Puntuacions[y]= teclat.nextInt();
                    Puntuacions[y+4]=(Puntuacions[y+1]*3+Puntuacions[y+2]*1);
                    System.out.println("L'Equip: "+ Equips[y] + " Té "+ Puntuacions[y] + " Partits Jugats ");
                    break;}
                case '4':  
                    if(Equips[y].equals(Nom)){
                    System.out.println("Nous Partits Guanyats");
                    Puntuacions[y+1]= teclat.nextInt();
                    Puntuacions[y+4]=(Puntuacions[y+1]*3+Puntuacions[y+2]*1);
                    Puntuacions[y]=(Puntuacions[y+1]+Puntuacions[y+2]+Puntuacions[y+3]);
                    System.out.println("L'Equip: "+ Equips[y] + " Té "+ Puntuacions[y+1] + " Partits Guanyats, i una puntuació nova de " + Puntuacions[y+4] + " i amb un total de " + Puntuacions[y] + " Partits jugats"  );
                    break;}
                case '5':  
                    if(Equips[y].equals(Nom)){
                    System.out.println("Nous Partits Empatats");
                    Puntuacions[y+2]= teclat.nextInt();
                    Puntuacions[y+4]=(Puntuacions[y+1]*3+Puntuacions[y+2]*1);
                    Puntuacions[y]=(Puntuacions[y+1]+Puntuacions[y+2]+Puntuacions[y+3]);
                    System.out.println("L'Equip: "+ Equips[y] + " Té "+ Puntuacions[y+2] + " Partits Empatats, i una puntuació nova de " + Puntuacions[y+4] + " i amb un total de " + Puntuacions[y] + " Partits jugats"    );
                    break;}
                case '6':  
                    if(Equips[y].equals(Nom)){
                    System.out.println("Nous Partits Perduts");
                    Puntuacions[y+3]= teclat.nextInt();
                    Puntuacions[y+4]=(Puntuacions[y+1]*3+Puntuacions[y+2]*1);
                    Puntuacions[y]=(Puntuacions[y+1]+Puntuacions[y+2]+Puntuacions[y+3]);
                    System.out.println("L'Equip: "+ Equips[y] + " Té "+ Puntuacions[y+3] + " Partits Perduts, i una puntuació nova de " + Puntuacions[y+4] + " i amb un total de " + Puntuacions[y] + " Partits jugats"    );
                    break;}
                case 's':
                    y=y+6;
                    enrere = true;
                    break;
                case 'S':
                    y=y+6;
                    enrere = true;
                    break;
            }
            }while(!enrere);
            } 
        } 
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

         for(int i=0;i<Equips.length;i++){
            if(Equips[i]!=null){
                if(Puntuacions[i+4]<min){
                min=Puntuacions[i+4];
                a=i;
                }
            }
        }System.out.println("L'equip " + Equips[a] + " és el equip cuer amb un total de " +  Puntuacions[a] + " Partits jugats/ "+ Puntuacions[a+1]+ " Partits guanyats/ "+Puntuacions[a+2]+ " Partits empatats/ "+Puntuacions[a+3]+ " Partits perduts/ I amb la puntuació més baixa: "+min);
        
        for(int i=0;i<Equips.length;i++){
            if(Equips[i]!=null){
                if(Puntuacions[i+4]>max){
                
                max=Puntuacions[i+4];
                y=i;
                }
            }
        }System.out.println("L'equip " + Equips[y] + " és el equip líder amb un total de " +  Puntuacions[y] + " Partits jugats/ "+ Puntuacions[y+1]+ " Partits guanyats/ "+Puntuacions[y+2]+ " Partits empatats/ "+Puntuacions[y+3]+ " Partits perduts/ I amb la puntuació més alta: "+max);
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
            Puntuacions[i+4]=(Puntuacions[i+1]*3+Puntuacions[i+2]*1);
            Puntuacions[i]=(Puntuacions[i+1]+Puntuacions[i+2]+Puntuacions[i+3]);
            System.out.println(Equips[i]+"\t\t\t"+Puntuacions[i]+"\t\t\t"+Puntuacions[i+1]+"\t\t\t"+Puntuacions[i+2]+"\t\t\t\t"+Puntuacions[i+3]+"\t\t\t"+Puntuacions[i+4]);
            j=i;
            pw.println(Equips[i]+":"+Puntuacions[i]+":"+Puntuacions[i+1]+":"+Puntuacions[i+2]+":"+Puntuacions[i+3]+":"+Puntuacions[i+4]);
           }
            
        //Diem quants productes té cada proveidor
        
        }pw.close(); 
     }
}


