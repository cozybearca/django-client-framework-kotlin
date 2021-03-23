import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import django_client_framework.*

class SampleTests {
    @Test
    fun testProxy() {
        val x = getData()
        var strng = "A"
        var S = x.runFile("https://cozybear.ca/api/v1/product?_limit=50&_page=1")
        if (S != null){
            strng = S
        }
        println("CONVERT BELOW:")
        //println(S)

        val result2 = convert<PageResult<Product>>(strng.trimIndent())
        //assertEquals(result2.page, 1)
        print (result2.objects[0].barcode.toString())

        val result = convert<Product>("""
            {"id": 628, "displayable_status": "\\u7b49\\u5f85\\u4fee\\u6539", "base_price": "0.00", "final_price": "0.00", "tax_rate": "0.00", "name_zh": "", "name_en": "Monster Energy Drink Salted Caramel 473 ML - My Convenience Store", "description": "", "weight_g": 0, "weight_oz": 0, "volume_ml": 0, "volume_oz": 0, "description_md": "", "barcode": "070847027249", "leftover": 99, "date_created": "2019-09-06T00:30:28.036000-04:00", "date_modified": "2020-11-19T12:33:11.497093-05:00", "status": "PU", "pricing_unit": "unit", "shipping_available": false, "sameday_delivery_available": false, "nextday_delivery_available": false, "pickup_available": false, "deliverynow_available": false, "replacing_id": null, "parent_id": null, "brand_id": null}
        """.trimIndent())
        assertEquals(628, result.id)
    }
}
