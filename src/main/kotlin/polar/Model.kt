package polar

import polar.annotations.Entity
import java.lang.reflect.Field
import java.util.*

/**
 * Created by User on 11.03.2016.
 */
class Model<T> {
    val clazz: Class<T>

    private val fields: HashMap<String,Field> = HashMap()

    var entityName: String? = null
        private set

    fun hasField(name: String) : Boolean = fields.containsKey(name)

    val fieldsCount : Int
        get() = fields.size

    constructor(clazz: Class<T>){
        this.clazz = clazz;
        build()
    }

    private fun build() {
        for(annotation in clazz.annotations){
            when(annotation){
                is Entity ->{
                    entityName = annotation.name
                }
            }
        }
        if(entityName == null){
            throw IllegalArgumentException("${clazz.name} should be annotaited by ${Entity::class.java.name}")
        }
        for(field in clazz.declaredFields){
            for(annotation in field.annotations){
                when(annotation){
                    is polar.annotations.Field -> {
                        fields.put(annotation.name,field)
                    }
                }
            }
        }
    }
}