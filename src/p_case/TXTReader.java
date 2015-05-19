package p_case;

import java.io.*;

/**
 *
 * @author ruckd
 *
 * Used as a help class for reading a txt. Reading the FAQ.
 */
public class TXTReader {

    BufferedReader in;
    File FAQTxt;
    ClassLoader classLoader = getClass().getClassLoader();

    public TXTReader() {

        try {

            FAQTxt = new File(classLoader.getResource("resources/FAQ.txt").getFile());
            in = new BufferedReader(new FileReader(FAQTxt));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getFAQs() {
        String faqs = "";
        if (in != null) {
            try {
                for (String line; (line = in.readLine()) != null;) {
                    faqs += line;
                    faqs += "\n";
                }
            } catch (IOException ie) {

            }
        }
        return faqs;
    }

    public static void main(String[] args) {

        TXTReader reader = new TXTReader();
        System.out.println(reader.getFAQs());
    }

}
