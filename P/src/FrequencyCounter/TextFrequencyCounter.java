/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrequencyCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import javafx.print.Collation;

/**
 *
 * @author INT303
 */
public class TextFrequencyCounter {
    private Map<String, Text> texts;
    
    public TextFrequencyCounter(){
        texts = new HashMap(125);
    }
    
    public void clear() {
        texts.clear();
    }
    
    public void processFile(String fileName) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(fileName));
        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            StringTokenizer stk = new StringTokenizer(line, " .,;:/-()\\");
            while (stk.hasMoreTokens()) {
                String text = stk.nextToken().toLowerCase();
                if(texts.get(text) == null){
                    texts.put(text, new Text(text));
                }else{
                    texts.get(text).addCount();
                }
            }
        }
    }

    public List<Text> getResult(){
        return new ArrayList(texts.values());
    }
    
    public String toString(){
        StringBuilder stb = new StringBuilder(100*20);
        List<Text> list = getResult();
        Collections.sort(list);
        for (Text text : list) {
            stb.append(String.format("%-15s:%3d\n", text.getText(), text.getCount()));
        }
        return stb.toString();
    }
    
}
