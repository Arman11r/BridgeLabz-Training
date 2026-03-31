interface DataExporter {

    void export();

    default void exportToJSON() {
        System.out.println("Exporting data to JSON file...");
    }
}


class CsvExporter implements DataExporter {

    public void export() {
        System.out.println("Exporting to CSV...");
    }
}


class PdfExporter implements DataExporter {

    public void export() {
        System.out.println("Exporting to PDF...");
    }
}


public class Export {

    public static void main(String[] args) {

        DataExporter csv = new CsvExporter();
        csv.export();
        csv.exportToJSON();

        DataExporter pdf = new PdfExporter();
        pdf.export();
        pdf.exportToJSON();
    }
}