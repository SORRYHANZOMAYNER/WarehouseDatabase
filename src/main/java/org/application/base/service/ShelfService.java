package org.application.base.service;

import org.application.base.models.Shelf;
import org.application.base.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfService {
    public ShelfRepository shelfRepository;
    public ShelfService(){}
    @Autowired
    public ShelfService(ShelfRepository shelfRepository){
        this.shelfRepository = shelfRepository;
    }
    public List<Shelf> getAllShelfs(){
        return shelfRepository.findAll();
    }
    public Shelf createShelf(Shelf shelf){
        return shelfRepository.save(shelf);
    }
    public Shelf getShelfById(Long shelfId) {
        return shelfRepository.findById(shelfId).orElseThrow(() -> new RuntimeException("Shelf not found with id: " + shelfId));
    }

}
