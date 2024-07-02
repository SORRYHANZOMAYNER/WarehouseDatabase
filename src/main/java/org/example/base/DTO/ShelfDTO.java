package org.example.base.DTO;

import java.util.List;


public class ShelfDTO {
    private long shelfId;
    private List<DetailDTO> cells;

    public ShelfDTO setShelfId(long shelfId) {
        this.shelfId = shelfId;
        return this;
    }

    public void setDetails(List<DetailDTO> cells) {
        this.cells = cells;
    }
    public List<DetailDTO> getDetails(){return cells;}

    public long getShelfId() {
        return  shelfId;
    }
}

