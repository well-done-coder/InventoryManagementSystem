package project.Inventory_management_backend.mapper;

import project.Inventory_management_backend.dto.InventoryDto;
import project.Inventory_management_backend.entity.Inventory;


public class InventoryMapper {

    public static InventoryDto mapToInventoryDto(Inventory inventory){
        return new InventoryDto(
                inventory.getId(),
                inventory.getItem(),
                inventory.getQuantity(),
                inventory.getItemRate()
                );
    }

    public static Inventory mapToInventory(InventoryDto inventoryDto){
        return new Inventory(
                inventoryDto.getId(),
                inventoryDto.getItem(),
                inventoryDto.getQuantity(),
                inventoryDto.getItemRate()
        );
    }
}
