import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author tyler
 *
 */
public class LetterAvg {
	
	private String fileName = "Mesonet.txt";
	private ArrayList<MesoStation> stationList = new ArrayList<MesoStation>();
	private ArrayList<MesoStation> sameAvg = new ArrayList<MesoStation>();
	
	/**
	 * @param ltrAvg
	 */
	public LetterAvg(char ltrAvg) {
		try {
			read(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		MesoStation compareStation;
		for(int i = 0; i < stationList.size(); i++) {
			compareStation = stationList.get(i);

			if(compareStation.getStID().charAt(0) == ltrAvg) {
				sameAvg.add(compareStation);
			}
		}
	}
	
	/**
	 * @return number of stations with same average
	 */
	public int numberOfStationWithLetterAvg() {
		return sameAvg.size();
	}
	
	/**
	 * @param filename
	 * @throws IOException
	 */
	private void read(String filename) throws IOException
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
	 *Lists stations with same average
	 */
	@Override
	public String toString() {
		String output = new String("\nThey are:");
		for(int i = 0; i < sameAvg.size(); i++) {
			output += ("\n" + sameAvg.get(i).getStID());
		}
		return output;
	}
}
