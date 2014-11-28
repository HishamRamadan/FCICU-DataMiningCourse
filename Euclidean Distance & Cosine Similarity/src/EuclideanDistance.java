import static java.lang.Math.*;
import java.util.*;

/*
 * @author Hisham Ramadan
 * Group: IS_DS_4
 * ID: 20110410
 */
class EuclideanDistance {

    // Just to avoid re-calculations
    public static Set<String> allTerms = CosineSimilarity.allTerms;
    public static Map<String, Integer> doc1_freq = CosineSimilarity.doc1_freq;
    public static Map<String, Integer> doc2_freq = CosineSimilarity.doc2_freq;

    public static void doEucCalculations(String doc1_path, String doc2_path) {
        double summation = 0;
        for (String t : allTerms) {
            summation += pow((doc1_freq.get(t) - doc2_freq.get(t)), 2);
        }
        double euclidean_distance = Math.round(sqrt(summation) * 100.00) / 100.00;
        System.out.println("Euclidean Distance = " + euclidean_distance);
    }

}
