import java.io.*;
import java.util.Scanner;


public class FORMAILACCS{
    public static void main(String[] args) {
        int lines = 0;
        File file = new File("500mail.txt");
        try(Scanner scanner = new Scanner(file)){
            while (scanner.hasNextLine()) {
                lines++;
                String[] array = scanner.nextLine().split(" ");
            }
        }catch (FileNotFoundException e){}
        System.out.println(lines);
        String[] a = new String[lines];
        String[] login = new String[lines];
        String[] password = new String[lines];
        String[] mail = new String[lines];
        String[] mailpass = new String[lines];
        try(FileReader reader = new FileReader("500mail.txt"))
        {
            BufferedReader buffReader = new BufferedReader(reader);
            int i=0;
            while (buffReader.ready()) {
                a[i]=buffReader.readLine();
                i++;
            }
            lines = i;
            reader.close();
            buffReader.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        for(int i=0;i<a.length;i++){
            mail[i] = a[i].substring(0, a[i].indexOf(":"));
            a[i]=a[i].substring(a[i].indexOf(":")+1);
            mailpass[i] = a[i].substring(0,a[i].indexOf(":"));
            a[i]=a[i].substring(a[i].indexOf(":")+1);
            login[i] = a[i].substring(0,a[i].indexOf(":"));
            a[i]=a[i].substring(a[i].indexOf(":")+1);
            try{password[i] = a[i].substring(0, a[i].indexOf(":"));}catch(Exception E){password[i] = a[i];}
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("test1.txt")))
        {
            for(int i=0;i< login.length;i++) {
                String text = login[i]+":"+password[i]+":"+mail[i]+":"+mailpass[i]+"\n";
                bw.write(text);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
