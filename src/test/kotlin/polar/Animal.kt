package polar

import polar.annotations.Entity
import polar.annotations.Field

/**
 * Created by User on 11.03.2016.
 */
@Entity("animal")
class Animal(@Field("name") val name:String,@Field("sex") val sex: Boolean)