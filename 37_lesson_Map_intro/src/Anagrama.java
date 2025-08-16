import java.util.HashMap;
import java.util.Map;

public class Anagrama {
    public static void main(String[] args) {
        //метод проверяет
        String baseWord = "electricity";
        //----------true
//        isAnagram(baseWord, "electric");
//
//        isAnagram(baseWord, "city");
//        isAnagram(baseWord, "tet");
//        isAnagram(baseWord, "let");
//        isAnagram(baseWord, "tree");
//        isAnagram(baseWord, "critic");
//
//        //=========false
//        isAnagram(baseWord,"tot");
//        isAnagram(baseWord, "tet ");
//        isAnagram(baseWord, "teeeet");
//        isAnagram(baseWord, " toot");
//        isAnagram(baseWord, "1tot");

        System.out.println(baseWord + " | " + "electric" + " -> " + isAnagram(baseWord, "electric"));
        System.out.println(baseWord + " | " + "city" + " -> " + isAnagram(baseWord, "city"));
        System.out.println(baseWord + " | " + "tet" + " -> " + isAnagram(baseWord, "tet"));
        System.out.println(baseWord + " | " + "let" + " -> " + isAnagram(baseWord, "let"));
        System.out.println(baseWord + " | " + "tree" + " -> " + isAnagram(baseWord, "tree"));
        System.out.println(baseWord + " | " + "critic" + " -> " + isAnagram(baseWord, "critic"));

        System.out.println(baseWord + " | " + "tot" + " -> " + isAnagram(baseWord,"tot"));
        System.out.println(baseWord + " | " + "tet " + " -> " + isAnagram(baseWord, "tet "));
        System.out.println(baseWord + " | " + "teeeet" + " -> " + isAnagram(baseWord, "teeeet"));
        System.out.println(baseWord + " | " + " toot" + " -> " + isAnagram(baseWord, " toot"));
        System.out.println(baseWord + " | " + "1tot" + " -> " + isAnagram(baseWord, "1tot"));








    }

    private static boolean isAnagram(String baseWord, String word) {
        word = word.toLowerCase();
        baseWord = baseWord.toLowerCase().trim();

        if( !word.matches("[a-z]+"))
            return false;

        Map <Character, Integer> baseMap = new HashMap<>();
        for(Character ch: baseWord.toCharArray()) {
            baseMap.put(ch, baseMap.getOrDefault(ch, 0)+1);
        }

        for( Character ch : word.toCharArray()){
            if(!baseMap.containsKey(ch) || baseMap.get(ch) == 0)
                return false;
            baseMap.put(ch, baseMap.get(ch)-1);

        }

        return true;




    }


}
