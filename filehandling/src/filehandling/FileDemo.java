package filehandling;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileDemo {
	public static void main(String[] args) throws IOException{
		//File f = new File("C:\\Users\\suhan\\Documents\\demo.java");
		List<Integer> l = findString("C:\\\\Users\\\\suhan\\\\Documents\\\\demo.java", "file");
		
		for(Integer lString : l) {
			System.out.println(lString);
		}
		/**File f2 = new File("C:\\Users\\ashis\\OneDrive\\Desktop\\Capgemini Batch\\6 04 21 JA05 and JA16\\workspace\\CoreJavaModule1\\src\\io\\FIleHandlingDemo.java");
		FileDemo obj = new FileDemo();

		try {
			// obj.doWriteOnFile(f);
			obj.findString(f, "file");
		} catch (Exception e) {
			// TODO: handle exception
		}**/
	}


	/**public void doReadFromFile(File f)throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line = "";
		int count = 0;
		int count1 =0;
		int lineNumber = 1;
		String[] words = null;
		while((line = br.readLine())!=null)
		{
			count =0;
			System.out.println(lineNumber+"."+line);
			words = line.split(" ");
			for(String word : words) {
				boolean b = word.contains("file") || word.contains("File");
				if(b) {
					count++;
					//System.out.println("----->> line Number "+lineNumber+" & count "+count);
				}
			}
			count1 += count;
			if(count!=0)
				System.out.println("----->> line Number "+lineNumber+" & count "+count1);

			
			lineNumber++;
		}

		System.out.println("\n\n\n====>> File count "+count1);
		//br.close();
	}**/
	public static List findString(String fileName, String str) throws IOException {
		Scanner sc = new Scanner(new File(fileName));
		int line = 0;
		List lineCount = new ArrayList();
		Pattern pattern = Pattern.compile("[fileName File]+");
		Matcher matcher = null;
		while(sc.hasNextLine()) {
			String l = sc.nextLine();
			line++;
			matcher = pattern.matcher(l);
			if(matcher.find()) {
				lineCount.add(line);
			}
		}
		return lineCount;
				
	}

	public void doWriteOnFile(File f)throws IOException
	{
		PrintWriter pw = new PrintWriter(new FileWriter(f));

		pw.append("gbfbfgnbgrfbnrgf");

		System.out.println("------------- Done ------------");
		pw.close();
	}
}
