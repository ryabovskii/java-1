import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ContainerTest {

    @Test
    public void testAdd() {
       Container<Integer> ar = new Container<>();
       ar.add(1);
       ar.add(2);
       ar.add(5);
       assertEquals((Integer)1, ar.get(0));
       assertEquals((Integer)2, ar.get(1));
       assertEquals((Integer)5, ar.get(2));
    }

    @Test
    public void testGet() {
        Container<Integer> ar = new Container<>();
        ar.add(1);
        ar.add(2);
        ar.add(5);
        assertEquals((Integer)1, ar.get(0));
        assertEquals((Integer)2, ar.get(1));
        assertEquals((Integer)5, ar.get(2));
        assertNull(ar.get(6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalGet() {
        Container<Integer> ar = new Container<>();
        ar.get(-1);
    }

    @Test
    public void testSize() {
        Container<Integer> ar = new Container<>();
        assertEquals(0, ar.size());
        ar.add(1);
        assertEquals(1, ar.size());
        ar.add(2);
        assertEquals(2, ar.size());
        ar.add(5);
        assertEquals(3, ar.size());
        ar.delete(0);
        assertEquals(2, ar.size());
    }

    @Test
    public void testDelete() {
        Container<Integer> ar = new Container<>();
        ar.add(1);
        ar.add(2);
        ar.add(5);
        assertEquals((Integer)5, ar.delete(2));
        assertEquals(2, ar.size());
        assertEquals((Integer)1, ar.delete(0));
        assertEquals(1, ar.size());
        assertNull(ar.delete(5));
        assertEquals(1, ar.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalDelete() {
        Container<Integer> ar = new Container<>();
        ar.delete(-1);
    }
}
