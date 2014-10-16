/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdoorProto;

/**
 * Little-endian int32, int32 string length, string chars, optional bin length,
 * bin data.
 * @author yur
 */
public class Packet {
	protected int dataSize; // size in bytes of packet data (including id, command etc.)
	protected int id; // new for request, negative for reply
	protected int command;
	
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
}
