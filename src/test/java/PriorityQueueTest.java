import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

class PriorityQueueTest {
    static Stream<Arguments> streamProvider(){
        return Stream.of(
                // normal testcase
                Arguments.of(new int[]{7, 9, 3, 2}, new int[]{2, 3, 7, 9}),
                Arguments.of(new int[]{5, 2, 10}, new int[]{2, 5, 10}),
                Arguments.of(new int[]{-3, 2, -1}, new int[]{-3, -1, 2}),
                Arguments.of(new int[]{1, -2, 3, -4}, new int[]{-4, -2, 1, 3}),
                Arguments.of(new int[]{0, 9, 0, 1, 0, 3}, new int[]{0, 0, 0, 1, 3, 9})
        );
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("streamProvider")
    void TestPrioriQueue(int[] input_array, int[] expected_array){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        int[] result = new int[input_array.length];

        //put input array element to priorityQueue
        for (int i=0; i<input_array.length; i++) {
            priorityQueue.add(input_array[i]);
        }
        //get element in priorityQueue
        for (int i=0; priorityQueue.size()>0 ; i++){
            result[i] = priorityQueue.poll();
        }

        assertArrayEquals(expected_array, result);
    }

    @Test
    public void TestIllegalArgumentException_capacity(){
        // Throws IllegalArgumentException – if initialCapacity is less than 1
        Exception exception = assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(-1);
        });
    }

    @Test
    public void TestNullPointerException_addNull(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        Exception exception = assertThrows(NullPointerException.class, () -> {
            priorityQueue.add(null);
        });
    }

    @Test
    public void TestNullPointerException_offerNull(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        Exception exception = assertThrows(NullPointerException.class, () -> {
            priorityQueue.offer(null);
        });
    }

}