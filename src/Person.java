import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Person {
	public enum Sex {
        MALE, FEMALE
    }
  
    String name; 
    LocalDate birthday;
    Sex gender;
    String codeName;
    String emailAddress;
  
    Person(String nameArg, LocalDate birthdayArg,
        Sex genderArg, String emailArg, String codeNameArg) {
        name = nameArg;
        birthday = birthdayArg;
        gender = genderArg;
        codeName = codeNameArg;
        emailAddress = emailArg;
    }  

    public int getAge() {
        return birthday
            .until(IsoChronology.INSTANCE.dateNow())
            .getYears();
    }

    public void printPerson() {
      System.out.println(name + ", " + this.getAge());
    }
    
    public Sex getGender() {
        return gender;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    
    public LocalDate getBirthday() {
        return birthday;
    }
    
    public String getCodeName() {
        return codeName;
    }
    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public static List<Person> createRoster() {
        
        List<Person> roster = new ArrayList<>();
        roster.add(
            new Person(
            "Fred",
            IsoChronology.INSTANCE.date(1980, 6, 20),
            Person.Sex.MALE,
            "A",
            "fred@example.com"));
        roster.add(
            new Person(
            "Jane",
            IsoChronology.INSTANCE.date(1990, 7, 15),
            Person.Sex.FEMALE, 
            "A",
            "jane@example.com"));
        roster.add(
            new Person(
            "George",
            IsoChronology.INSTANCE.date(1991, 8, 13),
            Person.Sex.MALE, 
            "B",
            "george@example.com"));
        roster.add(
            new Person(
            "Bob",
            IsoChronology.INSTANCE.date(2000, 9, 12),
            Person.Sex.MALE, 
            "B",
      		"bob@example.com"));
        
        return roster;
    }
    public static void main(String[] args) {
        List<Person> people = createRoster();
        List<String> list = people.stream()
                                  .map(Person::getName)
                                  .collect(Collectors.toList());
        System.out.println(list.toString());
        Map<String, List<Person>> peopleByCode = people.stream()
        							.collect(Collectors.groupingBy(Person::getCodeName));
        for(String key:peopleByCode.keySet()) {
        	System.out.println(key + " " + peopleByCode.get(key) );
        }
    }
}
