package me.asu.cmd_server.command;

import me.asu.cmd_server.CommandDispatcher;

public class HelpCommand implements me.asu.cmd_server.TelnetCommandHandler {

    public static final String NAME = "help";


    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String help() {
        StringBuilder builder = new StringBuilder();
        builder.append(NAME).append("用法： \n").append(NAME).append(" [cmd]\n").append("\tcmd\t")
               .append("命令\n");
        return builder.toString();
    }

    @Override
    public String shortDescription() {
        return "打印帮助。";
    }

    @Override
    public String handle(me.asu.cmd_server.TelnetWorker worker, String... args) {
        me.asu.cmd_server.CommandDispatcher dispatcher = CommandDispatcher.getInstance();
        if (args == null || args.length == 0) {
            return dispatcher.commandList();
        }

        me.asu.cmd_server.TelnetCommandHandler cmd = dispatcher.getCommand(args[0]);
        if (cmd == null) {
            return "无此命令";
        }

        return cmd.help() + "\n";
    }
}
