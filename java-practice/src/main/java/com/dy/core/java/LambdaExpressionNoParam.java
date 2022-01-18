package com.dy.core.java;

import java.util.*;

@FunctionalInterface
interface MyFunctionalInterface {

	// A method with no parameter
	public String sayHello();
}


@FunctionalInterface
interface SecondFunctionalInterface {

	//A method with single parameter
    public int incrementByFive(int a);
}

public class LambdaExpressionNoParam {

	public static void main(String args[]) {
		// lambda expression
		MyFunctionalInterface msg = () -> {
			return "Hello";
		};
		System.out.println(msg.sayHello());
		
		
		// lambda expression with single parameter num
		SecondFunctionalInterface f = (num) -> num+5;
        System.out.println(f.incrementByFive(22));
        
        
        List<String> list=new ArrayList<String>();  
        list.add("Rick");         
        list.add("Negan");       
        list.add("Daryl");         
        list.add("Glenn");         
        list.add("Carl");                
        list.forEach(          
            // lambda expression        
            (names)->System.out.println(names)         
        );     
	}
}
