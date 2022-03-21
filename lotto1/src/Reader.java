import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Vector;

public class Reader {
    public Reader(){

    }
    public Vector<String>readFile(){
        Vector<String> numbers = new Vector<>();
        
        try {
            FileReader fRead = new FileReader("szamok.txt");
            Scanner scan = new Scanner(fRead);
            while(scan.hasNext()){
                String row = scan.nextLine();
                if(row.matches("[0-9:]+")){
                    numbers.add(row);
                }
            }
            scan.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return numbers;
    }
}
