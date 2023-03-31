package challenge3binar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteData extends Rumus{
    public void createModus() throws IOException {
        save("Data_modus.txt", "Modus");
    }

    public void createMean() throws IOException{
        save("Data_Mean.txt", "Mean");
    }

    public void createMedian() throws IOException{
        save("Data_Median.txt", "Median");
    }

    public void createFrek() throws IOException{
        save("Data_Frekuensi.txt", "Frekuensi");
    }

    public void createBoth() throws IOException{
        createModus();
        createMean();
        createMedian();
        createFrek();
    }

    public void save(String namaFile, String count) throws IOException{
        String dir = "C:/Users/ARJ/IdeaProjects/dirData/";
        File folder = new File(dir);
        String fileName = namaFile;
        File file = new File(folder.getAbsolutePath() + "/" + fileName);
        if(!file.exists()){
            file.createNewFile();
        }else{
            System.err.println("Terdapat file " + count + ".txt" + " dengan nama yang sama!!");
        }
        if(count.contains("Modus")){
            FileWriter fw = new FileWriter(file);
            fw.write("Berikut data " + count + "\n");
            fw.write(count + " : " + getModus());
            fw.flush();
            fw.close();
        } else if (count.contains("Mean")) {
            FileWriter fw = new FileWriter(file);
            fw.write("Berikut data " + count + "\n");
            fw.write(count + " : " + getMean());
            fw.flush();
            fw.close();
        } else if (count.contains("Median")) {
            FileWriter fw = new FileWriter(file);
            fw.write("Berikut data " + count + "\n");
            fw.write(count + " : " + getMedian());
            fw.flush();
            fw.close();
        } else if (count.contains("Frekuensi")) {
            FileWriter fw = new FileWriter(file);
            fw.write("Nilai \t \t \t \t | Frekensi \n");
            fw.write("Jumlah Nilai Dibawah Lima \t |\t" + dibawah_lima +"\n");
            fw.write("5 \t \t \t \t \t |\t" + lima +"\n");
            fw.write("6 \t \t \t \t \t |\t" + enam +"\n");
            fw.write("7 \t \t \t \t \t |\t" + tujuh +"\n");
            fw.write("8 \t \t \t \t \t |\t" + delapan +"\n");
            fw.write("9 \t \t \t \t \t |\t" + sembilan +"\n");
            fw.write("10 \t \t \t \t \t |\t" + sepuluh +"\n \n");
            fw.write("Jumlah Frekuensi \t \t \t |\t" + Main.list.size() +"\n");
            fw.close();
        } else {
            System.err.print("Terjadi Kesalahan!!");
        }
    }

}
