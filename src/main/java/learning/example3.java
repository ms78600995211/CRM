package learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class example3 {
	
	 public static void main(String[] args) {

	        List list = Arrays.asList("MOHIT1", "RAVI", "NAMAN", "SANAY");

	        /*
	        Function<List, List> fun1 = li -> {
	            for (int i = 0; i < li.size(); i++) {
	                list2.add(li.get(i));
	            }
	            return list2;
	        };
	        System.out.println("fun1=========" + fun1.apply(list));
	        
	        */
	        
	        Function<List, Object> fun2 = li -> {
	            
	        	Object	list2= li.stream().map(e->e.toString().concat("44")).collect(Collectors.toList());
	        	
	            return list2;
	        };
	        
	        
	        System.out.println(fun2.apply(list));
	        
	        
	        
	        
	        
	        
	        
	    }

}
