import java.util.*;
public class CharacterFreq{
    public static void main(String[] args){
        String str = "java";
        Map<Character, Integer> characterFreq = new HashMap<>();
        for (char c : str.toCharArray()) { //taking char c in str for each letter
            characterFreq.put(c, characterFreq.getOrDefault(c, 0) + 1);
        }

        System.out.println("Character Frequency: " + characterFreq);

    }
}