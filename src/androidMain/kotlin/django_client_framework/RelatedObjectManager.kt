package django_client_framework


class RelatedObjectManager<T:Model, P:Model>(val parent:P, val key: String) {
    /**
     * .get() returns the object associated with the current object.
     *
     * Example:
     *      val product = Product(id=1, ...) // data from server
     *      val brand = product.brand.get()
     *
     * It sends a GET request to the url:
     *      GET /api/v1/product/1/brand
     */
    suspend fun get(): ObjectManager<T>? {
        throw NotImplementedError()
    }

    /**
     * .set() sets the object associated with the object
     *
     * Example:
     *      val product = Product(id=1, ...) // data from server
     *      val brand = Brand(...)
     *      product.brand.set(brand)
     *
     * It sends a PATCH request:
     *      PATCH /api/v1/product/1 {brand: 1}
     */
    suspend fun set(target: T?) {
        throw NotImplementedError()
    }
}
