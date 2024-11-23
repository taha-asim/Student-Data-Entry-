import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // ArrayList to store student data
        ArrayList<Student> studentList = new ArrayList<>();

        // Create frame
        JFrame frame = new JFrame("Student Data Entry");
        frame.setSize(600, 700);
        frame.setLayout(null);

        // Banner
        JLabel bannerLabel = new JLabel("Student Data Entry Form", SwingConstants.CENTER);
        bannerLabel.setBounds(0, 10, 600, 40);
        bannerLabel.setOpaque(true);
        bannerLabel.setBackground(Color.RED);
        bannerLabel.setForeground(Color.WHITE);
        frame.add(bannerLabel);

        // Form fields
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        nameLabel.setBounds(50, 60, 100, 25);
        nameField.setBounds(200, 60, 300, 25);
        frame.add(nameLabel);
        frame.add(nameField);

        JLabel fatherNameLabel = new JLabel("Father Name:");
        JTextField fatherNameField = new JTextField();
        fatherNameLabel.setBounds(50, 100, 100, 25);
        fatherNameField.setBounds(200, 100, 300, 25);
        frame.add(fatherNameLabel);
        frame.add(fatherNameField);

        JLabel cityLabel = new JLabel("City:");
        JComboBox<String> cityComboBox = new JComboBox<>(new String[]{"Select City", "Islamabad", "Lahore", "Karachi", "Peshawar"});
        cityLabel.setBounds(50, 140, 100, 25);
        cityComboBox.setBounds(200, 140, 300, 25);
        frame.add(cityLabel);
        frame.add(cityComboBox);

        JLabel addressLabel = new JLabel("Address:");
        JTextField addressField = new JTextField();
        addressLabel.setBounds(50, 180, 100, 25);
        addressField.setBounds(200, 180, 300, 25);
        frame.add(addressLabel);
        frame.add(addressField);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        emailLabel.setBounds(50, 220, 100, 25);
        emailField.setBounds(200, 220, 300, 25);
        frame.add(emailLabel);
        frame.add(emailField);

        // Image upload section
        JLabel imageLabel = new JLabel("Image:");
        JButton chooseFileButton = new JButton("Choose File");
        JLabel filePathLabel = new JLabel("No file selected");
        JLabel imageDisplayLabel = new JLabel(); // Label to display the image
        imageDisplayLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        imageLabel.setBounds(50, 260, 100, 25);
        chooseFileButton.setBounds(200, 260, 100, 25);
        filePathLabel.setBounds(310, 260, 300, 25);
        imageDisplayLabel.setBounds(200, 300, 200, 200); // Space to display the image

        frame.add(imageLabel);
        frame.add(chooseFileButton);
        frame.add(filePathLabel);
        frame.add(imageDisplayLabel);

        // Choose file action listener
        chooseFileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                String imagePath = fileChooser.getSelectedFile().getAbsolutePath();
                filePathLabel.setText(imagePath);

                // Display the selected image
                try {
                    ImageIcon imageIcon = new ImageIcon(imagePath);
                    Image scaledImage = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Scale the image
                    imageDisplayLabel.setIcon(new ImageIcon(scaledImage));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Unable to load the selected image!", "Error", JOptionPane.ERROR_MESSAGE);
                    filePathLabel.setText("No file selected");
                    imageDisplayLabel.setIcon(null); // Clear the image display
                }
            }
        });

        JLabel genderLabel = new JLabel("Gender:");
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderLabel.setBounds(50, 520, 100, 25);
        maleButton.setBounds(200, 520, 80, 25);
        femaleButton.setBounds(300, 520, 80, 25);
        frame.add(genderLabel);
        frame.add(maleButton);
        frame.add(femaleButton);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(250, 580, 100, 30);
        frame.add(submitButton);

        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(50, 620, 500, 25);
        frame.add(resultLabel);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String fatherName = fatherNameField.getText();
            String city = (String) cityComboBox.getSelectedItem();
            String address = addressField.getText();
            String email = emailField.getText();
            String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "";
            String imagePath = filePathLabel.getText();

            // Validate input
            if (name.isEmpty() || fatherName.isEmpty() || city.equals("Select City") || address.isEmpty()
                    || email.isEmpty() || gender.isEmpty() || imagePath.equals("No file selected")) {
                resultLabel.setText("Please fill in all fields!");
            } else {
                // Create a new student object and add it to the studentList
                Student student = new Student(name, fatherName, city, address, email, gender, imagePath);
                studentList.add(student);

                resultLabel.setText("Student data submitted successfully!");

                // Reset the form fields
                nameField.setText("");
                fatherNameField.setText("");
                addressField.setText("");
                emailField.setText("");
                cityComboBox.setSelectedIndex(0);
                filePathLabel.setText("No file selected");
                imageDisplayLabel.setIcon(null);
                genderGroup.clearSelection();

                // Display the list of students
                System.out.println("Current Students:");
                for (Student s : studentList) {
                    System.out.println(s);
                }
            }
        });

        // Show frame
        frame.setVisible(true);
    }
}
