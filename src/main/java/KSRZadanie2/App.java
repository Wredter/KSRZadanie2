package KSRZadanie2;

import KSRZadanie2.Model.DataService.DataInserter;
import KSRZadanie2.Model.DataService.DataLoader;
import KSRZadanie2.MembershipFunction.TriangleMemberFunc;
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
        System.out.println(result.size());

        TriangleMemberFunc x = new TriangleMemberFunc(1.0, 2.0, 3.0, 1.0);
        System.out.println(x.height);
    }
}
