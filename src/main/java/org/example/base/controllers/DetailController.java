package org.example.base.controllers;

import org.example.base.models.Detail;
import org.example.base.service.DetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api1/v1")
public class DetailController {


    public DetailService detailService;
    public DetailController(DetailService detailService){
        this.detailService = detailService;
    }
    @GetMapping("/details")
    public List<Detail> getDetails(){

        return detailService.getAllDetails();
    }
    @GetMapping("/details/{detailName}")
    public ResponseEntity<Detail> getDetailByName(@PathVariable String detailName) {
        Detail detail = detailService.getDetailByName(detailName);

        if (detail == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(detail, HttpStatus.OK);
        }
    }
    @PostMapping("/details")
    public Detail createDetail(@RequestBody Detail detail){
        detailService.createDetails(detail);
        return detail;
    }
    @PutMapping("/details/null/{name}")
    public ResponseEntity<Detail> updateDetail(@PathVariable String name) {
        Detail updatedDetail = detailService.updateDetailToNull(name);
        return new ResponseEntity<>(updatedDetail, HttpStatus.OK);
    }
    @PutMapping("/details/{detailId}")
    public ResponseEntity<Detail> updateDetail(@PathVariable Long detailId, @RequestBody Detail detail) {
        Detail updatedDetail = detailService.updateDetail(detailId, detail);
        return new ResponseEntity<>(updatedDetail, HttpStatus.OK);
    }
    @PutMapping("/details/update/{quantity}")
    public ResponseEntity<Detail> updateDetailsQuantity(@PathVariable int quantity,@RequestBody Detail detail) {
        Detail updatedDetail = detailService.updateDetailsQuantity(quantity,detail.getDetailName());
        return new ResponseEntity<>(updatedDetail, HttpStatus.OK);
    }

}
