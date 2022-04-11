package retina.nypd.entities;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "complaints")
public class ComplaintEntity {

    @Id
    private Long CMPLNT_NUM;
    private int KY_CD;

    public ComplaintEntity(Long CMPLNT_NUM, int KY_CD) {
        this.CMPLNT_NUM = CMPLNT_NUM;
        this.KY_CD = KY_CD;
    }

    public ComplaintEntity() {

    }
}