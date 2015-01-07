package diary;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * @author neeraj
 */
public class Note extends javax.swing.JFrame {
        String defaultDirectory;
        String filenameopened;
        Date date;
        String todaysFilename;
        Map encode,decode;
        JLabel label2;
        File file;
        public Note() throws IOException {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            initComponents();
            Font font=new Font("Serif",Font.TRUETYPE_FONT,14);
            textArea.setFont(font);
            if(System.getProperty("os.name").startsWith("Windows"))
                defaultDirectory="D:\\neeraj\\notes\\";
            else
                defaultDirectory="/media/Data/neeraj/notes/";

            encode=new HashMap();
            decode=new HashMap();
            String map="mkopqwerlityuasdfghjzxcvbnMKOPQWERLITYUASDFGHJZXCVBN";
            int i;
            char c='a';
            for(i=0;i<52;i++)
                
            {
                if(i==26)
                    c='A';
                encode.put(c,map.charAt(i));
                decode.put(map.charAt(i),c);
                c++;
            }
            label2=new JLabel();
            label2.setVisible(true);
            add(label2,BorderLayout.SOUTH);
            date=new Date();
            todaysFilename=defaultDirectory+(date.getYear()+1900)+"_"+(date.getMonth()+1)+"_"+date.getDate()+".txt";
            file=new File(todaysFilename);
            if(!file.exists())
                file.createNewFile();
            openFile(todaysFilename);
            filenameopened=todaysFilename;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        label = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newfile = new javax.swing.JMenuItem();
        open = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        label.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        newfile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newfile.setText("New");
        newfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newfileActionPerformed(evt);
            }
        });
        jMenu1.add(newfile);

        open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        open.setText("Open");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        jMenu1.add(open);

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jMenu1.add(save);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(defaultDirectory));
        int val = chooser.showOpenDialog(this);
        if(val == chooser.APPROVE_OPTION){//if user did choose a file
            filenameopened = chooser.getSelectedFile().getPath();//get chosen filepath in filenameopened
            openFile(filenameopened);//calls this fn to load the file in textArea
        }
    }//GEN-LAST:event_openActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
                if(filenameopened==null)//if no file is opened i.e. We started writing in a new empty textArea
                {
                    date=new Date();//we will use this date to uniquely name our file for each day(Daily diary!)
                    filenameopened=defaultDirectory+(date.getYear()+1900)+"_"+(date.getMonth()+1)+"_"+date.getDate()+".txt";
                    label.setText(filenameopened);
                    file=new File(filenameopened);
                    try {
                        file.createNewFile();//create this file in path present in filenameopened
                    } catch (IOException ex) {
                        Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                String text2="",text1 = textArea.getText();
                for(int i=0;i<text1.length();i++)
                {
                    char ch=text1.charAt(i);
                    if(isAlpha(ch))
                        ch=(char)decode.get(ch);//decode a char.Yes, the encoding used substitution cipher. Bah!!!
                    text2+=ch;
                }
                text1=text2;
                byte arr1[] = text1.getBytes();
                OutputStream os;
                try {
                        os = new FileOutputStream(filenameopened);
                        os.write(arr1);
                        os.close();
                     }
                catch (FileNotFoundException ex) {
                    System.out.println("file not found exception");
                }
                catch (IOException ex) {
                    System.out.println("IO exception");
//                      Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
                }               
    }//GEN-LAST:event_saveActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);// exit/close the application
    }//GEN-LAST:event_exitActionPerformed

    private void newfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newfileActionPerformed
        System.out.println("New not implemented yet!");//Do I really need this? Not required in daily diary?
    }//GEN-LAST:event_newfileActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JMenuItem newfile;
    private javax.swing.JMenuItem open;
    private javax.swing.JMenuItem save;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables

    private boolean isAlpha(char ch) {
        return (ch>='a' && ch<='z') ||(ch>='A' && ch<='Z');
    }

    private void openFile(String filenameopened) {
        File fileobj = new File(filenameopened);
        String text="";
        System.out.println("File object initialized");
        try {
            InputStream is = new FileInputStream(fileobj);
            char ch;
            int offset = 1;
                int filesize = is.available();
                while(offset <= filesize){
                    ch = (char) is.read();
                    if(isAlpha(ch))
                        ch=(char)encode.get(ch);
                    text = text + ch;
                    offset++;
                }
            }
            catch (IOException ex) {
                System.out.println("IO exception");
                Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
            }
        textArea.setText(text);
        label.setText(filenameopened);
        label2.setText(filenameopened);    
        }
}