package project.Inventory_management_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.Inventory_management_backend.entity.Inventory;
@Repository
public interface InventoryRepository extends JpaRepository <Inventory, Long>{
}
