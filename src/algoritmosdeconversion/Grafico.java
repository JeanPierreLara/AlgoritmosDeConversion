/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosdeconversion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Grafico extends JFrame {

    private JPanel contentPane;
     public static String posiblesterm[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z","(",")"};
    /**
     * Launch the application.
     */
    public static JTextArea trans1 = new JTextArea();
    public static JTextArea trans2 = new JTextArea();
    public static String terminales[]=new String[20];
    public static int cantTerminales=0;
    
    public static boolean BuscarEnTerminales(String x){ // busca si es no terminal
        boolean band=false;
        for(int i = 0; i < 27; i++) {
            if(posiblesterm[i].equals(x)){
                band=true;
            }
        }
        return band;
    }
    
    
    public static void GuardarTerminales(String term){
        boolean band=false;
        if(cantTerminales==0){
            terminales[cantTerminales]=term;
            cantTerminales++;
            band=true;
        }else{
            for (int i = 0; i < cantTerminales; i++) {
            if(terminales[i].equals(term)){
                band=true;
              }
            }
        }
        
        if(band!=true){
            terminales[cantTerminales]=term;
            cantTerminales++;
        }
        
       
    }
    
    public Grafico() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setBounds(0,0,800,600);
        
//        JTextField etiqueta1 = new JTextField();
//        etiqueta1.setText("Q1");
//        etiqueta1.setLocation(new Point(1,1)); 
//        etiqueta1.setBounds(245,280,100, 25);
//        this.contentPane.add(etiqueta1);
//        
//        JLabel etiqueta2 = new JLabel();
//        etiqueta2.setText("Q2");
//       
//        etiqueta2.setBounds(310,230,100, 25);
//        this.contentPane.add(etiqueta2);
        
        ///// text area
        
        
        trans1.setText("$;Z,S");
       
        trans1.setBounds(340,240,40, 25);
        this.contentPane.add(trans1);
        
        
        
        trans2.setLineWrap(true);
        trans2.setWrapStyleWord(true); 
        trans2.setBounds(520, 50, 80, 300);
        this.contentPane.add(trans2);
        
    }
    
    public void paint (Graphics g)
    {
        super.paint(g);

//        g.setColor (Color.black);
//        g.drawLine (0, 70, 100, 70);
//        g.drawRect (150, 70, 50, 70);
//        g.drawRoundRect (250, 70, 50, 70, 6, 6);
//        g.drawOval (350, 70, 50, 70);
//        int [] vx1 = {500, 550, 450};
//        int [] vy1 = {70, 120, 120};
//        g.drawPolygon (vx1, vy1, 3);
        
         
         g.setColor (Color.black);
         
         g.drawArc(460, 185, 30, 150, -10, 200); // arco
         
         g.drawLine(491, 272, 497, 266);//
         g.drawLine(491, 272, 483, 266);// flecha de arco
         
         g.drawLine(439, 290, 449, 295);//
         g.drawLine(439, 300, 449, 295);// flecha
         
         g.drawLine(269, 295,449, 295); // linea transicion
         g.drawOval(249, 269, 52, 72); // linea interior
         g.drawOval(446, 266, 58, 78); // linea exterior segundo circulo
         g.drawOval(449, 269, 52, 72); // linea segundo circulo
        g.setColor (Color.yellow);
//        g.fillRect (150, 270, 50, 70);
//        g.fillRoundRect (250, 270, 50, 70, 6, 6);
        
        g.fillOval (250, 270, 50, 70);
        g.fillOval (450, 270, 49, 69);
//        int [] vx2 = {500, 550, 450};
//        int [] vy2 = {270, 320, 320};
//        g.fillPolygon (vx2, vy2, 3);
    }
    
    public static void main(String[] args,int cantNoTerminales,int cantDeReglasPorNoTerm[],String noTerminales[],String matrix[][]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Grafico frame = new Grafico();
                    frame.setVisible(true);
                    String cadena="";
                    
                    
                    
                     for (int i = 0; i < cantNoTerminales; i++) {
                         for (int j = 0; j < cantDeReglasPorNoTerm[i]; j++) {
                                   
                                // buscar terminales en la regla
                                
                                char[] aCaracteres = matrix[i][j].toCharArray();
                                
                                for (int k = 0; k < matrix[i][j].length(); k++) {
                                    String caracter=aCaracteres[k]+"";
                                    if(BuscarEnTerminales(caracter)==true){
                                        
                                        GuardarTerminales(caracter);
                                 
                                    }
                                 }
                             
                                if(matrix[i][j].length()==11){
                                    cadena=cadena+"$;"+noTerminales[i]+";"+matrix[i][j];
                                }
                                else{
                                    int espacios=11-matrix[i][j].length();
                                    cadena=cadena+"$;"+noTerminales[i]+";"+matrix[i][j];
                                    for (int k = 1; k < espacios; k++) {
                                        cadena=cadena+" ";
                                    }
                                    
                                }
                             
                                
                                trans2.setText(cadena);
 
                         }
                  
                        }
                     
                        for (int i = 0; i < cantTerminales; i++) {
                            cadena=cadena+terminales[i]+";"+terminales[i]+";$      ";
                            trans2.setText(cadena);
                        }
                               
 
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}