package Statistic.Model;

import Game.Games.Runner.RunnerStatsEnum;
import Repository.Game.RunnerRepository;
import Statistic.Factory.RunnerStatisticFactory;
import Structure.AbstractModel;

import java.util.Map;

public class StatisticRunnerModel extends AbstractModel {

    private Object[][] donnees;

    public StatisticRunnerModel() {
        this.donnees = new Object[][]{};
    }

    public Object[][] getAllStatisctic(){
        return this.donnees;
    }

    public Object[][] getAllRunnerStat(){
        Map<RunnerStatsEnum, String> stat = RunnerRepository.getAll();
        int index = stat.size();
        this.donnees = new Object[index][2];
        index = 0;
        for (Map.Entry<RunnerStatsEnum, String> s : stat.entrySet()) {
            this.donnees[index][0] = RunnerStatisticFactory.getStringStat(s.getKey());
            this.donnees[index][1] = s.getValue();
            index++;
        }
        return this.donnees;
    }
}
