import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MesoInherit extends MesoAbstract{
	
	private String fileName = "Mesonet.txt";
	private ArrayList<MesoStation> stationList = new ArrayList<MesoStation>();
	private char[] stidChars = new char[4];
	private int[] avgList = new int[3];
	
	public MesoInherit(MesoStation station) {
		try {
			read(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		stidChars[0] = station.getStID().charAt(0);
		stidChars[1] = station.getStID().charAt(1);
		stidChars[2] = station.getStID().charAt(2);
		stidChars[3] = station.getStID().charAt(3);
		this.calAverage();
	}
	
	public int[] calAverage() {
		Double charTotal = 0.0;
		for(int i = 0; i < 4; i++) {
			charTotal += (double) stidChars[i];
		}
		avgList[0] = (int) Math.ceil(charTotal/4.0);
		avgList[1] = (int) Math.floor(charTotal/4.0);
		avgList[2] = (int) Math.round(charTotal/4.0);
		
		return avgList;
	}
	
	public char letterAverage() {
		return (char) avgList[2];
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
    		strg = strg.substring(1, 5);
    		MesoStation station = new MesoStation(strg);
    		stationList.add(station);
    		strg = br.readLine();
    	}
    	br.close();
    }
}
