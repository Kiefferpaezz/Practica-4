/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.awt.HeadlessException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Practica4 {

    /**
     * Método encargado de correr todo, pues crea el objeto de la clase vector, 
     * Y hace que el usuario pueda decidir cómo va modificar al vector.
     */
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
       boolean bandera= true;
       String entrada="";
       int longitud=0;
       while(bandera){
            try{
                longitud = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la longitud del vector"));
                if(longitud>0){
                   bandera = false;   
                }else{
                   JOptionPane.showMessageDialog(null, "Ingrese un dato positivo");
                }
            }catch(HeadlessException | NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ingrese un dato numerico");
                bandera=true;
          }
       }
       Vector vector= new Vector(longitud);
       vector.llenarVector();
       bandera=true;
       int opcion=0;
       boolean bandera1=true,bandera2=true;
       while(bandera){
           JOptionPane.showMessageDialog(null, "1. Cambiar elementos\n"
                   + "2. Cambiar posicion\n"
                   + "3. Invertir vector");
            while(bandera1){
                try{
                    opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion del 1 al 3"));
                    if(opcion>3||opcion<0){
                        JOptionPane.showMessageDialog(null, "Ingrese un dato valido");
                    }else{
                        bandera1=false;
                    }
                }catch(HeadlessException | NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese un dato numerico");
                    bandera1=true;
                }
            }
            bandera1=true;
           switch(opcion){
               case 1:
                   vector.cambiarPosicion();
                   break;
               case 2:
                   vector.cambiarElementos();
                   break;
               case 3:
                   vector.invertir();
                   break;
            }
           while(bandera2){
            entrada=JOptionPane.showInputDialog("¿Desea seguir  modificando el vector?(si/no)");
            if(entrada.equals("no")||entrada.equals("NO")){
                bandera=false;
                bandera2=false;
            }else if(entrada.equals("si")||entrada.equals("SI")){
                bandera2=false;
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese si o no");
            }   
           }
           bandera2=true;
       }
       
    }
           
}
    

