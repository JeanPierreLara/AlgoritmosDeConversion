/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosdeconversion;

import static algoritmosdeconversion.AFtoLR.sc;
import static algoritmosdeconversion.AFtoLR.tabla;

/**
 *
 * @author jean
 */
public class AFtoER {
    static public int tabla[][]=new int[100][100];
    public static int cantidadTrapStates=0;//cantidad trapsatate
    static public int[] TrapStates=new int[10];// estados eliminados
    static public int[] AEliminar=new int[20];
    public static int cantidadEliminar=0;//cantidad de estados a eliminar
    
    
    public static boolean buscar(int dato){
        boolean band=false;
        for (int i = 0; i < cantidadTrapStates; i++) {
            if(dato==TrapStates[i]){
                band=true;
            }
            
        }
        return band;
    }
    
    public static boolean buscarTS(int dato,int TrapStates[],int cantidadTrapStates){
        boolean band=false;
        for (int i = 0; i < cantidadTrapStates; i++) {
            if(dato==TrapStates[i]){
                band=true;
            }
            
        }
        return band;
    }
    
    public static boolean buscarEstadosFinales(int dato,int finales[],int cantTerminales){
        boolean band=false;
        for (int i = 0; i < cantTerminales; i++) {
            if(dato==finales[i]){

                band=true;
            }
            
        }
        return band;
    }
    
    public static boolean buscarEliminar(int dato){
        boolean band=false;
        for (int i = 0; i < cantidadEliminar; i++) {
            if(dato==AEliminar[i]){
                band=true;
            }
            
        }
        return band;
    }

    public static boolean buscarEliminado(int eliminados[],int cantidad,int dato){
        boolean band=false;
        for (int i = 0; i < cantidad; i++) {
        //    System.out.println("dato buscado "+eliminados[i]);
            if(dato==eliminados[i]){
                band=true;
            }
            
        }
        return band;
    }
    
