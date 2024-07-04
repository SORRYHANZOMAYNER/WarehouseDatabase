package org.example.base.controllers;

import org.example.base.models.Detail;
import org.example.base.models.Shelf;
import org.example.base.service.ShelfService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api1/v1")
public class ShelfController {


    public static ShelfService shelfService;

    public ShelfController(ShelfService shelfService){
        this.shelfService  = shelfService;
    }
    @GetMapping("/shelf")
    public List<Shelf> getShelf(){

        return shelfService.getAllShelfs();
    }
    @PostMapping("/shelf")
    public Shelf createShelfs(@RequestBody Shelf shelf){
        shelfService.createShelf(shelf);
        return shelf;
    }


}
