import java.lang.ref.Cleaner;
import java.util.*;

class Solution_roman_to_int {

    public static void main(String[] args){
        Solution_roman_to_int sol = new Solution_roman_to_int();
        System.out.println(sol.romanToInt("MCMXCIV"));
        
    }

    // ACCEPTED
    public int romanToInt(String s) {
        // convert input string to array of characters
        String sArr[] = s.split("");

        // create hashmap - key = roman numeral, value = value
        HashMap<String, Integer> romanKey = new HashMap<String, Integer>();
        romanKey.put("I", 1);
        romanKey.put("V", 5);
        romanKey.put("X", 10);
        romanKey.put("L", 50);
        romanKey.put("C", 100);
        romanKey.put("D", 500);
        romanKey.put("M", 1000);

        // iterating from right to left in roman numeral string
        Integer currentValue;
        Integer nextValue;
        Integer currentTotal = 0;        
        Integer valueToAdd = 0;
        
        
        for(int i = (sArr.length)-1; i > -1; i--){
            // update current value
            currentValue = romanKey.get(sArr[i]);
            // update next value if in bounds
            if(i > 0)
                nextValue = romanKey.get(sArr[i-1]);
            else 
                // arbitrary random value assigned
                nextValue = 2000;
            // check if current value is smaller than last iterations value
            // first iteration NEVER ENTERS LOOP BELOWS B/C lastValue = 0
            if(currentValue > nextValue) {
                i--; // compensate for preceding roman numeral
                // check for special cases
                if(nextValue.equals(1)) {
                    if(currentValue.equals(5)){
                        valueToAdd = 4;
                    }
                    else{
                        valueToAdd = 9;
                    }
                }
                else if(nextValue.equals(10)) {
                    if(currentValue.equals(50)){
                        valueToAdd = 40;
                    }
                    else{
                        valueToAdd = 90;
                    }
                }
                else if(nextValue.equals(100)) {
                    if(currentValue.equals(500)){
                        valueToAdd = 400;
                    }
                    else{
                        valueToAdd = 900;
                    }
                }
            }
            else{
                valueToAdd = romanKey.get(sArr[i]);
            }
            /* add this iterations value to the current
             running total so far */
            currentTotal += valueToAdd;
        }
        // return calculated value from roman numeral converter
        return currentTotal;
    }
}


