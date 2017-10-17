import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	
	private static final String FILENAME = "to_be_erased.txt";
	private static final String OUTFILENAME = "final.txt";
	
	public static void main(String[] args) {
		
		BufferedReader br = null;
		FileReader fr = null;
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			fw = new FileWriter(OUTFILENAME);
			bw = new BufferedWriter(fw);

			String sCurrentLine;
			String outclean;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				int fwd = sCurrentLine.indexOf("/");
				
				if(fwd == -1) {
					System.out.println(sCurrentLine);
					bw.write(sCurrentLine+"\n");
					continue;
				}
				String out = sCurrentLine.substring(fwd+1, sCurrentLine.length());
				//String out = sCurrentLine.substring(0, fwd);
				outclean = out.trim();
				
				System.out.println(outclean);
				bw.write(outclean+"\n");
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();
				
				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();
				
			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		
	}

}
