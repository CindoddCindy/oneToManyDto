package com.dtoonetomany.dtoonetomany.dto;

import com.dtoonetomany.dtoonetomany.model.Shelf;
import com.dtoonetomany.dtoonetomany.model.Warehouse;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@Data
public class ShelfDto {

    private Long id;
    private String code;
    private Long warehouseId;

    public ShelfDto(Shelf shelf) {
        BeanUtils.copyProperties(shelf, this, "warehouseId");

        Warehouse warehouse = shelf.getWarehouse();
        if (warehouse != null) {
            this.warehouseId = warehouse.getId();
        }
    }
}
