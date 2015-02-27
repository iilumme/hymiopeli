package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.highscore.HighScore;
import iilumme.hymiopeli.util.KieliUtil;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * Luo JOptionPanes.
 *
 * @author iina
 */
public class ViestiApuri {

    private final Apuri apuri;
    private static final String KISSALOGO = "Images/caticon.png";
    private static final String GAMEOVERLOGO = "Images/gameo.png";

    public ViestiApuri(Apuri a) {
        this.apuri = a;
    }

    /**
     * Luo JOptionPane-olion HighScoren lisäystä varten.
     *
     * @see iilumme.hymiopeli.util.KieliUtil#getString(java.lang.String)
     * @see iilumme.hymiopeli.ui.Apuri#getLiittyma()
     * @see iilumme.hymiopeli.ui.Apuri#getHighScoreTallentaja()
     * @see
     * iilumme.hymiopeli.highscore.HighScoreTallentaja#lisaaHighscore(java.lang.String,int)
     * @see iilumme.hymiopeli.highscore.HighScoreTallentaja#paivitaLista()
     * @see iilumme.hymiopeli.logiikka.HymioPeli#getPisteet()
     */
    public void highScoreLisaysJOptionPane() {

        String[] options = {"OK"};
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 0));
        JLabel label = new JLabel(KieliUtil.getString("annanimi"));
        JTextField name = new JTextField(10);
        panel.add(label);
        panel.add(name);

        int valinta = JOptionPane.showOptionDialog(apuri.getLiittyma().getFrame(),
                panel, KieliUtil.getString("highscorelistalle"), JOptionPane.NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                new ImageIcon(ClassLoader.getSystemResource(GAMEOVERLOGO)),
                options, options[0]);

        if (valinta == 0) {
            String nimi = name.getText();
            if (nimi.length() == 0) {
                apuri.getHighScoreTallentaja().lisaaHighscore(KieliUtil.getString("pelaaja"), apuri.getHymiopeli().getPisteet());
            } else {
                apuri.getHighScoreTallentaja().lisaaHighscore(nimi, apuri.getHymiopeli().getPisteet());
            }
            apuri.getHighScoreTallentaja().paivitaLista();
        }

    }

    /**
     * Luo JOptionPane-olion tason vaihtumisviestiksi.
     *
     * @see iilumme.hymiopeli.util.KieliUtil#getString(java.lang.String)
     * @see iilumme.hymiopeli.ui.Apuri#getHymiopeli()
     * @see iilumme.hymiopeli.logiikka.HymioPeli#getTaso()
     */
    public void tasonVaihtumisJOptionPane() {

        JOptionPane viesti = new JOptionPane(KieliUtil.getString("tasonvaihdos")
                + " " + apuri.getHymiopeli().getTaso(), JOptionPane.PLAIN_MESSAGE,
                JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        final JDialog dialogi = new JDialog();
        dialogi.setTitle(KieliUtil.getString("tasomuuttui"));
        dialogi.setModal(true);
        dialogi.setContentPane(viesti);
        dialogi.setLocation(170, 270);
        dialogi.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialogi.pack();

        Timer aika = new Timer(2000, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dialogi.dispose();
            }
        });
        aika.setRepeats(false);
        aika.start();
        dialogi.setVisible(true);
    }

    /**
     * Luo JOptionPane-olion HighScorejen näyttämistä varten.
     *
     * @see iilumme.hymiopeli.util.KieliUtil#getString(java.lang.String)
     * @see iilumme.hymiopeli.ui.Apuri#getLiittyma()
     */
    public void highScoreNayttoJOptionPane() {
        JOptionPane.showMessageDialog(apuri.getLiittyma().getFrame(),
                getScoret(), KieliUtil.getString("highscorenaytto"),
                JOptionPane.PLAIN_MESSAGE,
                new ImageIcon(ClassLoader.getSystemResource(KISSALOGO)));
    }

    /**
     * Luo JOptionPane-olion ohjeiden näyttämistä varten.
     *
     * @see iilumme.hymiopeli.util.KieliUtil#getString(java.lang.String)
     * @see iilumme.hymiopeli.ui.Apuri#getLiittyma()
     */
    public void ohjeetNayttoJOptionPane() {
        JOptionPane.showMessageDialog(apuri.getLiittyma().getFrame(),
                KieliUtil.getString("ohje"), KieliUtil.getString("ohjeet"),
                JOptionPane.PLAIN_MESSAGE,
                null);
    }

    private String getScoret() {
        String palautus = new String();
        if (apuri.getHighScoreTallentaja().getHighscoret().size() <= 10) {
            int sija = 1;
            for (HighScore s : apuri.getHighScoreTallentaja().getHighscoret()) {
                palautus += sija + ". " + s.getNimi() + " " + s.getPisteet() + "\n";
                sija++;
            }
        } else {
            for (int i = 0; i < 10; i++) {
                palautus += i + 1 + ". " + apuri.getHighScoreTallentaja().getHighscoret().get(i).getNimi()
                        + " " + apuri.getHighScoreTallentaja().getHighscoret().get(i).getPisteet() + "\n";
            }
        }
        return palautus;
    }
}
