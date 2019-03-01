/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrequencyCounter;

import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author INT303
 */
public class Text implements Comparable<Text> {

    private String text;
    private int count;
    public static CountComparator countComparator = new CountComparator();
    public Text(String text) {
        this.text = text;
        this.count = 1;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addCount() {
        this.count++;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.text);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Text other = (Text) obj;
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        return true;
    }

    private static class CountComparator implements Comparator<Text> {

        @Override
        public int compare(Text t1, Text t2) {
            return t2.count - t1.count;
        }

    }

    @Override
    public int compareTo(Text txt) {
        return this.text.compareTo(txt.text);
    }

}
