// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json    = Json(JsonConfiguration.Stable)
// val product = json.parse(Product.serializer(), jsonString)

package django_client_framework

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class Product (
    val barcode: String,

    @SerialName("base_price")
    val basePrice: String,

    @SerialName("brand_id")
    val brandID: Long? = null,

    @SerialName("date_created")
    val dateCreated: String,

    @SerialName("date_modified")
    val dateModified: String,

    @SerialName("deliverynow_available")
    val deliverynowAvailable: Boolean,

    val description: String? = null,

    @SerialName("description_md")
    val descriptionMd: String? = null,

    @SerialName("displayable_status")
    val displayableStatus: String,

    @SerialName("final_price")
    val finalPrice: String,

    override val id: Long,
    val leftover: Long,

    @SerialName("name_en")
    val nameEn: String? = null,

    @SerialName("name_zh")
    val nameZh: String? = null,

    @SerialName("nextday_delivery_available")
    val nextdayDeliveryAvailable: Boolean,

    @SerialName("parent_id")
    val parentID: Long? = null,

    @SerialName("pickup_available")
    val pickupAvailable: Boolean,

    @SerialName("pricing_unit")
    val pricingUnit: PricingUnit,

    @SerialName("replacing_id")
    val replacingID: Long? = null,

    @SerialName("sameday_delivery_available")
    val samedayDeliveryAvailable: Boolean,

    @SerialName("shipping_available")
    val shippingAvailable: Boolean,

    val status: Status,

    @SerialName("tax_rate")
    val taxRate: String,

    @SerialName("volume_ml")
    val volumeMl: Long,

    @SerialName("volume_oz")
    val volumeOz: Long,

    @SerialName("weight_g")
    val weightG: Long,

    @SerialName("weight_oz")
    val weightOz: Long
): Model

@Serializable(with = PricingUnit.Companion::class)
enum class PricingUnit(val value: String) {
    Box("box"),
    Pack("pack"),
    Unit("unit");

    companion object : KSerializer<PricingUnit> {
        override val descriptor: SerialDescriptor get() {
            return PrimitiveSerialDescriptor("django_client_framework.PricingUnit", PrimitiveKind.STRING)
        }
        override fun deserialize(decoder: Decoder): PricingUnit = when (val value = decoder.decodeString()) {
            "box"  -> Box
            "pack" -> Pack
            "unit" -> Unit
            else   -> throw IllegalArgumentException("PricingUnit could not parse: $value")
        }
        override fun serialize(encoder: Encoder, value: PricingUnit) {
            return encoder.encodeString(value.value)
        }
    }
}

@Serializable(with = Status.Companion::class)
enum class Status(val value: String) {
    D("D"),
    E("E"),
    PR("PR"),
    Pu("PU");

    companion object : KSerializer<Status> {
        override val descriptor: SerialDescriptor get() {
            return PrimitiveSerialDescriptor("django_client_framework.Status", PrimitiveKind.STRING)
        }
        override fun deserialize(decoder: Decoder): Status = when (val value = decoder.decodeString()) {
            "D"  -> D
            "E"  -> E
            "PR" -> PR
            "PU" -> Pu
            else -> throw IllegalArgumentException("Status could not parse: $value")
        }
        override fun serialize(encoder: Encoder, value: Status) {
            return encoder.encodeString(value.value)
        }
    }
}