    public static String  input(char alf[],int estados,int Efinal,int secuenciaEliminar[]){
       String rpt="";
       int[] Eliminados=new int[estados];
       String [] ps= new String[10];// lista de p con cantidad fija
       int  numP=0;//indice para los p  
        int estadosEliminados=0;
        boolean band=false;
//        for(int i=0;i<estados;i++){
//            for(int j=0;j<alf.length;j++){
//                System.out.println("Estado["+i+"]"+"Transicion["+alf[j]+"] ->");
//                int toEstate=sc.nextInt();
//                tabla[i][j]=toEstate;
//            }
//          }
//        tabla[0][0]=4;
//        tabla[0][1]=1;
//        
//        tabla[1][0]=3;
//        tabla[1][1]=2;
//        
//        tabla[2][0]=2;
//        tabla[2][1]=2;
//        
//        tabla[3][0]=1;
//        tabla[3][1]=2;
//        
//        tabla[4][0]=0;
//        tabla[4][1]=3;
//        


//          tabla[0][0]=0;
//          tabla[0][1]=1;
//          
//          tabla[1][0]=0;
//          tabla[1][1]=2;
//          
//          tabla[2][0]=-1;
//          tabla[2][1]=2;

//// examen

        tabla[0][0]=1;
        tabla[0][1]=6;
        
        tabla[1][0]=6;
        tabla[1][1]=2;
        
        tabla[2][0]=3;
        tabla[2][1]=4;
        
        tabla[3][0]=3;
        tabla[3][1]=5;
        
        tabla[4][0]=3;
        tabla[4][1]=4;
        
        tabla[5][0]=3;
        tabla[5][1]=4;
        
        tabla[6][0]=6;
        tabla[6][1]=6;

        int limite=secuenciaEliminar.length;
        deleteTrapSatate(estados,alf.length,alf,Efinal);
        
        limite=limite-cantidadTrapStates;
        for(int i=0;i<cantidadTrapStates;i++){
         
                System.out.println("Estado borrado="+TrapStates[i]);
                
            }
        
        
        for (int i = 0; i <cantidadTrapStates; i++) {
            Eliminados[i]=TrapStates[i];
            estadosEliminados++;
        }
        System.out.println("Quedan solo :"+limite+" estados");
        System.out.println("------------------------"); 
                        
                        
        String tablaProc[][]=new String[estados][estados];
        
        
        for(int i=0;i<estados;i++){
            for(int j=0;j<estados;j++){
                tablaProc[i][j]="$";
            }
        }
        
        for(int i=0;i<estados;i++){
            for(int j=0;j<alf.length;j++){
                if(tabla[i][j]!=-1){
                   
                   tablaProc[i][tabla[i][j]]=Character.toString(alf[j]);
                   
                }
                
                
            }
          }
        
    System.out.println("-----------------------------------------");
        for(int i=0;i<estados;i++){
            for(int j=0;j<estados;j++){
               
                    if(buscar(i)==false && buscar(j)==false) {
                        System.out.println("estado "+i+" estado "+j+" "+tablaProc[i][j]);
                    }
 
            }
        }
    System.out.println("-----------------------------------------");
    System.out.println("Quedan solo :"+limite+" estados");
     System.out.println("------------------------"); 
   
    AEliminar=secuenciaEliminar;
    cantidadEliminar=secuenciaEliminar.length;
        
    for(int m = 0; m < cantidadEliminar; m++) {
            System.out.println(AEliminar[m]);
        }    
//    
//        for(int m = 0; m < limite; m++) {
//            if(buscar(secuenciaEliminar[m])==false){
//                Eliminar[siguiente]=secuenciaEliminar[m];
//                siguiente++;
//            }
//           
//        }
//        do{
//            if(buscar(secuenciaEliminar[cont])==false){
//                Eliminar[siguiente]=secuenciaEliminar[cont];
//                siguiente++;
//                cont++;
//            }
//        }while(cont<limite);


        for(int m = 0; m < secuenciaEliminar.length; m++) {
            
            if(limite==2){
                
               
                for(int x=1;x<estados;x++){
                        if((buscarEliminado(Eliminados,estadosEliminados,x)==false) ) {
                             System.out.println("LA ER ES : "+ResultadoFinal(tablaProc,0,x));
                             rpt=ResultadoFinal(tablaProc,0,x);
                             x=1000; 
                           }
                              
                     }
                //System.out.println("LA ER ES : "+ResultadoFinal(tablaProc, m, m));
                cantidadTrapStates=0;
                
            }
            else{
                System.out.println("ELIMINANDO ESTADO "+AEliminar[m]+"...");
                if(AEliminar[m]==0 ){ // si el estado es igual a 0 y es diferente a estado final
                    System.out.println("NO SE PUEDE ELIMINAR ESTADO ["+AEliminar[m]+"] POR ESTADO INICIAL");
                }
                else{
                    if(buscar(AEliminar[m])==true){ // si el estado esta en la lista de trapstate
                        System.out.println("ESTADO ["+AEliminar[m]+"] YA ELIMINADO POR ST");
                        Eliminados[estadosEliminados]=AEliminar[m];
                        
                       // limite--;
                        System.out.println("Quedan solo :"+limite+" estados");
                        System.out.println("------------------------"); 
                        
                        estadosEliminados++;
                    }
                    else{
                       /////////////////////////////////////////////////////////
//                       if(buscarEstadosFinales(AEliminar[m],finales)==true){
//                           // eliminar estado final
//                           System.out.println("El estado "+AEliminar[m]+" es terminal!!!!!!!! ");
//                           if(AEliminar[m]==0){
//                               ps[numP]="("+tablaProc[0][0]+")*";
//                               
//                               for (int i = 0; i < finales.length; i++) {
//                                   if(finales[i]==AEliminar[m]){
//                                       finales[i]=-1;// estado final eliminado
//                                   }
//                               }
//                               
//                               numP++;
//                           }else{
//                               
//                               // limpiar estado final
//                               // funcion copia tabla 
//                               // obtener p 
//                               numP++;
//                           }
//                           
//                           band=true;
//                       }
                       
                       if((AEliminar[m]!=Efinal)){ // si no se encontro un estado final analizar la secuencia sin buscar p
                           System.out.println("-----------------------------------------");
                           System.out.println("ESTADO "+AEliminar[m]);
                            for (int i = 0; i < estados; i++) {
                                for (int j = 0; j < estados; j++) {

                                    if((buscarEliminado(Eliminados,estadosEliminados,i)==false) && (buscarEliminado(Eliminados,estadosEliminados,j)==false)){
                                        
//                                        if((buscarEstadosFinales(j, finales,cantTerminales)==false)&&(buscarEstadosFinales(i, finales,cantTerminales)==false )){
                                            if(Comprobar(tablaProc,i,j,AEliminar[m])==true ){ // comparacion de saltos
                                                System.out.println("DEL ["+i+","+j+"]");
                                                // corregir tabla
                                                CorregirTabla(tablaProc,i,j,AEliminar[m]); 
                                            
                                               
                                        }
                                                                          
                                            
                                    }
                                    
                                }
                            }
                            Eliminados[estadosEliminados]=AEliminar[m];
                            estadosEliminados++;
                            System.out.println("---------TABLA-------");
                            
                            for(int x=0;x<estados;x++){
                               for(int y=0;y<estados;y++){

                                     if((buscarEliminado(Eliminados,estadosEliminados,x)==false) && (buscarEliminado(Eliminados,estadosEliminados,y)==false)) {
                                          
                                        // if((buscarEstadosFinales(x, finales)==false) && (buscarEstadosFinales(y, finales)==false) ){
                                             System.out.println("estado "+x+" estado "+y+" "+tablaProc[x][y]);
                                        // }
                                         
                                         
                                       }
                                       
                                   }
                             }
                           
                            limite--;
                            System.out.println("Quedan solo :"+limite+" estados");
                            System.out.println("------------------------"); 
                       }
                       else{
                           System.out.println("ESTADO "+ AEliminar[m]+" NO SE PUEDE ELIMINAR...."); 
                       }
                       
                      
                            
                     
                    }
                }
            }
        }   
        
        System.out.println("secuencia que se elimino");
        for (int i = 0; i < estadosEliminados; i++) {
            System.out.print(Eliminados[i]+"-");
        }
        System.out.println("");
       
        return rpt;
    }
    
