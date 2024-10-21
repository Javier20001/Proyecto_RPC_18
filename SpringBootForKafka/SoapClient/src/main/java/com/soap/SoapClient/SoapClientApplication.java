package com.soap.SoapClient;

import com.example.consumingwebservice.wsdl.GetCountryResponse;
import com.soap.SoapClient.services.CountryClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.client.core.WebServiceTemplate;

@SpringBootApplication
public class SoapClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapClientApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(CountryClient countryClient) {
		return args -> {
			String country = "Spain";

			if (args.length > 0) {
				country = args[0];
			}
			GetCountryResponse response = countryClient.getCountry(country);
			System.err.println(response.getCountry().getCurrency());
		};
	}

}
