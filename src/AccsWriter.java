import java.io.*;
import java.util.Scanner;


public class AccsWriter {
    public static void main(String[] args) {
        int lines = 0;
        File file = new File("test.txt");
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
        try (FileReader reader = new FileReader("test.txt")) {
            BufferedReader buffReader = new BufferedReader(reader);
            int i = 0;
            while (buffReader.ready()) {
                a[i] = buffReader.readLine();
                i++;
            }
            reader.close();
            buffReader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        for (int i = 0; i < a.length; i++) {
            login[i] = a[i].substring(0, a[i].indexOf(":"));
            a[i]=a[i].substring(a[i].indexOf(":")+1);
            password[i] = a[i].substring(0, a[i].indexOf(":"));
        }
        for (int i = 0; i < login.length; i++) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter((i + 10311) + ".json"))) {
                String text = "{\n  \"Enabled\": true,\n  \"GamesPlayedWhileIdle\": [\n    730\n  ],\n  \"SteamLogin\": \"" + login[i] + "\",\n  \"SteamPassword\": \"" + password[i] + "\"\n}";
                bw.write(text);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}