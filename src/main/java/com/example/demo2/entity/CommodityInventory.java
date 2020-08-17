package com.example.demo2.entity;

/**
 * 商品库存
 */
public class CommodityInventory {
    /**
     *
     */
    private Integer id;
    /**
     * 商品名称
     */
    private String cname;
    /**
     * 库存
     */
    private Integer inventory;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "CommodityInventory{" +
                "id=" + id +
                ", cName='" + cname + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
