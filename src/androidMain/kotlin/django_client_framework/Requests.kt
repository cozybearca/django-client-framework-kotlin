package django_client_framework
import okhttp3.*

class Requests {
    var client = OkHttpClient()

    fun runFiles(url: String): String {
        val request: Request = Request.Builder()
            .url(url)
            .build()
        val response: okhttp3.Response = client.newCall(request).execute()
        val body = response.body?.string()
        if (body != null) return body;
        return "Error"
    }
}