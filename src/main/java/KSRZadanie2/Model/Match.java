package KSRZadanie2.Model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Match {
    private String leagueDivision;
    private Date date;
    private String homeTeam;
    private String awayTeam;
    private Integer fullTimeHomeGoals;
    private Integer fullTimeAwayGoals;
    private String fullTimeResult;
    private Integer halfTimeHomeTeamGoals;
    private Integer halfTimeAwayTeamGoals;
    private String halfTimeResult;
    private String referee;
    private Double attendance;
    private Integer homeTeamShots;
    private Integer awayTeamShots;
    private Integer homeTeamShotsOnTarget;
    private Integer awayTeamShotsOnTarget;
    private Integer homeTeamHitWoodwork;
    private Integer awayTeamHitWoodwork;
    private Integer homeTeamCorners;
    private Integer awayTeamCorners;
    private Integer homeTeamFoulsCommitted;
    private Integer awayTeamFoulsCommitted;
    private Integer homeTeamFreeKicks;
    private Integer awayTeamFreeKicks;
    private Integer homeTeamOffsides;
    private Integer awayTeamOffsides;
    private Integer homeTeamYellowCards;
    private Integer awayTeamYellowCards;
    private Integer homeTeamRedCards;
    private Integer awayTeamRedCards;

    public String ToStringFullTimeHomeGoals() {
        return "fullTimeHomeGoals";
    }
    public String ToStringFullTimeAwayGoals() {
        return "fullTimeAwayGoals";
    }

    public String ToStringHalfTimeHomeTeamGoals() {
        return "halfTimeHomeTeamGoals";
    }
    public String ToStringHalfTimeAwayTeamGoals() {
        return "halfTimeAwayTeamGoals";
    }

    public String ToStringHomeTeamShoots() {
        return "homeTeamShots";
    }
    public String ToStringAwayTeamShots() {
        return "awayTeamShots";
    }

    public String ToStringHomeTeamShotsOnTarget() {
        return "homeTeamShotsOnTarget";
    }
    public String ToStringAwayTeamShotsOnTarget() {
        return "awayTeamShotsOnTarget";
    }

    public String ToStringHomeTeamFoulsCommitted() {
        return "homeTeamFoulsCommitted";
    }
    public String ToStringAwayTeamFoulsCommitted() {
        return "awayTeamFoulsCommitted";
    }
}
