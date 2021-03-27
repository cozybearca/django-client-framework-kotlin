import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

inline fun<reified T> convert(json: String): T {
    return Json.decodeFromString<T>(json)
}
