package com.guildedthorn.thornbot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.guildedthorn.thornbot.Commands.*;
import com.guildedthorn.thornbot.Tasks.RPCTask;
import com.guildedthorn.thornbot.Utils.Config;
import com.jagrosh.discordipc.IPCClient;
import com.jagrosh.discordipc.IPCListener;
import com.jagrosh.discordipc.entities.RichPresence;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import tech.xigam.cch.ComplexCommandHandler;

import java.io.*;
import java.util.EnumSet;
import java.util.Timer;

public class ThornBot {

    private static JDA jda;
    private static Config config;
    private static final ComplexCommandHandler commandHandler = new ComplexCommandHandler(true);

    static {
        File configFile = new File("config.json");
        if (!configFile.exists()) {
            try {
                if (!configFile.createNewFile()) {
                    System.out.println("Unable to create config file. Check permissions.");
                    System.exit(1);
                }

                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                InputStream stream = classLoader.getResourceAsStream("config.json");
                if (stream == null) {
                    System.out.println("Unable to read template config file.");
                    System.exit(1);
                }

                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                StringBuilder out = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    out.append(line);
                }
                reader.close();

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                FileWriter writer = new FileWriter(configFile);
                gson.toJson(gson.fromJson(out.toString(), Config.class), writer);
                writer.close();
            } catch (IOException ignored) {
                System.out.println("Unable to create config file. Check permissions.");
                System.exit(1);
            }
        }
    }
    
    public static void main(String[] args) throws Throwable {
        
        File file = new File("config.json");
        if (!file.exists()) { throw new Exception().initCause(null); }
        
        try {
            FileReader reader = new FileReader(file);
            config = new Gson().fromJson(reader, Config.class);
        } catch (Exception ignored) {}
        
        
        try {
            commandHandler.setPrefix("tb!")
                    .registerCommand(new DeployCommand())
                    .registerCommand(new StatusCommand())
                    .registerCommand(new PortsCommand())
                    .registerCommand(new GithubCommand())
                    .registerCommand(new MachinesCommand());
            jda = JDABuilder.create(config.token, EnumSet.allOf(GatewayIntent.class))
                    .addEventListeners(commandHandler)
                    .setActivity(Activity.watching("Thorn's Apartment"))
                    .setAutoReconnect(true)
                    .build().awaitReady();
            commandHandler.setJda(jda);
        } catch (Exception ignored) {}
        
        try {
            IPCClient ipcClient = new IPCClient(config.client_id);
            ipcClient.setListener(new IPCListener() {
                @Override
                public void onReady(IPCClient client) {
                    RichPresence.Builder builder = new RichPresence.Builder();
                    builder.setDetails("Test");
                    builder.setLargeImage("test", "Tes.");
                    client.sendRichPresence(builder.build());
                }
            });
            ipcClient.connect();

            Timer timer = new Timer();
            timer.schedule(new RPCTask(ipcClient), 0, 30000);
        } catch (Exception ignored) {}
    }
    
    public static JDA getJDA() {
        return jda;
    }
    
    public static ComplexCommandHandler getCommandHandler() {
        return commandHandler;
    }
}