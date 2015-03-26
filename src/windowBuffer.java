/**
 * Created by archie on 3/25/15.
 */
public class windowBuffer{
    private int numLines;
    private String[] Buffer;
    private int lastString;

    void displayBuffer()
    {
    }
    void setVar(int numLines, String[] Buffer)
    {
        this.numLines = numLines;
        this.Buffer= Buffer;
    }
    void printBuffer(){
        for ( int i = lastString; i < 5; i++) {
            System.out.println(Buffer[i]);
        }
    }



}
