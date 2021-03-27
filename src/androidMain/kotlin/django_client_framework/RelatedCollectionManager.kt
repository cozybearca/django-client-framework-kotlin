package django_client_framework

class RelatedCollectionManager<T:Model, P:Model>(val parent:P, val key: String) {
    /**
     * .page() returns the search results filtered with the query dictionary.
     * If any key of the dictionary is not a valid query key, an InvalidQueryKeyError is thrown.
     *
     * Example:
     *      val product = Product(id: 1, ...)
     *      val page = product.categories.page(
     *          mapOf(
     *              "id__in" to listOf(1,2),
     *              "name" to "xxyy"
     *          ),
     *          Pagination(limit=50, page=2, order_by: "id")
     *      )
     *
     * It sends a GET request with the query parameters:
     *      GET /api/v1/product/1/categories?id__in[]=1&id__in[]=2&name=xxyy&_limit=50&_page=2&_order_by=id
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
     *      val product = Product(id: 1, ...)
     *      val obj = product.categories.get(
     *          mapOf(
     *              "id__in" to listOf(1,2),
     *              "name" to "xxyy"
     *          )
     *      )
     *
     * It sends a GET request with the query parameters:
     *      GET /api/v1/product/1/categories?id__in[]=1&id__in[]=2&name=xxyy
     */
    suspend fun get(query: Map<String, Any?>): ObjectManager<T> {
        throw NotImplementedError()
    }

    /**
     * .add_ids() add associated objects by their ids.
     *
     * Example:
     *      val product = Product(id:1, ...)
     *      product.categories.add_ids(listOf(1,2,3)) // add category 1, 2, 3 to product categories list
     *      val categories = product.categories.page(..) // contains categories with ids 1,2,3
     *
     * It sends a POST request:
     *      POST /api/v1/product/1/categories [1,2,3]
     */
    suspend fun add_ids(ids: List<Long>) {
        throw NotImplementedError()
    }

    suspend fun add(objects: List<T>) {
        return add_ids(objects.map { it.id })
    }

    /**
     * .set_ids() is same as /add() except it clears the associated objects before adding
     *
     * Example:
     *      val product = Product(id:1, ...)
     *      product.categories.add_ids(listOf(1,2,3)) // add category 1, 2, 3 to product categories list
     *      val categories = product.categories.page(..) // contains categories with ids 1,2,3
     *
     * It sends a POST request:
     *      PATCH /api/v1/product/1/categories [1,2,3]
     */
    suspend fun set_ids(ids: List<Long>) {
        throw NotImplementedError()
    }

    suspend fun set(objects: List<T>) {
        return set_ids(objects.map { it.id })
    }

    /**
     * .remove_ids() removes objects association by ids
     *
     * Example:
     *      val product = Product(id:1, ...)
     *      product.categories.remove_ids(listOf(1,2,3))
     *
     * It sends a POST request:
     *      DELETE /api/v1/product/1/categories [1,2,3]
     */
    suspend fun remove_ids(ids: List<Long>) {
        throw NotImplementedError()
    }


    suspend fun remove(objects: List<T>) {
        return remove_ids(objects.map { it.id })
    }

}
