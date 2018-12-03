package Statistic.Model;

import Game.Games.TicTacToe.TicTacToeStatsEnum;
import Repository.Game.TicTacToeRepository;
import Statistic.Factory.TicTacToeStatisticFactory;
import Structure.AbstractModel;

import java.util.Map;

public class StatisticTicTacToeModel extends AbstractModel {

    private Object[][] donnees;

    public StatisticTicTacToeModel() {
        this.donnees = new Object[][]{};
    }

    public Object[][] getAllStatisctic(){
        return this.donnees;
    }

    public Object[][] getAllTTTStat(){
        Map<TicTacToeStatsEnum, String> stat = TicTacToeRepository.getAll();
        int index = stat.size();
        this.donnees = new Object[index][2];
        index = 0;
        for (Map.Entry<TicTacToeStatsEnum, String> s : stat.entrySet()) {
            this.donnees[index][0] = TicTacToeStatisticFactory.getStringStat(s.getKey());
            this.donnees[index][1] = s.getValue();
            index++;
        }
        return this.donnees;
    }
}
