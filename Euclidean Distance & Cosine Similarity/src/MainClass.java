/*
 * @author Hisham Ramadan
 * Group: IS_DS_4
 * ID: 20110410
 */

public class MainClass {

    public static void main(String args[]) {
        String doc1_path = "file1.txt", doc2_path = "file2.txt";
        CosineSimilarity.doCosCalculations(doc1_path, doc2_path);
        EuclideanDistance.doEucCalculations(doc1_path, doc2_path);
    }
}