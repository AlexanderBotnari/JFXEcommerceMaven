package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataRepository {

	public <T> void save(T entity) {
		
		
		 try {
			File file = new File(entity.getClass()+".bin");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(entity);
			oos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}

	@SuppressWarnings("unchecked")
	public  <T> T load( Class<T> classType) throws IOException, ClassNotFoundException {
		T object1 = null ;
		
			File file = new File(classType+".bin");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream oos = new ObjectInputStream(fis);
			
			object1 = (T) oos.readObject();
			oos.close();
			
		return object1;
	}
	
	private static class SingletonHolder {
		private final static DataRepository INSTANCE = new DataRepository();
	}

	public static DataRepository getInstance(){
		return SingletonHolder.INSTANCE;
	}
}
