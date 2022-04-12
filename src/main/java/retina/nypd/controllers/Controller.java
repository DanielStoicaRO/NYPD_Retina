package retina.nypd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retina.nypd.dto.Dto;
import retina.nypd.entities.OffensesCount;
import retina.nypd.service.Service;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private final Service service;

    @Autowired
    public Controller(final Service service) {
        this.service = service;
    }

    // 	1-dataset/stats/total
    @GetMapping("/dataset/stats/total")
    public ResponseEntity<?> getTotalStats() {
        int total = service.getTotal();
        return new ResponseEntity<>(total, new HttpHeaders(), HttpStatus.OK);
    }

    //	2-dataset/stats/offenses
    @GetMapping("/dataset/stats/offenses")
    public ResponseEntity<?> getOffensesStats() {
        List<OffensesCount> stats = service.getComplaintsByKY_CD();
        return new ResponseEntity<>(stats, new HttpHeaders(), HttpStatus.OK);
    }

    // 3 - DELETE endpoints: /dataset/${id}
    @DeleteMapping("/dataset/{id}")
    public ResponseEntity<?> deleteComplaint(@PathVariable Long id) {
        if (service.deleteComplaint(id))
            return new ResponseEntity<>("Deleted successfully!", new HttpHeaders(), HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //4 POST dataset
    @PostMapping(value = "/dataset", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertByCmplnt_Num_Ky_Cd(@RequestBody Dto dto) {
        try {
            service.saveInDb(dto);

            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Fail to Execute Endpoint", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
