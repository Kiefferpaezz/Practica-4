/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.awt.HeadlessException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Vector {
    private int [] vector;

     public Vector(int longitud) {
        this.vector = new int[longitud];
    }

    public int[] getVector() {
        return vector;
    }

    public void setVector(int[] vector) {
        this.vector = vector;
    }
    /***
     * Este metodo es el encargado de llenar el vector, ya sea de manera manual pidiendole datos al usuario o de forma
     * aleatoria con numeros del 1 al 100. 
     * 
     **/
    public void llenarVector(){
        String entrada=null;        
        boolean bandera=true, bandera2=true;
        while(bandera){
            entrada=JOptionPane.showInputDialog("¿Desea llenar el vector manualmente? (si/no)");
            if(entrada.equals("no")||entrada.equals("NO")){
                bandera=false;
            }else if(entrada.equals("si")||entrada.equals("SI")){
                bandera=false;
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese si o no");
            }
        }
        if(entrada.equals("si")||entrada.equals("SI")){
            bandera=true;
            bandera2=true;
            int i=0,dato=0;
            while(bandera && i<vector.length){
                try{
                    dato= Integer.parseInt(JOptionPane.showInputDialog("Ingrese dato del vector numero "+(i+1)));
                    if(dato<0){
                        JOptionPane.showMessageDialog(null, "Ingrese un dato positivo");
                    }else{
                        vector[i]=dato;
                        dato=0;
                        i++;
                    }
                }catch(HeadlessException | NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese un dato numerico");
                    bandera=true;
                }
                while(bandera2){
                    entrada=JOptionPane.showInputDialog("¿Desea seguir  llenando el vector manualmente?(si/no)");
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
            for(int j=i+1;j<vector.length;j++){
                vector[j]=0;
            }
        }else{
            Random rn =new Random();
            for(int j=0;j<vector.length;j++){
                vector[j]=rn.nextInt(100)+1;
            }
        }
        mostrarVector();
    }
    /**
     * Metodo encargado de cambiar un dato del vector por un dato ingresado por el usuario o por uno generado
     * aleatoriamente.
     **/
    public void cambiarElementos(){
        boolean bandera=true;
        int indice=0, dato=0;
        String entrada;
        while(bandera){
            try{
                indice= Integer.parseInt(JOptionPane.showInputDialog("Ingrese posicion del vector que desea cambiar"));
                if(indice>vector.length || indice<1){
                   JOptionPane.showMessageDialog(null, "Ingrese un dato que este entre 1 y "+ vector.length);
                   
                }else{
                   bandera=false;
                }
            }catch(HeadlessException | NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ingrese un dato numerico");
                bandera=true;              
                                  
          }
       }
       indice=indice-1;
       entrada=JOptionPane.showInputDialog("¿ Desea ingresar el numero por el cual lo va a cambiar? (si/no)");
       if(entrada.equals("si")||entrada.equals("SI")){
           bandera=true; 
           while(bandera){
                try{
                    dato= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor por el cual desea reemplazarlo en la posicion"));
                    if(dato<0){
                        JOptionPane.showMessageDialog(null, "Ingrese un dato positivo");
                   
                    }else{
                        bandera=false;
                    }
                }catch(HeadlessException | NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese un dato numerico");
                    bandera=true;
                }
            }
           
           vector[indice]=dato;
       }else{
           Random rn=new Random();
           vector[indice]=rn.nextInt(100)+1;
       }
       mostrarVector();       
    }
    /**
     * método que permite cambiar la posición de dos elementos del arreglo, es decir, el
       usuario nos dará dos índices, el programa deberá cambiar la posición de ambos elementos.
     **/
    public void cambiarPosicion(){
        boolean bandera=true;
        int indice1=0,indice2=0;
        while(bandera){
            try{
                indice1= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la primera posicion del vector que desea cambiar"));
                if(indice1>vector.length || indice1<1){
                   JOptionPane.showMessageDialog(null, "Ingrese un dato que este entre 1 y "+ vector.length);
                   
                }else{
                   bandera=false;
                }
            }catch(HeadlessException | NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ingrese un dato numerico");
                bandera=true;
          }
       }
       bandera=true;
       indice1=indice1-1;
       while(bandera){
            try{
                indice2= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la segunda posicion del vector que desea cambiar"));
                if(indice2>vector.length || indice2<1){
                   JOptionPane.showMessageDialog(null, "Ingrese un dato que este entre 1 y "+ vector.length);
                   
                }else{
                   bandera=false;
                }
            }catch(HeadlessException | NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ingrese un dato numerico");
                bandera=true;
          }
       }
       indice2=indice2-1;
       int aux=0;
       aux=vector[indice1];
       vector[indice1]=vector[indice2];
       vector[indice2]=aux;
       mostrarVector();
    }
    /**
     * Metodo encargado de invetir los datos del vector.
     **/
    public void invertir(){
        int i=vector.length;
        int aux=0;
        for(int j=0;j<(vector.length/2);j++){
            aux=vector[j];
            vector[j]=vector[i-1];
            vector[i-1]=aux;
            i--;
        }
        mostrarVector();
    }
    /**
     * Metodo encargado mostrar los datos del vector.
     **/
    public void mostrarVector(){
        for(int i=0;i<vector.length;i++){
            System.out.print(vector[i]+"--");
        }
        System.out.println("");
    }    
    
}
