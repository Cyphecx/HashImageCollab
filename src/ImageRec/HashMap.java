package ImageRec;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class HashMap<T, K> implements Map<T,K>{
	private LinkedList[] data;
	private int size;
	private final int defaultSize= 128;
	private Vector list;
	public HashMap(){
		data = new LinkedList[defaultSize];
		for(int i = 0; i < data.length; i++){
			data[i] = new LinkedList();
		}
		list = new Vector(1024);
	}
	public HashMap(int sSize){
		data = new LinkedList[sSize];
		for(int i = 0; i < data.length; i++){
			data[i] = new LinkedList();
		}
	}
	public Vector getList(){
		return list;
	}
	@Override
	public void clear() {
		data = new LinkedList[defaultSize];
		for(int i = 0; i < data.length; i++){
			data[i] = new LinkedList();
		}
	}

	@Override
	public boolean containsKey(Object arg0) {

		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		
		return false;
	}

	@Override
	public Set entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public K get(Object arg0) {
		LinkedList<Data> working = data[hash((T)arg0)];
		for(int i = 0; i < working.size(); i++){
			if(working.get(i).getKey().equals((T)arg0)){
				return (K) working.get(i).getValue();
			}
		}
		return null;
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K put(T arg0, K arg1) {
		size++;
		data[hash(arg0)].add(new Data(arg0,arg1));
		if(size >= data.length* 0.75){
			reSize();
		}
		list.add(arg0);
		return arg1;
	}

	@Override
	public void putAll(Map arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public K remove(Object arg0) {
		LinkedList<Data> working = data[hash((T)arg0)];
		for(int i = 0; i < working.size(); i++){
			if(working.get(i).getKey().equals((T)arg0)){
				K t = (K) working.get(i).getValue();
				size--;
				working.remove(i);
				return t;
			}
		}
		return null;
	}

	@Override
	public int size(){return size;}
	
	public void reSize(){
		LinkedList<Data> store = new LinkedList<Data>();
		for(LinkedList i : data){
			for(Data m : (LinkedList<Data>)(i)){
				store.add(m);
			}
		}
		data = new LinkedList[data.length*2];
		for(int i = 0; i < data.length; i++){
			data[i] = new LinkedList();
		}
		for(Data m : store){
			put((T)m.getKey(), (K)m.getValue());
			size--;
		}
	}
	@Override
	public Collection values() {
		return null;
	}
	
	public int hash(T key){
		return (((int)(Math.pow((double)(((((key.hashCode()<<2) * 23)<<1) / 11)>>5),(double)(2) ))>>3)%data.length);
	}
	/*
	 *Hash function for converting Seeds into array indexes 
	 */
	public int hash(Seed s){
		int[][] pixels = s.getPixels();
		String bigIntInput = "1";
		for(int i = 0; i < pixels.length; i++){
			for(int j = 0; j < pixels[i].length; j++){
				bigIntInput += pixels[i][j];
			}
		}
		BigInteger hashInput = new BigInteger(bigIntInput);
		return (((hashInput.multiply(new BigInteger("20")).pow(3))).mod(new BigInteger(data.length + "")).intValue());
	}
}
