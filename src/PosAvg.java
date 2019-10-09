import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author tyler
 *
 */
public class PosAvg {
	
	private String fileName = "Mesonet.txt";
	private ArrayList<MesoStation> stationList = new ArrayList<MesoStation>();
	private int fileIndex;
	
	/**
	 * @param stID
	 */
	public PosAvg(String stID) {
		try {
			read(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		MesoStation station = new MesoStation(stID);
		
		for(int i = 0; i < stationList.size(); i++) {
			if(stationList.get(i).getStID().equals(station.getStID())) {
				//file index is 1 greater than array index
				this.fileIndex = i + 1;			
			}
		}
	}
	
	/**
	 * @return fileIndex
	 */
	public int indexOfStation() {
		return fileIndex;
	}
	
	/**
	 * @param filename
	 * @throws IOException
	 */
	public void read(String filename) throws IOException
    {
    	
    	BufferedReader br = new BufferedReader(new FileReader(filename));
    	
    	br.readLine();
    	br.readLine();
    	br.readLine();
 
    	String strg = br.readLine();
    	
    	//Adds stid, then loops through remaining lines
    	while (strg != null) {
    		strg = strg.substring(1, 5);
    		MesoStation station = new MesoStation(strg);
    		stationList.add(station);
    		strg = br.readLine();
    	}
    	br.close();
    }
	
	/**
	 * Lists a couple of stations which average is the same as index
	 */
	public String toString() {
		String minusOne = stationList.get(fileIndex - 2).getStID();
		String plusOne = stationList.get(fileIndex).getStID();
		String minusTwo = stationList.get(fileIndex - 3).getStID();
		String plusTwo = stationList.get(fileIndex + 1).getStID();
		return String.format("This index is average of %s and %s, %s and %s, and so on.", minusOne, plusOne, minusTwo, plusTwo);
	}
}

	