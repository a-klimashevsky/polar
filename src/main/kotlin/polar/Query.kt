package polar

/**
 * Created by User on 16.03.2016.
 */
class Query<T: Any>(val storage: Storage, val clazz: Class<T>) {

    private var predicate: ((T) -> Boolean)? = null

    fun find(): List<T>{
        return storage.find(clazz, predicate)
    }

    fun filter(predicate: (T) -> Boolean){
        this.predicate = predicate
    }
}