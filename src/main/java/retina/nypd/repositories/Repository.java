package retina.nypd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import retina.nypd.entities.ComplaintEntity;
import retina.nypd.entities.OffensesCount;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<ComplaintEntity, Long> {
    @Query("SELECT " +
            "    new retina.nypd.entities.OffensesCount(v.KY_CD, COUNT(v)) " +
            "FROM " +
            "    ComplaintEntity v " +
            "GROUP BY " +
            "    v.KY_CD")
    List<OffensesCount> findComplaintsByKY_CD();
}
