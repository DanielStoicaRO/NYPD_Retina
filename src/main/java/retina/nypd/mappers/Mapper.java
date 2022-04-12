package retina.nypd.mappers;


import retina.nypd.dto.Dto;
import retina.nypd.entities.ComplaintModel;
import retina.nypd.entities.ComplaintEntity;
import retina.nypd.getCsvData.CsvComplaint;

public class Mapper {

    public static ComplaintEntity toComplaintFromCSV(CsvComplaint csv) {
        return new ComplaintModel(Long.parseLong(csv.getCMPLNT_NUM()))
                .setKY_CD(Integer.parseInt(csv.getKY_CD()))
                .build();
    }

    //4 POST insert dataset
    public static ComplaintEntity toComplaint(Dto dto) {
        return new ComplaintModel(dto.
                getCMPLNT_NUM())
                .setKY_CD(dto.getKY_CD())
                .build();
    }
}
