package KSRZadanie2.Model.DataService;

import KSRZadanie2.Model.Match;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class DataInserter {
    public static List<Match> insert() {
        String path = "Data";
        DataParser dataParser = new DataParser();
        List<Match> matches = new LinkedList<>();

        File folder = new File(path);

        for (final File fileEntry : folder.listFiles()) {
            matches.addAll(dataParser.parseMatch(fileEntry.getPath()));
        }
        return matches;
    }
}
