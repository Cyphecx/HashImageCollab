package ImageRec;

public class Data<T,K>{
	T key;
	K value;
	public Data(T key,K value){
		this.key = key;
		this.value = value;
	}
	public T getKey() {
		return key;
	}
	public K getValue() {
		return value;
	}
	
}