    public static void deleteTrapSatate(int estados,int nalf,char alf[],int Efinal ){
        boolean band=false;
        
        for(int i=0;i<estados;i++){
            for(int j=0;j<nalf;j++){
                System.out.println("Estado "+i+", transicion "+alf[j]+"->"+tabla[i][j]);
                
            }
        }
        
        for(int i=0;i<estados;i++){
            for(int j=0;j<nalf;j++){
                
               if(j!=0){
                   for(int k=0;k<j;k++){
                       System.out.println("Ejecuta la comparacion actual"+tabla[i][j]+" anterior"+tabla[i][k] );
                        if((tabla[i][j]==tabla[i][k])&&(k!=j)){ // si todos los elementos del alf te llevan al mismo
                            band=true;
                        }
                        else{
                            if(tabla[i][k]==-1){
                                band=true;
                            }
                            else{
                                band=false;
                                break;
                            }
                        }

                        
                        
                   }
                 if(band==true){
                            
                            if(i!=Efinal){
                                System.out.println("Estado "+i+" es trap state");
                                TrapStates[cantidadTrapStates]=i;
                                cantidadTrapStates++;
                                band=false;
                            }else{
                                System.out.println("Estado "+i+" es trap state, pero no se puede eliminar porque es estado final");
                            }
                        
                            
                             
                        }
               }
            }
          }
        
         System.out.println("cantidad eliminados"+cantidadTrapStates);
        
            for(int i=0;i<cantidadTrapStates;i++){
         
                System.out.println("Estado borrado="+TrapStates[i]);
                
            }
        
    }

    
   
    
    public static boolean Comprobar(String tabla[][],int a, int b,int c){
        boolean band=false;
        if((c!=b)&&(a!=c)){
            
            if(tabla[a][c]!="$" && tabla[c][b]!="$"){
                band=true;
             }
             else{
                 band=false;
             }
            
        }
        
        return band;
    }
    
    public static void CorregirTabla(String tabla[][],int a, int b,int c){
        String s,r1,r2,r3;
        String resultado;
        String sumando2;
        
        s=tabla[a][b];
        r1=tabla[a][c];
        r2=tabla[c][c];
        r3=tabla[c][b];
        
        if(r2!="$"){
            sumando2=r1+"("+r2+"*)"+r3;
        }
        else{
            sumando2=r1+r3;
        }
        
        if(s!="$"){
            resultado=s+"+"+sumando2;
        }
        else{
            resultado=sumando2;
        }
            
        tabla[a][b]=resultado;
        resultado="";
    }
    
    public static String ResultadoFinal(String tabla[][],int a, int b){
        String w,x,y,z;
        String resultado;
        String sumando2;
        
        w=tabla[a][a];
        x=tabla[a][b];
        y=tabla[b][b];
        z=tabla[b][a];
        
     
      resultado="("+w+")*("+x+")(("+y+")"+"+"+z+"("+w+")*"+"("+x+"))*";
      
      return resultado;
      
    }
    
    
  
}
