package File_formats;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import GIS.GisElement;
import GIS.Layer;
import GIS.Metadata;

/**
 * This class convert CSV file into KML file
 * Gets path to file and convert it
 * @author Eti Reznikov and Chen Ostrovski
 */
public class Csv2Kml {
	Layer Layer_GIS;

	public Csv2Kml() {
		Layer_GIS=new Layer();
	}
	public Layer getLayer_GIS() {
		return Layer_GIS;
	}
	public void setLayer_GIS(Layer layer_GIS) {
		Layer_GIS = layer_GIS;
	}
	/**
	 * This method read the information from a CSV file and saves each row in GisElement
	 * @param inputName the path of the CSV file
	 * @param outputName the name that the user want to give to the KML file
	 */
	public String ReadCSV(String inputName, String outputName) {
		ArrayList<String []> output=new ArrayList<>();
		String tofinalKML;
		// Creates a new name to the kml file
		String nameFile=outputName+".kml";
		// The path of the csv file
		String csvFile = inputName;
		String line = "";
		String cvsSplitBy = ",";
		int thisLine=-1;

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
		{

			// Checks if the line is not empty
			while ((line = br.readLine()) != null) 
			{
				thisLine++;
				String[] wigleWifi = line.split(cvsSplitBy);
				// Add the info of the line
		//		output.add(wigleWifi);	
				
				if (thisLine>1) {
					// Add the info of the line
					output.add(wigleWifi);	
					Metadata metadata=new Metadata();
					metadata.setMAC(wigleWifi[0]);
					metadata.setSSID(wigleWifi[1]);
					metadata.setAuthMode(wigleWifi[2]);
					metadata.setTime(wigleWifi[3]);
					metadata.setPoint(Double.parseDouble(wigleWifi[6]),Double.parseDouble(wigleWifi[7]),Double.parseDouble(wigleWifi[8]));
					GisElement gis=new GisElement(metadata);
					this.getLayer_GIS().add(gis);
				}
			}
		}

		catch (IOException e) 
		{

			e.printStackTrace();

		}

		tofinalKML=this.writeFileKML(output,nameFile);
		return tofinalKML;
	}



	public String writeFileKML(ArrayList<String[]> toKML, String output) {
		ArrayList<String> KML = new ArrayList<String>();
//		ArrayList<String> tofinalKML = new ArrayList<String>();
		String tofinalKML="";
		String kmlstart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n"
				+ " <Document> <Folder><name>Wifi Networks</name>\n";


		KML.add(kmlstart);

		String kmlend = "</Folder>\n</Document>"+"\n</kml>";
		try{
			FileWriter fw = new FileWriter(output);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < toKML.size(); i++) {
				String[] s = toKML.get(i);
				String kmlelement ="<Placemark>\n" +
						"<description>"+"name"+s[1]+"name" +
						s[0]+", Capabilities:"+s[2]+", Date:"+s[3]+
						"</description>\n" +
						"<Point>\n" +
						"<coordinates>"+s[7]+","+s[6]+"</coordinates>\n" +
						"</Point>\n" +
						"<TimeStamp>\n" +
						"<when>"+s[3].replace(" ", "T")+"</when>\n" +
						"</TimeStamp>\n" +
						"</Placemark>\n";
				KML.add(kmlelement);
				tofinalKML=tofinalKML+kmlelement;
			}
			KML.add(kmlend);
			String csv="";
			for (int i=0; i<KML.size(); i++) {
				csv=csv+KML.get(i);		
			}

			bw.write(csv);
			bw.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return tofinalKML;
	
	}

}

