package polar

import java.util.*

/**
 * Created by User on 11.03.2016.
 */
class Storage {

    val primitives = listOf(
            Boolean::class.java.name,
            Int::class.java.name,
            Double::class.java.name,
            Float::class.java.name,
            Char::class.java.name,
            Byte::class.java.name,
            String::class.java.name,
            Date::class.java.name,
            Short::class.java.name)

    val models: HashMap<Class<*>, Model<*>> = HashMap()

    private val collections: HashMap<Class<*>, MutableList<Map<String, Any?>>> = HashMap()

    fun <T> register(clazz: Class<T>) {
        models.put(clazz, Model(clazz))
    }

    fun <T : Any> put(value: T) {
        val clazz = value.javaClass
        if (!models.containsKey(clazz)) {
            throw IllegalArgumentException("$clazz should be registered first.")
        }
        val model = models[clazz]
        val data = decompose(value, model!!)
        val collection = collections.getOrPut(clazz, { ArrayList<Map<String, Any?>>() })
        collection.add(data)
    }

    fun <T : Any> where(clazz: Class<T>): Query<T> {
        return Query(this, clazz)
    }

    fun decompose(value: Any, model: Model<*>): Map<String, Any?> {
        val map = HashMap<String, Any?>()
        for (field in model.fields) {
            if (field.value.type.name in primitives) {
                map.put(field.key, field.value.get(value))
            } else {
                if (models.containsKey(field.value.type)) {
                    val subModel = models[field.value.type]
                    val subValue = field.value.get(value)
                    if (subValue != null) {
                        val subEntity = decompose(field.value.get(value), subModel!!)
                        map.put(field.key, subEntity)
                    } else {
                        map.put(field.key, null)
                    }
                } else {
                    throw IllegalArgumentException("${field.value.type} should be registered first.")
                }
            }
        }
        return map
    }

    internal fun <T : Any> find(clazz: Class<T>, predicate: ((T) -> Boolean)?): List<T> {
        if (collections.containsKey(clazz)) {
            val maps = collections[clazz]
            val list = compose<T>(maps, models[clazz])
            if (predicate == null) {
                return list
            } else {
                return list.filter(predicate)
            }
        }
        return ArrayList()
    }

    private fun <T : Any> compose(maps: MutableList<Map<String, Any?>>?, model: Model<*>?): ArrayList<T> {
        val list: ArrayList<T> = ArrayList()
        for (data in maps!!) {
            val value: T = model!!.clazz.newInstance() as T
            for (field in model.fields) {
                field.value.set(value, data[field.key])
            }
            list.add(value)
        }
        return list
    }
}