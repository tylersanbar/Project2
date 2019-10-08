import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PosAvg {
	
	private String fileName = "Mesonet.txt";
	ArrayList<MesoStation> stationList = new ArrayList<MesoStation>();
	int fileIndex;
	MesoStation station;
	
	public PosAvg(String stID) {
		try {
			read(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.station = new MesoStation(stID);
		
		for(int i = 0; i < stationList.size(); i++) {
			if(stationList.get(i).getStID() == station.getStID()) {
				//file index is 1 greater than array index
				this.fileIndex = i + 1;
				
			}
		}
	}
	
	public int indexOfStation() {
		return fileIndex;
	}
	
	public void read(String filename) throws IOException
    {
    	
    	BufferedReader br = new BufferedReader(new FileReader(filename));
    	
    	br.readLine();
    	br.readLine();
    	br.readLine();
    	br.readLine();
    	br.readLine();
    	br.readLine();
    	String strg = br.readLine();
    	
    	//Adds stid, then loops through remaining lines
    	while (strg != null) {
    		strg = strg.substring(0, 3);
    		MesoStation station = new MesoStation(strg);
    		stationList.add(station);
    		strg = br.readLine();
    	}
    	br.close();
    }
	
	public String toString() {
		String minusOne = stationList.get(fileIndex - 2).getStID();
		String plusOne = stationList.get(fileIndex).getStID();
		String minusTwo = stationList.get(fileIndex - 3).getStID();
		String plusTwo = stationList.get(fileIndex + 1).getStID();
		return String.format("This index is average of %s and %s, %s and %s, and so on.", minusOne, plusOne, minusTwo, plusTwo);
	}
}

	