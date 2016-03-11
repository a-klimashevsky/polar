package polar

import java.lang.reflect.Field
import java.util.*

/**
 * Created by User on 11.03.2016.
 */
class Model<T> {
    val clazz: Class<T>

    private val fields: HashMap<String,Field> = HashMap()

    constructor(clazz: Class<T>){
        this.clazz = clazz;
        build()
    }

    private fun build() {
        for(field in clazz.declaredFields){
            for(annotation in field.declaredAnnotations){
                when(annotation){
                    is polar.annotations.Field -> {
                        fields.put(annotation.name,field)
                    }
                }
            }
        }
    }

    fun hasField(name: String) : Boolean = fields.containsKey(name)

    val fieldsCount : Int
        get() = fields.size
}