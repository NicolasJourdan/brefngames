package Statistic.Model;

import Game.Games.Hangman.HangmanStatsEnum;
import Repository.Game.HangmanRepository;
import Statistic.Factory.HangmanStatisticFactory;
import Structure.AbstractModel;

import java.util.Map;

public class StatisticHangmanModel extends AbstractModel {

    private Object[][] donnees;

    public StatisticHangmanModel() {
        this.donnees = new Object[][]{};
    }

    public Object[][] getAllStatisctic(){
        return this.donnees;
    }

    public Object[][] getAllHangmanStats(){
        Map<HangmanStatsEnum, String> stat = HangmanRepository.getAll();
        int index = stat.size();
        this.donnees = new Object[index][2];
        index = 0;
        for (Map.Entry<HangmanStatsEnum, String> s : stat.entrySet()) {
            this.donnees[index][0] = HangmanStatisticFactory.getStringStat(s.getKey());
            this.donnees[index][1] = s.getValue().replace("_", " ");
            index++;
        }
        return this.donnees;
    }
}
