package kr.ac.kumoh.s20170523.KIT_storage_backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date

@Document(collection = "inventories")
data class Inventory(
    @Id val id: String? = null,
    val image: String,
    val name: String,
    val user: String,
    val quantity: Int,
    val startDate: Date,
    val endDate: Date,
)
