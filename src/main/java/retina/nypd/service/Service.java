package retina.nypd.service;

import org.springframework.beans.factory.annotation.Autowired;
import retina.nypd.dto.Dto;
import retina.nypd.entities.ComplaintEntity;
import retina.nypd.entities.Offenses;
import retina.nypd.getCsvData.CsvTransformer;
import retina.nypd.mappers.Mapper;
import retina.nypd.repositories.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private final Repository repository;

    @Autowired
    public Service(final Repository repository) {
        this.repository = repository;
    }

    // 	1-dataset/stats/total
    public int getTotal() {
        return repository.findAll().size();
    }

    //	2-dataset/stats/offenses
    public List<Offenses> getComplaintsByKY_CD() {
        return repository.findComplaintsByKY_CD();
    }

    // 3 - DELETE endpoints: /dataset/${id}
    public boolean deleteComplaint(Long id) {
        Optional<ComplaintEntity> complaint = repository.findById(id);
        if (complaint.isPresent()) {
            repository.delete(complaint.get());
            CsvTransformer.exportCSV(repository);
            return true;
        } else {
            return false;
        }
    }

    //4 POST dataset
    public ComplaintEntity saveInDb(Dto dto) {
        ComplaintEntity entity = Mapper.toComplaint(dto);
        repository.save(entity);
        return entity;
    }

}
