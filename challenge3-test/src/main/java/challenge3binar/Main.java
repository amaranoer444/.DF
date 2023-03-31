package challenge3binar;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main extends Rumus{
    private static Scanner input = new Scanner(System.in);
    private static int pilihan = -1;
    static ArrayList list = new ArrayList();
    static ReadFile read = new ReadFile();

    public static void main(String[] args) throws IOException {
        MainMenu();
    }

    public static void MainMenu() throws IOException {
        ArrayList<ArrayList<String>> data = read.Read("src/main/resources/FileCSV/data_sekolah.csv");

        String regex = "\\b([1-9]|[1-9][0-9]|100)\\b";
        for (ArrayList<String> row : data) {
            for (String value : row) {
                System.out.print(value + " ");
                Pattern pattern = Pattern.compile(regex);
                if (pattern.matcher(value).matches()) {
                    list.add(value);
                }
                if(value.equals("1")){
                    satu++;
                    dibawah_lima++;
                }else if(value.equals("2")){
                    dua++;
                    dibawah_lima++;
                }else if(value.equals("3")){
                    tiga++;
                    dibawah_lima++;
                }else if(value.equals("4")){
                    empat++;
                    dibawah_lima++;
                }else if(value.equals("5")){
                    lima++;
                }else if(value.equals("6")){
                    enam++;
                }else if(value.equals("7")){
                    tujuh++;
                }else if(value.equals("8")){
                    delapan++;
                }else if(value.equals("9")){
                    sembilan++;
                }else if(value.equals("10")){
                    sepuluh++;
                }
            }
            System.out.println();
        }
        WriteData wf = new WriteData();
        Rumus rumus = new Rumus();

        while(pilihan != 0) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Aplikasi Pengolah Nilai Siswa");
            System.out.println("------------------------------------------------------------");
            System.out.println("Letakkan file csv dengan nama file data_sekolah di direktori");
            System.out.println("berikut: c://temp/direktori\n");
            System.out.println("Pilih menu : ");
            System.out.println("1. Generate txt untuk menampilkan modus");
            System.out.println("2. Generate txt untuk menampilkan nilai rata-rata, median");
            System.out.println("3. Generate kedua file");
            System.out.println("0. Exit");
            System.out.print("Masukkan pilihan anda : ");
            pilihan = input.nextInt();
            rumus.calculateMean();
            rumus.calculateMedian();
            rumus.calculateModus();

            switch (pilihan){
                case 1:
                    try{
                        wf.createFrek();
                        wf.createModus();
                        scsOutput(" Modus ");
                    }catch (IOException er){
                        failOutput(" C:/Users/ARJ/IdeaProjects/dirData/ ");
                        er.printStackTrace();
                    }
                    break;
                case 2:
                    try{
                        wf.createFrek();
                        wf.createMean();
                        wf.createMedian();
                        scsOutput(" Mean & Median ");
                    }catch (IOException er){
                        failOutput(" C:/Users/ARJ/IdeaProjects/dirData/ ");
                        er.printStackTrace();
                    }
                    break;
                case 3:
                    try{
                        wf.createBoth();
                        scsOutput(" Modus,Mean,Median ");
                    }catch (IOException er){
                        failOutput(" C:/Users/ARJ/IdeaProjects/dirData/ ");
                        er.printStackTrace();
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Inputan anda salah!!");
                    MainMenu();
            }
        }

    }

    public static void scsOutput(String perhitungan) throws IOException{
        System.out.println("------------------------------------------------------------");
        System.out.println("Aplikasi Pengolah Nilai Siswa");
        System.out.println("------------------------------------------------------------");
        System.out.println("File" + perhitungan +"telah di generate di C:/Users/ARJ/IdeaProjects/dirData");
        System.out.println("silahkan cek\n");
        System.out.println("0 Exit");
        System.out.println("1 Kembali ke main menu");
        pilihan = input.nextInt();
        if(pilihan == 1) {
            MainMenu();
        }else if (pilihan == 0){
            System.out.println("Terimakasih telah menggunakan program ini");
            System.exit(0);
        }
    }

    public static void failOutput(String path) throws IOException{
        System.err.println("------------------------------------------------------------");
        System.err.println("Aplikasi Pengolah Nilai Siswa");
        System.err.println("------------------------------------------------------------");
        System.err.println("Directory" + path + "tidak ditemukan\n");
        System.exit(0);
    }
}