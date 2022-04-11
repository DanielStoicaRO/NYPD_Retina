package retina.nypd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dto {

    @JsonProperty("CMPLNT_NUM")
    private Long CMPLNT_NUM;

    @JsonProperty("KY_CD")
    private int KY_CD;
}
