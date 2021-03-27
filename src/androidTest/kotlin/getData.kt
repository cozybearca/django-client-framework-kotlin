import okhttp3.OkHttpClient
import okhttp3.Request

class getData {
    var client = OkHttpClient()

    fun runFile(url: String): String {
        val request: Request = Request.Builder()
            .url(url)
            .build()
        val response: okhttp3.Response = client.newCall(request).execute()
        val body = response.body?.string()

        if (body != null) return body;
        return "Error"
    }
}
