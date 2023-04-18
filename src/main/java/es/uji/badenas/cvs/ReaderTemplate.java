package es.uji.badenas.cvs;

import es.uji.badenas.tables.Table;

import java.io.FileNotFoundException;

public abstract class ReaderTemplate {
    Table tabla;
    String fuente;
    ReaderTemplate( String f){
        tabla = new Table();
        fuente = f;
    }
    abstract void openSource(String source) throws FileNotFoundException;
    abstract void processHeaders(String headers);
    abstract void processData(String data);
    abstract void closeSource();
    abstract boolean hasMoreData(); // comprueba si hay más datos; en nuestro caso, si hay mas línea(s) en el fichero CSV
    abstract String getNextData(); // obtener el siguiente dato; una línea del fichero CSV en nuestro caso
    public final Table readTableFromSource() throws FileNotFoundException {
        openSource(fuente);
        processHeaders(getNextData());
        while(hasMoreData()){
            String s = getNextData();
            processData(s);
        }
        closeSource();
        return tabla;
    }
}
