package kr.ac.kumoh.s20170523.KIT_storage_backend.controller

import kr.ac.kumoh.s20170523.KIT_storage_backend.model.Inventory
import kr.ac.kumoh.s20170523.KIT_storage_backend.service.InventoryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/inventories")
class InventoryController(private val service:InventoryService) {
    @GetMapping
    fun getAllInventories(): List<Inventory> = service.getAllInventories()

    @GetMapping("/{id}")
    fun getInventoryById(@PathVariable id:String): Inventory? = service.getInventoryById(id)

    @GetMapping("/user/{user}")
    fun getInventoryByUser(@PathVariable user: String): List<Inventory> = service.getInventoryByUser(user)

    @PostMapping
    fun addInventory(@RequestBody inventory: Inventory): Inventory = service.addInventory(inventory)

    @PutMapping("/{id}")
    fun updateInventory(@PathVariable id: String, @RequestBody inventoryDetails: Inventory): Inventory? =  service.updateInventory(id, inventoryDetails)

    @DeleteMapping("/{id}")
    fun deleteInventory(@PathVariable id: String): Map<String, String> {
        return if (service.deleteInventory(id))
            mapOf("status" to "deleted")
        else
            mapOf("status" to "not found")
    }
}