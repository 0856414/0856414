import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PriorityQueueTest {
    static Stream<Arguments> streamIntArrayProvider() {
        return Stream.of(
                arguments(new int[]{3, 1, 2}, new int[]{1,2,3}),
                arguments(new int[]{-3,-1,-2,5}, new int[]{-3,-2,-1,5}),
                arguments(new int[]{3,-2,-5,-1,2}, new int[]{-5,-2,-1,2,3}),
                arguments(new int[]{-3,1,11,0,9,3}, new int[]{-3,0,1,3,9,11}),
                arguments(new int[]{3,7,2,-1,-2}, new int[]{-2,-1,2,3,7})
        );
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("streamIntArrayProvider")
    public void PriorityQueue_RunTest(int[] random_array,int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index=0;
        Integer s;
        int[] result=new int[random_array.length];
        //TODO random array add to PriorityQueue
        for(index=0;index < random_array.length;index++) {
            test.offer(random_array[index]);
        }
        //TODO get PriorityQueue result
        index=0;
        while ((s = test.poll()) != null) {
            result[index] =s;
            index++;
        }
        assertArrayEquals(correct_array,result);
    }

    private void assertArrayEquals(int[] correct_array, int[] result) {

    }

    @Test
    public void whenExceptionThrown_thenOfferEisNull(){
        Exception e = assertThrows(NullPointerException.class,()->{
            PriorityQueue<Integer> test = new PriorityQueue<Integer>();
            test.offer(null);
        });
    }
    @Test
    public void whenExceptionThrown_thenInitialCapacityNotGreaterThanOne(){
        Exception e = assertThrows(IllegalArgumentException.class,()->{
            PriorityQueue<Integer> test = new PriorityQueue<Integer>(0);
        });
    }
    @Test
    public void whenExceptionThrown_thenNoElementCanRemove(){
        Exception e = assertThrows(NoSuchElementException.class,()->{
            PriorityQueue<Integer> test = new PriorityQueue<Integer>();
            test.remove();
        });
    }

}
