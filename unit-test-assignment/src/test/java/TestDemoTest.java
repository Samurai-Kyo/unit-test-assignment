import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoTest extends Object {

    private TestDemo testDemo;

    @BeforeEach
    void setUp() {
        testDemo = new TestDemo();
    }

    @ParameterizedTest
    @MethodSource("TestDemoTest#argumentsForAddPositive")
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
        }

    }

    static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
                Arguments.arguments(2, 4, 6, false),
                Arguments.arguments(2322345, 1, 2322346, false),
                Arguments.arguments(-5, 334, 6, true),
                Arguments.arguments(211, -3644, 6, true),
                Arguments.arguments(-2342, -2344, 6, true)
        );
    }


    @Test
    void assertThatNumberSquaredIsCorrect() {
        int fiveSquared = createTestDemoMock().randomNumberSquared();
        assertThat(fiveSquared).isEqualTo(25);
    }

    private TestDemo createTestDemoMock() {
        TestDemo mockDemo = spy(testDemo);
        doReturn(5).when(mockDemo).getRandomInt();
        return mockDemo;
    }


}