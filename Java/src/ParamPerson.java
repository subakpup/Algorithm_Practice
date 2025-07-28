public class ParamPerson {
	String name;
	int age;
	boolean isHungry;
	
	ParamPerson(String n, int a, boolean i) {
		name = n;
		age = a;
		isHungry = i;
	}
	
	public static void main(String[] args) {
		ParamPerson person = new ParamPerson("함지수", 26, true);
		ParamPerson p2 = new ParamPerson();
	}
}