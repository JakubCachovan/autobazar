package gui;

import autobazar.Predajca;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Dialogove okno pre vytvorenie predajcu.
 * @author Jakub Cachovan
 */
public class NovyPredajcaDialog extends javax.swing.JDialog {
    private Predajca predajca;
    private ArrayList<Predajca> existujuciPredajcovia;
    private boolean upravaPredajcu = false;
    /**
     * Creates new form NovyPredajcaDialog
     * @param parent parent
     * @param modal modal
     */
    public NovyPredajcaDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jLabel1.setIcon(new ImageIcon("./icons/userM.png"));
        jButtonUlozitPredajcu.setIcon(new ImageIcon("./icons/save.png"));
    }

    /**
     * Getter pre objekt typu Predajca.
     * @return objekt typu Predajca
     */
    public Predajca getPredajca() {
        return predajca;
    }

    /**
     * Setter pre atribút typu Predajca.
     * @param predajca objekt typu Predajca
     */
    public void setPredajca(Predajca predajca) {
        this.predajca = predajca;
    }
  
    /**
     * Getter pre zoznam existujucich predajcov v autobazare.
     * @return zoznam existujucich predajcov
     */
    public ArrayList<Predajca> getExistujuciPredajcovia() {
        return existujuciPredajcovia;
    }
    
    /**
     * Setter pre zoznam existujucich predajcov.
     * @param existujuciPredajcovia zoznam existujucich predajcov
     */
    public void setExistujuciPredajcovia(ArrayList<Predajca> existujuciPredajcovia) {
        this.existujuciPredajcovia = existujuciPredajcovia;
    }
    
    /**
     * Setter pre indikator upravy predajcu.
     * @param upravaPredajcu indikator upravy predajcu
     */
    public void setUpravaPredajcu(boolean upravaPredajcu) {
        this.upravaPredajcu = upravaPredajcu;
    }
    
    /**
     * Validácia formuláru pre predajcu.
     * @return true/false
     */
    public boolean validaciaFormularu(){
        Pattern p = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        Matcher m = p.matcher(jTextFieldEmail.getText());
        if(!m.find()){
            JOptionPane.showMessageDialog(null, "Nesprávne zadaný email");
            return false;
        }else if(jTextFieldEmail.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Zadajte email");
            return false;
        }else if(jTextFieldMeno.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Zadajte meno");
            return false;
        }else if(jTextFieldPriezvisko.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Zadajte priezvisko");
            return false;
        }
        return true;
    }
    
    /**
     * Overenie existencie predajcu v autobazare.
     * @return true/false
     */
    private boolean existujuciPredajca(){
        String email = jTextFieldEmail.getText();
        for (Predajca p : existujuciPredajcovia) {
            if(p.getEmail().equalsIgnoreCase(email)){
                JOptionPane.showMessageDialog(null, "Existujúci predjaca", "Upozornenie!", JOptionPane.WARNING_MESSAGE);
                return true;
            }else{                             
                return false;
            }
        }
        return false;
    }
    
    /**
     * Naplnenie formularu informaciami o priradenom predajcovi, v prípade, že sa jedná o úpravu predajcu.
     */
    public void NaplnFormular(){
        jTextFieldEmail.setText(predajca.getEmail());
        jTextFieldLokalita.setText(predajca.getLokalita());
        jTextFieldMeno.setText(predajca.getMeno());
        jTextFieldPriezvisko.setText(predajca.getPriezvisko());
        jTextFieldTel.setText(predajca.getTelefon());      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldMeno = new javax.swing.JTextField();
        jTextFieldPriezvisko = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldLokalita = new javax.swing.JTextField();
        jTextFieldTel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonUlozitPredajcu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nový predajca");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setText("Lokalita");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setText("Telefón");

        jTextFieldMeno.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextFieldMeno.setToolTipText("");

        jTextFieldPriezvisko.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jTextFieldEmail.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jTextFieldLokalita.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jTextFieldTel.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Meno");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setText("Priezvisko");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setText("Email");

        jButtonUlozitPredajcu.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButtonUlozitPredajcu.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\Autobazar\\icons\\pridat.png")); // NOI18N
        jButtonUlozitPredajcu.setText("Uložiť");
        jButtonUlozitPredajcu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUlozitPredajcuActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\Autobazar\\icons\\userM.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldLokalita, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldMeno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPriezvisko, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonUlozitPredajcu)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMeno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPriezvisko, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLokalita, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonUlozitPredajcu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Priradenie predajcu k inzerátu.
     * @param evt - event
     */
    private void jButtonUlozitPredajcuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUlozitPredajcuActionPerformed
        if(validaciaFormularu()){
            String email = jTextFieldEmail.getText();
            String lokalita = jTextFieldLokalita.getText();
            String meno = jTextFieldMeno.getText();
            String priezvisko = jTextFieldPriezvisko.getText();
            String telefon = jTextFieldTel.getText(); 
            if(upravaPredajcu){
                predajca.setEmail(email);
                predajca.setLokalita(lokalita);
                predajca.setMeno(meno);
                predajca.setPriezvisko(priezvisko);
                predajca.setTelefon(telefon);
                JOptionPane.showMessageDialog(null, "Informácie o predajcovi boli obnovené", "Upozornenie", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            else if(!existujuciPredajca()){
            // pridanie noveho predajcu
                predajca = new Predajca(email, lokalita, meno, priezvisko, telefon); 
                dispose();
            }
        }       
    }//GEN-LAST:event_jButtonUlozitPredajcuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonUlozitPredajcu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLokalita;
    private javax.swing.JTextField jTextFieldMeno;
    private javax.swing.JTextField jTextFieldPriezvisko;
    private javax.swing.JTextField jTextFieldTel;
    // End of variables declaration//GEN-END:variables
}
