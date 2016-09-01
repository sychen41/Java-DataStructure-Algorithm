import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.Comparator;
import java.util.function.Predicate;
import java.lang.Iterable;
import java.time.chrono.IsoChronology;

public class RosterTest {
	interface CheckPerson {
		boolean test(Person p);
	}
	
	public static void printPersonsOlderThan(List<Person> roster, int age) {
		for (Person p: roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}
	
	public static void printPersonWithinAgeRange(List<Person> roster, int low, int high) {
		for (Person p: roster) {
			if (low <= p.getAge() && p.getAge() <= high) {
				p.printPerson();
			}
		}
	}
	
	public static void printPersons(
		List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	public static void printPersonsWithPredicate(
		    List<Person> roster, Predicate<Person> tester) {
		    for (Person p : roster) {
		        if (tester.test(p)) {
		            p.printPerson();
		        }
		    }
		}	

	public static void processPerson(
		List<Person> roster, 
		Predicate<Person> tester,
		Consumer<Person> block) {
		for (Person p: roster) {
			if (tester.test(p)) {
				block.accept(p);;
			}
		}
	}
	
	public static void processPersonWithFunction(
		List<Person> roster, 
		Predicate<Person> tester,
		Function<Person, String> mapper,
		Consumer<String> block) {
		for (Person p: roster) {
			if (tester.test(p)) {
				String data = mapper.apply(p);
				block.accept(data);;
			}
		}
	}
	
	public static<X, Y> void processElement(
		Iterable<X> source,
		Predicate<X> tester,
		Function<X, Y> mapper,
		Consumer<Y> block) {
		for (X x: source) {
			if (tester.test(x)) {
				Y y = mapper.apply(x);
				block.accept(y);
			}
		}
	}
	
	public static void main(String[] args) {
		List<Person> roster = Person.createRoster();
		//RosterTest.printPersonsOlderThan(roster, 10);
		//RosterTest.printPersonWithinAgeRange(roster, 15, 25);
		class CheckPersonEligibleForService implements CheckPerson {
			@Override
			public boolean test(Person p) {
				return p.getGender() == Person.Sex.MALE 
						&& p.getAge() >= 15
						&& p.getAge() <= 25;
			}
		}
		//RosterTest.printPersons(roster, new CheckPersonEligibleForService());

		/*RosterTest.printPersons(roster, new CheckPerson() {

			@Override
			public boolean test(Person p) {
				return p.getGender() == Person.Sex.MALE 
						&& p.getAge() >= 15
						&& p.getAge() <= 25;
			}
			
		});*/
		
		/*RosterTest.printPersons(
			roster, 
			(Person p) -> p.getGender() == Person.Sex.MALE 
						&& p.getAge() >= 15
						&& p.getAge() <= 25
		);*/
		
	/*	RosterTest.printPersonsWithPredicate(roster, 
			p -> p.getGender() == Person.Sex.MALE 
						&& p.getAge() >= 15
						&& p.getAge() <= 25
				);*/
	/*	RosterTest.processPerson(
			roster,
			p -> p.getGender() == Person.Sex.MALE 
						&& p.getAge() >= 15
						&& p.getAge() <= 25,
			p -> p.printPerson()
			);*/
	/*	RosterTest.processPersonWithFunction(roster,
			p -> p.getGender() == Person.Sex.MALE 
						&& p.getAge() >= 15
						&& p.getAge() <= 25,
			p -> p.getEmailAddress(),
			eMail -> System.out.println(eMail)
			);*/
		RosterTest.processElement(roster,
			p -> p.getGender() == Person.Sex.MALE,
			//p -> p.getGender() == Person.Sex.MALE 
			//			&& p.getAge() >= 15
			//			&& p.getAge() <= 25,
			(Person p) -> p.getEmailAddress(),
			(String eMail) -> System.out.println(eMail)
			);
	}
}
