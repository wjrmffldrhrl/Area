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
}
