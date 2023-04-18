package es.uji.badenas.tables;

import java.util.List;

public class Table {
    public void setHeader(List<String> split) {
        System.out.println("Table.seHeather");
        for(String s: split)
            System.out.printf("%s ", s);
        System.out.println(" ");
    }

    public void addRow(List<Double> split) {
        System.out.println("Table.seHeather");
        for(Double d: split)
            System.out.printf("%f ", d);
        System.out.println(" ");
    }
}
