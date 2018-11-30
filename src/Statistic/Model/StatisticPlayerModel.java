package Statistic.Model;

import Player.Player;
import Repository.Player.PlayerRepository;
import Repository.Player.PlayerStatsEnum;
import Repository.Player.PlayerStatsRepository;
import Statistic.Factory.PlayerStatisticFactory;
import Structure.AbstractModel;

import java.util.List;
import java.util.Map;

public class StatisticPlayerModel extends AbstractModel {

    private Object[][] donnees;

    private List<Player> allPlayers;

    public StatisticPlayerModel() {
        this.donnees = new Object[][]{};
        this.allPlayers = PlayerRepository.getAll();
    }

    public Object[][] getGlobalStatisctic(){
        return this.donnees;
    }

    public String[] getAllPlayers(){
        String[] players = new String[allPlayers.size()];
        int index = 0;
        for (Player p : allPlayers) {
            players[index] = p.getName();
            index ++;
        }
        return players;
    }

    public Object[][] getStatById(String idJoueur){
        Map<PlayerStatsEnum, String> stat = PlayerStatsRepository.getByPlayerId(idJoueur);
        int index = 0;
        for (Map.Entry<PlayerStatsEnum, String> s : stat.entrySet()) {
            index++;
        }
        this.donnees = new Object[index][2];
        index = 0;
        for (Map.Entry<PlayerStatsEnum, String> s : stat.entrySet()) {
            donnees[index][0] = PlayerStatisticFactory.getStringStat(s.getKey());
            donnees[index][1] = s.getValue();
            index++;
        }
        return donnees;
    }
}
