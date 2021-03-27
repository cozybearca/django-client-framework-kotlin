package django_client_framework

public class ObjectManager<T: Model>(
    val obj: T
) {
    /**
     * .refresh() pulls data from the server and updates the local data
     * Example:
     *      val obj = Product(id = 1, ...)
     *      // data changes in the backend
     *      obj.refresh()
     *      print(obj)
     *
     * It sends a GET request to the server:
     *      GET /api/v1/product/1
     */
    suspend fun refresh(): Unit {
        throw NotImplementedError()
    }

    /**
     * .delete() removes the data from the server
     * Example:
     *      val obj = Product(id = 1, ...)
     *      obj.delete() // product 1 is deleted from the server
     *
     * It sends a DELETE request to the server:
     *      DELETE /api/v1/product/1
     */
    suspend fun delete(): Unit {
        throw NotImplementedError()
    }

    /**
     * .save() updates the server with properties that have been changed on the object
     * Example:
     *      val obj = Product(...) // Data from server
     *      obj.barcode = "xxyy"
     *      obj.price = null
     *      obj.brand_id = 2
     *      obj.save()
     *
     * It sends a PATCH request to the server:
     *      PATCH /api/v1/product/1 {"barcode": "xxyy", "price": null, "brand_id": 2}
     */
    suspend fun save(): Unit {
        throw NotImplementedError()
    }

    /**
     * .update() updates the server with a dictionary, and also saves the changes locally.
     * If the dictionary contains a key that is not a property name, the method throws an error.
     * Example:
     *      val obj = Product(...)
     *      obj.update(
     *          mapOf(
     *              "barcode" to "xxyy",
     *              "price" to null
     *          )
     *      )
     *
     * It sends a PATCH request to the server:
     *      PATCH /api/v1/product/1 {"barcode": "xxyy", "price": null}
     */
    suspend fun update(vals: Map<String, Any?>): Unit {
        throw NotImplementedError()
    }
}
