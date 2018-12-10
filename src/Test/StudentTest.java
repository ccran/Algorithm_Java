package Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
  4
  100 90 A
  200 100 B
  300 90 C
  300 90 D
 */
public class StudentTest {
	public static boolean commit = false;
	
	public static class Student{
		public int score;
		public int id;
		public String name;
		
		public Student(int id, int score,String name) {
			super();
			this.score = score;
			this.id = id;
			this.name = name;
		}
		
		@Override
		public String toString() {
			return name+" "+id+" "+score;
		}
	}
	
	public static void main(String[] args) {
		InputStream is = null;
		try {
			if (commit) {
				is = System.in;
			} else {
				is = new FileInputStream("F:\\in.txt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(is);
		
		int n = scanner.nextInt();
		List<Student> studentList = new ArrayList<>();
		
		Map<Integer, Student> numStudentMap = new HashMap<>();
		for(int i=0;i<n;i++){
			int id = scanner.nextInt(),score = scanner.nextInt();
			String name = scanner.next();
			studentList.add(new Student(id,score,name));
			numStudentMap.put(i, new Student(id,score,name));
		}
		// 输出
				for (Student student : studentList) {
					System.out.println(student);
				}
				System.out.println("--------------------");
//		Collections.sort(studentList);
//		Collections.sort(studentList,new Comparator<Student>() {
//			//  100 90 A
//			//  200 100 B
//			@Override
//			public int compare(Student o1, Student o2) {
//				//                      A          B
//				//                      B          A
//				if(o1.score==o2.score){
//					return o2.id-o1.id;
//				}else{
//					return o2.score-o1.score;
//				}
//			}
//		});
//		// 输出
//		for (Student student : studentList) {
//			System.out.println(student);
//		}
		
		
		System.out.println("------------------");
		List<Map.Entry<Integer, Student>> kvEntryList = new ArrayList<>(numStudentMap.entrySet());
		Collections.sort(kvEntryList,new Comparator<Map.Entry<Integer, Student>>() {
			@Override
			public int compare(Entry<Integer, Student> o1, Entry<Integer, Student> o2) {
				if(o1.getValue().score==o2.getValue().score){
					if(o1.getValue().id == o2.getValue().id){
						return o2.getKey()-o1.getKey();
					}
					return o2.getValue().id-o1.getValue().id;
				}else{
					return o2.getValue().score-o1.getValue().score;
				}
			}
		});
		for(Map.Entry<Integer, Student> entry:kvEntryList){
			System.out.println(entry.getValue());
		}
	}
}
