package com.github.kumo0621.mcidrestrictedchat;

import net.kunmc.lab.commandlib.Command;

public class mozicommand extends Command {

    public mozicommand() {
        super("mozi");

        addChildren(new Command("start") {
            {
                execute(ctx -> {
                    ctx.sendSuccess("計測を開始しました。");
                    McidRestrictedChat.start = true;
                });
            }
        });
        addChildren(new Command("end") {
            {
                execute(ctx -> {
                    ctx.sendSuccess("計測を終了しました。");
                    McidRestrictedChat.start = false;
                });
            }
        });
    }
}
