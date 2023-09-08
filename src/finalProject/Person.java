package finalProject;

public class Person {
    private String name;
    private String secondName;
    private String surName;
    private String birthDate;
    private long phoneNumber;
    private char sex;

    public Person(String name, String secondName, String surName,
                  String birthDate, long phoneNumber, char sex) {
        this.name = name;
        this.secondName = secondName;
        this.surName = surName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public String getSecondName() {
        return secondName;
    }

}
