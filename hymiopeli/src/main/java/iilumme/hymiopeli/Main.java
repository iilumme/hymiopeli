/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iilumme.hymiopeli;

/**
 *
 * @author iina
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean A = false;
        boolean B = true;

        if (!(((A || (A && !B)) && (B || !A)) && !(A || B))) {
            System.out.println("hei");
        }
    }

}
