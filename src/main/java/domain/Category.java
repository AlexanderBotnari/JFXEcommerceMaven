package domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@AllArgsConstructor
@Getter
@Setter
public class Category implements Serializable{
  
	private String name;

	@Override
	public String toString() {
		return name ;
	}
	
	
}
