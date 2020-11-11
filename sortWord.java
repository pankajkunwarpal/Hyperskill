package sorting;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class sortWord {
    sortWord(String type, String Ofile, String Ifile) {
        Scanner scan = new Scanner(System.in);
        ListData<String> data = new ListData<>(true);
        if (Ifile != null) {
            try {
                File f = new File(Ifile);
                try (Scanner s = new Scanner(f)) {
                    while (s.hasNext()) {
                        data.add(s.next());
                    }
                }
            } catch (NullPointerException | FileNotFoundException e) { e.printStackTrace(); }
        }
        else  {
            while (scan.hasNext()) { data.add(scan.next()); }
        }
        System.out.println("Total words: " + data.getIndex() + ".");
//        System.out.println("The longest word: " + data.getMax() + " (" +
//                data.getCount() + " time(s), " +
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
