package project.Inventory_management_backend.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.Inventory_management_backend.dto.InventoryDto;
import project.Inventory_management_backend.entity.Inventory;
import project.Inventory_management_backend.exception.ResourceNotFoundException;
import project.Inventory_management_backend.mapper.InventoryMapper;
import project.Inventory_management_backend.repository.InventoryRepository;
import project.Inventory_management_backend.service.InventoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private InventoryRepository inventoryRepository;
    @Override
    public InventoryDto crateInventory(InventoryDto inventoryDto) {

        Inventory inventory = InventoryMapper.mapToInventory(inventoryDto);
        Inventory savedInventory = inventoryRepository.save(inventory);
        return InventoryMapper.mapToInventoryDto(savedInventory);

    }

    @Override
    public InventoryDto getInventoryById(Long inventoryId) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Item is not exist with given id :" + inventoryId));
        return InventoryMapper.mapToInventoryDto(inventory);
    }

    @Override
    public List<InventoryDto> getAllInventory() {
        List<Inventory> items = inventoryRepository.findAll();
        return items.stream().map((inventory) ->InventoryMapper.mapToInventoryDto(inventory))
                .collect(Collectors.toList());
    }

    @Override
    public InventoryDto updateInventory(Long itemid, InventoryDto updatedItem) {
        Inventory inventory = inventoryRepository.findById(itemid)
                .orElseThrow(() -> new ResourceNotFoundException("Item is not exist with given id :"+ itemid));

        inventory.setItem(updatedItem.getItem());
        inventory.setQuantity(updatedItem.getQuantity());
        inventory.setItemRate(updatedItem.getItemRate());

        Inventory updatedInventory = inventoryRepository.save(inventory);

        return InventoryMapper.mapToInventoryDto(updatedInventory);
    }

    @Override
    public void deleteInventory(Long inventoryId) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Item is not exist with given id :"+ inventoryId));
        inventoryRepository.deleteById(inventoryId);
    }
}
