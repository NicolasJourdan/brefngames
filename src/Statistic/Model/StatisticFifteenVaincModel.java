package Statistic.Model;

import Game.Games.FifteenVainc.FifteenVaincStatsEnum;
import Repository.Game.FifteenVaincRepository;
import Statistic.Factory.FifteenVaincStatisticFactory;
import Structure.AbstractModel;

import java.util.Map;

public class StatisticFifteenVaincModel extends AbstractModel {
    private Object[][] data;

    public StatisticFifteenVaincModel() {
        this.data = new Object[][]{};
    }

    public Object[][] getAllStatisctic(){
        return this.data;
    }

    public Object[][] getAllFifteenVaincStats(){
        Map<FifteenVaincStatsEnum, String> stat = FifteenVaincRepository.getAll();
        this.data = new Object[stat.size()][2];
        int index = 0;
        for (Map.Entry<FifteenVaincStatsEnum, String> s : stat.entrySet()) {
            this.data[index][0] = FifteenVaincStatisticFactory.getStringStat(s.getKey());
            this.data[index][1] = s.getValue().replace("_", " ");
            index++;
        }
        return this.data;
    }
}
