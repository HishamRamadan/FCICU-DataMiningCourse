import static java.lang.Math.*;
import java.util.*;

/*
 * @author Hisham Ramadan
 * Group: IS_DS_4
 * ID: 20110410
 */

class CosineSimilarity {

    public static double cosine_similarity, cosine_angle;
    public static List<String> doc1_terms = new ArrayList<>(); // Doc1 terms.
    public static List<String> doc2_terms = new ArrayList<>(); // Doc2 terms.
    public static Set<String> allTerms = new HashSet<>(); // Set of all terms
    public static Map<String, Integer> doc1_freq = new HashMap<>(); // <term, freq>
    public static Map<String, Integer> doc2_freq = new HashMap<>(); // <term, freq>

    public static void readTwoFiles(String doc1_path, String doc2_path) {
        String doc1 = DocHandler.readFile(doc1_path);
        doc1_terms.addAll(Arrays.asList(doc1.split(" ")));
        
        String doc2 = DocHandler.readFile(doc2_path);
        doc2_terms.addAll(Arrays.asList(doc2.split(" ")));
        
        allTerms.addAll(doc1_terms);
        allTerms.addAll(doc2_terms);
    }

    public static void fillFreqTables() {

        // Need to know each term in such set is repeated in each file
        for (String setTerm : allTerms) {

            // Doc1:
            if (!doc1_terms.contains(setTerm)) {
                doc1_freq.put(setTerm, 0); // Did not occur at all
            } else { // The term is found somewhere
                for (String docTerm : doc1_terms) {
                    if (docTerm.equals(setTerm)) {
                        if (doc1_freq.get(docTerm) == null) { // First time to appear
                            doc1_freq.put(docTerm, 1);
                        } else { // The term appeared before >> increment one ;)
                            doc1_freq.put(docTerm, doc1_freq.get(docTerm) + 1);
                        }
                    }
                }
            }

            // Doc2:
            if (!doc2_terms.contains(setTerm)) {
                doc2_freq.put(setTerm, 0); // Did not occur at all
            } else { // The term is found somewhere
                for (String docTerm : doc2_terms) {
                    if (docTerm.equals(setTerm)) {
                        if (doc2_freq.get(docTerm) == null) { // First time to appear
                            doc2_freq.put(docTerm, 1);
                        } else { // The term appeared before >> increment one ;)
                            doc2_freq.put(docTerm, doc2_freq.get(docTerm) + 1);
                        }
                    }
                }
            }

        }
    }

    public static void calcCosineSimilarity() {
        double numerator = 0;
        for (String key : doc1_freq.keySet()) { // doc1_freq.size = doc2_freq.size
            numerator += (doc1_freq.get(key) * doc2_freq.get(key));
        }

        double deno1 = 0, deno2 = 0;
        for (String key : doc1_freq.keySet()) {
            deno1 += pow(doc1_freq.get(key), 2);
            deno2 += pow(doc2_freq.get(key), 2);
        }

        cosine_similarity = (numerator / sqrt(deno1 * deno2));
        cosine_angle = Math.acos(cosine_similarity) * (180 / Math.PI);
        cosine_angle = Math.round(cosine_angle * 10.00) / 10.00; // Approx.
    }

    public static void doCosCalculations(String doc1_path, String doc2_path) {
        // Step 1: read the two files and load them into strings
        readTwoFiles(doc1_path, doc2_path);

        // Step 2: fill the frequency tables for the two documents
        fillFreqTables();

        // Step 3: calculate similarity equation
        calcCosineSimilarity();
        
        // Print the final result ;)
        System.out.println("Cosine Angle = " + cosine_angle);
    }
}