package KSRZadanie2;

import KSRZadanie2.DataService.DataInserter;
import KSRZadanie2.DataService.DataLoader;
import KSRZadanie2.Model.Match;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        DataLoader dl = new DataLoader();
        dl.downloadFiles("Data");
        List<Match> result = DataInserter.insert();
    }
}
