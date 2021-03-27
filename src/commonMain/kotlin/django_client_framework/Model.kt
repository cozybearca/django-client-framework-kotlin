package django_client_framework

interface Model {
    val id: Long
    fun getClassName() : String
}

fun <T:Model> T.manager(): ObjectManager<T> {
    return ObjectManager(this)
}

