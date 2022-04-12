package retina.nypd.entities;

public class ComplaintModel {
    private Long CMPLNT_NUM;
    private int KY_CD;

    public ComplaintModel(Long CMPLNT_NUM){
        this.CMPLNT_NUM = CMPLNT_NUM;
    }

    public ComplaintEntity build() {
        return new ComplaintEntity(CMPLNT_NUM, KY_CD);
    }

    public ComplaintModel setKY_CD(int KY_CD) {
        this.KY_CD = KY_CD;
        return this;
    }

    public ComplaintModel setCmplnt_num(Long CMPLNT_NUM) {
        this.CMPLNT_NUM = CMPLNT_NUM;
        return this;
    }


}