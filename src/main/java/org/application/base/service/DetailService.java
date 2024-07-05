package org.application.base.service;

import org.application.base.models.Detail;
import org.application.base.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DetailService {
    public DetailRepository detailRepository;
    @Autowired
    public DetailService(DetailRepository detailRepository){
        this.detailRepository = detailRepository;
    }
    public List<Detail> getAllDetails(){
        return detailRepository.findAll();
    }
    public Detail createDetails(Detail detail){
        return detailRepository.save(detail);
    }
    public Detail getDetailById(long detailId) {
        return detailRepository.findById(detailId)
                .orElseThrow(() -> new RuntimeException("Cell not found with id: " + detailId));
    }
    public Detail getDetailByName(String detailName) {
        return detailRepository.findByDetailName(detailName);
    }

    public Detail updateDetailToNull(String name) {
        Detail existingDetail = detailRepository.findByDetailName(name);
        existingDetail.setDetailName(null);
        existingDetail.setQuantity(0);
        return detailRepository.save(existingDetail);
    }
    public Detail updateDetail(Long detailId, Detail detail) {
        Detail existingDetail = detailRepository.findById(detailId).orElseThrow(() -> new EntityNotFoundException("Detail not found with id: " + detailId));
        existingDetail.setDetailName(detail.getDetailName());
        existingDetail.setQuantity(detail.getQuantity());
        return detailRepository.save(existingDetail);
    }
    public Detail updateDetailsQuantity(int quantity,String name){
        Detail existingDetail = detailRepository.findByDetailName(name);
        existingDetail.setQuantity(quantity);
        return detailRepository.save(existingDetail);
    }
}
