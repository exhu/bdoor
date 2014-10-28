/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdoorProto;

import java.io.InputStream;

/**
 *
 * @author yur
 */
public class PingCommand extends Command<PingCommand.PingRequest, PingCommand.PingReply> {

    public static final int COMMAND_ID = 0;

    static class PingReply extends Reply {

        PingReply(PacketHeader h) {
            super(h);
            header.command = COMMAND_ID;
        }
    }

    static class PingRequest extends Request {

        PingRequest(PacketHeader h) {
            super(h);
            header.command = COMMAND_ID;
        }

    public boolean readFromStream(InputStream i) {
        return true;
    }

    }
}
