package polar

import polar.annotations.Field

/**
 * Created by User on 11.03.2016.
 */
class Animal(@Field("name") val name:String,@Field("sex") val sex: Boolean)