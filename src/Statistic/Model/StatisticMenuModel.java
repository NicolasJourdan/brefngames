package Statistic.Model;

import Game.Games.GlobalStatisticsEnum;
import Menu.Model.MenuModel;
import Repository.Game.GlobalStatisticsRepository;
import Scene.Model.ActionEnum;
import Statistic.Factory.GlobalStatisticFactory;

import java.awt.*;
import java.util.Map;

public class StatisticMenuModel extends MenuModel {
    private Object[][] donnees;

    public StatisticMenuModel() {
        this.donnees = getAllGlobalStat();
    }
    public Object[][] getGlobalStatisctic(){
        return this.donnees;
    }


    public Object[][] getAllGlobalStat(){
        Map<GlobalStatisticsEnum, String> stat = GlobalStatisticsRepository.getAll();
        int index = stat.size();
        this.donnees = new Object[index][2];
        index = 0;
        for (Map.Entry<GlobalStatisticsEnum, String> s : stat.entrySet()) {
            this.donnees[index][0] = GlobalStatisticFactory.getStringStat(s.getKey());
            this.donnees[index][1] = s.getValue();
            index++;
        }
        return this.donnees;
    }

}
