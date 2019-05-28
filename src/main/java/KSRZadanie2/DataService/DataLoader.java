package KSRZadanie2.DataService;

import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
public class DataLoader {
    public void downloadFiles(String outputFolder){
        int i = 0;
        File theDir = new File(outputFolder);

// if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("creating directory: " + theDir.getName());
            boolean result = false;

            try{
                theDir.mkdir();
                result = true;
            }
            catch(SecurityException se){
                se.printStackTrace();
            }
            if(result) {
                System.out.println("DIR created");
            }
        }
        File f = new File(outputFolder + "/LeagueData" + i + ".csv");
        if(f.exists() && !f.isDirectory()) {
            System.out.println("Folder posiada już pliki z danymi.");
        }else {
            List<String> urlList = makeUrlList();

            for (String url : urlList) {
                downloadFile(outputFolder + "/LeagueData" + i + ".csv", url);
                i++;
            }
        }
    }
    private void downloadFile(String outputFile, String url){
        URL website = null;
        ReadableByteChannel rbc = null;
        FileOutputStream fos = null;
        try {
            website = new URL(url);
            rbc = Channels.newChannel(website.openStream());
            fos = new FileOutputStream(outputFile);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private List<String> makeUrlList(){
        List<String> urls = new ArrayList<>();
        //Liga angielska lata 2015/19
        urls.add("http://www.football-data.co.uk/mmz4281/1819/E0.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1819/E1.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1819/E2.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1819/E3.csv");

        urls.add("http://www.football-data.co.uk/mmz4281/1718/E0.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1718/E1.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1718/E2.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1718/E3.csv");

        urls.add("http://www.football-data.co.uk/mmz4281/1617/E0.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1617/E1.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1617/E2.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1617/E3.csv");

        urls.add("http://www.football-data.co.uk/mmz4281/1516/E0.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1516/E1.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1516/E2.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1516/E3.csv");
        //Liga niemiecka lata 2015/19
        urls.add("http://www.football-data.co.uk/mmz4281/1819/D1.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1819/D2.csv");

        urls.add("http://www.football-data.co.uk/mmz4281/1718/D1.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1718/D2.csv");

        urls.add("http://www.football-data.co.uk/mmz4281/1617/D1.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1617/D2.csv");

        urls.add("http://www.football-data.co.uk/mmz4281/1516/D1.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1516/D2.csv");
        //Liga Hiszpańska lata 2015/19
        urls.add("http://www.football-data.co.uk/mmz4281/1819/SP1.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1819/SP2.csv");

        urls.add("http://www.football-data.co.uk/mmz4281/1718/SP1.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1718/SP2.csv");

        urls.add("http://www.football-data.co.uk/mmz4281/1617/SP1.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1617/SP2.csv");

        urls.add("http://www.football-data.co.uk/mmz4281/1516/SP1.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1516/SP2.csv");
        //Liga Włoska lata 2015/19
        urls.add("http://www.football-data.co.uk/mmz4281/1819/I1.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1819/I2.csv");

        urls.add("http://www.football-data.co.uk/mmz4281/1718/I1.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1718/I2.csv");

        urls.add("http://www.football-data.co.uk/mmz4281/1617/I1.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1617/I2.csv");

        urls.add("http://www.football-data.co.uk/mmz4281/1516/I1.csv");
        urls.add("http://www.football-data.co.uk/mmz4281/1516/I2.csv");

        return urls;
    }
}
