package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField pan_numTextField, aadharTextField;
    JRadioButton syes,sno,yes,no;
    JButton next;
    JComboBox rlgn,cat,salary,edu,job;
    String formno;
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("New Account Application Form - Page 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);

        cat = new JComboBox(new String[]{"General", "OBC","SC","ST","Other"});
        cat.setBounds(300,190,400,30);
        add(cat);

        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);


        rlgn = new JComboBox(new String[]{"Hindu","Muslim","Sikh","Christian","Jain","Buddhism"});

        rlgn.setBounds(300,140,400,30);
        add(rlgn);


        JLabel dob = new JLabel("Income: ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        salary = new JComboBox(new String[]{"Unemployed","<1,50,000","<2,50,000","<5,00,000","More than 5,00,000"});
        salary.setBounds(300,240,400,30);
        add(salary);

        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,290,200,30);
        add(education);

        edu = new JComboBox(new String[]{"10th Pass","12th Pass","Graduate","Post Graduate","Doctorate","Uneducated"});
        edu.setBounds(300,300,400,30);
        add(edu);

        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,315,200,30);
        add(qualification);

        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);

        job = new JComboBox(new String[]{"Salaried","Self Employed","Business Man","Student","Retired","Other"});
        job.setBounds(300,390,400,30);
        add(job);

        JLabel pan_num = new JLabel("Pan Number: ");
        pan_num.setFont(new Font("Raleway",Font.BOLD,20));
        pan_num.setBounds(100,440,200,30);
        add(pan_num);

        pan_numTextField = new JTextField();
        pan_numTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pan_numTextField.setBounds(300,440,400,30);
        add(pan_numTextField);

        JLabel aadhdar = new JLabel("Aadhar No: ");
        aadhdar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhdar.setBounds(100,490,200,30);
        add(aadhdar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);

        JLabel state = new JLabel("Senior Cititzen: ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        add(sno);

        ButtonGroup sr_citizen = new ButtonGroup();
        sr_citizen.add(syes);sr_citizen.add(sno);

        JLabel existingAccount = new JLabel("Existing Account: ");
        existingAccount.setFont(new Font("Raleway",Font.BOLD,20));
        existingAccount.setBounds(100,590,200,30);
        add(existingAccount);


//        pinCodeTextField.setBounds(300,590,400,30);
        yes = new JRadioButton("Yes");
        yes.setBounds(300,590,100,30);
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(450,590,100,30);
        add(no);

        ButtonGroup acc = new ButtonGroup();
        acc.add(yes);acc.add(no);

        JButton next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.setBackground(Color.CYAN);
        next.addActionListener(this);
        add(next);
        getContentPane().setBackground(Color.YELLOW);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String religion = (String) rlgn.getSelectedItem();
        String category= (String) cat.getSelectedItem();
        String income = (String) salary.getSelectedItem();
        String education = (String) edu.getSelectedItem();
        String occupation = (String) job.getSelectedItem();

        String senior_citizen = "";
        if(syes.isSelected()){
            senior_citizen = "Yes";
        }else if(sno.isSelected()) {
            senior_citizen = "No";
        }

        String existingAccount = "";
        if(yes.isSelected()){
            existingAccount = "Yes";
        }else if(no.isSelected()){
            existingAccount = "No";
        }

        String span = pan_numTextField.getText();
        String aadhaar = aadharTextField.getText();


        try{

                Connections c = new Connections();
                String query = "insert into signuptwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+span+"', '"+aadhaar+"', '"+senior_citizen+"', '"+existingAccount+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno).setVisible(true);

        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
