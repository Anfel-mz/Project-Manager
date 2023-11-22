package database;

import java.util.ArrayList;

public interface CRUDDAO <u, j> {
	
	public void create(u a);
	public u read(j a);
	public void update (u a);
	public void delete(u a);
	public ArrayList<u> getAll();
	
}
