package exception;

import java.io.IOException;

public class MyClass {

	void danger() throws IOException {
		System.out.println("some codes1");
		System.out.println("some codes2");

		if (10 - 10 == 0) {
			throw new IOException();
		}

		System.out.println("some codes3");
		System.out.println("some codes4");
	}
}
