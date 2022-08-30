package utilities;

import java.util.Map;

public class Entry<K, V> implements java.util.Map.Entry<K, V> {

	K _key;
	
	V _value;
	
	@Override
	public K getKey() { return _key; }

	@Override
	public V getValue() { return _value; }

	@Override
	public V setValue(V value) {
		V oldValue = _value;
		_value = value;
		return oldValue;
	}

}
