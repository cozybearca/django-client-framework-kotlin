import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import django_client_framework.*

@Serializable
data class Product (
    val barcode: String,
    val base_price: String,
    val brand_id: Long? = null,
    val date_created: String,
    val date_modified: String,
    val deliverynow_available: Boolean,
    val description: String? = null,
    val description_md: String? = null,
    val displayable_status: String,
    val final_price: String,
    override val id: Long,
    val leftover: Long,
    val name_en: String? = null,
    val name_zh: String? = null,
    val nextday_delivery_available: Boolean,
    val parent_id: Long? = null,
    val pickup_available: Boolean,
    val pricing_unit: PricingUnit,
    val replacing_id: Long? = null,
    val sameday_delivery_available: Boolean,
    val shipping_available: Boolean,
    val status: Status,
    val tax_rate: String,
    val volume_ml: Long,
    val volume_oz: Long,
    val weight_g: Long,
    val weight_oz: Long
): Model {
    val replaced_by: RelatedObjectManager<Product, Product>
        get() { return RelatedObjectManager(this, "replaced_by") }
    val children: RelatedCollectionManager<Product, Product>
        get() { return RelatedCollectionManager(this, "children") }
    val replacing: RelatedObjectManager<Product, Product>
        get() { return RelatedObjectManager(this, "replacing") }
    val parent: RelatedObjectManager<Product, Product>
        get() { return RelatedObjectManager(this, "parent") }
//    val brand: RelatedObjectManager<Brand, Product>
//        get() { return RelatedObjectManager(this, "brand") }
}

enum class PricingUnit { box, pack, unit }

enum class Status { D, E, PR, PU }

@Serializable
data class Order (
    val assigned_delivery_service_id: Long? = null,
    val customer_notes: String? = null,
    val customer_status: CustomerStatus,
    val datetime_placed: String,
    val delivery_address: String? = null,
    val delivery_charge: String,
    val delivery_charge_rebated: String,
    val delivery_contact: String? = null,
    val delivery_distance: Long,
    val delivery_method: DeliveryMethod,
    val delivery_pickup_location: DeliveryPickupLocation? = null,
    val delivery_requires_signature: Boolean? = null,
    val delivery_service_status: String? = null,
    val delivery_unit_code: String? = null,
    val delivery_unit_number: String? = null,
    val displayable_customer_status: String,
    val displayable_datetime_placed: String,
    val displayable_delivery_method: String,
    val displayable_shop_status: String,
    val final_charge: String,
    override val id: Long,
    val last_notified_shop: String? = null,
    val participated_delivery_services: List<Long>,
    val product_charge: String,
    val product_charge_rebated: String,
    val product_name_list: List<String>,
    val products: List<Long>,
    val shop_status: ShopStatus,
    val user_id: Long
): Model {
}

enum class CustomerStatus { paid, received, unpaid }

enum class DeliveryMethod { nextday, now, pickup, sameday, shipping }

enum class DeliveryPickupLocation { loc1 }

enum class ShopStatus { confirmed, delivered, dispatched, rejected, unconfirmed }
