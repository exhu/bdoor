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
public class Reply extends Packet {
	public final static int STATUS_OK = 0;
	public final static int STATUS_ERROR = -1;
	
	/// 0 = OK, > 0 = extended status, < 0 = error code
	protected int status;
	
	/// extra data
    @Override
    public int defaultSize() {
        return super() + 4;
    }

    Reply(PacketHeader h) {
        super(h);
    }
	
}
