package CBossesMain;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class CMDCompleter implements TabCompleter{
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 1){
            List<String> e = new ArrayList<String>();
            List<String> result = new ArrayList<String>();
            e.add("getmobname");
            e.add("getmobhealth");
            e.add("getmobpotions");
            e.add("ismobababy");
            e.add("getmobdropchance");
            for(String a : e) {
                if(a.toLowerCase().startsWith(strings[0].toLowerCase())) {
                    result.add(a);
                }

            }
            return result;
        }

        return null;
    }
}
