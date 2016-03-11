package polar

import java.util.*

/**
 * Created by User on 11.03.2016.
 */
class Storage {
    private val models: HashMap<Class<*>,Model<*>> = HashMap()

    private var clazz: Class<*>? = null

    fun <T> register(clazz: Class<T>){
        models.put(clazz, Model(clazz))
    }

    fun <T: Any> put(value: T){
        if(value == null){
            throw IllegalArgumentException("value cannot be null.")
        }
        if(!models.containsKey(value.javaClass)){
            throw IllegalArgumentException("${value.javaClass} should be registered first.")
        }
    }
}