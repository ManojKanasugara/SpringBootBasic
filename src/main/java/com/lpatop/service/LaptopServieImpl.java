package com.lpatop.service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lpatop.model.Laptop;
import com.lpatop.repository.LaptopRepo;

@Service
public class LaptopServieImpl implements LaptopService {
	private final LaptopRepo laptopRepo;

	public LaptopServieImpl(LaptopRepo laptopRepo) {
		this.laptopRepo = laptopRepo;
	}

	@Override
	public List<Laptop> getLaptopByProcessor(String processor) {
		// TODO Auto-generated method stub
		return laptopRepo.findByProcessor(processor);
	}

	@Override
	public List<Laptop> getLaptopByProcessorAndRam(String processor, int ram) {
		System.out.println("inside service");
		List<Laptop> l = laptopRepo.findByProcessorAndRam(processor, ram);

		Map<Integer, Laptop> e = l.stream().collect(Collectors.toMap(x -> x.getRam(), Function.identity()));
		// .forEach(x -> System.out.println(x.getKey() + "--" +
		// x.getValue().getProcessor()));
//e.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).
//collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2)->e2,LinkedHashMap::new));

		e.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		return l;
	}

}
