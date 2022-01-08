import POJOS.Roles;
import POJOS.Villager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main {
    public static List<Villager> createParty(int players){  // Max 10 min 6
        List<Villager> playerList = new ArrayList<>();
        for (int i = 0; i < players; i++) {
            Villager v = new Villager(i+1, "Player %d".formatted(i+1), true, Roles.VILLAGER);
            playerList.add(v);
        }
        return assignRoles(playerList);
    }

    public static List<Villager> assignRoles(List<Villager> playersNotAssigned){
        int wolfs = playersNotAssigned.size() >= 6 ? 2 : 1;
        Random random = new Random();
        int value;
        for (int i = 0; i < wolfs; i++) {
            value = random.nextInt(playersNotAssigned.size() - 1);
            while(playersNotAssigned.get(value).getRole() == Roles.WEREWOLF){
                value = random.nextInt(playersNotAssigned.size() - 1);
            }
            playersNotAssigned.get(value).setRole(Roles.WEREWOLF);
        }
        for (Roles r : Roles.values()){
            if(r != Roles.VILLAGER && r != Roles.WEREWOLF){
                value = random.nextInt(playersNotAssigned.size() - 1);
                while(playersNotAssigned.get(value).getRole() != Roles.VILLAGER){
                    value = random.nextInt(playersNotAssigned.size() - 1);
                }
                playersNotAssigned.get(value).setRole(r);
            }
        }

        return playersNotAssigned;
    }

    public static void main(String[] args){
        List<Villager> party = createParty(20);
        for (Villager v : party){
            System.out.println(v);
        }
    }
}
