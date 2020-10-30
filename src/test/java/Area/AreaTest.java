package Area;

import com.github.wjrmffldrhrl.Area;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AreaTest {

    @Test(expected = IllegalArgumentException.class)
    public void underZeroIndexTest() {
        new Area(-1 , 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputInvalidIndexTest() {
        new Area(6, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sameIndexTest() {
        new Area(4 , 4);
    }

    @Test
    public void createAreaWithStringTest() {
        Area area = new Area("5", "9");
        Assert.assertEquals(area.getStart(), 5);
        Assert.assertEquals(area.getEnd(), 9);
        Assert.assertEquals(area.getLength(), 4);
    }

    @Test
    public void createAreaWithMatcherTest() {
        String text = "Hello world 25304 !!!";
        String numberPatternString = "[0-9]+";
        Pattern numberPattern = Pattern.compile(numberPatternString);
        Matcher matcher = numberPattern.matcher(text);
        while (matcher.find()) {
            Area area = new Area(matcher);

            Assert.assertEquals(area.getStart(), 12);
            Assert.assertEquals(area.getEnd(), 17);
            Assert.assertEquals(area.getLength(), 5);
        }


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
