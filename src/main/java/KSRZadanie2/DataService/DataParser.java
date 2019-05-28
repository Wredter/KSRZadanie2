package KSRZadanie2.DataService;

import KSRZadanie2.Model.Match;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
@NoArgsConstructor
public class DataParser {


    public List<Match> parseMatch(String path) {
        boolean attendanceFlag = false;
        boolean reefereeFlag = false;
        boolean teamShotsFlag = false;
        boolean teamShotsOnTargetFlag = false;
        boolean teamHitWoodworkFlag = false;
        boolean teamCornersFlag = false;
        boolean teamFoulsFlag = false;
        boolean teamFreeKicksFlag = false;
        boolean teamOffsidesFlag = false;
        boolean teamYellowCardsFlag = false;
        boolean teamRedCardsFlag = false;

        List<Match> matches = new LinkedList<>();
        BufferedReader br = null;
        String line;
        SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");

        try {
            br = new BufferedReader(new FileReader(path));

            //Skip first line with definitions of columns
            line = br.readLine();
            String[] csvLabels = line.split(",");
            int fieldsNumber = csvLabels.length;
            int counter = 10;
            if (csvLabels[counter].equals("Attendance")) {
                attendanceFlag = true;
                counter ++;
            }if (csvLabels[counter].equals("Referee")) {
                reefereeFlag = true;
                counter ++;
            }if (csvLabels[counter].equals("HS")) {
                teamShotsFlag = true;
                counter +=2;
            }if (csvLabels[counter].equals("HST")) {
                teamShotsOnTargetFlag = true;
                counter +=2;
            }if (csvLabels[counter].equals("HHW")) {
                teamHitWoodworkFlag = true;
                counter +=2;
            }if (csvLabels[counter].equals("HC")) {
                teamCornersFlag = true;
                counter +=2;
            }if (csvLabels[counter].equals("HF")) {
                teamFoulsFlag = true;
                counter +=2;
            }if (csvLabels[counter].equals("HFKC")) {
                teamFreeKicksFlag = true;
                counter +=2;
            }if (csvLabels[counter].equals("HO")) {
                teamOffsidesFlag = true;
                counter +=2;
            }if (csvLabels[counter].equals("HY")) {
                teamYellowCardsFlag = true;
                counter +=2;
            }if (csvLabels[counter].equals("HR")) {
                teamRedCardsFlag = true;
            }

            //Parse all matches in file to matches on list returned by this function
            while ((line = br.readLine()) != null) {
                try {
                    // use comma as separator
                    String[] csvMatch = line.split(",");

                    Match match = new Match();
                    if(fieldsNumber == csvMatch.length) {
                        //Set all values for match
                        match.setLeagueDivision(csvMatch[0]);
                        match.setDate(dateParser.parse(csvMatch[1]));
                        match.setHomeTeam(csvMatch[2]);
                        match.setAwayTeam(csvMatch[3]);
                        match.setFullTimeHomeGoals(Integer.parseInt(csvMatch[4]));
                        match.setFullTimeAwayGoals(Integer.parseInt(csvMatch[5]));
                        match.setFullTimeResult(csvMatch[6]);
                        match.setHalfTimeHomeTeamGoals(Integer.parseInt(csvMatch[7]));
                        match.setHalfTimeAwayTeamGoals(Integer.parseInt(csvMatch[8]));
                        match.setHalfTimeResult(csvMatch[9]);
                        counter = 10;
                        if (attendanceFlag) {
                            match.setAttendance(Double.parseDouble(csvMatch[counter]));
                            counter++;
                        }
                        if (reefereeFlag) {
                            match.setReferee(csvMatch[counter]);
                            counter++;
                        }
                        if (teamShotsFlag) {
                            match.setHomeTeamShots(Integer.parseInt(csvMatch[counter]));
                            counter++;
                            match.setAwayTeamShots(Integer.parseInt(csvMatch[counter]));
                            counter++;
                        }
                        if (teamShotsOnTargetFlag) {
                            match.setHomeTeamShotsOnTarget(Integer.parseInt(csvMatch[counter]));
                            counter++;
                            match.setAwayTeamShotsOnTarget(Integer.parseInt(csvMatch[counter]));
                            counter++;
                        }
                        if (teamHitWoodworkFlag) {
                            match.setHomeTeamHitWoodwork(Integer.parseInt(csvMatch[counter]));
                            counter++;
                            match.setAwayTeamHitWoodwork(Integer.parseInt(csvMatch[counter]));
                            counter++;
                        }
                        if (teamCornersFlag) {
                            match.setHomeTeamCorners(Integer.parseInt(csvMatch[counter]));
                            counter++;
                            match.setAwayTeamCorners(Integer.parseInt(csvMatch[counter]));
                            counter++;
                        }
                        if (teamFoulsFlag) {
                            match.setHomeTeamFoulsCommitted(Integer.parseInt(csvMatch[counter]));
                            counter++;
                            match.setAwayTeamFoulsCommitted(Integer.parseInt(csvMatch[counter]));
                            counter++;
                        }
                        if (teamFreeKicksFlag) {
                            match.setHomeTeamFreeKicks(Integer.parseInt(csvMatch[counter]));
                            counter++;
                            match.setAwayTeamFreeKicks(Integer.parseInt(csvMatch[counter]));
                            counter++;
                        }
                        if (teamOffsidesFlag) {
                            match.setHomeTeamOffsides(Integer.parseInt(csvMatch[counter]));
                            counter++;
                            match.setAwayTeamOffsides(Integer.parseInt(csvMatch[counter]));
                            counter++;
                        }
                        if (teamYellowCardsFlag) {
                            match.setHomeTeamYellowCards(Integer.parseInt(csvMatch[counter]));
                            counter++;
                            match.setAwayTeamYellowCards(Integer.parseInt(csvMatch[counter]));
                            counter++;
                        }
                        if (teamRedCardsFlag) {
                            match.setHomeTeamRedCards(Integer.parseInt(csvMatch[counter]));
                            counter++;
                            match.setAwayTeamRedCards(Integer.parseInt(csvMatch[counter]));
                        }

                        //Add matches to list of matches
                        matches.add(match);
                    }
                }catch (NumberFormatException e) {
                    System.out.println("Wpis ominięty");
                }
                catch (Exception e) {
                    System.out.println("Counter : " + counter);
                    System.out.println("Plik : " + path);
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return matches;
    }
}
