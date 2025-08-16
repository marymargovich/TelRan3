import java.util.*;

public class WordCounterAppl {
    public static void main(String[] args) {
        String str =  "jhgjghj tyrh sdsd, tyrh egdf jhgjghj erewf sdsd egdf yuiyuu tyrh";

        displayWordCount(str);


    }

    private static void displayWordCount(String str) {
        String [] words = str.split("[^A-za-z]+");//" \\ P{L}+
        Map<String , Integer> res = new HashMap<>();
        for (String word : words) {
            if(word.isEmpty())
                continue;
            res .put(word, res.getOrDefault(word, 0)+1);
        }
        System.out.println(res);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(res.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int res = Integer.compare(o1.getValue(), o2.getValue());
                return res !=0 ? res : o2.getKey().compareTo(o1.getKey());
            }});


        for (Map.Entry<String, Integer> entry : list) {
            System.out.printf("%s - > %d \n " , entry.getKey(), entry.getValue());

        }




    }
}
