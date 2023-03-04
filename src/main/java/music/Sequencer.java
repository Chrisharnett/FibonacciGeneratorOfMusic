package music;

import javax.sound.midi.*;

/**
 * @author saxDev
 * @studentnumber 20188141
 **/
public class Sequencer {
    public static Sequence generate(int instrument1, int instrument2, int bp) {
        //Prime Factorizations could determine overall structure of the piece (number of bars per phrase, perhaps).
        //Time sig determined by some other property of primes or fibonaccis
        //
        int timeSignature = 44;
        int subDivisions = timeSignature % 10; //TODO figure out what this does
        int numMeasures = 8; //TODO Make a variable of prime factorizations.
        Sequence generate = null;
        try {
            generate = new Sequence(Sequence.PPQ, subDivisions);
        } catch (InvalidMidiDataException e1) {
            e1.printStackTrace();
        }

        try {

            MidiChannel[] midiChannel;
            Synthesizer syn = MidiSystem.getSynthesizer();
            syn.open();

            midiChannel = syn.getChannels();
            midiChannel[0].programChange(instrument1);
            midiChannel[1].programChange(instrument2);
            midiChannel = syn.getChannels();

            javax.sound.midi.Sequencer sqr = MidiSystem.getSequencer();
            Transmitter sqrTrans = sqr.getTransmitter();
            Receiver synthRcvr = syn.getReceiver();
            sqrTrans.setReceiver(synthRcvr);

            sqr.open();
//            generate = WriteRandomMidi.combineSequence
//            sqr.setSequence(sq);
//            sqr.setTempoInBPM(bpm);
//            sqr.start();
            /**
             * Code to send out midi. Other Music Generator write a file and then plays it,
             * as far as I can tell.
             * I'd like to have it stream in real time, and be manipulated in real time.
             *
             * Instead of the generator class, filter the arrays of math functions
             */






        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }

        return generate;
    }

}
