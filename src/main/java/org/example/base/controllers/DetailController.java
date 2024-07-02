package org.example.base.controllers;

import org.example.base.DTO.DetailDTO;
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
    public ResponseEntity<DetailDTO> getDetailByName(@PathVariable String detailName) {
        Detail detail = detailService.getDetailByName(detailName);

        if (detail == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(DetailToDto(detail), HttpStatus.OK);
        }
    }
    @PostMapping("/details")
    public DetailDTO createDetail(@RequestBody DetailDTO detailDTO){
        var detail = DetailToEntity(detailDTO);
        detailService.createDetails(detail);
        var detailDTO2 = DetailToDto(detail);
        return detailDTO2;
    }
    @PutMapping("/details/null/{name}")
    public ResponseEntity<DetailDTO> updateDetail(@PathVariable String name) {
        Detail updatedDetail = detailService.updateDetailToNull(name);
        return new ResponseEntity<>(DetailToDto(updatedDetail), HttpStatus.OK);
    }
    @PutMapping("/details/{detailId}")
    public ResponseEntity<DetailDTO> updateDetail(@PathVariable Long detailId, @RequestBody DetailDTO detailDTO) {
        Detail updatedDetail = detailService.updateDetail(detailId, DetailToEntity(detailDTO));
        return new ResponseEntity<>(DetailToDto(updatedDetail), HttpStatus.OK);
    }
    @PutMapping("/details/update/{quantity}")
    public ResponseEntity<DetailDTO> updateDetailsQuantity(@PathVariable int quantity,@RequestBody DetailDTO detailDTO) {
        Detail updatedDetail = detailService.updateDetailsQuantity(quantity,detailDTO.getDetailName());
        return new ResponseEntity<>(DetailToDto(updatedDetail), HttpStatus.OK);
    }
    public static Detail DetailToEntity(DetailDTO detailDTO) {
        Detail detail = new Detail();
        detail.setDetailName(detailDTO.getDetailName());
        detail.setQuantity(detailDTO.getQuantity());
        detail.setDetailId(detailDTO.getDetailId());
        return detail;
    }
    public static DetailDTO DetailToDto(Detail detail) {
        DetailDTO detailDTO = new DetailDTO()
                .setDetailName(detail.getDetailName())
                .setQuantity(detail.getQuantity());
        detailDTO.setDetailId(detail.getDetailId());
        return detailDTO;
    }
}
