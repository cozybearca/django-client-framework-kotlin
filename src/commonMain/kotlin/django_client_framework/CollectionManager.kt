package django_client_framework

data class Pagination(
    val limit: Int = 50,
    val page: Int = 1,
    val order_by: String? = null
)

class CollectionManager<T : Model> {
    /**
     * .page() returns the search results filtered with the query dictionary.
     * If any key of the dictionary is not a valid query key, an InvalidQueryKeyError is thrown.
     *
     * Example:
     *      val page = Product.objects.page(
     *          mapOf(
     *              "id__in" to listOf(1,2),
     *              "name" to "xxyy"
     *          ),
     *          Pagination(limit=50, page=2, order_by: "id")
     *      )
     *
     * It sends a GET request with the query parameters:
     *      GET /api/v1/product?id__in[]=1&id__in[]=2&name=xxyy&_limit=50&_page=2&_order_by=id
     *
     */
    suspend fun page(query: Map<String, Any?> = emptyMap(), page: Pagination = Pagination()): PageResult<T> {
        
        throw NotImplementedError()
    }

    /**
     * .get() returns a search result filtered with the query dictionary.
     * Exactly one result is expected from the server. If the server responses with an empty result or multiple results,
     * then an InvalidObjectCount error is thrown.
     * If any key of the dictionary is not a valid query key, an InvalidQueryKeyError is thrown.
     *
     * Example:
     *      val obj = Product.objects.get(
     *          mapOf(
     *              "id__in" to listOf(1,2),
     *              "name" to "xxyy"
     *          )
     *      )
     *
     * It sends a GET request with the query parameters:
     *      GET /api/v1/product?id__in[]=1&id__in[]=2&name=xxyy
     */
    suspend fun get(query: Map<String, Any?>): ObjectManager<T> {
        throw NotImplementedError()
    }

    /**
     * .create() saves an object on the server with the provided data.
     * If any key of the dictionary is not a valid query key, an InvalidQueryKeyError is thrown.
     *
     * Example:
     *      val obj = Product.objects.create(
     *          mapOf(
     *              "name": "xxyy",
     *              "price": null
     *          )
     *      )
     *
     * It sends a POST request with JSON:
     *      POST /api/v1/product {"name": "xxyy", "price": null}
     */
    suspend fun create(query: Map<String, Any?>): ObjectManager<T> {
        throw NotImplementedError()
    }

    /**
     * .get_or_create() first tries to .get() the object with the query dictionary. If the object does not exist, then
     * it .create() the object by using values on both query and defaults
     *
     * Example:
     *      val obj = Product.objects.get_or_create(
     *          query = mapOf(
     *              "name": "xxyy"
     *          ),
     *          defaults = mapOf(
     *              "price": null
     *          )
     *      )
     *
     * It sends a GET request:
     *      GET /api/v1/product?name="xxyy"
     * If the object does not exist, then sends a POST request with JSON:
     *      POST /api/v1/product {"name": "xxyy", "price": null}
     */
    suspend fun get_or_create(query: Map<String, Any?>, defaults: Map<String, Any?> = emptyMap()): ObjectManager<T> {
        throw NotImplementedError()
    }


    /**
     * .update_or_create() first tries to .get() the object with the query dictionary. If the object exist, then
     * it updates the object by using the values of defaults. If the object does not exist, then it .create() the object
     * by using values on both query and defaults.
     *
     * Example:
     *      val obj = Product.objects.update_or_create(
     *          query = mapOf(
     *              "name": "xxyy"
     *          ),
     *          defaults = mapOf(
     *              "price": null
     *          )
     *      )
     *
     * It sends a GET request:
     *      GET /api/v1/product?name="xxyy"
     * If the object exist, get the object, then sends a PATCH request with JSON:
     *      PATCH /api/v1/product/{id} {"price": null}
     * If the object does not exist, then sends a POST request with JSON:
     *      POST /api/v1/product {"name": "xxyy", "price": null}
     */
    suspend fun update_or_create(query: Map<String, Any?>, defaults: Map<String, Any?> = emptyMap()): ObjectManager<T> {
        throw NotImplementedError()
    }
}
