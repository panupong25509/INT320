/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrequencyCounter;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INT303
 */
public class CountText {

    public static void main(String[] args) {
        TextFrequencyCounter text = new TextFrequencyCounter();
        try {
            text.processFile("data.txt");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CountText.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(text);
    }
}
