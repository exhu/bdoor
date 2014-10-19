/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdoorProto;

/**
 *
 * @author yur
 */
public class PingCommand extends Command<PingCommand.PingRequest, PingCommand.PingReply> {
	public static final int COMMAND_ID = 0;
	
	static class PingReply extends Reply {
		PingReply() {
			super(0);
			header.command = COMMAND_ID;
		}
	}
	
	static class PingRequest extends Request {
		PingRequest() {
			super(0);
			header.command = COMMAND_ID;
		}
		
	}
}
