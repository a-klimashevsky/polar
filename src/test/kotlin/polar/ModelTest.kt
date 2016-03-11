package polar

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by User on 11.03.2016.
 */
class KModelTest {

    @Test
    fun testGetClazz() {
        val model = Model(Animal::class.java)
        assertEquals(Animal::class.java, model.clazz)
    }

    @Test
    fun testHasField() {
        val model = Model(Animal::class.java)
        assertTrue(model.hasField("name"))
        assertTrue(model.hasField("sex"))
        assertFalse(model.hasField("foo"))
    }

    @Test
    fun testGetFieldsCount() {
        val model = Model(Animal::class.java)
        assertEquals(2, model.fieldsCount)
    }

    @Test
    fun testEntityName(){
        val model = Model(Animal::class.java)
        assertEquals("animal", model.entityName)

        try {
            val model1 = Model(Any::class.java)
            assertTrue(false)
        } catch (e: IllegalArgumentException){

        }

    }
}