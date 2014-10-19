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
public abstract class Packet {
	protected PacketHeader header = new PacketHeader();
	
	
	public static Packet newFromStream(InputStream i, PacketFactory f) {
		PacketHeader h = new PacketHeader();
		if (readHeaderFromStream(h, i)) {
			Packet p = f.newFromHeader(h);
			p.readFromStream(i);
			return p;
		}
		
		return null;
	}
	
	/// extra data size in bytes (excluding dataSize, id, command fields)
	protected Packet(int userDataSz) {
		header.dataSize += userDataSz;
	}
	
	private static int prevId = 0;
	
	protected static int nextId() {
		if (prevId == Integer.MAX_VALUE)
			prevId = 1;
		else
			++prevId;
		
		return prevId;
	}
	
	static protected int readInt(InputStream i) throws IOException {
		byte [] bytes = new byte[4];
		int c = i.read(bytes);
		if (c < 4)
			throw new IOException("not enough data");
	
		return (int)(bytes[0] & 0xFF) | (int)((bytes[1] & 0xFF)<<8)
			| (int)((bytes[2] & 0xFF)<<16) | (int)((bytes[3] & 0xFF)<<24);
	}
	
	static protected boolean readHeaderFromStream(PacketHeader h, InputStream i) {
		try {
			h.dataSize = readInt(i);
			h.id = readInt(i);
			h.command = readInt(i);
		}
		catch(IOException e) {
			return false;
		}
			
		return true;
	}
	
	/// read only packet specific data, excluding the header
	public abstract boolean readFromStream(InputStream i);
	
	public boolean writeToStream(InputStream i) {
		// TODO
		return true;
	}
}
