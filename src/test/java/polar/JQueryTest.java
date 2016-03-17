package polar;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by User on 17.03.2016.
 */
public class JQueryTest{

    @Test
    public void testFind(){
        Storage storage = new Storage();
        storage.register(JAnimal.class);
        JAnimal animal = new JAnimal();
        animal.setName("Dog");
        storage.put(animal);
        Query<JAnimal> query = storage.where(JAnimal.class);
        List<JAnimal> list = query.find();
        Assert.assertEquals(1, list.size());
        JAnimal animal1 = list.get(0);
        Assert.assertEquals(animal, animal1);
    }

    @Test
    public void testFilter(){
        Storage storage = new Storage();
        storage.register(JAnimal.class);
        JAnimal animal = new JAnimal();
        animal.setName("Dog");
        storage.put(animal);
        animal = new JAnimal();
        animal.setName("Cat");
        storage.put(animal);
        Query<JAnimal> query = storage.where(JAnimal.class);
        query.filter(x -> "Cat".equals(x.getName()));
        List<JAnimal> list = query.find();
        Assert.assertEquals(1, list.size());
    }
}
