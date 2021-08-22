/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosdeconversion;

import java.util.*;

public class AFtoLR {
    
    static Scanner sc= new Scanner(System.in);
    public static char noTerminales[]=new char[5];
    
    static public int tabla[][]=new int[100][100];
    
    public static void inputs(char alf[],int estados,int finales[],int cantTerminales){
        int toEstate;
        
        for(int i=0;i<estados;i++){
            for(int j=0;j<alf.length;j++){
                System.out.println("Estado["+i+"]"+"Transicion["+alf[j]+"] ->");
                toEstate=sc.nextInt();
                tabla[i][j]=toEstate;
            }
        }
        int cantAlf=alf.length;
        start(estados,cantAlf,alf,cantTerminales,finales);
    }
    
    public static void start(int estados,int cantAlfabeto,char alf[],int estadosfinales,int finales[]){
        
        
    }
}
