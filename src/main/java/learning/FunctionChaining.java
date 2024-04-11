package learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionChaining {
	
	
	
	public static void main(String[] args) {
		
		
		Function<String ,String> fun11=x->x.toUpperCase();
		Function<String ,String> fun21= y->y.substring(0, 3).toString();
		Function<String ,String> funChain=fun11.andThen(fun21);
		System.out.println(funChain.apply("umbrellaa"));
		
		
		Function<Integer, Integer> fun1=x->x*2;
		Function<Integer, Integer>fun2=x-> x*x*x ;
		Function<Integer, Integer>fun1_fun2=fun1.andThen(fun2);
		Function<Integer,Integer>fun2_fun1=fun2.andThen(fun1);
		Function<Integer ,Integer>compose=fun1.compose(fun2);
		
		System.out.println(fun1_fun2.apply(3));
		System.out.println(fun2_fun1.apply(3));
		System.out.println(compose.apply(3));
		
		
		Consumer<String> cosumexample=x->System.out.println(x);
		cosumexample.accept("mohit sharma");
		
		
		List<Integer> list111=new ArrayList();
		list111.add(1);
		list111.add(14);
		list111.add(12);
		list111.add(11);
		list111.add(120);
		Consumer<List<Integer>> cosumeList=e->{
			for(Integer i:e) {
				
				System.out.println("=========="+i+"  100");
			}
			
		};
		
		
		
		Consumer<List<Integer>> cosumelist11=e->{
			for(Integer i:e) {
				System.out.println(i);
			}
		};
		
	
		cosumeList.andThen(cosumelist11).accept(Arrays.asList(1,2,3,4,5,6));
		Supplier<Integer> supplier=()->1487400;
		System.out.println(supplier.get());
		
		
		Predicate<Integer> predicate=x->x%2==0;
        Function<Integer,Integer> function=x->x+3*x;
        Consumer<Integer> cosumerr=x->System.out.println("x==="+x);
		Supplier<Integer> supplierr= ()-> 1000;
		
		if(predicate.test(supplierr.get())) {
			
			cosumerr.accept(function.apply(supplierr.get()));
		}
		
		
		
	}
	
	


	
	
	
	

}
