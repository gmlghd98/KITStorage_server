package kr.ac.kumoh.s20170523.KIT_storage_backend.service

import kr.ac.kumoh.s20170523.KIT_storage_backend.model.Inventory
import kr.ac.kumoh.s20170523.KIT_storage_backend.repository.InventoryRepository
import org.springframework.stereotype.Service

@Service
class InventoryService(private val repository: InventoryRepository) {
    fun getAllInventories(): List<Inventory> = repository.findAll()
}