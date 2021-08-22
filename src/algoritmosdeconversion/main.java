/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosdeconversion;

import java.util.*;

public class main {

    public static AFtoLR al;
    public static AFtoER ae;
    public int tablatrans[][];
    public static char alfabeto[];
    public static char noTerminales[] = new char[5];
    public static String p[] = new String[10]; // lista de p que se obtienen en multiples estados finales 
    static gramaticaPila gp = new gramaticaPila();
    
    
    /////////////////// metodos e instancias solo para AP -> GRAMATICA
    
    public static LinkedList<transicionPila> transiciones = new LinkedList<transicionPila>();
    public static LinkedList<transicionPila> push = new LinkedList<transicionPila>();
    public static LinkedList<transicionPila> pop = new LinkedList<transicionPila>();
    public static LinkedList<reglas> reglasGram = new LinkedList<reglas>();
    public static int estados []=new int[100];
    public static int cantEstados=0;
    
    public static void guardarEstados(int estado,int pos){
        //buscar si ya esta guardado
        if(pos==0){
            estados[cantEstados]=estado;
            cantEstados++;
        }
        else{
            boolean band=false;
            for (int i = 0; i < estados.length; i++) {
                if(estado==estados[i]){
                    band=true;
                }

            }

            if(band==true){// ya esta guardado el estado

            }else{
                estados[cantEstados]=estado;
                cantEstados++;
            }
        }
        
    }

    //////////////////////////////////////////////////////
    
    
    
