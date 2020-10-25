package Area;

import com.github.wjrmffldrhrl.Area;
import com.github.wjrmffldrhrl.exception.InvalidIndexException;
import org.junit.Assert;
import org.junit.Test;

public class AreaTest {

    @Test(expected = InvalidIndexException.class)
    public void underZeroIndexTest() {
        new Area(-1 , 4);
    }

    @Test(expected = InvalidIndexException.class)
    public void inputInvalidIndexTest() {
        new Area(6, 4);
    }

    @Test(expected = InvalidIndexException.class)
    public void sameIndexTest() {
        new Area(4 , 4);
    }

    @Test
    public void overlapTest() {
        Area leftArea = new Area(1,5);
        Area centerArea = new Area(2,7);
        Area smallCenterArea = new Area(3,6);
        Area rightArea = new Area(6,9);
        Area otherArea = new Area(9,13);

        Assert.assertTrue(leftArea.isOverlap(centerArea));
        Assert.assertTrue(rightArea.isOverlap(centerArea));
        Assert.assertTrue(centerArea.isOverlap(smallCenterArea));
        Assert.assertTrue(smallCenterArea.isOverlap(centerArea));
        Assert.assertFalse(rightArea.isOverlap(otherArea));

    }

    @Test
    public void equalsTest() {
        Area a1 = new Area(1,3);
        Area a2 = new Area(1,3);

        Area a3 = new Area(1,2);

        Assert.assertTrue(a1.equals(a2));
        Assert.assertFalse(a1.equals(a3));
    }

    @Test
    public void cloneTest() {
        Area originalArea = new Area(1,3);
        Area cloneArea = originalArea.clone();

        Assert.assertTrue(originalArea.equals(cloneArea));
    }
}
