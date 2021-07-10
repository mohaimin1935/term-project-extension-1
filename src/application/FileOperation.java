package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileOperation {
    private static final String INPUT_FILE_NAME = "developmentDatabase.txt";
    private static final String OUTPUT_FILE_NAME = "developmentDatabase.txt";

    public static List<Player> readFromFile() throws Exception {
        List<Player> playerList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] tokens = line.split(",");

            Player p = new Player();
            p.setName(tokens[0]);
            p.setCountry(tokens[1]);
            p.setAge(Integer.parseInt(tokens[2]));
            p.setHeight(Double.parseDouble(tokens[3]));
            p.setPlayerClub(tokens[4]);
            p.setPosition(tokens[5]);
            p.setNumber(Integer.parseInt(tokens[6]));
            p.setWeeklySalary(Double.parseDouble(tokens[7]));
            playerList.add(p);
        }
        br.close();
        return playerList;
    }

    public static void writeToFile(Player p) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME, true));
        bw.write("\n" + p.getName() + "," + p.getCountry() + "," + p.getAge() + "," + p.getHeight() + "," + p.getPlayerClub() + "," + p.getPosition() + "," + p.getNumber() + "," + p.getWeeklySalary());
        bw.close();
    }
}