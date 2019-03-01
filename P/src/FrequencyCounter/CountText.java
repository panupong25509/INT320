/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrequencyCounter;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
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
            List<Text> list = text.getResult();
            Collections.sort(list, Text.countComparator);
            for (Text text1 : list) {
                System.out.printf("%-15s:%3d\n", text1.getText(), text1.getCount());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CountText.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println(text);
    }
}
