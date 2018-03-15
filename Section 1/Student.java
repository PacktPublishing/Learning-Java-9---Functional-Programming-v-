package Product3.GenericDataStructures;

public class Student {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String emailAddress;

    public Student(String firstName, String lastName, int age, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
