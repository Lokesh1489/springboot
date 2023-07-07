package greeting;

import org.springframework.stereotype.Component;

@Component
public class Greet {

	public void greet() {
		System.out.println("Hi I am a bean class");
	}
}
