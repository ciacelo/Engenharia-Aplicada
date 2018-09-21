package casiaplication.model.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Arquivo {
	
	public void gravaobj(ArrayList<Usuario> lista, String nomeSeArq) throws Exception {
		File file = new File(nomeSeArq+".dat");
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
        output.writeObject(lista);
	}
	
	public ArrayList<Usuario> leobj(String nomeArq) throws Exception {
		ArrayList<Usuario> user;
        
        File file = new File(nomeArq+".dat");
       	ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        user = (ArrayList<Usuario>) input.readObject();
        return user;
	}

}