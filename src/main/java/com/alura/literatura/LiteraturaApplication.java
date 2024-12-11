package com.alura.literatura;
import com.alura.literatura.Principal.DriverLiteratura;
import com.alura.literatura.service.AuthorSerivece;
import com.alura.literatura.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LiteraturaApplication  implements CommandLineRunner {

	@Autowired
	BookService bookService;
	@Autowired
	AuthorSerivece authorSerivece;

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		DriverLiteratura driverLiteratura = new DriverLiteratura( bookService,authorSerivece);
		driverLiteratura.test();
	}
}
