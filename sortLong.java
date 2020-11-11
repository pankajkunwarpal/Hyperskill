package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.InputMismatchException;

class sortLong {
    sortLong(String type, String Ofile, String Ifile) {
        Scanner scan = new Scanner(System.in);
        ListData<Long> data = new ListData<>(false);
        if (Ifile != null) {
            try {
                File f = new File(Ifile);
                try (Scanner s = new Scanner(f)) {
                    while (s.hasNext()) {
                        data.add(s.nextLong());
                    }
                }
            } catch (NullPointerException | FileNotFoundException e) { e.printStackTrace(); }
        }
        while (scan.hasNext()) {
            try {
                data.add(scan.nextLong());
            } catch (InputMismatchException e) {
                System.out.println("\"" + scan.next() +
                        "\" is not a long. It will be skipped.");
            }
        }
        System.out.println("Total numbers: " + data.getIndex() + ".");
//        System.out.println("The greatest number: " + data.getMax() +
//                " (" + data.getCount() + " time(s), " +
//                ((double) data.getCount() / (double) data.getIndex()) * 100 + " %).");

        if ("natural".equals(type)) {
            data.sort();
            System.out.println(data.toString());
        } else {
            data.sort();
            MapData<Long, Integer> map = new MapData<>(data.getSize());
            map.put((Long) data.getData()[0].getValue(), 1);
            int index = 1;
            for (int i = 1; i < data.getSize(); i++) {
                if (data.getData()[i].getValue().equals(data.getData()[i - index].getValue())) {
                    map.updateValue(i - index, (Integer) map.getData()[i - index].getValue() + 1);
                    index++;
                } else {
                    map.put((Long) data.getData()[i].getValue(), 1);
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
