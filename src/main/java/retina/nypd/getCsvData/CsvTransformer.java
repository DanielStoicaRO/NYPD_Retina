package retina.nypd.getCsvData;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.http.client.fluent.Request;
import retina.nypd.entities.ComplaintEntity;
import retina.nypd.mappers.Mapper;
import retina.nypd.repositories.Repository;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvTransformer {

    private static final String URL = "https://data.cityofnewyork.us/resource/qgea-i56i.csv?$limit=10";
    private static final String NYPD_CSV = "C:\\repository\\NypdDASProj\\src\\main\\resources\\nypd.csv";

    public static List<CsvComplaint> csvToComplaint() throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(NYPD_CSV))
        ) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CsvComplaint.class)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return (List<CsvComplaint>) csvToBean.parse();
        }
    }

    public static void getSampleData(Repository repository) {

        try {
            File myFile = new File(NYPD_CSV);
            Request.Get(URL).execute().saveContent(myFile);
            List<CsvComplaint> complaints = CsvTransformer.csvToComplaint();
            for (CsvComplaint complaint : complaints) {
                repository.save(Mapper.toComplaintFromCSV(complaint));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exportCSV(Repository repository) {

        List<ComplaintEntity> allComplaintEntities = repository.findAll();
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(NYPD_CSV));
        ) {
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            beanToCsv.write(allComplaintEntities);
        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }

}
