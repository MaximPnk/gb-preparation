package lesson1.task1;

public class PersonBuilder {
    
    private final Person instance;

    public PersonBuilder() {
        instance = new Person();
    }

    public Person build() {
        return instance;
    }

    public PersonBuilder setFirstName(String firstName) {
        instance.setFirstName(firstName);
        return this;
    }

    public PersonBuilder setLastName(String lastName) {
        instance.setLastName(lastName);
        return this;
    }

    public PersonBuilder setMiddleName(String middleName) {
        instance.setMiddleName(middleName);
        return this;
    }

    public PersonBuilder setCountry(String country) {
        instance.setCountry(country);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        instance.setAddress(address);
        return this;
    }

    public PersonBuilder setPhone(String phone) {
        instance.setPhone(phone);
        return this;
    }

    public PersonBuilder setAge(int age) {
        instance.setAge(age);
        return this;
    }

    public PersonBuilder setGender(String gender) {
        instance.setGender(gender);
        return this;
    }
    
}
