package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> result1 = App.take(numbers1, 2);
        assertThat(result1).isEqualTo(Arrays.asList(1, 2));

        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        List<Integer> result2 = App.take(numbers2, 8);
        assertThat(result2).isEqualTo(Arrays.asList(7, 3, 10));

        List<Integer> numbers3 = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
        List<Integer> result3 = App.take(numbers3, 0);
        assertThat(result3).isEmpty();

        List<Integer> numbers4 = new ArrayList<>(Arrays.asList(9, 10, 11));
        List<Integer> result4 = App.take(numbers4, 5);
        assertThat(result4).isEqualTo(Arrays.asList(9, 10, 11));

        List<Integer> numbers5 = new ArrayList<>();
        List<Integer> result5 = App.take(numbers5, 3);
        assertThat(result5).isEmpty();
    }
}
