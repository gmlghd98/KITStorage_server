package kr.ac.kumoh.s20170523.KIT_storage_backend.repository

import kr.ac.kumoh.s20170523.KIT_storage_backend.model.Inventory
import org.springframework.data.mongodb.repository.MongoRepository

interface InventoryRepository: MongoRepository<Inventory, String> {
    fun findByUser(user: String): List<Inventory>
}