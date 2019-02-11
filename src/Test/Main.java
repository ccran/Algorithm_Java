package Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		String[] res = "hello.world".split("\\.");
		Set<String> wordSet = new HashSet<>(Arrays.asList("hello hello world".split(" ")));
		System.out.println(res);
	}

}
