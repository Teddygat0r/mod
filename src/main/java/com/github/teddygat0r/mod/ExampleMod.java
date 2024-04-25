package com.github.teddygat0r.mod;

import com.github.teddygat0r.mod.commands.CrashCommand;
import com.github.teddygat0r.mod.commands.TabCompleter;
import com.github.teddygat0r.mod.test.CheeseDetector;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.LogManager;

@Mod(modid = "mod", useMetadata=true)
public class ExampleMod {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("Dirt: " + Blocks.dirt.getUnlocalizedName());
        registerEvents();
        registerCommands();

    }

    public void registerEvents() {
        MinecraftForge.EVENT_BUS.register(new CheeseDetector());
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void registerCommands() {
        ClientCommandHandler.instance.registerCommand(new CrashCommand());
        ClientCommandHandler.instance.registerCommand(new TabCompleter());
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        GuiScreen currentScreen = Minecraft.getMinecraft().currentScreen;
        if (!(currentScreen instanceof GuiChest)) return;
        GuiChest currentScreen1 = (GuiChest) currentScreen;
        ContainerChest container = (ContainerChest) currentScreen1.inventorySlots;
        LogManager.getLogger("ExampleMod").info("Container Name: "
                + container.getLowerChestInventory().getDisplayName().getFormattedText());
        // Continuing the TickEvent from before
        for (int i = 0; i < container.getLowerChestInventory().getSizeInventory(); i++) {
            ItemStack stack = container.getLowerChestInventory().getStackInSlot(i);
            if (stack != null)
                LogManager.getLogger("ExampleMod").info("Slot " + i + ": " + stack);
        }
    }
}
