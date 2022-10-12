package org.seitz.bioinformatics.DNA;

import org.junit.jupiter.api.Test;
import org.seitz.bioinformatics.DnaSequenceValidator;
import org.seitz.bioinformatics.RnaSequenceValidator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class NucleotideCounterTest {

    private final NucleotideCounter counter;

    public NucleotideCounterTest() {
        this.counter = new NucleotideCounter(new DnaSequenceValidator(), new RnaSequenceValidator());
    }

    @Test
    public void shouldCountDnaSequenceCorrectly() throws InvalidNucleotideException, IllegalArgumentException {
        String dnaSequence = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
        int[] result = new int[]{20, 12, 17, 21};
        assertArrayEquals(result, this.counter.count(dnaSequence, "DNA"));
    }

    @Test
    public void shouldCountRnaSequenceCorrectly() throws InvalidNucleotideException, IllegalArgumentException {
        String rnaSequence = "AGCUUUUCAUUCUGACUGCAACGGGCAAUAUGUCUCUGUGUGGAUUAAAAAAAGAGUGUCUGAUAGCAGC";
        int[] result = new int[]{20, 12, 17, 21};
        assertArrayEquals(result, this.counter.count(rnaSequence, "RNA"));
    }

    @Test
    public void shouldNotAcceptInvalidDnaSequence() throws IllegalArgumentException {
        String dnaSequence = "AGCTTTTCATTCTGACTGCAACGGGUAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
        assertThrows(InvalidNucleotideException.class,
                () -> this.counter.count(dnaSequence, "DNA"));
    }

    @Test
    public void shouldNotAcceptInvalidRnaSequence() throws IllegalArgumentException {
        String rnaSequence = "AGCUUUUCAUUCUGACTGCAACGGGCAAUAUGUCUCUGUGUGGAUUAAAAAAAGAGUGUCUGAUAGCAGC";
        assertThrows(InvalidNucleotideException.class,
                () -> this.counter.count(rnaSequence, "RNA"));
    }

    @Test
    public void shouldNotAcceptInvalidTypeOfSequence() {
        String dnaSequence = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
        assertThrows(IllegalArgumentException.class,
                () -> this.counter.count(dnaSequence, "FOO"));
    }
}