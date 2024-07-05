package org.application.base.controllers;

import org.application.base.models.Shelf;
import org.application.base.service.ShelfService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
