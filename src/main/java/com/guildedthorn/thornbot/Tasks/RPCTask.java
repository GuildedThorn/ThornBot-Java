package com.guildedthorn.thornbot.Tasks;

import com.jagrosh.discordipc.IPCClient;
import com.jagrosh.discordipc.entities.RichPresence;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;

public class RPCTask extends TimerTask {
    
    private static IPCClient Client;
    
    public RPCTask(IPCClient ipcClient) {
        Client = ipcClient;
    }
    
    @Override
    public void run() {
        RichPresence.Builder builder = new RichPresence.Builder();
        
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        
        builder.setDetails("This is a test.");
        builder.setState("Test.");
        builder.setLargeImage("test", "Time: " + localTime.format(dateTimeFormatter));
        Client.sendRichPresence(builder.build());
    }
}