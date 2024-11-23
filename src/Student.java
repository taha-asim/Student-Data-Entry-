public class Student {
    private String name;
    private String fatherName;
    private String city;
    private String address;
    private String email;
    private String gender;
    private String imagePath;

    // Constructor to initialize student data
    public Student(String name, String fatherName, String city, String address, String email, String gender, String imagePath) {
        this.name = name;
        this.fatherName = fatherName;
        this.city = city;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.imagePath = imagePath;
    }

    // Getters for the student data
    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getImagePath() {
        return imagePath;
    }

    //displaying student information
    @Override
    public String toString() {
        return "Name: " + name + ", Father Name: " + fatherName + ", City: " + city + ", Address: " + address +
                ", Email: " + email + ", Gender: " + gender + ", Image Path: " + imagePath;
    }
}
