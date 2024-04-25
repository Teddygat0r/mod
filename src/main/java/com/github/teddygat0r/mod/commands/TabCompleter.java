package com.github.teddygat0r.mod.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TabCompleter extends CommandBase {
    @Override
    public String getCommandName() {
        return "tabcompleter";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "Completes tab";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0) {
            sender.addChatMessage(new ChatComponentText("§cPlease use an argument"));
        } else if (args[0].equals("weather")) {
            sender.addChatMessage(new ChatComponentText("§bCurrent Weather: " +
                    (Minecraft.getMinecraft().theWorld.isRaining() ? "§7Rainy!" : "§eSunny!")));
        } else if (args[0].equals("coinflip")) {
            sender.addChatMessage(new ChatComponentText("§bCoinflip: " +
                    (ThreadLocalRandom.current().nextBoolean() ? "§eHeads" : "§eTails")));
        } else {
            sender.addChatMessage(new ChatComponentText("§cUnknown subcommand"));
        }
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        if (args.length == 1)
            return getListOfStringsMatchingLastWord(args, "weather");
        return Arrays.asList();
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
