package org.example;

import java.util.*;

public class Rumus {

    static double mean, median, modus, banyak_data = 0, jumlah = 0;
    static int satu = 0, dua = 0, tiga = 0, empat = 0, lima = 0 , enam = 0 , tujuh = 0 , delapan = 0 , sembilan = 0 , sepuluh = 0, dibawah_lima = 0;

    public static double getMean() {
        return mean;
    }

    public static void setMean(double paramMean) {
        Rumus.mean = paramMean;
    }

    public static double getMedian() {
        return median;
    }

    public static void setMedian(double paramMedian) {
        Rumus.median = paramMedian;
    }

    public static double getModus() {
        return modus;
    }

    public static void setModus(double paramModus) {
        Rumus.modus = paramModus;
    }

    public void dataMeanMedian(){
        jumlah = satu * 1 + dua * 2 + tiga * 3 + empat * 4
                + lima * 5 + enam * 6 + tujuh * 7 + delapan * 8 + sembilan * 9 + sepuluh*10;
        banyak_data = satu+dua+tiga+empat+lima+enam+tujuh+delapan+sembilan+sepuluh;
    }
    public void calculateMean() {
        dataMeanMedian();
        mean = jumlah/banyak_data;
        setMean(mean);
    }

    public void calculateMedian() {
        List<Integer> temp = Main.list;
        Collections.sort(temp);
        int tengah = temp.size() / 2;
        Double median ;
        if (temp.size() % 2 == 1) {
            median = Double.valueOf((String) Main.list.get(tengah));
        }else {
            median =(double) ((Integer.parseInt(String.valueOf(temp.get(tengah-1))) +
                    (Integer.parseInt(String.valueOf(temp.get(tengah))))) / 2);
        }
        setMedian(median);
    }

    public void calculateModus() {
        int maxKey = 0;
        int maxCounts = 0;
        List<Integer> temp = Main.list;
        int[] counts = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            Integer integerTemp = (Integer.parseInt(String.valueOf(temp.get(i))));
            counts[integerTemp]++;
            if (maxCounts < counts[(Integer.parseInt(String.valueOf(temp.get(i))))]) {
                maxCounts = counts[(Integer.parseInt(String.valueOf(temp.get(i))))];
                maxKey = (Integer.parseInt(String.valueOf(temp.get(i))));
            }
        }
        setModus(maxKey);
    }
}

