package corejava8.v1ch13.CollectionTest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListTest {

	public static void main(String[] args) {
		List<String> a = new LinkedList<String>();
		a.add("Amy");
		a.add("Carl");
		a.add("Erica");
		a.add("cai");

		List<String> b = new LinkedList<String>();
		b.add("Bob");
		b.add("Doug");
		b.add("Frances");
		b.add("Gloria");
		b.add("Erica");
		b.add("cai");

//		union(a,b);
		removeDupliAndUnion(a,b);
		System.out.println("b-"+b);
		System.out.println("a-"+a);


	}
	/**
	 * 采用下标遍历的方式合并两个list，将source的元素合并到target中
	 * @param source 
	 * @param target
	 * @return
	 */
	public  static <T>  List<T> union(List<T> source,List<T> target){
		ListIterator<T> targetIter = target.listIterator();
		Iterator<T> sourceIter = source.iterator();
		while (sourceIter.hasNext()) {
			if (targetIter.hasNext())
			{
				targetIter.next();
			}
			targetIter.add(sourceIter.next());
		}
		return target;
	}
	/**
	 * 采用addall的方式进行合并
	 * @param source
	 * @param target
	 * @return
	 */
	public  static <T>  List<T> unionAll(List<T> source,List<T> target){
		target.addAll(source);
		return target;
	}
	
	/**
	 * 采用addall的方式进行合并
	 * @param source
	 * @param target
	 * @return
	 */
	public  static <T>  List<T> removeDupliAndUnion(List<T> source,List<T> target){
		target.removeAll(source);
		target.addAll(source);
		return target;
	}
	/**
	 * 交集
	 * @param source
	 * @param target
	 * @return
	 */
	public  static <T>  List<T> intersection(List<T> source,List<T> target){
		target.containsAll(source);
		return target;
	}
	/**
	 * 差集
	 * @param source
	 * @param target
	 * @return
	 */
	public  static <T>  List<T> diff(List<T> source,List<T> target){
		target.removeAll(source);
		return target;
	}

}
