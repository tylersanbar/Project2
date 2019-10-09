import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LetterAvg {
	
	private String fileName = "Mesonet.txt";
	private ArrayList<MesoStation> stationList = new ArrayList<MesoStation>();
	private ArrayList<MesoStation> sameAvg = new ArrayList<MesoStation>();
	
	public LetterAvg(char ltrAvg) {
		try {
			read(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		MesoStation compareStation;
		MesoInherit compareInherit;
		for(int i = 0; i < stationList.size(); i++) {
			compareStation = stationList.get(i);
			compareInherit = new MesoInherit(compareStation);
			if(compareInherit.letterAverage() == ltrAvg) {
				sameAvg.add(compareStation);
			}
		}
	}
	
	public int numberOfStationWithLetterAvg() {
		return sameAvg.size();
	}
	
	private void read(String filename) throws IOException
    {
    	
    	BufferedReader br = new BufferedReader(new FileReader(filename));
    	
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
	
	@Override
	public String toString() {
		String output = new String("They are:/n");
		for(int i = 0; i < sameAvg.size(); i++) {
			output.concat(sameAvg.get(i).getStID() + "/n");
		}
		return output;
	}
}
