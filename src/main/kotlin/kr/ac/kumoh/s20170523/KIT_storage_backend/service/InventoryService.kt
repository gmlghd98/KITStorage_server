package kr.ac.kumoh.s20170523.KIT_storage_backend.service

import kr.ac.kumoh.s20170523.KIT_storage_backend.model.Inventory
import kr.ac.kumoh.s20170523.KIT_storage_backend.repository.InventoryRepository
import org.springframework.stereotype.Service

@Service
class InventoryService(private val repository: InventoryRepository) {
    fun addInventory(inventory: Inventory): Inventory = repository.save(inventory)

    fun getAllInventories(): List<Inventory> = repository.findAll()
    fun getInventoryById(id: String): Inventory? = repository.findById(id).orElse(null)
    fun getInventoryByUser(user: String): List<Inventory> = repository.findByUser(user)

    fun updateInventory(id: String, inventory: Inventory): Inventory? {
        val inventoryTarget = repository.findById(id)

        return if (inventoryTarget.isPresent) {
            val oldSong = inventoryTarget.get()
            val updatedSong = oldSong.copy(
                image = inventory.image,
                name = inventory.name,
                user = inventory.user,
                quantity = inventory.quantity,
                startDate = inventory.startDate,
                endDate = inventory.endDate,
            )
            repository.save(updatedSong)
        } else {
            null
        }
    }

    fun deleteInventory(id: String): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else {
            false
        }
    }

}