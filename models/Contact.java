package models;


import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Contact {
    private String name;
    private String birthDate;
    private String phoneNumber;
    private int age;

    public Contact(String name, String birthDate, String phoneNumber) throws ParseException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can not be blank.");
        }
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone Number can not be blank.");
        }
        if (phoneNumber.length() < 5) {
            throw new IllegalArgumentException("Phone Number cannot be less than 5.");
        }

        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.age = toAge(birthDate);

    }

    public Contact(Contact source) {
        this.name = source.name;
        this.birthDate = source.birthDate;
        this.phoneNumber = source.phoneNumber;
        this.age = source.age;

    }

    public String getName() {
        return this.name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public String getPhoneNumber() {

        return this.phoneNumber;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null/Blank");
        }
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank() || phoneNumber.length() < 5) {
            throw new IllegalArgumentException("Phone Number Can not be null/blank.");
        }
        if (phoneNumber.length() < 5) {
            throw new IllegalArgumentException("Phone number can not be Less than 5 charecters");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = birthDate;
        setAge(toAge(birthDate));
    }

    public int toAge(String birthDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        long difference = new Date().getTime() - formatter.parse(birthDate).getTime();
        return (int) (TimeUnit.MILLISECONDS.toDays(difference) / 365);
    }

    public String toString() {
        return "Name: " + this.name + "\n" +

                "Phone number: " + this.phoneNumber + "\n" +

                "Birth Date: " + this.birthDate + "\n" +

                "Age: " + this.age + " year old\n";
    }

}
