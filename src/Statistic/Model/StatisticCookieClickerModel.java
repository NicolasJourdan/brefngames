package Statistic.Model;

import Game.Games.CookieClicker.CookieClickerStatsEnum;
import Repository.Game.CookieClickerRepository;
import Statistic.Factory.CookieClickerStatisticFactory;
import Structure.AbstractModel;

import java.util.Map;

public class StatisticCookieClickerModel extends AbstractModel {

    private Object[][] donnees;

    public StatisticCookieClickerModel() {
        this.donnees = new Object[][]{};
    }

    public Object[][] getAllStatisctic(){
        return this.donnees;
    }

    public Object[][] getAllCookieClickerStats(){
        Map<CookieClickerStatsEnum, String> stat = CookieClickerRepository.getAll();
        int index = stat.size();
        this.donnees = new Object[index][2];
        index = 0;
        for (Map.Entry<CookieClickerStatsEnum, String> s : stat.entrySet()) {
            this.donnees[index][0] = CookieClickerStatisticFactory.getStringStat(s.getKey());
            this.donnees[index][1] = s.getValue();
            index++;
        }
        return this.donnees;
    }
}
