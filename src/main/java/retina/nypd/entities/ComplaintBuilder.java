package retina.nypd.entities;

public class ComplaintBuilder {
    private Long cmplnt_num;
    private int ky_cd;

    public ComplaintBuilder(Long cmplnt_num){
        this.cmplnt_num = cmplnt_num;
    }

    public ComplaintBuilder setKY_CD(int ky_cd) {
        this.ky_cd = ky_cd;
        return this;
    }


    public ComplaintBuilder setCmplnt_num(Long cmplnt_num) {
        this.cmplnt_num = cmplnt_num;
        return this;
    }

    public ComplaintEntity build() {
        return new ComplaintEntity(cmplnt_num, ky_cd);
    }
}