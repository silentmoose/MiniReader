/**
 * Created by archie on 3/23/15.
 */


import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Spine;
import nl.siegmann.epublib.epub.EpubReader;


import java.io.*;
import java.util.List;

public class main {
    public static void main(String args[]) throws IOException {
        List<nl.siegmann.epublib.domain.Resource> stringBuf = null;;
        String[] sortedStringBuf = null;
        String extractPath = null;
        if (args[1].equals("-e"))
        {
            extractPath = args[2];
            System.out.println(extractPath);

        }



        // read epub file
        EpubReader epubReader = new EpubReader();
        Book book = epubReader.readEpub(new FileInputStream(args[0]));
        windowBuffer wB = new windowBuffer();
        String inputLine = null;
        Spine spine = book.getSpine();
        stringBuf = book.getContents();
        String finalString = null;
        for(int i = 0; i < stringBuf.size(); i ++) {
            nl.siegmann.epublib.domain.Resource r = stringBuf.get(i);

            BufferedReader in = new BufferedReader(new InputStreamReader(r.getInputStream()));
            while ((inputLine = in.readLine()) != null) {

                finalString += inputLine.replaceAll("\\<.*?\\>", "");

            }

            in.close();
        }
        if (args[1].equals("-r")) {
            //if user has chosen to read we will print the text
            System.out.println(finalString);
        }
        //export the plain text to a user proposed file
        if (args[1].equals("-e"))
        {
            System.out.println("Extracting File");
            PrintWriter writer = new PrintWriter(extractPath, "UTF-8");
            writer.print("Extracted using MiniReader:");
            writer.print(finalString);
            writer.close();
        }
        System.out.println("args " + args[0] + ' ' + args[1] + ' ' + args[2] );











// print the first title
        List<String> titles = book.getMetadata().getTitles();
        System.out.println(book.getTitle());




    }
}
