import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments

		if(args.length != 1){
			System.out.println("\n usage : a | r | c +student | ? student \n");

		}

		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader buffereReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String line = buffereReader.readLine();
			String Names[] = line.split(",");			
			for(String name : Names) { System.out.println(name.trim()); }
			} catch (Exception e){} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader buffereReader  = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String line = buffereReader.readLine();
			System.out.println(line);
			String Names[] = line.split(" ,");	
			Random random = new Random();
				int randomNumber = random.nextInt(4);
					System.out.println(Names[randomNumber].trim());
			} catch (Exception e){

			} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains(" + ")){
			System.out.println("Loading data ...");			
			try {
			BufferedWriter buffereReader = new BufferedWriter(
					new FileWriter("students.txt", true));
			String newStudents = args[0].substring(1);
	        Date date = new Date();
	        String dateTimeFormat = "dd/MM/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(dateTimeFormat);
	        String dateTody= dateFormat.format(date);
			buffereReader.write(", "+newStudents+"\nList last updated on "+dateTody);
			buffereReader.close();
			} catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains(" ? ")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader buffereReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String line = buffereReader.readLine();
			String Names[] =line.split(" , ");	
			boolean done = false;
			String student = args[0].substring(1);
			for(int index = 0; index<Names.length && !done; index++)
			 {
				if(Names[index].equals(student))
				 {
					System.out.println("We found it!");
						done=true;
				}
			}
			} catch (Exception e){ 

			} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains(" c ")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String D = bufferedReader.readLine();
			char chr[] = D.toCharArray();			
			boolean in_word = false;
			int count=0;
			for(char ch:chr) {
				if(ch ==' ') 
				{
					if (!in_word) {	count++; in_word =true;	}
					else { in_word=false;}			
				}
			}
			System.out.println(count +" word(s) found " + chr.length);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
	}
}