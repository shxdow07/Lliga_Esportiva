
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
    static int contadorEquips=0;
    static int contadorPuntuacions=0;
    static int pj;
    static int pg;
    static int pe;
    static int pp;
    static int pt;
    public static String [] Equips= new String[1000];
    public static int [][] Puntuacions= new int[100][100];
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
                System.out.print(Equips[contadorEquips++]=sl.next());
                System.out.print("\t\t\t");
                System.out.print(Puntuacions[contadorPuntuacions][1]=sl.nextInt());
                System.out.print("\t\t\t");
                System.out.print(Puntuacions[contadorPuntuacions][2]=sl.nextInt());
                System.out.print("\t\t\t");
                System.out.print(Puntuacions[contadorPuntuacions][3]=sl.nextInt());
                System.out.print("\t\t\t\t");
                System.out.print(Puntuacions[contadorPuntuacions][4]=sl.nextInt());
                System.out.print("\t\t\t");
                System.out.println(Puntuacions[contadorPuntuacions][5]=sl.nextInt());
                contadorPuntuacions++;
                
        }
  
        }catch (FileNotFoundException e) {
			e.printStackTrace();
		}
                
    }
     static void visualitzarequips() throws FileNotFoundException{
        File fitxer = new File(carpeta);
        FileReader reader = new FileReader (fitxer);
        BufferedReader buffer = new BufferedReader (reader);
        System.out.println("-------------PUNTUACIONS------------");
        System.out.println("Equip            Partits Jugats          Partits Guanyats        Partits Empatats                Partits Perduts           Punts Totals    ");
        System.out.println("--------     ---------------------     --------------------    --------------------            -------------------       ----------------    ");
        for (int i=0;i<Equips.length;i++){
            if(Equips[i]!=null){
             System.out.println("" + Equips[i] + "\t\t\t" + Puntuacions[i][1]+ "\t\t\t" + Puntuacions[i][2]+ "\t\t\t" + Puntuacions[i][3]+ "\t\t\t" + Puntuacions[i][4]+ "\t\t\t" + Puntuacions[i][5]);
           }
        //Diem quants productes té cada proveidor
        
        }
    }
     
     static void afegirequip() throws FileNotFoundException, IOException{
        int y=0;
        File fitxer = new File(carpeta);
        FileWriter fw = new FileWriter (fitxer, true);
        Scanner teclat = new Scanner (System.in);
            for (int i=contadorEquips;i<Equips.length;i++){
                if(Equips[i]==null){
                System.out.println(Equips[i]);
                y=i;
                System.out.println("Posar el nom de l'equip");
                Nom=teclat.nextLine();
                Equips[y]=Nom;
                System.out.println("Posar els partits jugats");
                pj=teclat.nextInt();
                Puntuacions[i][1]=pj;
                System.out.println("Posar els partits guanyats");
                pg=teclat.nextInt();
                Puntuacions[i][2]=pg;
                System.out.println("Posar els partits empatas");
                pe=teclat.nextInt();
                Puntuacions[i][3]=pe;
                System.out.println("Posar els partits perduts");
                pp=teclat.nextInt();
                Puntuacions[i][4]=pp;
                pt=pg*3+pe*1;
                Puntuacions[i][5]=pt;
                fw.write(Equips[i]+":"+Puntuacions[i][1]+":"+Puntuacions[i][2]+":"+Puntuacions[i][3]+":"+Puntuacions[i][4]+":"+Puntuacions[i][5]+"\n");
                fw.close();
                break;
           }           
        }       
     }

     static void editarEquip() throws FileNotFoundException, IOException{
        int y=0;
        File fitxer = new File(carpeta);
        FileReader reader = new FileReader (fitxer);
        BufferedReader buffer = new BufferedReader (reader);
        Scanner teclat = new Scanner (System.in);
        
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
                    Puntuacions[i][5]= teclat.nextInt();
                    System.out.println("L'equip: "+ Equips[y] + "  Té una nova punutació de: "+ Puntuacions[i][5]);
                    break;}
                case '2':  
                    if(Equips[y].equals(Nom)){
                    System.out.println("Nou Nom");
                    Equips[y]= teclat.nextLine();
                    System.out.println("El nou nom d'equip és   "+ Equips[y] + "     Punts Totals  "+ Puntuacions[i][5]);
                    break;}
                case '3':  
                    if(Equips[y].equals(Nom)){
                    System.out.println("Nous Partits Jugats");
                    Puntuacions[i][1]= teclat.nextInt();
                    Puntuacions[i][5]=(Puntuacions[i][2]*3+Puntuacions[i][3]*1);
                    System.out.println("L'Equip: "+ Equips[y] + " Té "+ Puntuacions[i][1] + " Partits Jugats ");
                    break;}
                case '4':  
                    if(Equips[y].equals(Nom)){
                    System.out.println("Nous Partits Guanyats");
                    Puntuacions[i][2]= teclat.nextInt();
                    Puntuacions[i][5]=(Puntuacions[i][2]*3+Puntuacions[i][3]*1);
                    Puntuacions[i][1]=(Puntuacions[i][2]+Puntuacions[i][3]+Puntuacions[i][4]);
                    System.out.println("L'Equip: "+ Equips[y] + " Té "+ Puntuacions[i][2] + " Partits Guanyats, i una puntuació nova de " + Puntuacions[i][5] + " i amb un total de " + Puntuacions[i][1] + " Partits jugats"  );
                    break;}
                case '5':  
                    if(Equips[y].equals(Nom)){
                    System.out.println("Nous Partits Empatats");
                    Puntuacions[i][3]= teclat.nextInt();
                    Puntuacions[i][5]=(Puntuacions[i][2]*3+Puntuacions[i][3]*1);
                    Puntuacions[i][1]=(Puntuacions[i][2]+Puntuacions[i][3]+Puntuacions[i][4]);
                    System.out.println("L'Equip: "+ Equips[y] + " Té "+ Puntuacions[i][3] + " Partits Empatats, i una puntuació nova de " + Puntuacions[i][5] + " i amb un total de " + Puntuacions[i][1] + " Partits jugats"    );
                    break;}
                case '6':  
                    if(Equips[y].equals(Nom)){
                    System.out.println("Nous Partits Perduts");
                    Puntuacions[i][4]= teclat.nextInt();
                    Puntuacions[i][5]=(Puntuacions[i][2]*3+Puntuacions[i][3]*1);
                    Puntuacions[i][1]=(Puntuacions[i][2]+Puntuacions[i][3]+Puntuacions[i][4]);
                    System.out.println("L'Equip: "+ Equips[y] + " Té "+ Puntuacions[i][4] + " Partits Perduts, i una puntuació nova de " + Puntuacions[i][5]+ " i amb un total de " + Puntuacions[i][1] + " Partits jugats"    );
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
        int a=0;
        int y=0;
        int min=Puntuacions[a][5];
        int max=Puntuacions[y][0];
        for(int i=0;i<Equips.length;i++){
            
            if(Equips[i]!=null){
                if(Puntuacions[i][5]<min){
                min=Puntuacions[i][5];
                a=i;
                }
            }
        }System.out.println("L'equip " + Equips[a] + " és el equip cuer amb un total de " +  Puntuacions[a][1] + " Partits jugats/ "+ Puntuacions[a][2]+ " Partits guanyats/ "+Puntuacions[a][3]+ " Partits empatats/ "+Puntuacions[a][4]+ " Partits perduts/ I amb la puntuació més baixa: "+min);
        
        for(int i=0;i<Equips.length;i++){
            if(Equips[i]!=null){
                if(Puntuacions[i][5]>max){
                max=Puntuacions[i][5];
                y=i;
                }
            }
        }System.out.println("L'equip " + Equips[y] + " és el equip líder amb un total de " + Puntuacions[a][1] + " Partits jugats/ "+ Puntuacions[a][2]+ " Partits guanyats/ "+Puntuacions[a][3]+ " Partits empatats/ "+Puntuacions[a][4]+ " Partits perduts/ I amb la puntuació més alta: "+max);
    }
    
     static void guardarDades() throws IOException{
        int j=0;
        File fitxer = new File(carpeta);
        FileWriter fw = new FileWriter (fitxer);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        Scanner teclat = new Scanner (System.in);
         System.out.println("S'han desat les DADES;");
         System.out.println("                                                -------------EQUIPS------------");
         System.out.println("Equip            Partits Jugats          Partits Guanyats        Partits Empatats                Partits Perduts           Punts Totals    ");
         System.out.println("--------     ---------------------     --------------------    --------------------            -------------------       ----------------    ");
        for (int i=0;i<Equips.length;i++){
            if(Equips[i]!=null){
            Puntuacions[i][5]=(Puntuacions[i][2]*3+Puntuacions[i][3]*1);
                    Puntuacions[i][1]=(Puntuacions[i][2]+Puntuacions[i][3]+Puntuacions[i][4]);
            System.out.println(Equips[i]+"\t\t\t"+Puntuacions[i][1]+"\t\t\t"+Puntuacions[i][2]+"\t\t\t"+Puntuacions[i][3]+"\t\t\t\t"+Puntuacions[i][4]+"\t\t\t"+Puntuacions[i][5]);
            pw.println(Equips[i]+":"+Puntuacions[i][1]+":"+Puntuacions[i][2]+":"+Puntuacions[i][3]+":"+Puntuacions[i][4]+":"+Puntuacions[i][5]);
           }

        }pw.close();
        exit=true;
     }
}

