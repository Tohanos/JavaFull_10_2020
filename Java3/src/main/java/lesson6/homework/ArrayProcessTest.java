package lesson6.homework;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArrayProcessTest extends TestCase {

    @Test
    public void arrayProcessOneSearchFor4() {

        int[] arrayToFind = {2, 3, 4};

        int[] res1 = ArrayProcessOne.arraySearchFor4(new int[]{5, 6, 7, 4, 5, 7});
        int[] res2 = ArrayProcessOne.arraySearchFor4(new int[]{1, 4, 4, 4, 4, 4, 2, 3, 4});
        int[] res3 = ArrayProcessOne.arraySearchFor4(new int[]{5, 6, 7, 8, 2, 3, 4});
        int[] res4 = ArrayProcessOne.arraySearchFor4(new int[]{7, 8, 9, 0, 4, 3, 4});

        assertFalse(Arrays.equals(arrayToFind, res1));
        assertTrue(Arrays.equals(arrayToFind, res2));
        assertTrue(Arrays.equals(arrayToFind, res3));
        assertFalse(Arrays.equals(arrayToFind, res4));
    }

    @Test
    public void arrayProcessOneSearchForOneFour() {
        assertTrue(ArrayProcessOne.arraySearchForOneFour(new int[]{1, 4, 1, 4, 1, 1}));
        assertFalse(ArrayProcessOne.arraySearchForOneFour(new int[]{1, 1, 1, 1, 1}));
        assertFalse(ArrayProcessOne.arraySearchForOneFour(new int[]{4, 4, 4, 4, 4}));
        assertFalse(ArrayProcessOne.arraySearchForOneFour(new int[]{1, 1, 4, 3, 4}));
    }
}