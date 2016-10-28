//package org.elevenfifty.java301;
//
//import java.time.LocalDate;
//import java.util.Calendar;
//import java.util.Map;
//
//import org.elevenfifty.java301.beans.User;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.Bean;
//
//
//@SpringBootApplication
//
//public class ApplicationSpringBasic {
//
//	public static void main(String[] args) {
//
//		// SpringApplication.run(Application.class, args);
//
//		ConfigurableApplicationContext context = new SpringApplicationBuilder().sources(ApplicationSpringBasic.class).run(args);
//
//		Message msg = context.getBean(Message.class);
//		System.out.println(msg.message);
//
//		User u = context.getBean("instructor", User.class);
//		System.out.println(u.getFirstName());
//		
//		Map<String, User> users = context.getBeansOfType(User.class);
//		
//		users.values().forEach(u2 -> System.out.println(u2.getFirstName()));
//		
//		
//	}
//
//	@Bean
//	public User instructor() {
//		User u = new User();
//		u.setActive(true);
//		u.setBirthday(LocalDate.of(1983, 1, 31));
//		u.setFirstName("James");
//		u.setLastName("Keim");
//		u.setId(1);
//		u.setNickname("That one guy");
//		u.setTitle("Instructor");
//		u.setPhoneNumber("317.867.5309");
//		return u;
//	}
//
//	@Bean
//	public User student() {
//		User u = new User();
//		u.setActive(true);
//		u.setBirthday(LocalDate.of(1985, 9, 11));
//		u.setFirstName("Travis");
//		u.setLastName("Falls");
//		u.setId(2);
//		u.setNickname("Doesn't like nicknames");
//		u.setTitle("Student");
//		u.setPhoneNumber("574.210.9726");
//		return u;
//	}
//
//	@Bean
//	public Message getMessage() {
//		Message m = new Message();
//		m.message = "OVERRIDE";
//		return m;
//	}
//
//	public class Message {
//		private String message = "The message";
//
//		public String getMessage() {
//			return message;
//		}
//	}
//
//}
