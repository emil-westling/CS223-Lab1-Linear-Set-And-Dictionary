package utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Spliterator;


public class ArraySet<E> implements List<E>, Set<E>
{

	protected ArrayList<E> _list;
	
	public ArraySet() {
		_list = new ArrayList<E>();
	}
	
	public ArraySet(Collection<E> e) 
	{
		_list = new ArrayList<>();
		this.addAll(e);
	}

	@Override
	public int size() { return _list.size(); }

	@Override
	public boolean isEmpty() { return _list.isEmpty(); }
	
	@Override
	public boolean contains(Object o) { return _list.contains(o); }

	@Override
	public Iterator<E> iterator() { return _list.iterator(); }

	@Override
	public Object[] toArray() { return _list.toArray();	}

	@Override
	public <T> T[] toArray(T[] a) { return _list.toArray(a); }

	
	/**
	 * adds specified element to set. 
	 * 
	 * @return true if set did not already contain specified element
	 */
	@Override
	public boolean add(E e) { 
		if (_list.contains(e)) return false;
		return _list.add(e);
	}

	
	/**
	 * remove specified element from set. 
	 * 
	 * @return true if set contained specified element
	 */
	@Override
	public boolean remove(Object o) { return _list.remove(o); }

	@Override
	public boolean containsAll(Collection<?> c) { return _list.containsAll(c); }

	@Override
	public boolean addAll(Collection<? extends E> c) { return _list.addAll(c); }

	@Override
	public boolean addAll(int index, Collection<? extends E> c) { return _list.addAll(index, c); }

	@Override
	public boolean removeAll(Collection<?> c) { return _list.removeAll(c); }

	/**
	 * removes all the elements in the set that are not in the specified collection. 
	 * 
	 * @return true if this set changed as a result of the call
	 */
	@Override
	public boolean retainAll(Collection<?> c) {return _list.retainAll(c); }

	@Override
	public void clear() { _list.clear(); }

	@Override
	public E get(int index) { return _list.get(index);  }

	@Override
	public E set(int index, E element) { return _list.set(index, element); }

	@Override
	public void add(int index, E element) { _list.add(index, element); }

	@Override
	public E remove(int index) { return _list.remove(index); }

	@Override
	public int indexOf(Object o) { return _list.indexOf(o); }

	@Override
	public int lastIndexOf(Object o) { return _list.lastIndexOf(o); }

	@Override
	public ListIterator<E> listIterator() { return _list.listIterator(); }

	@Override
	public ListIterator<E> listIterator(int index) { return _list.listIterator(index); }

	@Override
	public List<E> subList(int fromIndex, int toIndex) { return _list.subList(fromIndex, toIndex); }

	@Override
	public Spliterator<E> spliterator() 
	{
		return List.super.spliterator();
	}



}

