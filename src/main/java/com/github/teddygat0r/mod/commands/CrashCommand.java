package com.github.teddygat0r.mod.commands;

import java.util.*;
import net.minecraft.command.*;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.apache.logging.log4j.LogManager;

public class CrashCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "crashme";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        // Be sure to check the array length before checking an argument
        if (args.length == 1 && args[0].equals("confirm")) {
            LogManager.getLogger("CrashCommand").info("Intentionally crashing the Game!");
            FMLCommonHandler.instance().exitJava(1, false);
        } else {
            sender.addChatMessage(new ChatComponentText("§aAre you sure you want to crash the game? Click to confirm!")
                    .setChatStyle(new ChatStyle()
                            .setChatClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/crashme confirm"))));
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getCommandAliases() {
        return Arrays.asList("dontcrashme");
    }
}