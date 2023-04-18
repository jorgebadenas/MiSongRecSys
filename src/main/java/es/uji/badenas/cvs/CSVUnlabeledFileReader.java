package es.uji.badenas.cvs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVUnlabeledFileReader extends ReaderTemplate {
    Scanner scanner;
    public CSVUnlabeledFileReader(String source) {
        super(source);
    }
    @Override
    void openSource(String source) throws FileNotFoundException {
        File file = new File(source);
        scanner = new Scanner(file);
    }

    @Override
    void processHeaders(String headers) {
        tabla.setHeader(List.of(headers.split(",")));
    }

    @Override
    void processData(String data) {
        List<Double> listaDoubles = new ArrayList<>();
        String [] leidos = data.split( ",");
        for (String s: leidos ) {
            listaDoubles.add(Double.parseDouble(s));
        }
        tabla.addRow(listaDoubles);
    }

    @Override
    void closeSource() {
        scanner.close();
    }

    @Override
    boolean hasMoreData() {
        return scanner.hasNextLine();
    }

    @Override
    String getNextData() {
        return scanner.nextLine();
    }
}
