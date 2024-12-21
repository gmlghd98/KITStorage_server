package kr.ac.kumoh.s20170523.KIT_storage_backend.controller

import kr.ac.kumoh.s20170523.KIT_storage_backend.model.Inventory
import kr.ac.kumoh.s20170523.KIT_storage_backend.service.InventoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class InventoryController(private val service:InventoryService) {
    @GetMapping("api/inventories")
    fun getAllInventories(): List<Inventory> = service.getAllInventories()
}