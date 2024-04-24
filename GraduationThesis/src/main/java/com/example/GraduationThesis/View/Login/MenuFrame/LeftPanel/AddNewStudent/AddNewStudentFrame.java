package com.example.GraduationThesis.View.Login.MenuFrame.LeftPanel.AddNewStudent;


import com.example.GraduationThesis.View.Login.MenuFrame.LeftPanel.AddNewStudent.Button.StudentInfoForm;
import com.example.GraduationThesis.View.Login.MenuFrame.LeftPanel.AddNewStudent.Button.SubmitButtonListener;
import com.example.GraduationThesis.View.Login.MenuFrame.MenuFrame;

import javax.swing.*;
import java.awt.*;


import java.util.ArrayList;


public class AddNewStudentFrame extends JFrame {
    private JTextField usernameField;
    private JTextField classnameField;
    private JTextField emailField;
    private JTextField dateOfBirthField;
    private JTextField numberphoneField;
    private JTextField addressField;
    private JTextField positionField;
    private JTextField teachernameField;
    private JTextField partentsnameField;
    private JTextField partensnumberphoneField;
    private ArrayList<JTextField[]> scoreFields;


    private MenuFrame menuFrame;

    public AddNewStudentFrame(MenuFrame menuFrame) {
        this.menuFrame = menuFrame;
        // Tạo các label và text field cho thông tin cá nhân
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        JLabel classnameLabel = new JLabel("Classname:");
        classnameField = new JTextField(20);
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);
        JLabel dateOfBirthLabel = new JLabel("Date of Birth:");
        dateOfBirthField = new JTextField(20);
        JLabel numberphoneLabel = new JLabel("Numberphone:");
        numberphoneField = new JTextField(20);
        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField(20);
        JLabel positionLabel = new JLabel("Position:");
        positionField = new JTextField(20);
        JLabel teachernameLabel = new JLabel("Teacher Name:");
        teachernameField = new JTextField(20);
        JLabel partentsnameLabel = new JLabel("Parent's Name:");
        partentsnameField = new JTextField(20);
        JLabel partensnumberphoneLabel = new JLabel("Parent's Numberphone:");
        partensnumberphoneField = new JTextField(20);

        // Create a panel for personal information
        JPanel personalInfoPanel = new JPanel(new GridLayout(12, 2));
        personalInfoPanel.add(usernameLabel);
        personalInfoPanel.add(usernameField);
        personalInfoPanel.add(classnameLabel);
        personalInfoPanel.add(classnameField);
        personalInfoPanel.add(emailLabel);
        personalInfoPanel.add(emailField);
        personalInfoPanel.add(dateOfBirthLabel);
        personalInfoPanel.add(dateOfBirthField);
        personalInfoPanel.add(numberphoneLabel);
        personalInfoPanel.add(numberphoneField);
        personalInfoPanel.add(addressLabel);
        personalInfoPanel.add(addressField);
        personalInfoPanel.add(positionLabel);
        personalInfoPanel.add(positionField);
        personalInfoPanel.add(teachernameLabel);
        personalInfoPanel.add(teachernameField);
        personalInfoPanel.add(partentsnameLabel);
        personalInfoPanel.add(partentsnameField);
        personalInfoPanel.add(partensnumberphoneLabel);
        personalInfoPanel.add(partensnumberphoneField);

        // Create a panel for scores
        JPanel scoresPanel = new JPanel(new GridLayout(14, 6));
        JLabel subjectLabel = new JLabel("Subject");
        scoresPanel.add(subjectLabel);
        JLabel fifteenLabel = new JLabel("15 minutes");
        scoresPanel.add(fifteenLabel);
        JLabel oneHourLabel = new JLabel("1 hour");
        scoresPanel.add(oneHourLabel);
        JLabel midTermLabel = new JLabel("Midterm");
        scoresPanel.add(midTermLabel);
        JLabel finalTermLabel = new JLabel("Final term");
        scoresPanel.add(finalTermLabel);

        scoreFields = new ArrayList<>();
        String[] subjects = {"Literature", "Math", "English", "History", "Geography", "Physics", "Chemistry", "Biology", "Citizen_Education", "National_Defense_And_Security_Education", "Technology", "Information_Technology", "Physical_Education"};

        for (String subject : subjects) {
            JLabel subjectNameLabel = new JLabel(subject);
            scoresPanel.add(subjectNameLabel);

            JTextField[] fields = new JTextField[4];
            for (int i = 0; i < 4; i++) {
                fields[i] = new JTextField(3);
                scoresPanel.add(fields[i]);
            }
            scoreFields.add(fields);
        }

        // Create a panel for conduct
        JPanel conductPanel = new JPanel(new GridLayout(5, 2));
        JLabel conduct2017_2018Label = new JLabel("Conduct 2017-2018:");
        conductPanel.add(conduct2017_2018Label);
        JTextField conduct2017_2018TextField = new JTextField(20);
        conductPanel.add(conduct2017_2018TextField);

        JLabel conduct2018_2019Label = new JLabel("Conduct 2018-2019:");
        conductPanel.add(conduct2018_2019Label);
        JTextField conduct2018_2019TextField = new JTextField(20);
        conductPanel.add(conduct2018_2019TextField);

        JLabel conduct2019_2020Label = new JLabel("Conduct 2019-2020:");
        conductPanel.add(conduct2019_2020Label);
        JTextField conduct2019_2020TextField = new JTextField(20);
        conductPanel.add(conduct2019_2020TextField);

        JLabel attendanceScoreLabel = new JLabel("Attendance Score:");
        conductPanel.add(attendanceScoreLabel);
        JTextField attendanceScoreTextField = new JTextField(20);
        conductPanel.add(attendanceScoreTextField);


        // create submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener(menuFrame, this, usernameField, classnameField, emailField, dateOfBirthField, numberphoneField, addressField, positionField, teachernameField, partentsnameField, partensnumberphoneField, scoreFields, conduct2017_2018TextField, conduct2018_2019TextField, conduct2019_2020TextField, attendanceScoreTextField));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(personalInfoPanel);
        mainPanel.add(scoresPanel);
        mainPanel.add(conductPanel);
        mainPanel.add(submitButton);

        add(mainPanel);

        setTitle("Student Information Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close this window without affecting the MenuFrame
        pack();
        requestFocusInWindow();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentInfoForm::new);
    }
}