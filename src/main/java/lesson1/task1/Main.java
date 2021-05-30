package lesson1.task1;

public class Main {

    public static void main(String[] args) {
        Person person = new PersonBuilder().setAddress("address").setAge(15).setCountry("Ru").setFirstName("M").setGender("f").setLastName("A").setPhone("123").setMiddleName("L").build();
        System.out.println(person);
    }
}
