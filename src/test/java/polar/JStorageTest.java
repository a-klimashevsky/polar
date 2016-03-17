package polar;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by User on 16.03.2016.
 */
public class JStorageTest {

    @Test
    public void testRegister() {
        Storage storage = new Storage();
        JAnimal animal = new JAnimal();
        try {
            storage.put(animal);
            Assert.assertTrue(false);
        } catch (IllegalArgumentException e){

        }
        storage.register(JAnimal.class);
        storage.put(animal);
    }

    @Test
    public void testRegisterSubEntity(){
        Storage storage = new Storage();
        JZoo zoo = new JZoo();
        storage.register(JZoo.class);
        try {
            storage.put(zoo);
            Assert.assertTrue(false);
        } catch (IllegalArgumentException e){

        }
        storage.register(JAnimal.class);
        storage.put(zoo);
    }

    @Test
    public void testPut() {
        Storage storage = new Storage();
        JAnimal animal = new JAnimal();
        storage.register(JAnimal.class);
        storage.put(animal);
    }

    @Test
    public void testDecompose() {
        Storage storage = new Storage();
        storage.register(JAnimal.class);
        JAnimal animal = new JAnimal();
        animal.setName("Dog");
        animal.setSex(true);
        Map<String, Object> map = storage.decompose(animal, storage.getModels().get(JAnimal.class));
        Assert.assertEquals("Dog", map.get("name"));
        Assert.assertEquals(true, map.get("sex"));
    }
}
