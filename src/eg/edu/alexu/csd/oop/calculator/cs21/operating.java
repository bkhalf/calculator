package eg.edu.alexu.csd.oop.calculator.cs21;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class operating implements Calculator {
	
	private boolean valid=true;
	private char sign='&';
	private double num1,num2;
	int nn;
	String []steps=new String[5];
	String []anss=new String[5];
	public String ansNum;
	int index=0;
	int get=0;
	boolean isFirst=true;
	
	@Override
	public void input(String s) {
		// TODO Auto-generated method stub
		sign='&';
		nn=0;
		valid=true;
		int n=0;
		int t=-1;
		if(s.contains("-")) {
			System.out.println("in --");
			ArrayList<Character> ts=new ArrayList<Character>();
			ArrayList<Integer> tn=new ArrayList<Integer>();
			for(int i=0;i<s.length();i++) {
				char temp=s.charAt(i);
				if(temp=='+'||temp=='*'||temp=='/'||temp=='-') {
					n++;
					ts.add(temp);
					tn.add(i);
					if(n>3||i==s.length()-1) {
						valid=false;
						return;
					}
				}	
			}
			if(n==1) {
				if(tn.get(0)==0) {
					nn=1;
					t=-1;
					sign=ts.get(0);
				}else {
					t=tn.get(0);
					sign=ts.get(0);
				}
			}else if(n==2) {
				if(tn.get(0)==0&&(tn.get(0)!=(tn.get(1)-1))) {
					t=tn.get(1);
					sign=ts.get(1);
					}
				else if((tn.get(0)==tn.get(1)-1)&&ts.get(1)=='-'&&tn.get(0)!=0) {
					t=tn.get(0);
					sign=ts.get(0);
				}
				else {valid=false;return;}
			}else if(n==3) {
				if(tn.get(0)==0&&(tn.get(1)==tn.get(2)-1&&ts.get(2)=='-')) {
					t=tn.get(1);
					sign=ts.get(1);
					}
				else {
					valid=false;return;
				}
			}
			
		}else {
			for(int i=0;i<s.length();i++) {
				char temp=s.charAt(i);
				if(temp=='+'||temp=='*'||temp=='/') {
					n++;
					sign=temp;
					t=i;
					if(n>1||i==s.length()-1) {
						valid=false;
						return;
					}
				}	
			}
			
		}
		if(t==-1) {
			try {
				num1=Double.parseDouble(s);
			}catch(Exception e) {
				valid=false;
				return;
			}
			nn=1;
			
		}else {
			nn=2;
			try {
				num1=Double.parseDouble(s.substring(0, t));
				num2=Double.parseDouble(s.substring(t+1, s.length()));
			}catch(Exception e){
				valid=false;
				return;
			}
			
		}
		//storing the previous input in the array
		if(!(sign=='/'&&num2==0)) {
			if(steps[4]==null) {
				steps[index]=s;
				index++;
			}else {
				for(int i=0;i<4;i++) {
					steps[i]=steps[i+1];
				}
				steps[4]=s;
			}
			get=index;
			isFirst=true;
		}
		
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		double ans=0;
		if(!valid) {
			return "Error: invalid expression";
		}
		if(nn==1) {
			if(anss[4]==null) {
				anss[index-1]=""+num1;
			}else {
				for(int i=0;i<4;i++) {
					anss[i]=anss[i+1];
				}
				anss[4]=""+num1;
			}
			return ""+num1;
		}
		else if(nn==2) {
			if(sign=='+')ans=num1+num2;
			else if(sign=='*')ans=num1*num2;
			else if(sign=='-')ans=num1-num2;
			else if(sign=='/') {
				if(num2==0) {
					return"Error: can't divide by zero";
				}else ans=num1/num2;
			}
			if(anss[4]==null) {
				anss[index-1]=""+ans;
			}else {
				for(int i=0;i<4;i++) {
					anss[i]=anss[i+1];
				}
				anss[4]=""+ans;
			}
			for(int i=0;i<5;i++) {
				System.out.println(steps[i]+"______"+anss[i]);
			}
			return ""+ans;
		}
		return null;
	}

	@Override
	public String current() {
		for(int i=4;i>=0;i--) {
			if(steps[i]!=null) {
				ansNum=anss[i];
				get=i;
				isFirst=false;
				return steps[i];
			}
		}
		return "Error: you didn't insert antthing";
	}

	@Override
	public String prev() {
			if(get==0)return "Error: No Prev";
			if(isFirst) {
				if(get==1)return "Error: No Prev";
				isFirst=false;
				get-=2;
				ansNum=anss[get];
				return steps[get];
			}
			get--;
			ansNum=anss[get];
		return steps[get];
	}

	@Override
	public String next() {
		if(get==4)return "Error: No Next";
		if(steps[get+1]==null)return "Error: No Next";
			get++;
			ansNum=anss[get];
		return steps[get];
	}

	@Override
	public void save() {
		
		try {
			FileWriter fw=new FileWriter("calcu.txt");
			for(int i=0;i<5;i++) {
				if(steps[i]!=null) {
					fw.write(steps[i]);
					if((i+1)!=5) {
						fw.write("\n");
					}
				}
			}
			fw.close();
			System.out.println("we wrote in the file");
		}catch(IOException e) {
			System.out.println("there is something wrong");
		}
		
		
		
	}

	@Override
	public void load() {
		for(int i=0;i<5;i++) {
			steps[i]=null;
			anss[i]=null;
		}
		index=0;
		get=0;
		isFirst=true;
		
		try {
			File file=new File("calcu.txt");
			Scanner read=new Scanner(file);
			while(read.hasNextLine()) {
				String data=read.nextLine();
				input(data);
				getResult();
			}
			read.close();
			System.out.println("we load it");
		}catch(IOException e) {
			System.out.println("there is something wrong");
		}
		
	}

	
}
