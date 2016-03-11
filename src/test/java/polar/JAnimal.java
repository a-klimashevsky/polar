package polar;

import polar.annotations.Field;

/**
 * Created by User on 11.03.2016.
 */
public class JAnimal {
    @Field(name = "name")
    private String name;

    @Field(name="sex")
    private boolean sex;
}
