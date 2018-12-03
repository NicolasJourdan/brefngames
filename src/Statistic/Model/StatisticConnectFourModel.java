package Statistic.Model;

import Game.Games.ConnectFour.ConnectFourStatsEnum;
import Repository.Game.ConnectFourRepository;
import Statistic.Factory.ConnectFourStatisticFactory;
import Structure.AbstractModel;

import java.util.Map;

public class StatisticConnectFourModel extends AbstractModel {

    private Object[][] donnees;

    public StatisticConnectFourModel() {
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
            this.donnees[index][0] = ConnectFourStatisticFactory.getStringStat(s.getKey());
            this.donnees[index][1] = s.getValue();
            index++;
        }
        return this.donnees;
    }
}
