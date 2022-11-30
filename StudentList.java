import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments

		if(args.length != 1){
			System.out.println(Constants.INPUT_ERROR_MESSAFE);

		}

		if(args[0].equals(Constants.SHOW_ALL)) {
			System.out.println((Constants.DATA_LOADED));			
			try {
			BufferedReader buffereReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constants.FILE_NAME))); 
			String line = buffereReader.readLine();
			String Names[] = line.split(",");			
			for(String name : Names) { System.out.println(name.trim()); }
			} catch (Exception e){} 
			System.out.println(Constants.DATA_LOADED);
		}
		else if(args[0].equals(Constants.RANDOM_NUMBER)) 
		{
			System.out.println(Constants.LOAD_DATA);			
			try {
			BufferedReader buffereReader  = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constants.FILE_NAME))); 
			String line = buffereReader.readLine();
			System.out.println(line);
			String Names[] = line.split(Constants.COMMA);	
			Random random = new Random();
				int randomNumber = random.nextInt(4);
					System.out.println(Names[randomNumber].trim());
			} catch (Exception e){

			} 
			System.out.println(Constants.DATA_LOADED);			
		}
		else if(args[0].contains(" + ")){
			System.out.println(Constants.LOAD_DATA);			
			try {
			BufferedWriter buffereReader = new BufferedWriter(
					new FileWriter(Constants.FILE_NAME , true));
			String newStudents = args[0].substring(1);
	        Date date = new Date();
	        String dateTimeFormat = Constants.DATE_TIME_FORMAT;
	        DateFormat dateFormat = new SimpleDateFormat(dateTimeFormat);
	        String dateTody= dateFormat.format(date);
			buffereReader.write(", "+newStudents+"\nList last updated on "+dateTody);
			buffereReader.close();
			} catch (Exception e){}
							
			System.out.println(Constants.DATA_LOADED);	
		}
		else if(args[0].contains(Constants.FIND_NAME)) 
		{
			System.out.println(Constants.DATA_LOADED);			
			try {
			BufferedReader buffereReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constants.FILE_NAME))); 
			String line = buffereReader.readLine();
			String Names[] =line.split(Constants.COMMA);	
			boolean done = false;
			String student = args[0].substring(1);
			for(int index = 0; index<Names.length && !done; index++)
			 {
				if(Names[index].equals(student))
				 {
					System.out.println(Constants.FOUND_MESSAGE);
						done=true;
				}
			}
			} catch (Exception e){ 

			} 
			System.out.println(Constants.DATA_LOADED);				
		}
		else if(args[0].contains(Constants.COUNT_STUDENT)) 
		{
			System.out.println(Constants.LOAD_DATA);			
			try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constants.FILE_NAME))); 
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
			System.out.println(count +Constants.FOUND_MESSAGE+ chr.length);
			} catch (Exception e){} 
			System.out.println(Constants.DATA_LOADED);				
		}
	}
}