package homework_student;

import java.util.Scanner;

public class College {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//zadavam minimuma za stipendia
		System.out.print("Enter the minimum grade for scholarship:");
		double min = sc.nextDouble();
		System.out.println();
		
		//suzdavam obektite
		Student spas = new Student("Spas", "Java", 24);
		Student georgi = new Student("Georgi", "PHP", 34);
		Student todor = new Student("Todor", "Java", 29);
		Student maya = new Student("Maya", "PHP", 24);
		Student vladimir = new Student("Vladimir", "Java", 30);
		Student vasil = new Student("Vasil", "Java", 22);
		Student daniela = new Student("Daniela", "Java", 24);
		Student yanko = new Student("Yanko", "PHP", 24);
		Student evdokia = new Student("Evdokia", "PHP", 24);
		Student dimitur = new Student("Dimitur", "PHP", 24);
		Student snejana = new Student("Snejana", "Java", 24);
		
		StudentGroup java = new StudentGroup("Java");
		
		//zadavam dopulnitelno promenlivi na obektite i gi im prilagam suotvetnite metodi
		spas.yearInCollege = 2;
		spas.grade = 5.1;
		spas.isDegree = false;
		spas.money = 0;
		spas.receiveScholarship(min, 360);
		spas.upYear();
		
		maya.yearInCollege = 3;
		maya.grade = 4.7;
		maya.isDegree = false;
		maya.money = 360;
		maya.receiveScholarship(min, 360);
		maya.upYear();
		
		evdokia.yearInCollege = 3;
		evdokia.grade = 6;
		evdokia.isDegree = false;
		evdokia.money = 360;
		evdokia.receiveScholarship(min, 360);
		evdokia.upYear();
		
		dimitur.yearInCollege = 4;
		dimitur.grade = 6;
		dimitur.isDegree = true;
		dimitur.money = 720;
		dimitur.receiveScholarship(min, 360);
		dimitur.upYear();
		
		snejana.yearInCollege = 4;
		snejana.grade = 4.5;
		snejana.isDegree = true;
		snejana.money = 360;
		snejana.receiveScholarship(min, 360);
		snejana.upYear();
		
		georgi.yearInCollege = 2;
		georgi.grade = 3.2;
		georgi.isDegree = false;
		georgi.money = 0;
		georgi.receiveScholarship(min, 360);
		georgi.upYear();
		
		todor.yearInCollege = 3;
		todor.grade = 5.3;
		todor.isDegree = false;
		todor.money = 0;
		todor.receiveScholarship(min, 360);
		todor.upYear();
		
		vladimir.yearInCollege = 3;
		vladimir.grade = 6;
		vladimir.isDegree = false;
		vladimir.money = 360;
		vladimir.receiveScholarship(min, 360);
		vladimir.upYear();
		
		vasil.yearInCollege = 1;
		vasil.grade = 3.7;
		vasil.isDegree = false;
		vasil.money = 0;
		vasil.receiveScholarship(min, 360);
		vasil.upYear();
		
		daniela.yearInCollege = 2;
		daniela.grade = 5.0;
		daniela.isDegree = false;
		daniela.money = 0;
		daniela.receiveScholarship(min, 360);
		daniela.upYear();
		
		yanko.yearInCollege = 2;
		yanko.grade = 4.6;
		yanko.isDegree = false;
		yanko.money = 0;
		yanko.receiveScholarship(min, 360);
		yanko.upYear();
		
		//proverqvam kakvi promeni sa se poluchili sled metodite
		System.out.println(spas.name);
		System.out.println(spas.isDegree);
		System.out.println(spas.money + "\n");
		
		System.out.println(vladimir.name);
		System.out.println(vladimir.isDegree);
		System.out.println(vladimir.money + "\n");
		
		System.out.println(todor.name);
		System.out.println(todor.isDegree);
		System.out.println(todor.money + "\n");
		
		System.out.println(georgi.name);
		System.out.println(georgi.isDegree);
		System.out.println(georgi.money + "\n");
		
		System.out.println(yanko.name);
		System.out.println(yanko.isDegree);
		System.out.println(yanko.money + "\n");
		
		System.out.println(maya.name);
		System.out.println(maya.isDegree);
		System.out.println(maya.money + "\n");
		
		System.out.println(vasil.name);
		System.out.println(vasil.isDegree);
		System.out.println(vasil.money + "\n");
		
		System.out.println(daniela.name);
		System.out.println(daniela.isDegree);
		System.out.println(daniela.money + "\n");
		
		System.out.println(snejana.name);
		System.out.println(snejana.isDegree);
		System.out.println(snejana.money + "\n");
		
		System.out.println(dimitur.name);
		System.out.println(dimitur.isDegree);
		System.out.println(dimitur.money + "\n");
		
		System.out.println(evdokia.name);
		System.out.println(evdokia.isDegree);
		System.out.println(evdokia.money + "\n");
		
		//pulnq grupata s ime java
		java.addStudent(spas);
		java.addStudent(georgi);
		java.addStudent(yanko);
		java.addStudent(todor);
		java.addStudent(snejana);
		java.addStudent(vasil);
		java.addStudent(daniela);
		java.addStudent(evdokia);
		java.addStudent(maya);
		java.addStudent(vladimir);
		java.addStudent(dimitur);
		
		
		java.printStudentsInGroup();
		java.bestStudent();
		
		//izprazvam grupata
		java.emptyGroup();
		//pulnq q nanovo za proverka dali vzima pravilno
		java.addStudent(spas);
		java.addStudent(georgi);
		java.addStudent(yanko);
		java.addStudent(todor);
		java.addStudent(vladimir);
		java.addStudent(daniela);
		java.addStudent(evdokia);
		java.addStudent(maya);
		java.addStudent(snejana);
		java.addStudent(dimitur);
		java.addStudent(vasil);
		
		java.printStudentsInGroup();
		java.bestStudent();
		
		//suzdavam nova grupa php i q pulnq
		StudentGroup php = new StudentGroup("PHP");
		
		php.addStudent(spas);
		php.addStudent(georgi);
		php.addStudent(yanko);
		php.addStudent(todor);
		php.addStudent(vladimir);
		php.addStudent(vasil);
		php.addStudent(daniela);
		php.addStudent(evdokia);
		php.addStudent(maya);
		php.addStudent(snejana);
		php.addStudent(dimitur);
		
		php.printStudentsInGroup();
		php.bestStudent();
		
	}

}
