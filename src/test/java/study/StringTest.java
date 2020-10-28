package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split() {

        String inputStr = "1,2";

        String[] result = inputStr.split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

}
