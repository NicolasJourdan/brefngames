package Statistic.Model;

import Game.Games.FifteenVainc.FifteenVaincStatsEnum;
import Repository.Game.FifteenVaincRepository;
import Statistic.Factory.FifteenVaincStatisticFactory;
import Structure.AbstractModel;

import java.util.Map;

public class StatisticFifteenVaincModel extends AbstractModel {
    private Object[][] donnees;

    public StatisticFifteenVaincModel() {
        this.donnees = new Object[][]{};
    }

    public Object[][] getAllStatisctic(){
        return this.donnees;
    }

    public Object[][] getAllFifteenVaincStats(){
        Map<FifteenVaincStatsEnum, String> stat = FifteenVaincRepository.getAll();
        int index = stat.size();
        this.donnees = new Object[index][2];
        index = 0;
        for (Map.Entry<FifteenVaincStatsEnum, String> s : stat.entrySet()) {
            this.donnees[index][0] = FifteenVaincStatisticFactory.getStringStat(s.getKey());
            this.donnees[index][1] = s.getValue().replace("_", " ");
            index++;
        }
        return this.donnees;
    }
}
