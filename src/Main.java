import java.io.*;


public class Main {
    public static void main(String[] args) {
        String[] a = new String[5];
        String[] login = new String[5];
        String[] password = new String[5];
        try(FileReader reader = new FileReader("100.txt"))
        {
            BufferedReader buffReader = new BufferedReader(reader);
            int i=0;
            while (buffReader.ready()) {
                a[i]=buffReader.readLine();
                i++;
            }
            reader.close();
            buffReader.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        for(int i=0;i<a.length;i++){
                login[i] = a[i].substring(0, a[i].indexOf(":"));
                password[i] =(a[i].substring(a[i].indexOf(":")+1)).substring(0,(a[i].substring(a[i].indexOf(":")+1)).indexOf(":"));
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("ACCS.txt")))
        {
            for(int i=0;i< login.length;i++) {
                String text = "{\n\"Details\": {\n\"Username\": \"" + login[i] + "\",\n\"Password\": \"" + password[i] + "\",\n\"LoginKey\": \"\"\n},\n\"ShowOnlineStatus\": true,\n\"ConnectToSteamCommunity\": true,\n\"RestartGamesEveryThreeHours\": true,\n\"JoinSteamGroup\": false,\n\"IgnoreAccount\": false,\n\"ChatResponse\": \"\",\n\"Games\": [\n 730,\n 570,\n 440,\n 1172470\n]\n}";
                bw.write(text);
                bw.write("\n,\n");
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}