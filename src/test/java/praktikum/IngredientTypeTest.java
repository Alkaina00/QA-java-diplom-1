package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void getSauceTest() {
        Assert.assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void getFillingTest() {
        Assert.assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}
