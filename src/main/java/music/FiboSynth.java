package music;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.Random;

/**
 * @author saxDev
 * @studentnumber 20188141
 **/
public class FiboSynth {
    public static void main(String[] args) {
        Synthesizer synth = null;
        try {
            synth = MidiSystem.getSynthesizer();
        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        }
        try {
            synth.open();
        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        }

        final MidiChannel[] mc = synth.getChannels();

        Instrument[] instr = synth.getDefaultSoundbank().getInstruments();

        synth.loadInstrument(instr[002]);

        JFrame frame = new JFrame("The Fibonacci Synthesizer");
        JPanel pane = new JPanel();
        JButton button1 = new JButton("Note");
        JButton button2 = new JButton("Another Note");
        frame.getContentPane().add(pane);
        pane.add(button1);
        pane.add(button2);
        frame.pack();
        frame.show();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(613, 357);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        button1.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();

                int[] testArray = {1,2,3,4,5,6,7,8,9};
                mc[5].noteOn(79, 600);

            }
        }));
        button2.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mc[5].noteOn(77, 600);

            }
        }));



    }
}
