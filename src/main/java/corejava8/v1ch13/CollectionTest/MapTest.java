package corejava8.v1ch13.CollectionTest;

import java.util.*;
import java.util.Map.Entry;

/**
 * This program demonstrates the use of a map with key type String and value
 * type Employee.
 * 
 * @version 1.10 2004-08-02
 * @author Cay Horstmann
 */
public class MapTest {
	public static void main(String[] args) {
		Map<String, Employee> staff = new HashMap<String, Employee>();
		staff.put("144-25-5464", new Employee("Amy Lee"));
		staff.put("567-24-2546", new Employee("Harry Hacker"));
		staff.put("157-62-7935", new Employee("Gary Cooper"));
		staff.put("456-62-5527", new Employee("Francesca Cruz"));

		// print all entries

		System.out.println(staff);

		// remove an entry

		staff.remove("567-24-2546");

		// replace an entry

		staff.put("456-62-5527", new Employee("Francesca Miller"));

		// look up a value

		System.out.println(staff.get("157-62-7935"));

		// iterate through all entries

		for (Map.Entry<String, Employee> entry : staff.entrySet()) {
			String key = entry.getKey();
			Employee value = entry.getValue();
			System.out.println("key=" + key + ", value=" + value);
		}
	
	}
    /**
     *
     * @param sort
     */
	public static void sortMapKey(final String sort) {
		Map<String, String> treeMapTest = new TreeMap<String, String>(new Comparator<String>() {
			public int compare(String obj1, String obj2) {
				if (sort.equals("+")) {
					return obj1.compareTo(obj2);
				} else if (sort.equals("-")) {
					return obj2.compareTo(obj1);
				}
				return 0;
			}
		});
		treeMapTest.put("1", "h");
		treeMapTest.put("2", "e");
		treeMapTest.put("3", "l");
		treeMapTest.put("4", "l");
		treeMapTest.put("5", "o");
		
		for(Entry<String, String> entry:treeMapTest.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}

	/**
	 * 
	 * @param map
	 */
	public static void  sortMapValueTest(){  
		Map<String,String> map =  new HashMap<String,String>();
		map.put("1", "h");
		map.put("2", "e");
		map.put("3", "l");
		map.put("4", "l");
		map.put("5", "o");

		// 这里将map.entrySet()转换成list
		List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
		// 然后通过比较器来实现排序
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			// 升序排序
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}

		});
		for (Map.Entry<String, String> mapping : list) {
			System.out.println(mapping.getKey() + ":" + mapping.getValue());
		}

	}
	

	
}

/**
 * A minimalist employee class for testing purposes.
 */
class Employee {
	/**
	 * Constructs an employee with $0 salary.
	 * 
	 * @param n
	 *            the employee name
	 */
	public Employee(String n) {
		name = n;
		salary = 0;
	}

	public String toString() {
		return "[name=" + name + ", salary=" + salary + "]";
	}

	private String name;
	private double salary;
}
