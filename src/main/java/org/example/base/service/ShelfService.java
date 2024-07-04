package org.example.base.service;

import org.example.base.models.Shelf;
import org.example.base.repository.ShelfRepository;
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
