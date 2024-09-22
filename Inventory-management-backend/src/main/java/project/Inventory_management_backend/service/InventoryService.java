package project.Inventory_management_backend.service;

import project.Inventory_management_backend.dto.InventoryDto;

import java.util.List;

public interface InventoryService {
    InventoryDto crateInventory(InventoryDto inventoryDto);

    InventoryDto getInventoryById(Long inventoryId);

    List<InventoryDto> getAllInventory();

    InventoryDto updateInventory(Long item, InventoryDto updatedItem);

    void deleteInventory(Long inventoryId);
}
