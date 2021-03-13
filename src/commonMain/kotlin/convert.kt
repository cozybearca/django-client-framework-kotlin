import kotlinx.serialization.*
import kotlinx.serialization.json.*

inline fun<reified T> convert(json: String): T {
    return Json.decodeFromString<T>(json)
}
