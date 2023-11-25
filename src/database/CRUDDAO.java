<<<<<<< HEAD
package database;

import java.util.ArrayList;

public interface CRUDDAO <u, j> {
	
	public void create(u a);
	public u read(j a);
	public void update (u a);
	public void delete(u a);
	public ArrayList<u> getAll();
	
}
=======
package database;

import java.util.ArrayList;

public interface CRUDDAO <u> {
	
	public void create(u a);
	public void update (u a);
	public void delete(u a);
	public ArrayList<u> getAll();	
}
>>>>>>> 3095955c871f5f2d33d6d5d0612170eff38c7932
