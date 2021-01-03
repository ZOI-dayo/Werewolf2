package net.zoizoi.plugin.werewolf2.core.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CommandMaster {
    protected net.zoizoi.plugin.werewolf2.core.command.CommandManager manager;

    public CommandMaster(net.zoizoi.plugin.werewolf2.core.command.CommandManager manager) {
        this.manager = manager;

        //Nameを実装していない場合はAssertを発生させる
        assert getName() != null;
    }

    protected Map<String, CommandMaster> subCommands = new HashMap<>();

    public abstract String getName();

    public abstract String getPermission();

    protected void addSubCommand(CommandMaster childCommand) {
        subCommands.put(childCommand.getName(), childCommand);
    }

    public abstract boolean onCommand(CommandSender sender, Command command, String label, String[] args);


    public abstract List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args);
    // return new ArrayList<>(subCommands.keySet());
}