    public static void main(String[] args) {

        int opc;
        int nAlf;
        int cont1 = 0;// contador de cantidad de alfabeto
        int numEstado;
        String elementos = "";
        int cont2 = 0;// contador de cantidad de terminales

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1. AFD -> GR");
            System.out.println("2. GR  -> AFD");
            System.out.println("3. GRAMATICA -> AP");
            System.out.println("4. AP -> GRAMATICA");
            System.out.println("5. SALIR");
            System.out.println("Ingrese opcion->");
            opc = sc.nextInt();

            switch (opc) {
                case 1:

                    System.out.println("Ingrese cantidad de elementos al alfabeto");
                    nAlf = sc.nextInt();
                    String x;

                    while (cont1 < nAlf) {

                        System.out.println("Ingrese elemento " + cont1 + " :");
                        x = sc.next();
                        if (cont1 == 0) {
                            elementos = x;
                        } else {
                            elementos = elementos + x;
                        }
                        alfabeto = elementos.toCharArray();
                        cont1++;

                    }

                    System.out.println("Ingrese cantidad de estados");
                    numEstado = sc.nextInt();
                    int terminales[] = new int[numEstado];
                    char rpt;
                    int terminal;
                    do {

                        System.out.println("Ingrese estado terminal");
                        terminal = sc.nextInt();
                        terminales[cont2] = terminal;
                        System.out.println("Desea ingresar otro estado s/n : ");
                        rpt = sc.next().charAt(0);

                        cont2++;

                    } while (rpt == 's');
                    System.out.println("Alfabeto");

                    for (int i = 0; i < alfabeto.length; i++) {

                        System.out.println(alfabeto[i] + " ");
                    }

                    al.inputs(alfabeto, numEstado, terminales, cont2);

                    break;

                case 2:

                    System.out.println("Ingrese cantidad de elementos al alfabeto");
                    nAlf = sc.nextInt();

                    String y;

                    while (cont1 < nAlf) {

                        System.out.println("Ingrese elemento " + cont1 + " :");
                        y = sc.next();
                        if (cont1 == 0) {
                            elementos = y;
                        } else {
                            elementos = elementos + y;
                        }
                        alfabeto = elementos.toCharArray();
                        cont1++;

                    }

                    System.out.println("Ingrese cantidad de estados");
                    numEstado = sc.nextInt();

                    int Eterminales[] = new int[numEstado];
                    char rpta;
                    int eterminal;

                    System.out.println("Alfabeto");

                    for (int i = 0; i < alfabeto.length; i++) {

                        System.out.println(alfabeto[i] + " ");
                    }

                    int secuencia[] = new int[numEstado];

//                       secuencia[0]=0;
//                       secuencia[1]=1;
//                       secuencia[2]=2;
//                       secuencia[3]=3;
//                       secuencia[4]=4;
//                       secuencia[5]=5;
//                       secuencia[6]=6;
                    do {

                        System.out.println("Ingrese estado terminal");
                        eterminal = sc.nextInt();
                        Eterminales[cont2] = eterminal;
                        System.out.println("Desea ingresar otro estado s/n : ");
                        rpta = sc.next().charAt(0);

                        p[cont2] = ae.input(alfabeto, numEstado, eterminal, secuencia);
                        cont2++;

                    } while (rpta == 's');
                    System.out.println("---------------------------------------------");
                    System.out.println("---------------------------------------------");
                    System.out.println("---------------------------------------------");
                    for (int i = 0; i < cont2; i++) {
                        System.out.println("p" + i + "=" + p[i]);
                    }
                    System.out.println("---------------------------------------------");
                    System.out.println("---------------------------------------------");
                    System.out.println("---------------------------------------------");

                    break;

                case 3:

                    int cantNoTerminales;
                    int cont3 = 0; // contador para ingresar los no terminales

                    System.out.println("Ingrese cantidad de No terminales");
                    cantNoTerminales = sc.nextInt();

                    String NoTerminales[] = new String[cantNoTerminales];
                    String NoTerminal;

//                    NoTerminales[0] = "S";
//                    NoTerminales[1] = "A";
//                    NoTerminales[2] = "B";
//                    NoTerminales[3] = "C";
//                    NoTerminales[4] = "D";
//                    cantNoTerminales = 5;

                    while (cont1 < cantNoTerminales) {
                        System.out.println("Ingrese No terminal");
                        NoTerminal = sc.next();
                        NoTerminales[cont1] = NoTerminal;
                        cont3++;
                    }

                    String matrix[][] = new String[cantNoTerminales][100];
                    int cantDeReglasPorNoTerm[] = new int[cantNoTerminales];
                    String regla;

//                          matrix[0][0]="BAaD";
//                          matrix[0][1]="AaD";
//                          matrix[0][2]="BaD";
//                          matrix[0][3]="BAa";
//                          matrix[0][4]="aD";
//                          matrix[0][5]="Aa";
//                          matrix[0][6]="Ba";
//                          matrix[0][7]="a";
//
//                          matrix[1][0]="b";
//
//
//                          matrix[2][0]="AD";
//                          matrix[2][1]="b";
//                          matrix[2][2]="c";
//
//                          matrix[3][0]="d";
//
//
//                          matrix[4][0]="c";
//
//
//                          cantDeReglasPorNoTerm[0]=8;
//                          cantDeReglasPorNoTerm[1]=1;
//                          cantDeReglasPorNoTerm[2]=3;
//                          cantDeReglasPorNoTerm[3]=1;
//                          cantDeReglasPorNoTerm[4]=1;
                    for (int i = 0; i < cantNoTerminales; i++) {
                        char rpt1;

                        do {
                            System.out.println("Ingrese produccion");
                            System.out.println("No terminal [" + NoTerminales[i] + "] ->");
                            regla = sc.next();
                            System.out.println("la regla ingresada fue ->" + regla);
                            matrix[i][cont2] = regla;

                            System.out.println("Desea ingresar mas reglas ? [s/n]");

                            rpt1 = sc.next().charAt(0);

                            if (rpt1 == 'n') {
                                cont2++;
                                cantDeReglasPorNoTerm[i] = cont2;
                                cont2 = 0;

                            } else {
                                cont2++;
                            }

                        } while (rpt1 != 'n');

                    }
                    int cantReglas = 0;
                    // cuenta la cantidad de reglas
                    for (int i = 0; i < cantNoTerminales; i++) {
                        for (int j = 0; j < cantDeReglasPorNoTerm[i]; j++) {
                            cantReglas++;
                            System.out.print(matrix[i][j] + " | ");
                        }
                        System.out.println();
                    }

                    String reglas[] = new String[cantReglas];
                    int cont5 = 0;

                    // ingresa las reglas al array
                    for (int i = 0; i < cantNoTerminales; i++) {
                        for (int j = 0; j < cantDeReglasPorNoTerm[i]; j++) {

                            reglas[cont5] = matrix[i][j];
                            cont5++;
                            //System.out.print(matrix[i][j]+" | ");

                        }

                    }

                    Grafico.main(args, cantNoTerminales, cantDeReglasPorNoTerm, NoTerminales, matrix);

                    break;

                case 4:
                     char respuesta;
                     int i_estado,f_estado;
                     String lee,apila,desapila;

                        do {
                            
                            System.out.println("---------------------------------------------");
                            System.out.println("---------------------------------------------");
                            System.out.println("Ingrese estado origen");
                            i_estado=sc.nextInt();
                            guardarEstados(i_estado, cantEstados);
                            System.out.println("Elemento a leer");
                            lee=sc.next();
                            System.out.println("Desapilar");
                            desapila=sc.next();
                            System.out.println("Ingrese estado destino");
                            f_estado=sc.nextInt();
                            guardarEstados(f_estado, cantEstados);
                            System.out.println("Apilar");
                            apila=sc.next();
                            
                            System.out.println("Desea ingresar mas reglas ? [s/n]");

                            respuesta = sc.next().charAt(0);
                            transicionPila tp = new transicionPila(i_estado,lee,desapila,f_estado,apila);
                            transiciones.add(tp);
                        } while (respuesta != 'n');
                        
                    
                    
                        System.out.println("cantidad en el array "+transiciones.size());
                        for (int i = 0; i < transiciones.size(); i++) {
                            System.out.print("&("+transiciones.get(i).getI_estado()+",");
                            System.out.print(transiciones.get(i).getLee()+",");
                            System.out.print(transiciones.get(i).getDesApila()+")");
                            System.out.print("=("+transiciones.get(i).getF_estado());
                            System.out.print(","+transiciones.get(i).getApila()+")");
                            System.out.println("");

                            // comprobamos quien se va a la lista de push y pop
                            if(transiciones.get(i).getApila().equals("$")){
                                pop.add(transiciones.get(i));
                            }
                            else{
                                push.add(transiciones.get(i));
                            }
                        }
                        System.out.println("---------------------------------------------");
                        System.out.println("---------------------------------------------");
                        System.out.println("LISTA PARA PUSH");
                        for (int i = 0; i < push.size(); i++) {
                            System.out.print("&("+push.get(i).getI_estado()+",");
                            System.out.print(push.get(i).getLee()+",");
                            System.out.print(push.get(i).getDesApila()+")");
                            System.out.print("=("+push.get(i).getF_estado());
                            System.out.print(","+push.get(i).getApila()+")");
                            System.out.println("");

                        }
                        System.out.println("---------------------------------------------");
                        System.out.println("LISTA PARA POP");
                        for (int i = 0; i < pop.size(); i++) {
                            System.out.print("&("+pop.get(i).getI_estado()+",");
                            System.out.print(pop.get(i).getLee()+",");
                            System.out.print(pop.get(i).getDesApila()+")");
                            System.out.print("=("+pop.get(i).getF_estado());
                            System.out.print(","+pop.get(i).getApila()+")");
                            System.out.println("");

                        }
                    
                    System.out.println("----------------PASO 1-------------------------");
                    /// paso 1 la gramatica 
                    System.out.println("V={S");    
                    // para el QXQ    
                      for (int i = 0; i < cantEstados; i++) {
                          for (int j = 0; j < cantEstados; j++) {
                              System.out.print("[Q"+estados[i]+"XQ"+estados[j]+"],");
                          }
                     }
                      
                      // para el QZQ    
                      for (int i = 0; i < cantEstados; i++) {
                          for (int j = 0; j < cantEstados; j++) {
                              System.out.print("[Q"+estados[i]+"XZ"+estados[j]+"],");
                          }
                     } 
                    System.out.println("}");
                    
                     
 
                    System.out.println("----------------PASO 2-------------------------");
                    System.out.println("A) S ----------------------------------------");
                    // Regla de S
                    String r; // regla
                    for (int i = 0; i <cantEstados; i++) {
                        reglasGram.add(new reglas("S","[Q0ZQ"+i+"]"));
                        System.out.println("S->"+"[Q0ZQ"+i+"]");
                    }
                    System.out.println("B) POP  ------------------------------------------");
                    // Reglas POP
                    for (int i = 0; i < pop.size(); i++) {
                        reglasGram.add(new reglas("[Q"+pop.get(i).getI_estado()+pop.get(i).getDesApila()+"Q"+
                                pop.get(i).f_estado+"]",pop.get(i).lee));
                     }
                    System.out.println("B) PUSH  ----------------------------------------");
                    String X,Y;
                    int cantXY;// cantidad de x,y por apilacion
                    for (int i = 0; i < push.size(); i++) {
                        cantXY=push.get(i).getApila().length();
                        char element[]=push.get(i).getApila().toCharArray();
                         
                        if(cantXY==1){ // si el contenido a apilar es igual a 1
                            for (int j = 0; j < cantEstados; j++) {
                                reglasGram.add(new reglas("["+push.get(i).getI_estado()+element[0]+estados[j]+"]","["
                                +push.get(i).getF_estado()+element[0]+estados[j]+"]"));
                            }
                        }
                        else{
                            
                            for (int k = 0; k < cantEstados; k++) {
                              String x1="["+push.get(i).getI_estado()+push.get(i).getDesApila()+estados[k]+"]";
                                for (int j = 0; j < cantEstados; j++) {
                                     reglasGram.add(new reglas(x1,
                                             push.get(i).getLee()+"[Q"+push.get(i).getF_estado()+element[0]+"Q"+estados[j]+"]"+"[Q"+estados[j]+
                                                     element[1]+"Q"+estados[k]+"]"));
                                }
                              
                            }
                            
                        }
                            
                        
                        
                    }
                    
                    
                    
                    
                    System.out.println("-------------------- GRAMATICA--------------------");
                    System.out.println("---------------------------------------------");
                    for (int i = 0; i < reglasGram.size(); i++) {
                        System.out.println(reglasGram.get(i).getX()+"->"+reglasGram.get(i).getY());
                     }
                    System.out.println("--------------------FIN--------------------");
                    System.out.println("---------------------------------------------");
                    break;
                    
                    

            }

        } while (opc != 5);

    }

}
