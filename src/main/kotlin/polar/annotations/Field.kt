package polar.annotations

import java.lang.annotation.RetentionPolicy

/**
 * Created by User on 11.03.2016.
 */
@Retention(AnnotationRetention.RUNTIME)
annotation class Field(val name: String)