package filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeFileDemo {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		File f = new File("C:\\Users\\suhan\\Documents\\EmployeeData.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line = "";
		/**while((line = br.readLine())!=null)
		{
			System.out.println(line);
		}**/
		List<Employee> l = fileOper(f);
		//System.out.println(l);
		
		Map<String, List<Employee>> mp = doFindDepart(l);
		for(Map.Entry i: mp.entrySet()) {
			System.out.println(i.getKey()+" : "+i.getValue());
		}
		
	}
	
	public static List<Employee> fileOper(File f) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line = "";
		String words[] = null;
		List<Employee> emp = new ArrayList<>();
		Employee e = null;
		String l[] = null;
		while((line = br.readLine())!=null)
		{
			l = line.split("\n");
			for(int i = 0; i < l.length; i++) {
				words = l[i].split(",");
				for(int j = 0; j < 4; j++) {
					
					emp.add(new Employee(words[j], words[++j], words[++j], words[++j]));
					
					
				}
			}
			}
		
		
		return emp;
	}
	
	public static Map<String, List<Employee>> doFindDepart(List<Employee> empList) {
		
		Map<String, List<Employee>> mp = new HashMap<String, List<Employee>>();
		List<Employee> emp1 = new ArrayList<Employee>();
		List<Employee> emp2 = new ArrayList<Employee>();
		List<Employee> emp3 = new ArrayList<Employee>();
		List<Employee> emp4 = new ArrayList<Employee>();
		
		
		for(Employee e : empList) {
			if(e.getDepartment().equals("ICICI-Bank")) {
				emp1.add(e);
				mp.put(e.getDepartment(), emp1);
			}
			else if(e.getDepartment().equals("HP")) {
				emp2.add(e);
				mp.put(e.getDepartment(), emp2);
				
			}
			else if(e.getDepartment().equals("Dell")) {
				emp3.add(e);
				mp.put(e.getDepartment(), emp3);
			}
			else if(e.getDepartment().equals("LIC")) {
				emp4.add(e);
				mp.put(e.getDepartment(), emp4);
			}
		}
		return mp;
	}
	
}
