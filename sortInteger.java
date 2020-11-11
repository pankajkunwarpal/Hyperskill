package sorting;

import java.util.Scanner;

public class sortInteger {
    sortInteger() {
        Scanner scan = new Scanner(System.in);
        ListData<Integer> data = new ListData<>(false);
        while(scan.hasNextInt()) {
            data.add(scan.nextInt());
        }
        System.out.println("Total numbers: " + data.getSize() + ".");
        data.sort();
        System.out.println("Sorting data: " + data.toString());
    }
}
