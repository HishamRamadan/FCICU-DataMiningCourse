import java.io.*;

/*
 * @author Hisham Ramadan
 * Group: IS_DS_4
 * ID: 20110410
 */

class DocHandler {

    // return the whole file as a string
    public static String readFile(String file_path) {
        String wholeFile = "";

        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                wholeFile += line + " ";
            }
        } catch (FileNotFoundException ex) {
            System.exit(0);
        } catch (IOException ex) {
            System.exit(0);
        }
        
        return wholeFile;
    }

}