package br.com.okidoi.converter;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerConverter {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <O, D> D parseObject(O origin, Class<D> destination){
		
		return mapper.map(origin, destination);
	}

	public static <O, D> List<D> parseListObjects(List<O> originList, Class<D> destination){
		
		List<D> destinationObjets = new ArrayList<D>();
		for (O o : originList) {
			destinationObjets.add(mapper.map(o, destination));
			
		}
		
		return destinationObjets;
	}
	
}
