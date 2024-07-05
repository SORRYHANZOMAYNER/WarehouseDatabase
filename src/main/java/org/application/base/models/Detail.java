package org.application.base.models;

import javax.persistence.*;

@Entity
@Table(name = "Detail")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long detailId;
    private String detailName;
    private int quantity;
    @ManyToOne
    private Shelf shelf_fk;

    public long getDetailId() {
        return detailId;
    }

    public void setDetailId(long detailId) {
        this.detailId = detailId;
    }
    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Detail(){

    }
    public Detail(String name,int quantity){
        this.detailName = name;
        this.quantity = quantity;
    }


}
