package Statistic.Model;

import Game.Games.GlobalStatisticsEnum;
import Menu.Model.MenuModel;
import Repository.Game.GlobalStatisticsRepository;
import Statistic.Factory.GlobalStatisticFactory;

import java.util.Map;

public class StatisticMenuModel extends MenuModel {
    private Object[][] donnees;

    public StatisticMenuModel() {
        this.donnees = getAllGlobalStats();
    }
    public Object[][] getGlobalStatisctic(){
        return this.donnees;
    }


    public Object[][] getAllGlobalStats(){
        Map<GlobalStatisticsEnum, String> stat = GlobalStatisticsRepository.getAll();
        int index = stat.size();
        this.donnees = new Object[index][2];
        index = 0;
        for (Map.Entry<GlobalStatisticsEnum, String> s : stat.entrySet()) {
            this.donnees[index][0] = GlobalStatisticFactory.getStringStat(s.getKey());
            this.donnees[index][1] = s.getValue().replace("_", " ");
            index++;
        }
        return this.donnees;
    }

}
