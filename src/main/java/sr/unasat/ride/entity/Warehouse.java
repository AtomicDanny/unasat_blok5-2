package sr.unasat.ride.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long warehouseId;

    @Column(unique = true, nullable = false)
    private String warehouseName;


    @ManyToMany(mappedBy = "userWarehouse")
    List<User> warehouses;

    public Warehouse(){}

    public Warehouse(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }



    public List<User> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<User> warehouses) {
        this.warehouses = warehouses;
    }
}
