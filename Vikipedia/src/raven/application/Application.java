package raven.application;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import raven.application.form.LoginForm;
import raven.application.form.MainForm;
import raven.toast.Notifications;
import raven.data.*;
import java.util.ArrayList;

/**
 *
 * @author Raven
 */
public class Application extends javax.swing.JFrame {

    private static Application app;
    private final MainForm mainForm;
    private final LoginForm loginForm;

    public Application() {
        initComponents();
        setSize(new Dimension(1366, 768));
        setLocationRelativeTo(null);
        mainForm = new MainForm();
        loginForm = new LoginForm();
        setContentPane(loginForm);
        getRootPane().putClientProperty(FlatClientProperties.FULL_WINDOW_CONTENT, true);
        Notifications.getInstance().setJFrame(this);
    }

    public static void showForm(Component component) {
        component.applyComponentOrientation(app.getComponentOrientation());
        app.mainForm.showForm(component);
    }

    public static void login() {
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.mainForm);
        app.mainForm.applyComponentOrientation(app.getComponentOrientation());
        setSelectedMenu(0, 0);
        app.mainForm.hideMenu();
        SwingUtilities.updateComponentTreeUI(app.mainForm);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    }

    public static void logout() {
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.loginForm);
        app.loginForm.applyComponentOrientation(app.getComponentOrientation());
        SwingUtilities.updateComponentTreeUI(app.loginForm);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    }

    public static void setSelectedMenu(int index, int subIndex) {
        app.mainForm.setSelectedMenu(index, subIndex);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("raven.theme");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            app = new Application();
            //  app.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            init();
            app.setVisible(true);
        });
    }

    public static ArrayList<VWE> enveList= new ArrayList<VWE>();
    public static ArrayList<VNE> nonenveList= new ArrayList<VNE>();
    
    public final static void init() {
		int[] ckvHIV = {38700000,650000,38050000};
                int[] ckvCOVID = {704800000, 7010000, 625200000};
                int[] ckvVAC = {0,0,0};
                int[] ckvCAL = {0,0,0};
                int[] ckvROTA = {138000000,472000,111000000};
                int[] ckvREOV = {0,0,0};
                String[] COV = new String []{"Realm: Riboviria","Kingdom: Orthornavirae","Phylum: Pisuviricota","Class: Pisoniviricetes","Order: Nidovirales","Family: Coronaviridae","Subfamily: Orthocoronavirinae"};
                String[] Hiv= new String []{"Realm: Riboviria","Kingdom: Pararnavirae","Phylum: Artverviricota","Class: Revtraviricetes","Order: Ortervirales","Family: Retroviridae","Subfamily: Orthoretrovirinae"};
		String[] VAC = new String[]{"Realm: Varidnaviria","Kingdom: Bamfordvirae","Phylum: Nucleocytoviricota","Class: Pokkesviricetes","Order: Chitovirales","Family: Poxviridae"};	
                String[] CAL= new String []{"Realm: Riboviria","Kingdom: Orthornavirae","Phylum: Pisuviricota","Class: Pisoniviricetes","Order: Picornavirales","Family: Caliciviridae"};
                String[] ROTA= new String []{"Family: Reoviridae","Subfamily: Sedoreovirinae","Genus: Rotavirus", "", "", ""};
                String[] REOV= new String []{"Realm: Riboviria","Kingdom: Orthornavirae","Phylum: Duplornaviricota", "Class: Resentoviricetes","Order: Reovirales","Family: Sedoreoviridae"};

                VWE vir1 = new VWE("COVID19",COV,String.format(
    "<html>COVID-19 is a novel coronavirus, characterized by its single-stranded RNA genetic material. Unlike human cells, which typically carry double-stranded DNA, coronaviruses utilize RNA as their genetic blueprint. " +
    "Coronaviruses, including COVID-19, possess a crucial enzyme called RNA-dependent RNA polymerase, enabling them to replicate their RNA genome within host cells. " +
    "Upon infecting a cell, COVID-19 first binds to specific receptors on the host cell's surface, facilitating its entry into the cell.</html>")
,"SARS-CoV-2","Dec 2019",ckvCOVID,
                String.format(
                    "<html>" +
                    "<b>COVID-19:</b> COVID-19, caused by the SARS-CoV-2 virus, is a respiratory illness " +
                    "that spreads primarily through droplets. Symptoms range froWm mild to severe, " +
                    "including fever, cough, and difficulty breathing. Vaccines and preventive measures " +
                    "are crucial to control its spread.<br><br>" +
                    "<b>Vaccinia Virus:</b> The vaccinia virus, used in the smallpox vaccine, " +
                    "is a member of the orthopoxvirus family. It helps confer immunity to smallpox. " +
                    "While generally safe, the vaccine can cause adverse effects in rare cases." +
                    "</html>"), "D:/Vikipedia/src/raven/data/COVID19.png","D:\\Vikipedia\\src\\raven\\data\\COVID19.mp4");

        
    	VWE vir2 = new VWE("HIV"
                            ,Hiv,
                            String.format(
                            "<html>HIV is a retrovirus, which means it carries single-stranded RNA as its genetic material rather than the double-stranded DNA human cells carry. " +
                            "Retroviruses also have the enzyme reverse transcriptase, which allows it to copy RNA into DNA and use that DNA \"copy\" to infect human, or host, cells. " +
                            "When HIV infects a cell, it first attaches to and fuses with the host cell. Then the virus uses the host cell's machinery to convert the viral RNA into DNA and replicate itself. " +
                            "The new copies of HIV then leave the host cell and move on to infect other cells.</html>"), 
                            "HIV",
                            "1983",
                            ckvHIV,
                            String.format(
                                "<html>HIV, a retrovirus with single-stranded RNA, " +
                                "uses reverse transcriptase to convert RNA into DNA, " +
                                "allowing it to infect and replicate within host cells."+
                                "New HIV copies then spread to other cells.</html>"),"D:/Vikipedia/src/raven/data/HIV.png","D:\\Vikipedia\\src\\raven\\data\\HIV.mp4");

   		VWE vir3 = new VWE("VACCINA VIRUS",VAC,String.format(
    "<html>The Vaccinia virus is a member of the poxvirus family, which is known for its large, double-stranded DNA genome. Unlike human cells that carry their genetic material in the form of double-stranded DNA within a nucleus, poxviruses replicate entirely in the cytoplasm of the host cell. " +
    "Poxviruses, including Vaccinia, possess a complex set of enzymes, including DNA-dependent RNA polymerase, which allows them to transcribe their DNA into mRNA and produce viral proteins directly in the host cell's cytoplasm.</html>")
,"VACV","1796", ckvVAC,
                        String.format(
            "<html>Vaccinia virus is a large, complex virus belonging to the poxvirus family. " + ""
                    + "Unlike most viruses, it carries double-stranded DNA as its genetic material. " +
            "One of the remarkable features of vaccinia virus is its ability to replicate exclusively " + ""
                    + "in the cytoplasm of infected cells, unlike other DNA viruses that replicate in the nucleus.</html>"),
                "D:/Vikipedia/src/raven/data/VACCINAVIRUS.png","D:\\Vikipedia\\src\\raven\\data\\VACCINAVIRUS.mp4");

    	
    	VNE vir4 = new VNE("CALICI VIRUS",CAL,
                String.format(
                "<html>Calicivirus is a family of viruses known for causing gastrointestinal"
                        + "illness in humans and animals. Like HIV, caliciviruses are single-stranded RNA viruses," +
                        "but they do not carry the enzyme reverse transcriptase. Instead, " +
                        "they replicate using their own RNA-dependent RNA polymerase. When a calicivirus infects " + 
                        "a host cell, it hijacks the cell's machinery to replicate its RNA and produce more virus " + 
                        "particles. These particles then spread to infect other cells in the gastrointestinal tract.</html>"),
                        "FCV", "1957", ckvCAL, 
                        String.format(
                        "<html>Calicivirus is a family of single-stranded RNA " +
                        "viruses causing gastrointestinal illness. They replicate" +
                        "using RNA-dependent RNA polymerase, spreading through infected cells " +
                        "in the gastrointestinal tract.</html>"), "D:/Vikipedia/src/raven/data/CALICIVIRUS.png","D:\\Vikipedia\\src\\raven\\data\\CALICIVIRUS.mp4");


    	
    	VNE vir5 = new VNE("ROTAVIRUS",ROTA,
                String.format(
                "<html>Rotavirus is a double-stranded RNA virus that is a common cause of diarrhea in young children. " +
                        "Unlike HIV, rotavirus does not carry reverse transcriptase. Instead, it uses its own RNA-dependent RNA " +
                        "polymerase to replicate its genome. When a rotavirus infects a host cell lining the intestine, it " +
                        "causes the cell to produce new virus particles, which are then shed in the stool and can spread to other" +
                        "individuals through contaminated food, water, or surfaces.</html>"),
                "Rotavirus", "1972", ckvROTA,
                String.format(
    "<html>Rotavirus is a double-stranded RNA virus that is a common cause of diarrhea" + 
            "in young children. Unlike HIV, rotavirus does not carry reverse transcriptase." +
            "Instead, it uses its own RNA-dependent RNA polymerase to replicate its genome. " +
            "When a rotavirus infects a host cell lining the intestine, it causes the cell " +
            "to produce new virus particles, which are then shed in the stool and can spread to" +
            "other individuals through contaminated food, water, or surfaces.</html>"),"D:/Vikipedia/src/raven/data/ROTAVIRUS.jpg","D:\\Vikipedia\\src\\raven\\data\\ROTAVIRUS.mp4");


    	
    	VNE vir6 = new VNE("REOVIRIDAE VIRUS",REOV,
                String.format(
    "<html>Reoviridae is a family of viruses that includes several important human pathogens. These viruses have a " +
            "double-stranded RNA genome, like rotavirus, and they replicate their genetic material using their own RNA-dependent" +
            "RNA polymerase. However, unlike HIV, reoviruses do not carry reverse transcriptase. When a reovirus " + 
            "infects a host cell, it forms replication complexes in the cytoplasm, where it synthesizes new RNA strands and assembles " +
            "new virus particles. These particles are then released to infect other cells and spread the infection.</html>"),
            "Reoviridae", "1953", ckvREOV,
             String.format(
    "<html>Reoviridae viruses, with a double-stranded RNA genome, include significant " +
            "human pathogens. They replicate using RNA-dependent RNA polymerase in cytoplasmic " +
            "complexes, releasing new virus particles to infect other cells.</html>"),
                     "D:/Vikipedia/src/raven/data/REOVIRIDAE.png","D:\\Vikipedia\\src\\raven\\data\\REOVIRIDAE.mp4");


    	enveList.add(vir1); 
    	enveList.add(vir2);
    	enveList.add(vir3);
    	nonenveList.add(vir4);
    	nonenveList.add(vir5);
        nonenveList.add(vir6);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
