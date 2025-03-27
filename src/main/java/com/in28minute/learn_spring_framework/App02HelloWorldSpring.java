package com.in28minute.learn_spring_framework;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		// jvm이 spring을 실행하고 spring은 bean을 관리하도록함(예를 들어 name이라는 객체를 관리하도록함)
		// 1. Launch a Spring Context (설정클래스(@Configuration)를 사용하여 스프링 context를 시작할 수 있다.)
		
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		
		
		// 2. Configure the things that we want Spring to manage/스프링 프레임워크가 관리하도록 할 것을 설정한다.
		// context를 사용해 객체를 가져온다.HelloWorldConfiguration의 클래스에서 spring에서 관리하는 이름객체를 이미 생성해놓았음.
		// spring 컨텍스트 객체에 이름을 부여하도록함. Spring에서 관리하는것은 무엇이든 Bean이 될 수 있다. 
		
		// 3. Retrieving Beans managed by Spring (스프링에 의해 관리되는 Beans 검색)
		// 컨텍스트가 getBean이고 컨텍스트에서 값을 가져올수 있는 방법은 많다. 그중에 이름을 사용하는법
		// 여기서 부여한 이름은 name이다(HelloWorldConfiguration 클래스의 메소드 이름)
		System.out.println(context.getBean("name"));
		
		// 추가로 작성하는 bean 메소드들을 불러올 수 있다
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));
		 
		// 새로운 인물을 이미 spring에서 관리하고있는 기존의 bean을 사용할 경우
		System.out.println(context.getBean("person2MethodCall"));
		
		// bean 메소드를 직접 호출하지않고 파라미터(매개변수)로 호출하는방법
		System.out.println(context.getBean("person3Parameters"));
		
		// bean의 이름을 address2로 커스터마이징 했기때문에 address로 출력하면 컴파일오류가 뜬다
		//System.out.println(context.getBean("address"));
		System.out.println(context.getBean("address2"));
		
		// 유형도 매개 변수로 사용할 수 있다./ context.getBean대신 클래스를 전달 가능./ Address.class 유형의 주소로 bean을 가져옴.
		// expected single matching bean but found 2: address2,address3 / 컴파일 시 1개의 address를 기대하지만 address2, address3이 있기때문에 에러가나게됨
		// System.out.println(context.getBean(Address.class));
		
		// Q1 스프링 컨테이너, 스프링 컨텍스트, IOC컨테이너, 어플리케이션 컨텍스트 란 무엇인가?
		//   -스프링컨테이너 = 스프링 컨텍스트 or IOC컨테이너(IOC란 제어의 역전). 스프링 컨테이너는 스프링빈과 수명주기를 관리한다. 이는 클래스와 인풋을가지고 실행되는 시스템을 만드는것을 의미
		//   -에플리케이션 컨텍스트는 웹어플리케이션, 웹서비스, Rest API, 마이크로서비스에 사용
		
		// Q2 Java Bean vs Spring Bean
		// POJO vs Java Bean vs Spring Bean 
		// POJO : 일반적인 오래된 Java객체. 제약 없음. 모든 자바객체는 POJO이다.
		// Java Bean : 세 가지 제약을 준수하는 클래스
		//  1. public no-arg constructor (public javaBean(){} ※아무것도 없는 생성자)
		//  2. getter, setter 필요
		//  3. Serializable
		// Spring Bean : Spring이 관리하는 모든 Java 객체 
		
		// Q3 스프링 프레임워크가 관리하는 Bean을 모두 나열하려면 어떻게해야되나
		// Spring Bean을 나열하려면 Context를 요청해야한다. context.getBeanDefinitionNames()를 사용하면 이 레지스트리에 정의된 모든 이름을 반환한다.
		// context.getBeanDefinitionCount()는 레지스트리에 정의된 Bean 개수를 반환한다. context.getBeanDefinition()은 Bean의 이름을 매개변수로 구문 분석할수도 있다.
		// getBeanDefinitionNames을 반복하고 모든것을 출력하는법
		Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
		
		// Q4 여러개의 Bean을 사용할 수 있으면 어떻게 될까?
		// 일치하는 후보가 여러개인 시나리오에서는 예외가 출력된다/
		// 이 문제를 수정하는 방법은 이 중 하나를 기본으로 만드는것이다. @Primary
		System.out.println(context.getBean(Person.class));
		// 다른 한가지는 Bean을 한정자로 만드는것이다 @Qualifier("address3qualifier")
		System.out.println(context.getBean("person5Qualifier"));
		
		// Q5 스프링은 객체를 관리하고 자동 연결도 수행한다. -코드를 작성해 객체를 만드는건 누구냐? -스프링이 객체를 만들게하면안되나?
		
		
	}

}
