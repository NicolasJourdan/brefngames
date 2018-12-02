package Statistic.Model;

import Game.Games.ConnectFour.ConnectFourStatsEnum;
import Repository.Game.ConnectFourRepository;
import Statistic.Factory.CFStatisticFactory;
import Structure.AbstractModel;

import java.util.Map;

public class StatisticCFModel extends AbstractModel {

    private Object[][] donnees;

    public StatisticCFModel() {
        this.donnees = new Object[][]{};
    }

    public Object[][] getAllStatisctic(){
        return this.donnees;
    }

    public Object[][] getAllCFStat(){
        Map<ConnectFourStatsEnum, String> stat = ConnectFourRepository.getAll();
        int index = stat.size();
        this.donnees = new Object[index][2];
        index = 0;
        for (Map.Entry<ConnectFourStatsEnum, String> s : stat.entrySet()) {
            this.donnees[index][0] = CFStatisticFactory.getStringStat(s.getKey());
            this.donnees[index][1] = s.getValue();
            index++;
        }
        return this.donnees;
    }
}
