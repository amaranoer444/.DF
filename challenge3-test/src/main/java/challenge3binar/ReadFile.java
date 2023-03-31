package challenge3binar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ReadFile {
    static ArrayList<String[]> data = new ArrayList<>();

    public ArrayList<ArrayList<String>> Read(String csvFile) {
        BufferedReader br = null;
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<ArrayList<String>> data = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            for (String row : lines) {
                String[] values = row.split(";");
                ArrayList<String> rowData = new ArrayList<>();
                Collections.addAll(rowData, values);
                data.add(rowData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}


    /*protected void readData() throws IOException {
        int hitung = 0;
        String line = "";
        String regex = "[0-9]";
        String csvFile = "src/main/resources/FileCSV/data_sekolah.csv";
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        for (int i = 1; i < hitung; i++) {
            data.clear();
            line = br.readLine();
            row = line.split(";");
            for (int j = 1; j < row.length; j++) {
                if (row[j].matches(regex)) data.add(String.valueOf(Integer.parseInt(row[j])));
            }
        }
        System.out.println();
    }*/

    /*protected static void read(String csvFile){
        try{
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String delimiter = ",";
            String[] tempArr;
            while((line = br.readLine())!= null){
                tempArr = line.split(delimiter);
                for(String tempStr : tempArr){
                    System.out.print(tempStr + " ");
                }
                System.out.println();
            }
            br.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }*/
