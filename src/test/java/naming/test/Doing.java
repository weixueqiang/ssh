package naming.test;

public class Doing {

	Session session;
	
	public Doing() {
		session=new Session();
	}
	
	
	public void test(Excuter excuter) {
		System.out.println("...1");
		excuter.doExcuter(session);
		System.out.println("ok");
	}
	
	public static void main(String[] args) {
		new Doing().test(new Excuter() {
			@Override
			public void doExcuter(Session session) {
				session.say("i`m session....");
			}
		});
	}
	
}
