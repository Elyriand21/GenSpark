import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import javax.security.auth.login.LoginException;

/*              Update Log
        FlexBot Version 0.1.0
        Date: 02/12/2021
        - countMessage method added
        - !ping = Pong! method added
        - Main class declared

        02/13/2021
        So, my dumbass totally forgot some statements like
            - builder.setActivity(Activity.listening("f!"));
            - method

        - .getTimeCreated() added to recieved info

        Things to do
            - Go through countCommand and check where the F U C K shit is going wrong

 */

/* Functions to add to the Bot

*/


public class Main extends ListenerAdapter {

    //SQL
    static Statement statement;

    public static void main(String[] args) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault("ODA5NDg2NDI4NTQyNDY4MDk3.YCVy_A.ToFqGGbwUldNtpPvN_hisc9NTiw");
        builder.addEventListeners(new Main());
        builder.setActivity(Activity.listening("f!"));
        builder.build();
    }

    //Message Interactions

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {

        String messagePrefix = event.getMessage().getContentRaw().substring(0,2);

        // Checks to see if the author of the message is a bot
        if(event.getAuthor().isBot()) {
            // Cancel function if so
            return;
        }


        // Checks to see if the message is directed to the bot
        if(messagePrefix.compareTo("f! ") == 0) {
            return;
        }

        //Creates a guild object
        Guild guild = event.getGuild();
        //Creates a user object
        User user = event.getAuthor();

        System.out.println("It got here");

       if(event.getMessage().getContentRaw().equals("f! count")){
           Commands.countCommand(event.getMessage(), event.getChannel());
        }
    }

    public void onMessageReceived(MessageReceivedEvent event){

        //to ignore other bots
        if(event.getAuthor().isBot()) {
            return;
        }

        //if(Objects.equals(event.getMessage().getContentDisplay().charAt(0), "!")) {
           //    return;
        //}
        //States that whenever a message is received, the name and the message contents are retrieved
        System.out.println("We received a message from "+
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay() + " at " +
                event.getMessage().getTimeCreated()
        );

        //let's use raw so we hve the content exactly as the user wrote it
        if(event.getMessage().getContentRaw().equals("!ping")){

            //remember to call queue()
            //otherwise the message will never be sent
            event.getChannel().sendMessage("Pong!").queue();
        }
    }
}