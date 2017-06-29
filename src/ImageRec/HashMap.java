package ImageRec;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class HashMap<T, K>{
	private LinkedList[] data;
	private int size;
	private final int defaultSize= 128;
	public HashMap(){
		data = new LinkedList[defaultSize];
		for(int i = 0; i < data.length; i++){
			data[i] = new LinkedList();
		}
	}
	public HashMap(int sSize){
		data = new LinkedList[sSize];
		for(int i = 0; i < data.length; i++){
			data[i] = new LinkedList();
		}
	}
	
	public void clear() {
		data = new LinkedList[defaultSize];
		for(int i = 0; i < data.length; i++){
			data[i] = new LinkedList();
		}
	}

	
	public boolean containsKey(Object arg0) {

		return false;
	}

	
	public boolean containsValue(Object arg0) {
		
		return false;
	}

	
	public Set entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public K get(Object arg0) {
		LinkedList<Data> working = data[hash((T)arg0)];
		for(int i = 0; i < working.size(); i++){
			if(working.get(i).getKey().equals((T)arg0)){
				return (K) working.get(i).getValue();
			}
		}
		return null;
		
	}

	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Set keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean put(T arg0, K arg1) {
		size++;
		if(data[hash(arg0)].contains(new Data(arg0,arg1))){
			return false;
		}
		data[hash(arg0)].add(new Data(arg0,arg1));
		if(size >= data.length* 0.75){
			reSize();
		}
		return true;
	}

	public void putAll(Map arg0) {
		// TODO Auto-generated method stub
		
	}

	
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
	public LinkedList toList(){
		
		return null;
	}
}
