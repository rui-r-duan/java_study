package chap13.ryan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.midi.*;

public class MyBeatBox {

    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;
    private JCheckBox[] chkBoxes;

    static final String[] instrumentNames = {
        "Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare",
        "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas",
        "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom",
        "High Agogo", "Open Hi Conga"};

    static final int[] instruments = {
        35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

    static final int notesNum = 16;

    public static void main(String[] args) {
        MyBeatBox me = new MyBeatBox();
        me.buildGui();
        me.setUpMidi();
    }

    void buildGui() {
        JFrame frame = new JFrame("Cyber BeatBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create background panel to replace the default panel in JFrame.
        BorderLayout borderLayout = new BorderLayout();
        JPanel background = new JPanel(borderLayout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        labelPanel.setBackground(Color.green); // debug
        // javax.swing.Box can be used to replace JPanel here.
        // Box labelBox = new Box(BoxLayout.Y_AXIS);
        // labelBox.setBackground(Color.green); // debug, no effect, no visible bg

        GridLayout gridLayout = new GridLayout(instrumentNames.length, notesNum);
        gridLayout.setVgap(1);
        gridLayout.setHgap(2);
        JPanel chkboxPanel = new JPanel(gridLayout);
        chkboxPanel.setBackground(Color.orange); // debug

        // javax.swing.Box can be used to replace JPanel here.
        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.blue); // debug
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));

        // Create instruments labels.
        int instrumentCnt = instrumentNames.length;
        // We do NOT use javax.swing.JLabel here, because JLabel cannot spread
        // evenly in the BoxLayout.  So we use java.awt.Label.
        Label[] labels = new Label[instrumentCnt];
        for (int i = 0; i < instrumentCnt; i++) {
            labels[i] = new Label(instrumentNames[i]);
            // labelBox.add(labels[i]);
            labelPanel.add(labels[i]);
        }

        // Create notes checkboxes.
        int chkboxCnt = instrumentCnt * notesNum;
        chkBoxes = new JCheckBox[chkboxCnt];
        for (int j = 0; j < chkboxCnt; j++) {
            chkBoxes[j] = new JCheckBox();
            // chkBoxes[j].setSelected(false);
            chkboxPanel.add(chkBoxes[j]);
        }

        // Create buttons.
        JButton startBtn = new JButton("Start");
        JButton stopBtn = new JButton("Stop");
        JButton upTempoBtn = new JButton("Tempo Up");
        JButton downTempoBtn = new JButton("Tempo Down");
        startBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buildTrackAndStart();
                }
            });
        stopBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sequencer.stop();
                }
            });
        upTempoBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    float tempoFactor = sequencer.getTempoFactor();
                    sequencer.setTempoFactor((float)(tempoFactor * 1.03));
                }
            });
        downTempoBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    float tempoFactor = sequencer.getTempoFactor();
                    sequencer.setTempoFactor((float)(tempoFactor * .97));
                }
            });
        btnPanel.add(startBtn);
        btnPanel.add(stopBtn);
        btnPanel.add(upTempoBtn);
        btnPanel.add(downTempoBtn);

        background.add(BorderLayout.CENTER, chkboxPanel);
        // background.add(BorderLayout.WEST, labelBox);
        background.add(BorderLayout.WEST, labelPanel);
        background.add(BorderLayout.EAST, btnPanel);

        frame.getContentPane().add(background);

        frame.setSize(600, 480);
        frame.pack();
        frame.setVisible(true);
    }

    void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ,
                                // PPQ: The tempo-based timing type, for which
                                // the resolution is expressed in pulses
                                // (ticks) per quarter note.
                                    4); // the timing resolution
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void buildTrackAndStart() {
        int[] trackList = null;
        
        // Get rid of the old track, make a fresh one.
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        // Do this for each of the 'instrumentNames.length' ROWS (i.e. Bass,
        // Congo, etc.)
        for (int i = 0; i < instrumentNames.length; i++) {
            trackList = new int[instrumentNames.length];

            // Set the 'key' that represents which instrument this is
            int key = instruments[i];

            // Do this for each of the BEATS for this row.
            for (int j = 0; j < notesNum; j++) {
                JCheckBox jc = chkBoxes [j + notesNum * i];
                if (jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }
            
            // For this instrument, and for all 16 beats, make events and add
            // them to track.
            makeTracks(trackList);
            track.add(makeEvent(176, 1, 127, 0, 16));
        }
        
        track.add(makeEvent(192, 9, 1, 0, 15));
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // close buildTrackAndStart

    void makeTracks(int[] list) {
        for (int i = 0; i < notesNum; i++) {
            int key = list[i];
            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i+1));
            }
        }
    }

    MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
}
