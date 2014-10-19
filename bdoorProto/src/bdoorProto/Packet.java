/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdoorProto;

import java.io.IOException;
import java.io.InputStream;

/**
 * Little-endian int32, int32 string length, string chars, optional bin length,
 * bin data.
 * @author yur
 */
public class Packet {
	protected int dataSize = 0; // size in bytes of packet data (including id, command etc.)
	protected int id = 0; // new for request, negative for reply
	protected int command = -1; // zero is reverved for PingCommand
	
	/// extra data size in bytes (excluding dataSize, id, command fields)
	Packet(int userDataSz) {
		dataSize = userDataSz + 4 * 3;
	}
	
	private static int prevId = 0;
	
	protected static int nextId() {
		if (prevId == Integer.MAX_VALUE)
			prevId = 1;
		else
			++prevId;
		
		return prevId;
	}
	
	protected int readInt(InputStream i) throws IOException {
		byte [] bytes = new byte[4];
		int c = i.read(bytes);
		if (c < 4)
			throw new IOException("not enough data");
	
		return (int)(bytes[0] & 0xFF) | (int)((bytes[1] & 0xFF)<<8)
			| (int)((bytes[2] & 0xFF)<<16) | (int)((bytes[3] & 0xFF)<<24);
	}
	
	public boolean readFromStream(InputStream i) {
		try {
			dataSize = readInt(i);
			id = readInt(i);
			command = readInt(i);
		}
		catch(IOException e) {
			return false;
		}
			
		return true;
	}
	
	public boolean writeToStream(InputStream i) {
		// TODO
		return true;
	}
}
