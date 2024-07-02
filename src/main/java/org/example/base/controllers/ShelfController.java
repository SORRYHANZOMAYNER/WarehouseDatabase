package org.example.base.controllers;

import org.example.base.DTO.DetailDTO;
import org.example.base.DTO.ShelfDTO;
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
    public ShelfDTO createShelfs(@RequestBody ShelfDTO shelf){
        var post = toEntity(shelf); // Сначала в Entity
        shelfService.createShelf(post);
        var postDTO = toDTO(post); // Потом в DTO
        return postDTO;
    }
    public static ShelfDTO toDTO(Shelf shelf) {
        ShelfDTO shelfDTO = new ShelfDTO();
        shelfDTO.setShelfId(shelf.getShelfId());
        List<DetailDTO> detailDTOList = shelf.getDetails().stream()
                .map(cell -> {
                    DetailDTO detailDTO = new DetailDTO();
                    detailDTO.setDetailName(cell.getDetailName());
                    detailDTO.setQuantity(cell.getQuantity());
                    detailDTO.setDetailId(cell.getDetailId());
                    return detailDTO;
                })
                .collect(Collectors.toList());
        shelfDTO.setDetails(detailDTOList);
        return shelfDTO;
    }
    public static Shelf toEntity(ShelfDTO shelfDTO) {
        Shelf shelf = new Shelf();
        shelf.setShelfId(shelfDTO.getShelfId());
        List<Detail> cellList = shelfDTO.getDetails().stream()
                .map(cellDTO -> {
                    Detail cell = new Detail();
                    cell.setDetailName(cellDTO.getDetailName());
                    cell.setQuantity(cellDTO.getQuantity());
                    cell.setDetailId(cellDTO.getDetailId());
                    return cell;
                })
                .collect(Collectors.toList());
        shelf.setDetails(cellList);
        return shelf;
    }


}
