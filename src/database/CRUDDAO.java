package database;

import java.util.ArrayList;

public interface CRUDDAO <u> {
	
	public void create(u a);
	public void update (u a);
	public void delete(u a);
	public ArrayList<u> getAll();	
}

