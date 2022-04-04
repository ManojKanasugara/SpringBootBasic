package com.lpatop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lpatop.controller.CustomerController;
import com.lpatop.controller.EmployeeController;
import com.lpatop.model.Address;
import com.lpatop.model.Customer;
import com.lpatop.model.Employee;
import com.lpatop.model.Laptop;
import com.lpatop.model.StorageType;
import com.lpatop.repository.AddressRepository;
import com.lpatop.repository.CustomerRepository;
import com.lpatop.repository.EmployeeRepo;
import com.lpatop.repository.LaptopRepo;
import com.lpatop.repository.StorageTypeRepo;
import com.lpatop.service.AddressServiceImpl;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private LaptopRepo laptopRepo;
	@Autowired
	private StorageTypeRepo storageTypeRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private CustomerController customerController;

	@Autowired
	private AddressRepository addressRepo;

	@Autowired
	private AddressServiceImpl addressServiceImpl;

	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private EmployeeController empController;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		int a = 11;
		int b = 5;
		int c = 7;

		int aa[] = new int[3];
		aa[0] = a;
		aa[1] = b;
		aa[2] = c;

		Arrays.sort(aa);
		int add = ((aa[1] * aa[1]) + (aa[0] * aa[0])) - ((aa[2] * aa[2]) + (aa[1] * aa[1]));
		System.out.println(add < 0 ? add * -1 : add);
//*****************************************************************
		// Adding storage type and laptops
		
		int aa1=3077;
		String bb=Character.toString((char)aa1);
		System.out.println(bb);
		
		StorageType ssd512 = new StorageType("ssd", 512);
		StorageType hdd = new StorageType("hdd", 1024);
		StorageType ssd256 = new StorageType("ssd", 256);
		storageTypeRepo.save(ssd512);
		storageTypeRepo.save(hdd);
		storageTypeRepo.save(ssd256);
		List<StorageType> storageList = new ArrayList<>();
		storageList.add(ssd512);
		//storageList.add(hdd);
		storageList.add(ssd256);
		boolean storage = storageList.stream().map(x -> x.getStorageType()).distinct().count() > 1 ? true : false;
		System.out.println("unique " + storage);
System.out.println(storageList.stream().map(x -> x.getStorageType()).distinct().count());
		Laptop dellI5 = new Laptop("Di5", "i5", 8);
		dellI5.getStorageType().add(ssd512);

		Laptop dellI7 = new Laptop("Di7", "i7", 16);
		dellI7.getStorageType().add(ssd256);

		Laptop dellI3 = new Laptop("Di3", "i3", 4);
		dellI3.getStorageType().add(hdd);
		Laptop dellI5Hybrid = new Laptop("Di7", "i7", 16);
		dellI5Hybrid.getStorageType().add(ssd256);
		dellI5Hybrid.getStorageType().add(hdd);

		laptopRepo.save(dellI5);
		laptopRepo.save(dellI7);
		laptopRepo.save(dellI3);
		laptopRepo.save(dellI5Hybrid);

//*************************************************************************
		// Adding Address and customer
		Customer customer = new Customer("Manoj", "Kanasugara", "manojkanasugara06@gmail.com", "7676545212");
		customerController.save(customer);
		Address primaryAddress = new Address("India", "Karnataka", "Bidar", "Bidar", "Bidar", 585421, "near temple");
		primaryAddress.setCustomer(customer);
		Address secondaryAddress = new Address("India", "Karnataka", "Bidar", "Bidar", "Manhalli", 585403,
				"near river");
		secondaryAddress.setCustomer(customer);
		Address officeAddress = new Address("India", "Karnataka", "Bengalur", "Bengaluru", "Namma Bengaluru", 560067,
				"near college");
		officeAddress.setCustomer(customer);

		customer.getAddressList().add(primaryAddress);
		customer.getAddressList().add(secondaryAddress);
		customer.getAddressList().add(officeAddress);
		customerRepo.save(customer);

		addressRepo.save(primaryAddress);
		addressRepo.save(secondaryAddress);
		addressRepo.save(officeAddress);
		// addressServiceImpl.getMaxNumber();
		Employee e = new Employee("1", "asd");
		Employee e1 = new Employee("", null);
		Employee e2 = new Employee("12", "zss");
		Employee e3 = new Employee("21", "qwerty");
		Employee e4 = new Employee("41.00", "lkj");
		Employee e5 = new Employee("15", "zxc");
		Employee e6 = new Employee("18", "mnb");
		empRepo.save(e);
		empRepo.save(e1);
		empRepo.save(e2);
		empRepo.save(e3);
		empRepo.save(e4);
		empRepo.save(e5);
		empRepo.save(e6);
		empController.getMaxNumber();
	}

}
