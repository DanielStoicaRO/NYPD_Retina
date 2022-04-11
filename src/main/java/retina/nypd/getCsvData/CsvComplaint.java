package retina.nypd.getCsvData;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CsvComplaint {

    @CsvBindByPosition(position = 0)
    private String CMPLNT_NUM;

    @CsvBindByPosition(position = 7)
    private String KY_CD;

}
