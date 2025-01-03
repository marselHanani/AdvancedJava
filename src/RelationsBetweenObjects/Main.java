package RelationsBetweenObjects;
import java.util.ArrayList;
import java.util.List;

interface Identifiable {String getId();}
class Human implements Identifiable{ // implementation
    protected String name;
    public Human() {  name = "marcel";}
    public String getId() {return "ID: " + name.hashCode();}
}
class Person extends Human { // inheritance relation
    Car car = new Car();// association
    List<Child> children = new ArrayList<>() ; // aggregation
    Address address = new Address("cairo"); // composition
    public Person() {super();name = "ahmad"; car.color = "black"; children.add(new Child("ahmad"));}
    void takeCourse(Course course) { course.price = 100; } // dependency
}
class Course { public double price;}
class Car { public String color; }
class Child { public String name; Child(String name) { this.name = name; } }
class Address { // without person class the Address class will be without meaning
    private String city;
    public Address(String city) {this.city = city;}
    public String getFullAddress() {return city;}
}
public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("Person's ID: " + person.getId());
        System.out.println("Address: " + person.address.getFullAddress());
    }
}
/*
* 1- Inheritance: Child class extends parent class to reuse the code and properties
? style of inheritance: ---------|>
# in the code : class Person extends Human
* 2- Dependency : a class depends on another class to work mean the dependent class can not work without the dependency class
? style of Dependency: - - - ->
# in the code : class Person { method(Human h){ System.out.println(h.name); } }
* 3- Association : a class has a relationship with another class (has field form other class) and is stronger than dependency
? style of Association: --------->
# in the code : class Person { Human h; }
* 4- Aggregation : is a kind of association it is used to represent one-to-many or many-to-many relationships we say
* class a has or contain many instances of class b
? style of Aggregation: <>------>
# in the code : class Department { List<Employee> employees; }
* 5- Composition : is same as Aggregation but the class b cant work without class a
? style of Composition: <+>------> (<> بكون مظلل)
# in the code : class University { field Department d; }
* 6- implementation : is like inheritance but you should write implementation in child class
? syle of implementation: - - - -|>
# in the code : class Person implements Human
 */
/*
 ?why code change?
!Better Understanding Through Action: Solving a problem often clarifies its complexities and allows for a deeper understanding.
!External Change: Uncontrollable changes, like the discontinuation of Flash support by browsers, force developers to adapt their code.
!Shifting Expectations: Clients' demands can evolve during a project, adding new features or changes not originally discussed.
 */