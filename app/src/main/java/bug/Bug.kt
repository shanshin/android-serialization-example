@file:OptIn(ExperimentalSerializationApi::class)

package bug

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@JsonClassDiscriminator("entity")
@Serializable
sealed class SyncEntity

@Serializable
@SerialName("category")
data class SyncCategory(
    val id: Long,
    val type: Category.Type, // enum class
) : SyncEntity()

@Serializable
data class Category(val i: Int) {
    enum class Type {
        ATYPE, BTYPE, CTYPE,
    }
}