package org.example.base.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Shelf")
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shelfId;
    @OneToMany(mappedBy = "shelf_fk",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Detail> cells = new ArrayList<>();
    public List<Detail> getDetails() {
        return cells;
    }

    public void setDetails(List<Detail> cells) {
        this.cells = cells;
    }

    public long getShelfId() {
        return shelfId;
    }

    public void setShelfId(long shelfId) {
        this.shelfId = shelfId;
    }

    public Shelf() {
        for (int i = 0; i < 10; i++) {
            cells.add(new Detail());
        }
    }
}
