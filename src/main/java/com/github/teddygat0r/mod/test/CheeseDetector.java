package com.github.teddygat0r.mod.test;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CheeseDetector {
    int chatCount = 0;
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        if (event.message.getFormattedText().contains("cheese")){
            System.out.println("shdfisfids");
            event.setCanceled(true);
        }
        chatCount++;
        System.out.println("Chats received total: " + chatCount);

    }

}