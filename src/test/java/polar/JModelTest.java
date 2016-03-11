package polar;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by User on 11.03.2016.
 */
public class JModelTest {

    @Test
    public void testGetClazz() {
        Model<JAnimal> model = new Model<>(JAnimal.class);
        Assert.assertEquals(JAnimal.class, model.getClazz());

    }

    @Test
    public void testHasField() {
        Model<JAnimal> model = new Model<>(JAnimal.class);
        Assert.assertTrue(model.hasField("name"));
        Assert.assertTrue(model.hasField("sex"));
        Assert.assertFalse(model.hasField("foo"));
    }

    @Test
    public void testGetFieldsCount() {
        Model<JAnimal> model = new Model<>(JAnimal.class);
        Assert.assertEquals(2,model.getFieldsCount());

    }
}