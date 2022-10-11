package org.seitz.bioinformatics.DNA;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class NucleotideCounterTest {

    @Test
    public void shouldCountNucleotidesCorrectly() throws InvalidNucleotideException {
        NucleotideCounter counter = new NucleotideCounter();
        String input = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
        int[] result = new int[]{20, 12, 17, 21};
        assertArrayEquals(result, counter.count(input));
    }

    @Test
    public void shouldNotAcceptInvalidInput() {
        NucleotideCounter counter = new NucleotideCounter();
        String input = "AGCTTTTCATTCTGACTGCAACGGGFAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
        assertThrows(InvalidNucleotideException.class,
                () -> counter.count(input));
    }
}