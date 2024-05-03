import java.awt.Font;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


public class PasswordGen {
    public static Random random = new Random();
    public static JCheckBox[] conditions = {new JCheckBox("Has U Letters"),new JCheckBox ("Has Numbers"), 
                                            new JCheckBox("Has Symbols"),
                                            new JCheckBox ("Has other characters") };
    public static void main(String[] args) {
        JFrame frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(20, 10, 360, 270);
        JPanel panel =new JPanel();
        for (JCheckBox chk:conditions){
        panel.add(chk);
        }

        JSpinner letterCount = new JSpinner(new SpinnerNumberModel(8,8,500,1));
        JLabel letterCountLabel = new JLabel("How Many Letters?");

        panel.add(letterCountLabel);
        panel.add(letterCount);
         JTextField password = new JTextField(20);
         panel.add(password);
         JButton gen = new JButton("Generate");
         gen.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
                    StringBuilder generated = new StringBuilder("");
                    int count = (int)letterCount.getValue();
                    for (int i=0; i <count; i++){
                    int  rand;
                    if(conditions[0].isSelected()){
                    if(random.nextBoolean()){
                    rand = 65+random.nextInt(25);
                generated.append((char)rand);
            continue;
            }
                }
    
                if(conditions[1].isSelected()){
            if(random.nextBoolean()){
            rand = 48+random.nextInt(1);
            generated.append((char)rand);
            continue;
            }
        }
            if(conditions[2].isSelected()){
                if(random.nextBoolean()){
                rand = 33+random.nextInt(2);
            generated.append((char)rand);
            continue;
            }
            if(conditions[3].isSelected()){
                if(random.nextBoolean()){
                rand = 65+random.nextInt(Character.MAX_VALUE);
            generated.append((char)rand);
            continue;
            }
                    
        }
                rand = 97+random.nextInt(25);
                generated.append((char)rand);
                }
                password.setText(generated.toString());           
            
                }
             }
            });
             JButton copy = new JButton("copy"); 
             copy.addActionListener(new ActionListener (){
                 @Override
                 public void actionPerformed(ActionEvent e){
                    
                    //Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(password.getText(), null));
                 }
            });
             panel.add(gen);
             //panel.add(copy);
             for (Component c:panel.getComponents()){
                c.setFont(new Font("Arial",Font.PLAIN,20));
             }

            frame.add(panel);
            frame.setVisible(true);
            }
    }


        

