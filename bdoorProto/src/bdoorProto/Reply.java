/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdoorProto;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
        return super.defaultSize() + 4;
    }

    @Override
    public boolean writeToStream(OutputStream o) {
        if (super.writeToStream(o)) {
            try {
                PacketUtils.writeInt(o, status);
                return true;
            }
            catch(IOException e) {
                return false;
            }
        }

        return false;
    }


    Reply(PacketHeader h) {
        super(h);
    }

    @Override
    public boolean readFromStream(InputStream i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}
