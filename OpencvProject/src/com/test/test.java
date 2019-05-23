package com.test;

public class test {
	static A obj3=new A(15);
	A obj1=new A(5);
	static void fx(){
		A obj2=new A(10);
		//System.out.println(obj1);
	}
public static void main(String[] args) {
	System.out.println("begain");
	A obj4=new A(20);
	fx();
	System.out.println("done");
}
}
