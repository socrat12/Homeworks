package home57;

//git config --local core.autocrlf input

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ExtractBaks {
    private String line;
    private URL kursBaksURL;
    private URLConnection connect;
    private InputStream in;
    private BufferedReader reader;
    private int index;

    public ExtractBaks() throws Exception {
        kursBaksURL = new URL("http://nbrb.by");
        connect = kursBaksURL.openConnection();
        in = connect.getInputStream();
        reader = new BufferedReader(new InputStreamReader(in));
        while ((line = reader.readLine()) != null){
            if(line.contains("Курсы валют") && line.contains(".17")){
                index=1;
                System.out.print("Курсы валют:\t");
                convertLine(line, index);
            }
            if(line.contains("1 Доллар США")){
                index=2;
                System.out.print("1 Доллар США\t");
                convertLine(line, index);
            }
            if(line.contains("1 Евро")){
                index=3;
                System.out.print("1 Евро\t\t\t");
                convertLine(line, index);
            }
        }
    }

//<th align="left" colspan="2" width="110"><b>Курсы валют</b></th><th class="b1" align="right" width="62">21.12.17</th><th class="b2" align="right" width="62">22.12.17</th>
//<td>EUR&nbsp;</td><td class="small" style="white-space:nowrap;">1 Евро</td><td align="right">2,3815</td><td align="right">2,3790</td>
    
    
    private void convertLine(String line, int index) {
        String[] value = line.split("<");
        for (int i=0; i<value.length; i++){
            if(value[i].contains(".17") && index==1){
                System.out.print(value[i].substring(value[i].length()-8,value[i].length()) + "\t");
            }
            if(value[i].contains("1,") || value[i].contains("2,") && index==2){
                System.out.print(value[i].substring(value[i].length()-6,value[i].length())+"\t\t");
            }
            if(value[i].contains("1,") || value[i].contains("2,") && index==3){
                System.out.print(value[i].substring(value[i].length()-6,value[i].length())+ "\t\t");
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws Exception {
        new ExtractBaks();
    }
}
