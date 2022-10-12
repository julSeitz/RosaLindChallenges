package org.seitz.bioinformatics.DNA;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class NucleotideCounterTest {

    private final NucleotideCounter counter;

    public NucleotideCounterTest() {
        this.counter = new NucleotideCounter();
    }

    @Test
    public void shouldCountNucleotidesCorrectly() throws InvalidNucleotideException {
        String dnaSequence = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
        int[] result = new int[]{20, 12, 17, 21};
        assertArrayEquals(result, this.counter.count(dnaSequence));
    }

    @Test
    public void shouldNotAcceptInvalidInput() {
        String dnaSequence = "AGCTTTTCATTCTGACTGCAACGGGFAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
        assertThrows(InvalidNucleotideException.class,
                () -> this.counter.count(dnaSequence));
    }
}