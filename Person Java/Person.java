/////////////////////////////////////////////////////////////////////////////////
// Angel G. Romero Rosario
// 801-18-2064
// This program asks the user the names and age of the persons it wants to create a database
// It later prints out all the persons in a orderly fashion
// Person class
////////////////////////////////////////////////////////////////////////////////


public class Person
{
	// instance data
	protected String name;
	protected int age = 21;
	private static int drivingAge = 16;
	private static int num = 0;

	//constructors
	public Person(String name)
	{
		this.name = name;
		num++;
	}
	public Person(String name, int age){
		this(name);
		this.age = age;
	}

	//accessor and mutators
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	
		/* static accessor methods
		The this reference does not
		exist in static methods
	*/
	public static int getDrivingAge(){
		return drivingAge;
	}
	public static int getNum(){
		return num;
	}
	//overridden methods inherited from Object
	public String toString(){
		return "Person" + name;
	}

	public boolean equals(Object o){
		if( o == null)
			return false;
		if( getClass() != o.getClass())
			return false;
		Person p = (Person)o;
		return this.age == p.age;
	}
	
}
