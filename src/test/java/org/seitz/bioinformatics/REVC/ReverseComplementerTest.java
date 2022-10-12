package org.seitz.bioinformatics.REVC;

import org.junit.jupiter.api.Test;
import org.seitz.bioinformatics.DNA.InvalidNucleotideException;
import org.seitz.bioinformatics.DnaSequenceValidator;
import org.seitz.bioinformatics.RNA.SequenceTooLongException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReverseComplementerTest {

    private final ReverseComplementer reverseComplementer;

    public ReverseComplementerTest() {
        this.reverseComplementer = new ReverseComplementer(new DnaSequenceValidator());
    }

    @Test
    public void generatesReverseComplement() throws SequenceTooLongException, InvalidNucleotideException {
        String dnaSequence = "AAAACCCGGT";
        String result = "ACCGGGTTTT";
        assertEquals(result, this.reverseComplementer.getReverseComplement(dnaSequence));
    }

    @Test
    public void doesNotAcceptTooLongSequences() {
        assertThrows(SequenceTooLongException.class,
                () -> this.reverseComplementer.getReverseComplement("GTGTGGCTAGATCTTAGCTTTCGTCACTAGAGGGCCCACGCTTAGTTTTTATGATCCATTGATCTCCTAGACGCTGCAAGATTTGCAACCAGGCAGACTTAGCGGTAGGTCCTAGTGCAGCGGGACTTTTTTTCTATAGTCGTTGAGAGGAGGAGTCGTCAGACCAGATACCTTTGATGTCCTGATTGGAAGGACCGTTGGCCCCCGACCCTTAGACAGTGTACTCAGTTCTATAAACGAGCTATTAGATATGAGATCCGTAGATTGAAAAGGGTGACGGAATTCGCCCGGACGCAAAAGACGGACAGCTAGGTATCCTGAGCACGGTTGCGCGTCCGAATCAAGCTCCTCTTTACAGGCCCCGGTTTCTGTTGGTCGTAGAGCGCAGAACGGATTGGGGGGATGTACGACAATATCTCTTAGTCACCTTTGGGTCACGGTCTGCTACCTTACAGGAATTCAGACCGTCCTTTAATTTCCCTTGCATATATGTTGCGTTTCTTCGACCTTCTAACCGCACCCTTAGGACGAAGACAGATACGTTCTTACCCATACTCCACCGTTGGCAGCGGGATCGCATGTCCCACGTGAAACATTGCTAAACCCTCAGGCCTCTGAGCGACAAAAGCTTTAAAGGGAAATTCGCGCCCATAACTTGGTCCGAATACGGGTTCTAGCATCGTTCGTCTGAGTTTGTTCTATATAAAACGGGCGCAATGTCTGCTTTGATCAACCTCCAATACCTCGTATGATTGTGCACCCGCCGGTGACCACTCAATGATGTGGGGTCCCCGTTGCAACTACGAGGATTTATTGAGACCGACCTACGTTCGGCATTGTGGGCAGAGTGAAGTATTGGCAAACGTTAAGTGCCGAACTAGATCTGACCTAACGGTAAGAGAGTTTCATAATACGTCCAGCCGCATGCGCAGGGTACATTTGGACAGTATTGAATGGACTCTGATCAACCTTCACACCGATCTAGAAACGAGTGCGTAGAT"));
    }


    @Test
    public void onlyAcceptsValidDnaSequence() {
        assertThrows(InvalidNucleotideException.class,
                () -> this.reverseComplementer.getReverseComplement("AGCTH"));
    }
}
