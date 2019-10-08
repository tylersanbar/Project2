import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MesoInherit {
	
	private String fileName = "Mesonet.txt";
	ArrayList<MesoStation> stationList = new ArrayList<MesoStation>();
	int[] avgList = new int[3];
	
	public MesoInherit(MesoStation station) {
		try {
			read(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int[] calAverage() {
		
	}
	public void read(String filename) throws IOException
    {
    	
    	BufferedReader br = new BufferedReader(new FileReader(filename));
    	
    	br.readLine();
    	br.readLine();
    	br.readLine();

    	String strg = br.readLine();
    	
    	//Adds stid, then loops through remaining lines
    	while (strg != null) {
    		strg = strg.substring(4, 8);
    		MesoStation station = new MesoStation(strg);
    		stationList.add(station);
    		strg = br.readLine();
    	}
    	br.close();
    }
}
