package polar;

import polar.annotations.Entity;
import polar.annotations.Field;

import java.util.Date;
import java.util.Objects;

/**
 * Created by User on 11.03.2016.
 */
@Entity(name = "animal")
public class JAnimal {
    @Field(name = "name")
    private String name;

    @Field(name = "sex")
    private boolean sex;

    @Field(name = "legCount")
    private int legCount;

    @Field(name = "a1")
    private short a1;

    @Field(name = "b1")
    private byte b1;

    @Field(name = "birth")
    private Date birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof JAnimal)) return false;
        JAnimal other = (JAnimal) obj;
        return
                Objects.equals(name, other.name) &&
                        Objects.equals(sex, other.sex);
    }
}
