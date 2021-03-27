package django_client_framework
import kotlinx.serialization.Serializable

@Serializable
data class PageResult<T: Model>(
    val page: Int = 0,
    val limit: Int = 0,
    val total: Int = 0,
    val previous: String?,
    val next: String?,
    val objects: List<T> = emptyList()
) {
    fun managers(): List<ObjectManager<T>> {
        return objects.map { x:T -> x.manager() }
    }
}