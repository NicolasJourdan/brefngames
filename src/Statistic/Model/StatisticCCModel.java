package Statistic.Model;

import Game.Games.CookieClicker.CookieClickerStatsEnum;
import Repository.Game.CookieClickerRepository;
import Repository.Game.TicTacToeRepository;
import Statistic.Factory.CCStatisticFactory;
import Structure.AbstractModel;

import java.util.Map;

public class StatisticCCModel extends AbstractModel {

    private Object[][] donnees;

    public StatisticCCModel() {
        this.donnees = new Object[][]{};
    }

    public Object[][] getAllStatisctic(){
        return this.donnees;
    }

    public Object[][] getAllCCStat(){
        Map<CookieClickerStatsEnum, String> stat = CookieClickerRepository.getAll();
        int index = stat.size();
        this.donnees = new Object[index][2];
        index = 0;
        for (Map.Entry<CookieClickerStatsEnum, String> s : stat.entrySet()) {
            this.donnees[index][0] = CCStatisticFactory.getStringStat(s.getKey());
            this.donnees[index][1] = s.getValue();
            index++;
        }
        return this.donnees;
    }
}
