package project.Inventory_management_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.Inventory_management_backend.dto.InventoryDto;
import project.Inventory_management_backend.service.InventoryService;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private InventoryService inventoryService;

    //Post API
    @PostMapping
    public ResponseEntity<InventoryDto> createInventory(@RequestBody InventoryDto inventoryDto){
        InventoryDto savedInventory = inventoryService.crateInventory(inventoryDto);
        return new ResponseEntity<>(savedInventory, HttpStatus.CREATED);
    }
    //Get API
    @GetMapping("{id}")
    public ResponseEntity<InventoryDto> getInventory(@PathVariable("id") Long itemid){
       InventoryDto inventoryDto = inventoryService.getInventoryById(itemid);
       return ResponseEntity.ok(inventoryDto);
    }

    //Get All Items REST API
    @GetMapping
    public ResponseEntity<List<InventoryDto>> getAllInventory(){
        List<InventoryDto> items = inventoryService.getAllInventory();
        return ResponseEntity.ok(items);
    }

    //update Item REST API
    @PutMapping("{id}")
    public ResponseEntity<InventoryDto> updateInventory(@PathVariable("id") Long item, @RequestBody InventoryDto updatedInventory){
        InventoryDto inventoryDto = inventoryService.updateInventory(item, updatedInventory);
        return ResponseEntity.ok(inventoryDto);
    }
    //delete inventory REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteInventory(@PathVariable("id") Long inventoryId){
       inventoryService.deleteInventory(inventoryId);
       return ResponseEntity.ok("Item deleted Successfully in the Inventory");
    }
}
