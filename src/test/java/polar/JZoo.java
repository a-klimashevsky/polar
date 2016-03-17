package polar;

import polar.annotations.Entity;
import polar.annotations.Field;

/**
 * Created by User on 16.03.2016.
 */
@Entity(name = "zoo")
public class JZoo {
    @Field(name = "main")
    private JAnimal mainAnimal;
}
