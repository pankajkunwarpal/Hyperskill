package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class sortLine {
    sortLine(String type, String Ofile, String Ifile) {
        Scanner scan = new Scanner(System.in);
        ListData<String> data = new ListData<>(true);
        if (Ifile != null) {
            try {
                File f = new File(Ifile);
                try (Scanner s = new Scanner(f)) {
                    while (s.hasNextLine()) {
                        data.add(s.nextLine());
                    }
                }
            } catch (NullPointerException | FileNotFoundException e) { e.printStackTrace(); }
        }
        while(scan.hasNextLine()) { data.add(scan.nextLine()); }

        System.out.println("Total lines: " + data.getIndex() + ".");
//        System.out.println("The longest line:");
//        System.out.println(data.getMax());
//        System.out.println("(" + data.getCount() + " time(s), " +
//                (int)(((double) data.getCount() / data.getIndex())*100) + " %).");
        if ("natural".equals(type)) {
            data.sort();
            System.out.println(data.toString());
        } else {
            data.sort();
            MapData<String, Integer> map = new MapData<>(data.getSize());
            map.put((String) data.getData()[0].getValue(), 1);
            int index = 1;
            for (int i = 1; i < data.getSize(); i++) {
                if (data.getData()[i].getValue().equals(data.getData()[i - index].getValue())) {
                    map.updateValue(i - index, (Integer) map.getData()[i - index].getValue() + 1);
                    index++;
                } else {
                    map.put((String) data.getData()[i].getValue(), 1);
                }
            } map.sort();
            if (Ofile != null) {
                try {
                    PrintWriter pw = new PrintWriter(new File(Ofile));
                    pw.println(map.toString());
                } catch (FileNotFoundException e) { e.printStackTrace(); }
            }
            else {
                System.out.println(map.toString());
            }
        }
    }
}
