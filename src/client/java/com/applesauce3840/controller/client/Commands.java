package com.applesauce3840.controller.client;


public class Commands {

    public int movement_ticks = 0;
    public boolean moving = false;
    public int turn = 0;
    //registering commands
    public static void register(){
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(
                    ClientCommandManager.literal("controller")
                            .then(
                                    ClientCommandManager.literal("run")
                                            .executes(context -> {
                                                Commands.run();
                                                return 1;
                                            })
                            )
        }
    }

    //timer
    public static void runloop() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(turn > 4){
                movement_ticks = 0;
                turn = 0;
            }
            // runs every client tick
            if(movement_ticks >= 40){
                stopForwardBackward();
                //turning function placeholder turns right 90 degreees in 20 ticks
                if(movement_ticks >= 60){
                    //jump placeholder
                    if(movement_ticks >=70)
                        movement_ticks = 0;
                        turn++;
                }

            }
            if(moving == true) {
                if(movement_ticks < 40){
                    moveForward();
                }
                movement_ticks++;

            }
        });
    }

    //controller run command, should run bot with no goal(maybe just wander and play?)
    public static void run(){
        //message saying this is running so you know its running(great!)
        MinecraftClient client = MinecraftClient.getInstance();

        client.player.sendMessage(
                Text.literal("Controller bot is online with no goal!"),
                false
        );

        //temporary
        moving = true;

        //repeat per tick so well bot works(gagagaga there is no exit your stuck forever in bot mode)
        runloop();
    }
}