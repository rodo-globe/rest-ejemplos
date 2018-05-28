/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.org.cjpb.demo.shape;

/**
 *
 * @author rodo
 */
public class ColorConverter {

   private final Color BLACK = new Color("black");
   private final Color BLUE = new Color("blue");
   private final Color RED = new Color("red");
   
   public Color fromString(String value) {
        if (value.equalsIgnoreCase(BLACK.toString())) {
            return BLACK;
        } else if (value.equalsIgnoreCase(BLUE.toString())) {
            return BLUE;
        } else if (value.equalsIgnoreCase(RED.toString())) {
            return RED;
        }
        
        throw new IllegalArgumentException("Invalid color: " + value);
    }

    public String toString(Color value) {
        return value.toString();
    }
}


