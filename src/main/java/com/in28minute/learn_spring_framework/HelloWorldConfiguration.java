package com.in28minute.learn_spring_framework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
// Indicates that a class declares one or more @Bean methods andmay be processed by the Spring 
// 이 자바 문서는 클래스가 하나 이상의 Bean 메소드를 선언함을 나타낸다

// Spring이 사용자 지정 클래스의 객체를 관리하도록 할 수 있는지 확인
// record는 jdk16에서 추가된 기능. record를 쓰면 아래처럼 인수가 포함된 인물 생성자가 자동으로 생성된다.
record Person (String name, int age, Address address) {};
record Address (String firstLine, String city) {};

// 설정 클래스는 @Configuration으로 주석을 추가하여 설정할수있다
@Configuration
public class HelloWorldConfiguration {
	// 여기에 spring bean을 정의할 수 있다. ※spring bean이란? spring에서 관리하는것들
	// 설정클래서에서 메소드를 정의하여 spring bean을 생성할 수 있다.
	
	//메소드가 이 spring 컨테이너가 관리하는 bean을 생성함 // import org.springframework.context.annotation.Bean 
	@Bean
	public String name() {
		return "Ranga";
	}
	
	// 정수를 만드는 bean 생성
	@Bean
	public int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		return new Person("Ravi", 20, new Address("Main Street", "Utrecht")); 
	}
	
	//새로운 인물을 만들지만 이름은 이미 spring에서 관리하고있는 기존의 bean을 사용한다면?
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(),  address()); 
	}
	
	//bean 메소드를 직접 호출하지않고 파라미터(매개변수)로 호출하는방법
	@Bean
	public Person person3Parameters(String name, int age, Address address3) {
		return new Person(name, age,  address3); 
	}
	
	//일치하는 단일 Bean이 있어야하지만 address2와 address3 두개밖에없다.(Address로 정의된 Bean이 없으므로 에러난다)
	@Bean
	@Primary // 같은 이름의 Bean이 여러개일 때 프라이머리를 설정해주면 이게 기본값으로 출력된다.
	public Person person4Parameters(String name, int age, Address address) {
		return new Person(name, age,  address); 
	}	
	
	//@Qualifier : 한정자. 객체 외부에서 사용할 수 있다.
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) {
		return new Person(name, age,  address); 
	}	
			
	
	
	// bean의 이름을 커스터마이징도 가능하다
	@Bean(name = "address2")
	@Primary // 같은 이름의 Bean이 여러개일 때 프라이머리를 설정해주면 이게 기본값으로 출력된다.
	public Address address() {
		return new Address("Baker Street", "London");
	}
	
	@Bean(name = "address3")
	@Qualifier("address3qualifier") //@Qualifier : 한정자. 객체 외부에서 사용할 수 있다.
	public Address address3() {
		return new Address("Motinagar", "Hyderabad");
	}
}
